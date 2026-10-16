package com.act21.rule.engine.dsl.expression.runtime;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.ISerializer;

import com.act21.rule.engine.dsl.model.BoolLiteral;
import com.act21.rule.engine.dsl.model.DecimalLiteral;
import com.act21.rule.engine.dsl.model.IntLiteral;
import com.act21.rule.engine.dsl.model.ModelFactory;
import com.act21.rule.engine.dsl.model.StringLiteral;

public class RequestDataResourceBuilder {

	private ISerializer serializer;
	private XtextResourceSet resourceSet;

	public RequestDataResourceBuilder(ISerializer serializer, XtextResourceSet resourceSet) {
		this.serializer = serializer;
		this.resourceSet = resourceSet;
	}

	public void initialize(Map<String, VariableSchema> schema) throws IOException {
		this.loadRequestDataReource(schema);
	}

	private void loadRequestDataReource(Map<String, VariableSchema> schema) throws IOException {
		XtextResource resource = (XtextResource) resourceSet
				.createResource(URI.createFileURI("requestData" + UUID.randomUUID() + ".exp"));
		String requestDataContent = toModelContent(schema, this.serializer);
		resource.load(new ByteArrayInputStream(requestDataContent.getBytes()), null);
	}

	public String toModelContent(Map<String, VariableSchema> schema, ISerializer serializer) {
		StringBuilder content = new StringBuilder();

		content.append("class RequestData{");
		for (var key : schema.keySet()) {
			var variable = ModelFactory.eINSTANCE.createVariableDeclaration();
			variable.setName(key);
			if (schema.get(key).getType() == null) {
				throw new RuntimeException("Error: Type must be present");
			}
			var type = ModelFactory.eINSTANCE.createTypeReference();
			type.setIdentifier(schema.get(key).getType().getBaseType());
			if (Type.isCollection(schema.get(key).getType())) {
				type.getTypeArguments().addAll(schema.get(key).getType().getTypeArguments().stream()
						.map(arg -> arg.getBaseType()).collect(Collectors.toList()));
			}
			variable.setType(type);
			var arrayExp = ModelFactory.eINSTANCE.createArrayExpression();
			if (schema.get(key).getValues() != null) {
				for (var value : schema.get(key).getValues()) {
					var literalExprsssion = ModelFactory.eINSTANCE.createLiteralExpression();
					if (value instanceof Double) {
						DecimalLiteral literal = ModelFactory.eINSTANCE.createDecimalLiteral();
						literal.setValue(BigDecimal.valueOf((Double) value));
						literalExprsssion.setValue(literal);
					} else if (value instanceof Integer) {
						IntLiteral literal = ModelFactory.eINSTANCE.createIntLiteral();
						literal.setValue((BigInteger) value);
						literalExprsssion.setValue(literal);
					} else if (value instanceof String) {
						StringLiteral literal = ModelFactory.eINSTANCE.createStringLiteral();
						literal.setValue((String) value);
						literalExprsssion.setValue(literal);
					} else if (value instanceof Boolean) {
						BoolLiteral literal = ModelFactory.eINSTANCE.createBoolLiteral();
						literal.setValue((Boolean) value);
						literalExprsssion.setValue(literal);
					}
					arrayExp.getElements().add(literalExprsssion);
				}
			}
			variable.setValues(arrayExp);
			content.append(serializer.serialize(variable));
			content.append("\n");
		}
		content.append("}");

		return content.toString();
	}
}
