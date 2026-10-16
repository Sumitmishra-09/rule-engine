package com.act21.impaktapps.rule.engine.test;
import com.act21.impaktapps.rule.engine.api.*;
import com.act21.impaktapps.rule.engine.commons.*;
import com.act21.impaktapps.rule.engine.test.Dt;
import java.util.Map;
import java.math.*;import com.act21.rule.engine.dsl.expression.runtime.HelperFunctions;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class ulip_payout_slab1 implements Rule {
 private  final int H_0= 0;
 private  final int V_0= 0;
 private  final int V_1= 1;
 private  final int V_2= 2;
 private  final int V_3= 3;
 private  final int V_4= 4;

@Override
public final void execute(Object requestData,RuleStatistics ruleStats) {
Dt requestData1= (Dt)requestData ;
try{
java.util.BitSet horizontal = new java.util.BitSet(1);
java.util.BitSet vertical = new java.util.BitSet(5);
decideHorizontal(requestData1, horizontal,ruleStats);
decideVertical(requestData1, vertical,ruleStats);
executeTableActions(requestData1, horizontal, vertical,ruleStats);

}catch(Exception e){
throw new RuntimeException("Execution of grid: ulip_payout_slab with version: 2 failed , last Cell Executed: [R:"+ruleStats.getCurrentRowIndex()+ ",C:"+ruleStats.getCurrentColIndex()+"]. Please check logs for details: ", e);}
}
private  void decideHorizontal( Dt requestData, final java.util.BitSet bitSet,RuleStatistics ruleStats) {bitSet.set(H_0);
}
private  void decideVertical( Dt requestData, final java.util.BitSet bitSet,RuleStatistics ruleStats) {
decide_V_0(requestData, bitSet,ruleStats);
}
private  void decide_V_0 (Dt requestData , final java.util.BitSet bitSet,RuleStatistics ruleStats) {
if(Commons.log(ruleStats,1,0,"A2") && requestData.getSpecialChannelFlag().equals(true)==true) { 
decide_V_0_0(requestData , bitSet,ruleStats) ;
}
else if(Commons.log(ruleStats,2,0,"A3") && requestData.getSpecialChannelFlag().equals(true)==true) { 
decide_V_0_1(requestData , bitSet,ruleStats) ;
}
else if(Commons.log(ruleStats,3,0,"A4") && requestData.getSpecialChannelFlag().equals(true)==true) { 
decide_V_0_2(requestData , bitSet,ruleStats) ;
}
else if(Commons.log(ruleStats,4,0,"A5") && requestData.getSpecialChannelFlag().equals(false)==true) { 
decide_V_0_3(requestData , bitSet,ruleStats) ;
}
else if(Commons.log(ruleStats,5,0,"A6") && requestData.getSpecialChannelFlag().equals(true)==true) { 
decide_V_0_4(requestData , bitSet,ruleStats) ;
}
}
private  void decide_V_0_0 (Dt requestData , final java.util.BitSet bitSet,RuleStatistics ruleStats) {
if(Commons.log(ruleStats,1,1,"B2") && requestData.getTotal_ulip_premium().compareTo(new BigDecimal("100000.0"))>=0 && requestData.getTotal_ulip_premium().compareTo(new BigDecimal("500000.0"))<=0) { 
bitSet.set(V_0);
ruleStats.getRuleExecuted().add(1L);
}
}
private  void decide_V_0_1 (Dt requestData , final java.util.BitSet bitSet,RuleStatistics ruleStats) {
if(Commons.log(ruleStats,2,1,"B3") && requestData.getTotal_ulip_premium().compareTo(new BigDecimal("500001.0"))>=0 && requestData.getTotal_ulip_premium().compareTo(new BigDecimal("1000000.0"))<=0) { 
bitSet.set(V_1);
ruleStats.getRuleExecuted().add(2L);
}
}
private  void decide_V_0_2 (Dt requestData , final java.util.BitSet bitSet,RuleStatistics ruleStats) {
if(Commons.log(ruleStats,3,1,"B4") && requestData.getTotal_ulip_premium().compareTo(new BigDecimal("1000001.0"))>=0 && requestData.getTotal_ulip_premium().compareTo(new BigDecimal("1500000.0"))<=0) { 
bitSet.set(V_2);
ruleStats.getRuleExecuted().add(3L);
}
}
private  void decide_V_0_3 (Dt requestData , final java.util.BitSet bitSet,RuleStatistics ruleStats) {
if(Commons.log(ruleStats,4,1,"B5") && requestData.getTotal_ulip_premium().compareTo(new BigDecimal("1500001.0"))>=0 && requestData.getTotal_ulip_premium().compareTo(new BigDecimal("2000000.0"))<=0) { 
bitSet.set(V_3);
ruleStats.getRuleExecuted().add(4L);
}
}
private  void decide_V_0_4 (Dt requestData , final java.util.BitSet bitSet,RuleStatistics ruleStats) {
if(Commons.log(ruleStats,5,1,"B6") && requestData.getTotal_ulip_premium().compareTo(new BigDecimal("2000000.0"))>0) { 
bitSet.set(V_4);
ruleStats.getRuleExecuted().add(5L);
}
}
private  void executeTableActions(Dt requestData,final java.util.BitSet horizontal, final java.util.BitSet vertical,RuleStatistics ruleStats) {
if(horizontal.get(0)){
executeTableActions(requestData ,0 , vertical ,ruleStats);
}

}
private  void executeTableActions(Dt requestData, final int x, final java.util.BitSet vertical,RuleStatistics ruleStats) {
if(vertical.get(0)){
executeTableActions(requestData ,x , 0,ruleStats );
}
else if(vertical.get(1)){
executeTableActions(requestData ,x , 1,ruleStats );
}
else if(vertical.get(2)){
executeTableActions(requestData ,x , 2,ruleStats );
}
else if(vertical.get(3)){
executeTableActions(requestData ,x , 3,ruleStats );
}
else if(vertical.get(4)){
executeTableActions(requestData ,x , 4,ruleStats );
}

}
private  void executeTableActions( Dt requestData, final int x, final int y ,RuleStatistics ruleStats) { 
computationtableaction_0(requestData , x , y,ruleStats) ;

}
private  void computationtableaction_0( Dt requestData, final int x, final int y,RuleStatistics ruleStats) {
switch(x) {
case 0 :
matrix_0_x_0(requestData , y ,ruleStats);
break;
default:
throw new java.lang.IllegalStateException() ;
}
}
private  void matrix_0_x_0(Dt requestData, final int y,RuleStatistics ruleStats) {
switch(y) {
case 0 :
Commons.log(ruleStats,1,2,"C2");
requestData.setUlip_payout_slab(new BigDecimal("0.021"));
break;
case 1 :
Commons.log(ruleStats,2,2,"C3");
requestData.setUlip_payout_slab(new BigDecimal("0.035"));
break;
case 2 :
Commons.log(ruleStats,3,2,"C4");
requestData.setUlip_payout_slab(new BigDecimal("0.042345"));
break;
case 3 :
Commons.log(ruleStats,4,2,"C5");
requestData.setUlip_payout_slab(new BigDecimal("0.0421"));
break;
case 4 :
Commons.log(ruleStats,5,2,"C6");
requestData.setUlip_payout_slab(new BigDecimal("0.06"));
break;
default:
throw new java.lang.IllegalStateException() ;
}
}
}