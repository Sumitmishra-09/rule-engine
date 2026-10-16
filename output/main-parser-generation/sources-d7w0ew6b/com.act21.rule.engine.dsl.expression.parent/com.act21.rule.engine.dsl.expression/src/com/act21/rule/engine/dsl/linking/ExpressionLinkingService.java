package com.act21.rule.engine.dsl.linking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.act21.rule.engine.dsl.datatype.TypeSystem;
import com.act21.rule.engine.dsl.expression.util.InBuiltLibrary;
import com.act21.rule.engine.dsl.expression.functions.RegisteredFunctionTypes;
import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry;
import com.act21.rule.engine.dsl.model.Argument;
import com.act21.rule.engine.dsl.model.Decide;
import com.act21.rule.engine.dsl.model.ElementReferenceExpression;
import com.act21.rule.engine.dsl.model.FunctionDeclaration;
import com.act21.rule.engine.dsl.model.ModelFactory;
import com.act21.rule.engine.dsl.model.Parameter;
import com.google.inject.Inject;

public class ExpressionLinkingService extends DefaultLinkingService {
	@Inject
	private InBuiltLibrary inBuiltLibrary;

	@Inject
	@LinkingScopeProviderBinding
	private IScopeProvider scopeProvider;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	private List<EObject> getNodesForFunctionDeclarations(EObject context, EReference ref, INode node) {
		final String crossRefString = getCrossRefNodeAsString(node);
		// A schema field with the same name must not hide an explicitly called function.
		var registeredClass = inBuiltLibrary.getClass(FunctionRegistry.MODEL_CLASS, context);
		if (registeredClass != null) {
			List<EObject> registered = registeredClass.getMembers().stream()
					.filter(member -> member instanceof FunctionDeclaration && crossRefString.equals(member.getName()))
					.map(member -> (EObject) member).collect(Collectors.toList());
			if (!registered.isEmpty()) return registered;
		}
		final IScope scope = getScope(context, ref);
		final QualifiedName qualifiedLinkName = qualifiedNameConverter.toQualifiedName(crossRefString);
		final Iterable<IEObjectDescription> descriptions = scope.getElements(qualifiedLinkName);
		return StreamSupport.stream(descriptions.spliterator(), false).map(IEObjectDescription::getEObjectOrProxy)
				.filter(e -> e instanceof FunctionDeclaration).collect(Collectors.toList());
	}

	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {

		try {

			List<EObject> result = null;
			if (context instanceof ElementReferenceExpression
					&& ((ElementReferenceExpression) context).isOperationCall() == true
					&& (result = this.getNodesForFunctionDeclarations(context, ref, node)) != null) {

				return getCorrectFunctionDeclarationNode(node, result, (ElementReferenceExpression) context);
			}
			return super.getLinkedObjects(context, ref, node);

		} catch (Exception e) {
			throw e;
		}

	}

	private Argument getHeaderArgument(ElementReferenceExpression context, FunctionDeclaration functionDeclaration) {
		Decide decideNode;
		if ((functionDeclaration.getName().equals("in") || functionDeclaration.getName().equals("contains"))
				&& (decideNode = EcoreUtil2.getContainerOfType(context, Decide.class)) != null) {
			Argument headerArgument = ModelFactory.eINSTANCE.createArgument();
			ElementReferenceExpression ere = ModelFactory.eINSTANCE.createElementReferenceExpression();
			ere.setReference(decideNode.getName());
			headerArgument.setValue(ere);
			return headerArgument;
		}
		return null;
	}

	private List<EObject> getCorrectFunctionDeclarationNode(INode node, List<EObject> result,
			ElementReferenceExpression context) throws IllegalNodeException {

		List<Argument> arguments = new ArrayList<>(context.getArguments());
		List<StringBuilder> errors = new ArrayList<StringBuilder>();

		return Collections.singletonList(result.stream().filter((elem) -> {
			FunctionDeclaration functionDeclaration = ((FunctionDeclaration) elem);
			var registered = inBuiltLibrary.getRegisteredFunction(functionDeclaration);
			if (registered != null) {
				try {
					RegisteredFunctionTypes.validate(registered, arguments);
					return true;
				} catch (IllegalArgumentException e) {
					errors.add(new StringBuilder(e.getMessage()));
					return false;
				}
			}
			Argument headerArg = this.getHeaderArgument(context, functionDeclaration);
			if (headerArg != null) {
				arguments.add(0, headerArg);
			}
			List<Parameter> parameters = functionDeclaration.getParameters();
			if (arguments.size() < parameters.size()) {
				errors.add(new StringBuilder("Too few arguments..."));
				return false;
			}

			for (int argIterator = 0; argIterator < arguments.size(); argIterator++) {

				String argType = TypeSystem.inferType(arguments.get(argIterator));
				String paramType;
				if (argIterator < parameters.size()) {
					paramType = TypeSystem.inferType(parameters.get(argIterator));
				} else if (parameters.get(parameters.size() - 1).getVarArgs() != null) {
					paramType = TypeSystem.inferType(parameters.get(parameters.size() - 1));
				} else {
					errors.add(new StringBuilder(
							"Expected " + parameters.size() + " parameters but got " + arguments.size()));
					return false;
				}
				if (!paramType.equals(argType) && !TypeSystem.isTypeCastingPossible(argType, paramType)) {
					errors.add(new StringBuilder("Expecting type " + paramType + " but got " + argType));
					return false;
				}
			}
			return true;

		}).findFirst().orElseThrow(() -> new IllegalNodeException(node,
				errors.stream().map(StringBuilder::toString).collect(Collectors.joining("\n")))));
	}

}
