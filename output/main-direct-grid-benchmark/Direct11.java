package com.act21.impaktapps.rule.engine.compiled;
import com.act21.impaktapps.rule.engine.api.*;
import com.act21.impaktapps.rule.engine.commons.*;
import com.act21.impaktapps.rule.engine.test.RegisteredFunctionFact;
import java.util.Map;
import java.math.*;import com.act21.rule.engine.dsl.expression.runtime.HelperFunctions;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Direct11 implements Rule {
private final com.act21.rule.engine.dsl.expression.functions.FunctionRegistry registeredFunctions;
 private  final int H_0= 0;
 private  final int V_0= 0;

@Override
public final void execute(Object requestData,RuleStatistics ruleStats) {
RegisteredFunctionFact requestData1= (RegisteredFunctionFact)requestData ;
try{
java.util.BitSet horizontal = new java.util.BitSet(1);
java.util.BitSet vertical = new java.util.BitSet(1);
decideHorizontal(requestData1, horizontal,ruleStats);
decideVertical(requestData1, vertical,ruleStats);
executeTableActions(requestData1, horizontal, vertical,ruleStats);

}catch(Exception e){
throw new RuntimeException("Execution of grid: Direct1 with version: 1 failed , last Cell Executed: [R:"+ruleStats.getCurrentRowIndex()+ ",C:"+ruleStats.getCurrentColIndex()+"]. Please check logs for details: ", e);}
}
private  void decideHorizontal( RegisteredFunctionFact requestData, final java.util.BitSet bitSet,RuleStatistics ruleStats) {bitSet.set(H_0);
}
private  void decideVertical( RegisteredFunctionFact requestData, final java.util.BitSet bitSet,RuleStatistics ruleStats) {
decide_V_0(requestData, bitSet,ruleStats);
}
private  void decide_V_0 (RegisteredFunctionFact requestData , final java.util.BitSet bitSet,RuleStatistics ruleStats) {
if(Commons.log(ruleStats,1,0,"A2") && true) { 
bitSet.set(V_0);
ruleStats.getRuleExecuted().add(1L);
}
}
private  void executeTableActions(RegisteredFunctionFact requestData,final java.util.BitSet horizontal, final java.util.BitSet vertical,RuleStatistics ruleStats) {
if(horizontal.get(0)){
executeTableActions(requestData ,0 , vertical ,ruleStats);
}

}
private  void executeTableActions(RegisteredFunctionFact requestData, final int x, final java.util.BitSet vertical,RuleStatistics ruleStats) {
if(vertical.get(0)){
executeTableActions(requestData ,x , 0,ruleStats );
}

}
private  void executeTableActions( RegisteredFunctionFact requestData, final int x, final int y ,RuleStatistics ruleStats) { 
computationtableaction_0(requestData , x , y,ruleStats) ;

}
private  void computationtableaction_0( RegisteredFunctionFact requestData, final int x, final int y,RuleStatistics ruleStats) {
switch(x) {
case 0 :
matrix_0_x_0(requestData , y ,ruleStats);
break;
default:
throw new java.lang.IllegalStateException() ;
}
}
private  void matrix_0_x_0(RegisteredFunctionFact requestData, final int y,RuleStatistics ruleStats) {
switch(y) {
case 0 :
Commons.log(ruleStats,1,1,"B2");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
default:
throw new java.lang.IllegalStateException() ;
}
}
private final local.benchmark.DirectGridBenchmark.Functions __gridFunctionTarget0;
private java.lang.Long __gridFunction0(java.lang.Long arg0,java.lang.Integer arg1) {
java.lang.Long value0 = arg0;
java.lang.Long value1 = arg1 == null ? null : java.lang.Long.valueOf(arg1.longValue());
try { return __gridFunctionTarget0.add((java.lang.Long) value0,(java.lang.Long) value1); }
catch (Error failure) { throw failure; }
catch (Throwable failure) { throw new IllegalStateException("Function plus failed", failure); }
}
public Direct11() { this(com.act21.rule.engine.dsl.expression.functions.FunctionRegistry.empty()); }
public Direct11(com.act21.rule.engine.dsl.expression.functions.FunctionRegistry functions) { this.registeredFunctions = java.util.Objects.requireNonNull(functions);
this.__gridFunctionTarget0 = (local.benchmark.DirectGridBenchmark.Functions) registeredFunctions.getDefinition("plus").getTarget();
}
}