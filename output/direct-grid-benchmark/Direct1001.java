package com.act21.impaktapps.rule.engine.compiled;
import com.act21.impaktapps.rule.engine.api.*;
import com.act21.impaktapps.rule.engine.commons.*;
import com.act21.impaktapps.rule.engine.test.RegisteredFunctionFact;
import java.util.Map;
import java.math.*;import com.act21.rule.engine.dsl.expression.runtime.HelperFunctions;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Direct1001 implements Rule {
private final com.act21.rule.engine.dsl.expression.functions.FunctionRegistry registeredFunctions;
 private  final int H_0= 0;
 private  final int V_0= 0;
 private  final int V_1= 1;
 private  final int V_2= 2;
 private  final int V_3= 3;
 private  final int V_4= 4;
 private  final int V_5= 5;
 private  final int V_6= 6;
 private  final int V_7= 7;
 private  final int V_8= 8;
 private  final int V_9= 9;
 private  final int V_10= 10;
 private  final int V_11= 11;
 private  final int V_12= 12;
 private  final int V_13= 13;
 private  final int V_14= 14;
 private  final int V_15= 15;
 private  final int V_16= 16;
 private  final int V_17= 17;
 private  final int V_18= 18;
 private  final int V_19= 19;
 private  final int V_20= 20;
 private  final int V_21= 21;
 private  final int V_22= 22;
 private  final int V_23= 23;
 private  final int V_24= 24;
 private  final int V_25= 25;
 private  final int V_26= 26;
 private  final int V_27= 27;
 private  final int V_28= 28;
 private  final int V_29= 29;
 private  final int V_30= 30;
 private  final int V_31= 31;
 private  final int V_32= 32;
 private  final int V_33= 33;
 private  final int V_34= 34;
 private  final int V_35= 35;
 private  final int V_36= 36;
 private  final int V_37= 37;
 private  final int V_38= 38;
 private  final int V_39= 39;
 private  final int V_40= 40;
 private  final int V_41= 41;
 private  final int V_42= 42;
 private  final int V_43= 43;
 private  final int V_44= 44;
 private  final int V_45= 45;
 private  final int V_46= 46;
 private  final int V_47= 47;
 private  final int V_48= 48;
 private  final int V_49= 49;
 private  final int V_50= 50;
 private  final int V_51= 51;
 private  final int V_52= 52;
 private  final int V_53= 53;
 private  final int V_54= 54;
 private  final int V_55= 55;
 private  final int V_56= 56;
 private  final int V_57= 57;
 private  final int V_58= 58;
 private  final int V_59= 59;
 private  final int V_60= 60;
 private  final int V_61= 61;
 private  final int V_62= 62;
 private  final int V_63= 63;
 private  final int V_64= 64;
 private  final int V_65= 65;
 private  final int V_66= 66;
 private  final int V_67= 67;
 private  final int V_68= 68;
 private  final int V_69= 69;
 private  final int V_70= 70;
 private  final int V_71= 71;
 private  final int V_72= 72;
 private  final int V_73= 73;
 private  final int V_74= 74;
 private  final int V_75= 75;
 private  final int V_76= 76;
 private  final int V_77= 77;
 private  final int V_78= 78;
 private  final int V_79= 79;
 private  final int V_80= 80;
 private  final int V_81= 81;
 private  final int V_82= 82;
 private  final int V_83= 83;
 private  final int V_84= 84;
 private  final int V_85= 85;
 private  final int V_86= 86;
 private  final int V_87= 87;
 private  final int V_88= 88;
 private  final int V_89= 89;
 private  final int V_90= 90;
 private  final int V_91= 91;
 private  final int V_92= 92;
 private  final int V_93= 93;
 private  final int V_94= 94;
 private  final int V_95= 95;
 private  final int V_96= 96;
 private  final int V_97= 97;
 private  final int V_98= 98;
 private  final int V_99= 99;

@Override
public final void execute(Object requestData,RuleStatistics ruleStats) {
RegisteredFunctionFact requestData1= (RegisteredFunctionFact)requestData ;
try{
java.util.BitSet horizontal = new java.util.BitSet(1);
java.util.BitSet vertical = new java.util.BitSet(100);
decideHorizontal(requestData1, horizontal,ruleStats);
decideVertical(requestData1, vertical,ruleStats);
executeTableActions(requestData1, horizontal, vertical,ruleStats);

}catch(Exception e){
throw new RuntimeException("Execution of grid: Direct100 with version: 1 failed , last Cell Executed: [R:"+ruleStats.getCurrentRowIndex()+ ",C:"+ruleStats.getCurrentColIndex()+"]. Please check logs for details: ", e);}
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
if(Commons.log(ruleStats,2,0,"A3") && true) { 
bitSet.set(V_1);
ruleStats.getRuleExecuted().add(2L);
}
if(Commons.log(ruleStats,3,0,"A4") && true) { 
bitSet.set(V_2);
ruleStats.getRuleExecuted().add(3L);
}
if(Commons.log(ruleStats,4,0,"A5") && true) { 
bitSet.set(V_3);
ruleStats.getRuleExecuted().add(4L);
}
if(Commons.log(ruleStats,5,0,"A6") && true) { 
bitSet.set(V_4);
ruleStats.getRuleExecuted().add(5L);
}
if(Commons.log(ruleStats,6,0,"A7") && true) { 
bitSet.set(V_5);
ruleStats.getRuleExecuted().add(6L);
}
if(Commons.log(ruleStats,7,0,"A8") && true) { 
bitSet.set(V_6);
ruleStats.getRuleExecuted().add(7L);
}
if(Commons.log(ruleStats,8,0,"A9") && true) { 
bitSet.set(V_7);
ruleStats.getRuleExecuted().add(8L);
}
if(Commons.log(ruleStats,9,0,"A10") && true) { 
bitSet.set(V_8);
ruleStats.getRuleExecuted().add(9L);
}
if(Commons.log(ruleStats,10,0,"A11") && true) { 
bitSet.set(V_9);
ruleStats.getRuleExecuted().add(10L);
}
if(Commons.log(ruleStats,11,0,"A12") && true) { 
bitSet.set(V_10);
ruleStats.getRuleExecuted().add(11L);
}
if(Commons.log(ruleStats,12,0,"A13") && true) { 
bitSet.set(V_11);
ruleStats.getRuleExecuted().add(12L);
}
if(Commons.log(ruleStats,13,0,"A14") && true) { 
bitSet.set(V_12);
ruleStats.getRuleExecuted().add(13L);
}
if(Commons.log(ruleStats,14,0,"A15") && true) { 
bitSet.set(V_13);
ruleStats.getRuleExecuted().add(14L);
}
if(Commons.log(ruleStats,15,0,"A16") && true) { 
bitSet.set(V_14);
ruleStats.getRuleExecuted().add(15L);
}
if(Commons.log(ruleStats,16,0,"A17") && true) { 
bitSet.set(V_15);
ruleStats.getRuleExecuted().add(16L);
}
if(Commons.log(ruleStats,17,0,"A18") && true) { 
bitSet.set(V_16);
ruleStats.getRuleExecuted().add(17L);
}
if(Commons.log(ruleStats,18,0,"A19") && true) { 
bitSet.set(V_17);
ruleStats.getRuleExecuted().add(18L);
}
if(Commons.log(ruleStats,19,0,"A20") && true) { 
bitSet.set(V_18);
ruleStats.getRuleExecuted().add(19L);
}
if(Commons.log(ruleStats,20,0,"A21") && true) { 
bitSet.set(V_19);
ruleStats.getRuleExecuted().add(20L);
}
if(Commons.log(ruleStats,21,0,"A22") && true) { 
bitSet.set(V_20);
ruleStats.getRuleExecuted().add(21L);
}
if(Commons.log(ruleStats,22,0,"A23") && true) { 
bitSet.set(V_21);
ruleStats.getRuleExecuted().add(22L);
}
if(Commons.log(ruleStats,23,0,"A24") && true) { 
bitSet.set(V_22);
ruleStats.getRuleExecuted().add(23L);
}
if(Commons.log(ruleStats,24,0,"A25") && true) { 
bitSet.set(V_23);
ruleStats.getRuleExecuted().add(24L);
}
if(Commons.log(ruleStats,25,0,"A26") && true) { 
bitSet.set(V_24);
ruleStats.getRuleExecuted().add(25L);
}
if(Commons.log(ruleStats,26,0,"A27") && true) { 
bitSet.set(V_25);
ruleStats.getRuleExecuted().add(26L);
}
if(Commons.log(ruleStats,27,0,"A28") && true) { 
bitSet.set(V_26);
ruleStats.getRuleExecuted().add(27L);
}
if(Commons.log(ruleStats,28,0,"A29") && true) { 
bitSet.set(V_27);
ruleStats.getRuleExecuted().add(28L);
}
if(Commons.log(ruleStats,29,0,"A30") && true) { 
bitSet.set(V_28);
ruleStats.getRuleExecuted().add(29L);
}
if(Commons.log(ruleStats,30,0,"A31") && true) { 
bitSet.set(V_29);
ruleStats.getRuleExecuted().add(30L);
}
if(Commons.log(ruleStats,31,0,"A32") && true) { 
bitSet.set(V_30);
ruleStats.getRuleExecuted().add(31L);
}
if(Commons.log(ruleStats,32,0,"A33") && true) { 
bitSet.set(V_31);
ruleStats.getRuleExecuted().add(32L);
}
if(Commons.log(ruleStats,33,0,"A34") && true) { 
bitSet.set(V_32);
ruleStats.getRuleExecuted().add(33L);
}
if(Commons.log(ruleStats,34,0,"A35") && true) { 
bitSet.set(V_33);
ruleStats.getRuleExecuted().add(34L);
}
if(Commons.log(ruleStats,35,0,"A36") && true) { 
bitSet.set(V_34);
ruleStats.getRuleExecuted().add(35L);
}
if(Commons.log(ruleStats,36,0,"A37") && true) { 
bitSet.set(V_35);
ruleStats.getRuleExecuted().add(36L);
}
if(Commons.log(ruleStats,37,0,"A38") && true) { 
bitSet.set(V_36);
ruleStats.getRuleExecuted().add(37L);
}
if(Commons.log(ruleStats,38,0,"A39") && true) { 
bitSet.set(V_37);
ruleStats.getRuleExecuted().add(38L);
}
if(Commons.log(ruleStats,39,0,"A40") && true) { 
bitSet.set(V_38);
ruleStats.getRuleExecuted().add(39L);
}
if(Commons.log(ruleStats,40,0,"A41") && true) { 
bitSet.set(V_39);
ruleStats.getRuleExecuted().add(40L);
}
if(Commons.log(ruleStats,41,0,"A42") && true) { 
bitSet.set(V_40);
ruleStats.getRuleExecuted().add(41L);
}
if(Commons.log(ruleStats,42,0,"A43") && true) { 
bitSet.set(V_41);
ruleStats.getRuleExecuted().add(42L);
}
if(Commons.log(ruleStats,43,0,"A44") && true) { 
bitSet.set(V_42);
ruleStats.getRuleExecuted().add(43L);
}
if(Commons.log(ruleStats,44,0,"A45") && true) { 
bitSet.set(V_43);
ruleStats.getRuleExecuted().add(44L);
}
if(Commons.log(ruleStats,45,0,"A46") && true) { 
bitSet.set(V_44);
ruleStats.getRuleExecuted().add(45L);
}
if(Commons.log(ruleStats,46,0,"A47") && true) { 
bitSet.set(V_45);
ruleStats.getRuleExecuted().add(46L);
}
if(Commons.log(ruleStats,47,0,"A48") && true) { 
bitSet.set(V_46);
ruleStats.getRuleExecuted().add(47L);
}
if(Commons.log(ruleStats,48,0,"A49") && true) { 
bitSet.set(V_47);
ruleStats.getRuleExecuted().add(48L);
}
if(Commons.log(ruleStats,49,0,"A50") && true) { 
bitSet.set(V_48);
ruleStats.getRuleExecuted().add(49L);
}
if(Commons.log(ruleStats,50,0,"A51") && true) { 
bitSet.set(V_49);
ruleStats.getRuleExecuted().add(50L);
}
if(Commons.log(ruleStats,51,0,"A52") && true) { 
bitSet.set(V_50);
ruleStats.getRuleExecuted().add(51L);
}
if(Commons.log(ruleStats,52,0,"A53") && true) { 
bitSet.set(V_51);
ruleStats.getRuleExecuted().add(52L);
}
if(Commons.log(ruleStats,53,0,"A54") && true) { 
bitSet.set(V_52);
ruleStats.getRuleExecuted().add(53L);
}
if(Commons.log(ruleStats,54,0,"A55") && true) { 
bitSet.set(V_53);
ruleStats.getRuleExecuted().add(54L);
}
if(Commons.log(ruleStats,55,0,"A56") && true) { 
bitSet.set(V_54);
ruleStats.getRuleExecuted().add(55L);
}
if(Commons.log(ruleStats,56,0,"A57") && true) { 
bitSet.set(V_55);
ruleStats.getRuleExecuted().add(56L);
}
if(Commons.log(ruleStats,57,0,"A58") && true) { 
bitSet.set(V_56);
ruleStats.getRuleExecuted().add(57L);
}
if(Commons.log(ruleStats,58,0,"A59") && true) { 
bitSet.set(V_57);
ruleStats.getRuleExecuted().add(58L);
}
if(Commons.log(ruleStats,59,0,"A60") && true) { 
bitSet.set(V_58);
ruleStats.getRuleExecuted().add(59L);
}
if(Commons.log(ruleStats,60,0,"A61") && true) { 
bitSet.set(V_59);
ruleStats.getRuleExecuted().add(60L);
}
if(Commons.log(ruleStats,61,0,"A62") && true) { 
bitSet.set(V_60);
ruleStats.getRuleExecuted().add(61L);
}
if(Commons.log(ruleStats,62,0,"A63") && true) { 
bitSet.set(V_61);
ruleStats.getRuleExecuted().add(62L);
}
if(Commons.log(ruleStats,63,0,"A64") && true) { 
bitSet.set(V_62);
ruleStats.getRuleExecuted().add(63L);
}
if(Commons.log(ruleStats,64,0,"A65") && true) { 
bitSet.set(V_63);
ruleStats.getRuleExecuted().add(64L);
}
if(Commons.log(ruleStats,65,0,"A66") && true) { 
bitSet.set(V_64);
ruleStats.getRuleExecuted().add(65L);
}
if(Commons.log(ruleStats,66,0,"A67") && true) { 
bitSet.set(V_65);
ruleStats.getRuleExecuted().add(66L);
}
if(Commons.log(ruleStats,67,0,"A68") && true) { 
bitSet.set(V_66);
ruleStats.getRuleExecuted().add(67L);
}
if(Commons.log(ruleStats,68,0,"A69") && true) { 
bitSet.set(V_67);
ruleStats.getRuleExecuted().add(68L);
}
if(Commons.log(ruleStats,69,0,"A70") && true) { 
bitSet.set(V_68);
ruleStats.getRuleExecuted().add(69L);
}
if(Commons.log(ruleStats,70,0,"A71") && true) { 
bitSet.set(V_69);
ruleStats.getRuleExecuted().add(70L);
}
if(Commons.log(ruleStats,71,0,"A72") && true) { 
bitSet.set(V_70);
ruleStats.getRuleExecuted().add(71L);
}
if(Commons.log(ruleStats,72,0,"A73") && true) { 
bitSet.set(V_71);
ruleStats.getRuleExecuted().add(72L);
}
if(Commons.log(ruleStats,73,0,"A74") && true) { 
bitSet.set(V_72);
ruleStats.getRuleExecuted().add(73L);
}
if(Commons.log(ruleStats,74,0,"A75") && true) { 
bitSet.set(V_73);
ruleStats.getRuleExecuted().add(74L);
}
if(Commons.log(ruleStats,75,0,"A76") && true) { 
bitSet.set(V_74);
ruleStats.getRuleExecuted().add(75L);
}
if(Commons.log(ruleStats,76,0,"A77") && true) { 
bitSet.set(V_75);
ruleStats.getRuleExecuted().add(76L);
}
if(Commons.log(ruleStats,77,0,"A78") && true) { 
bitSet.set(V_76);
ruleStats.getRuleExecuted().add(77L);
}
if(Commons.log(ruleStats,78,0,"A79") && true) { 
bitSet.set(V_77);
ruleStats.getRuleExecuted().add(78L);
}
if(Commons.log(ruleStats,79,0,"A80") && true) { 
bitSet.set(V_78);
ruleStats.getRuleExecuted().add(79L);
}
if(Commons.log(ruleStats,80,0,"A81") && true) { 
bitSet.set(V_79);
ruleStats.getRuleExecuted().add(80L);
}
if(Commons.log(ruleStats,81,0,"A82") && true) { 
bitSet.set(V_80);
ruleStats.getRuleExecuted().add(81L);
}
if(Commons.log(ruleStats,82,0,"A83") && true) { 
bitSet.set(V_81);
ruleStats.getRuleExecuted().add(82L);
}
if(Commons.log(ruleStats,83,0,"A84") && true) { 
bitSet.set(V_82);
ruleStats.getRuleExecuted().add(83L);
}
if(Commons.log(ruleStats,84,0,"A85") && true) { 
bitSet.set(V_83);
ruleStats.getRuleExecuted().add(84L);
}
if(Commons.log(ruleStats,85,0,"A86") && true) { 
bitSet.set(V_84);
ruleStats.getRuleExecuted().add(85L);
}
if(Commons.log(ruleStats,86,0,"A87") && true) { 
bitSet.set(V_85);
ruleStats.getRuleExecuted().add(86L);
}
if(Commons.log(ruleStats,87,0,"A88") && true) { 
bitSet.set(V_86);
ruleStats.getRuleExecuted().add(87L);
}
if(Commons.log(ruleStats,88,0,"A89") && true) { 
bitSet.set(V_87);
ruleStats.getRuleExecuted().add(88L);
}
if(Commons.log(ruleStats,89,0,"A90") && true) { 
bitSet.set(V_88);
ruleStats.getRuleExecuted().add(89L);
}
if(Commons.log(ruleStats,90,0,"A91") && true) { 
bitSet.set(V_89);
ruleStats.getRuleExecuted().add(90L);
}
if(Commons.log(ruleStats,91,0,"A92") && true) { 
bitSet.set(V_90);
ruleStats.getRuleExecuted().add(91L);
}
if(Commons.log(ruleStats,92,0,"A93") && true) { 
bitSet.set(V_91);
ruleStats.getRuleExecuted().add(92L);
}
if(Commons.log(ruleStats,93,0,"A94") && true) { 
bitSet.set(V_92);
ruleStats.getRuleExecuted().add(93L);
}
if(Commons.log(ruleStats,94,0,"A95") && true) { 
bitSet.set(V_93);
ruleStats.getRuleExecuted().add(94L);
}
if(Commons.log(ruleStats,95,0,"A96") && true) { 
bitSet.set(V_94);
ruleStats.getRuleExecuted().add(95L);
}
if(Commons.log(ruleStats,96,0,"A97") && true) { 
bitSet.set(V_95);
ruleStats.getRuleExecuted().add(96L);
}
if(Commons.log(ruleStats,97,0,"A98") && true) { 
bitSet.set(V_96);
ruleStats.getRuleExecuted().add(97L);
}
if(Commons.log(ruleStats,98,0,"A99") && true) { 
bitSet.set(V_97);
ruleStats.getRuleExecuted().add(98L);
}
if(Commons.log(ruleStats,99,0,"A100") && true) { 
bitSet.set(V_98);
ruleStats.getRuleExecuted().add(99L);
}
if(Commons.log(ruleStats,100,0,"A101") && true) { 
bitSet.set(V_99);
ruleStats.getRuleExecuted().add(100L);
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
if(vertical.get(1)){
executeTableActions(requestData ,x , 1,ruleStats );
}
if(vertical.get(2)){
executeTableActions(requestData ,x , 2,ruleStats );
}
if(vertical.get(3)){
executeTableActions(requestData ,x , 3,ruleStats );
}
if(vertical.get(4)){
executeTableActions(requestData ,x , 4,ruleStats );
}
if(vertical.get(5)){
executeTableActions(requestData ,x , 5,ruleStats );
}
if(vertical.get(6)){
executeTableActions(requestData ,x , 6,ruleStats );
}
if(vertical.get(7)){
executeTableActions(requestData ,x , 7,ruleStats );
}
if(vertical.get(8)){
executeTableActions(requestData ,x , 8,ruleStats );
}
if(vertical.get(9)){
executeTableActions(requestData ,x , 9,ruleStats );
}
if(vertical.get(10)){
executeTableActions(requestData ,x , 10,ruleStats );
}
if(vertical.get(11)){
executeTableActions(requestData ,x , 11,ruleStats );
}
if(vertical.get(12)){
executeTableActions(requestData ,x , 12,ruleStats );
}
if(vertical.get(13)){
executeTableActions(requestData ,x , 13,ruleStats );
}
if(vertical.get(14)){
executeTableActions(requestData ,x , 14,ruleStats );
}
if(vertical.get(15)){
executeTableActions(requestData ,x , 15,ruleStats );
}
if(vertical.get(16)){
executeTableActions(requestData ,x , 16,ruleStats );
}
if(vertical.get(17)){
executeTableActions(requestData ,x , 17,ruleStats );
}
if(vertical.get(18)){
executeTableActions(requestData ,x , 18,ruleStats );
}
if(vertical.get(19)){
executeTableActions(requestData ,x , 19,ruleStats );
}
if(vertical.get(20)){
executeTableActions(requestData ,x , 20,ruleStats );
}
if(vertical.get(21)){
executeTableActions(requestData ,x , 21,ruleStats );
}
if(vertical.get(22)){
executeTableActions(requestData ,x , 22,ruleStats );
}
if(vertical.get(23)){
executeTableActions(requestData ,x , 23,ruleStats );
}
if(vertical.get(24)){
executeTableActions(requestData ,x , 24,ruleStats );
}
if(vertical.get(25)){
executeTableActions(requestData ,x , 25,ruleStats );
}
if(vertical.get(26)){
executeTableActions(requestData ,x , 26,ruleStats );
}
if(vertical.get(27)){
executeTableActions(requestData ,x , 27,ruleStats );
}
if(vertical.get(28)){
executeTableActions(requestData ,x , 28,ruleStats );
}
if(vertical.get(29)){
executeTableActions(requestData ,x , 29,ruleStats );
}
if(vertical.get(30)){
executeTableActions(requestData ,x , 30,ruleStats );
}
if(vertical.get(31)){
executeTableActions(requestData ,x , 31,ruleStats );
}
if(vertical.get(32)){
executeTableActions(requestData ,x , 32,ruleStats );
}
if(vertical.get(33)){
executeTableActions(requestData ,x , 33,ruleStats );
}
if(vertical.get(34)){
executeTableActions(requestData ,x , 34,ruleStats );
}
if(vertical.get(35)){
executeTableActions(requestData ,x , 35,ruleStats );
}
if(vertical.get(36)){
executeTableActions(requestData ,x , 36,ruleStats );
}
if(vertical.get(37)){
executeTableActions(requestData ,x , 37,ruleStats );
}
if(vertical.get(38)){
executeTableActions(requestData ,x , 38,ruleStats );
}
if(vertical.get(39)){
executeTableActions(requestData ,x , 39,ruleStats );
}
if(vertical.get(40)){
executeTableActions(requestData ,x , 40,ruleStats );
}
if(vertical.get(41)){
executeTableActions(requestData ,x , 41,ruleStats );
}
if(vertical.get(42)){
executeTableActions(requestData ,x , 42,ruleStats );
}
if(vertical.get(43)){
executeTableActions(requestData ,x , 43,ruleStats );
}
if(vertical.get(44)){
executeTableActions(requestData ,x , 44,ruleStats );
}
if(vertical.get(45)){
executeTableActions(requestData ,x , 45,ruleStats );
}
if(vertical.get(46)){
executeTableActions(requestData ,x , 46,ruleStats );
}
if(vertical.get(47)){
executeTableActions(requestData ,x , 47,ruleStats );
}
if(vertical.get(48)){
executeTableActions(requestData ,x , 48,ruleStats );
}
if(vertical.get(49)){
executeTableActions(requestData ,x , 49,ruleStats );
}
if(vertical.get(50)){
executeTableActions(requestData ,x , 50,ruleStats );
}
if(vertical.get(51)){
executeTableActions(requestData ,x , 51,ruleStats );
}
if(vertical.get(52)){
executeTableActions(requestData ,x , 52,ruleStats );
}
if(vertical.get(53)){
executeTableActions(requestData ,x , 53,ruleStats );
}
if(vertical.get(54)){
executeTableActions(requestData ,x , 54,ruleStats );
}
if(vertical.get(55)){
executeTableActions(requestData ,x , 55,ruleStats );
}
if(vertical.get(56)){
executeTableActions(requestData ,x , 56,ruleStats );
}
if(vertical.get(57)){
executeTableActions(requestData ,x , 57,ruleStats );
}
if(vertical.get(58)){
executeTableActions(requestData ,x , 58,ruleStats );
}
if(vertical.get(59)){
executeTableActions(requestData ,x , 59,ruleStats );
}
if(vertical.get(60)){
executeTableActions(requestData ,x , 60,ruleStats );
}
if(vertical.get(61)){
executeTableActions(requestData ,x , 61,ruleStats );
}
if(vertical.get(62)){
executeTableActions(requestData ,x , 62,ruleStats );
}
if(vertical.get(63)){
executeTableActions(requestData ,x , 63,ruleStats );
}
if(vertical.get(64)){
executeTableActions(requestData ,x , 64,ruleStats );
}
if(vertical.get(65)){
executeTableActions(requestData ,x , 65,ruleStats );
}
if(vertical.get(66)){
executeTableActions(requestData ,x , 66,ruleStats );
}
if(vertical.get(67)){
executeTableActions(requestData ,x , 67,ruleStats );
}
if(vertical.get(68)){
executeTableActions(requestData ,x , 68,ruleStats );
}
if(vertical.get(69)){
executeTableActions(requestData ,x , 69,ruleStats );
}
if(vertical.get(70)){
executeTableActions(requestData ,x , 70,ruleStats );
}
if(vertical.get(71)){
executeTableActions(requestData ,x , 71,ruleStats );
}
if(vertical.get(72)){
executeTableActions(requestData ,x , 72,ruleStats );
}
if(vertical.get(73)){
executeTableActions(requestData ,x , 73,ruleStats );
}
if(vertical.get(74)){
executeTableActions(requestData ,x , 74,ruleStats );
}
if(vertical.get(75)){
executeTableActions(requestData ,x , 75,ruleStats );
}
if(vertical.get(76)){
executeTableActions(requestData ,x , 76,ruleStats );
}
if(vertical.get(77)){
executeTableActions(requestData ,x , 77,ruleStats );
}
if(vertical.get(78)){
executeTableActions(requestData ,x , 78,ruleStats );
}
if(vertical.get(79)){
executeTableActions(requestData ,x , 79,ruleStats );
}
if(vertical.get(80)){
executeTableActions(requestData ,x , 80,ruleStats );
}
if(vertical.get(81)){
executeTableActions(requestData ,x , 81,ruleStats );
}
if(vertical.get(82)){
executeTableActions(requestData ,x , 82,ruleStats );
}
if(vertical.get(83)){
executeTableActions(requestData ,x , 83,ruleStats );
}
if(vertical.get(84)){
executeTableActions(requestData ,x , 84,ruleStats );
}
if(vertical.get(85)){
executeTableActions(requestData ,x , 85,ruleStats );
}
if(vertical.get(86)){
executeTableActions(requestData ,x , 86,ruleStats );
}
if(vertical.get(87)){
executeTableActions(requestData ,x , 87,ruleStats );
}
if(vertical.get(88)){
executeTableActions(requestData ,x , 88,ruleStats );
}
if(vertical.get(89)){
executeTableActions(requestData ,x , 89,ruleStats );
}
if(vertical.get(90)){
executeTableActions(requestData ,x , 90,ruleStats );
}
if(vertical.get(91)){
executeTableActions(requestData ,x , 91,ruleStats );
}
if(vertical.get(92)){
executeTableActions(requestData ,x , 92,ruleStats );
}
if(vertical.get(93)){
executeTableActions(requestData ,x , 93,ruleStats );
}
if(vertical.get(94)){
executeTableActions(requestData ,x , 94,ruleStats );
}
if(vertical.get(95)){
executeTableActions(requestData ,x , 95,ruleStats );
}
if(vertical.get(96)){
executeTableActions(requestData ,x , 96,ruleStats );
}
if(vertical.get(97)){
executeTableActions(requestData ,x , 97,ruleStats );
}
if(vertical.get(98)){
executeTableActions(requestData ,x , 98,ruleStats );
}
if(vertical.get(99)){
executeTableActions(requestData ,x , 99,ruleStats );
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
case 1 :
Commons.log(ruleStats,2,1,"B3");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 2 :
Commons.log(ruleStats,3,1,"B4");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 3 :
Commons.log(ruleStats,4,1,"B5");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 4 :
Commons.log(ruleStats,5,1,"B6");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 5 :
Commons.log(ruleStats,6,1,"B7");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 6 :
Commons.log(ruleStats,7,1,"B8");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 7 :
Commons.log(ruleStats,8,1,"B9");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 8 :
Commons.log(ruleStats,9,1,"B10");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 9 :
Commons.log(ruleStats,10,1,"B11");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 10 :
Commons.log(ruleStats,11,1,"B12");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 11 :
Commons.log(ruleStats,12,1,"B13");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 12 :
Commons.log(ruleStats,13,1,"B14");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 13 :
Commons.log(ruleStats,14,1,"B15");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 14 :
Commons.log(ruleStats,15,1,"B16");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 15 :
Commons.log(ruleStats,16,1,"B17");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 16 :
Commons.log(ruleStats,17,1,"B18");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 17 :
Commons.log(ruleStats,18,1,"B19");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 18 :
Commons.log(ruleStats,19,1,"B20");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 19 :
Commons.log(ruleStats,20,1,"B21");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 20 :
Commons.log(ruleStats,21,1,"B22");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 21 :
Commons.log(ruleStats,22,1,"B23");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 22 :
Commons.log(ruleStats,23,1,"B24");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 23 :
Commons.log(ruleStats,24,1,"B25");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 24 :
Commons.log(ruleStats,25,1,"B26");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 25 :
Commons.log(ruleStats,26,1,"B27");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 26 :
Commons.log(ruleStats,27,1,"B28");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 27 :
Commons.log(ruleStats,28,1,"B29");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 28 :
Commons.log(ruleStats,29,1,"B30");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 29 :
Commons.log(ruleStats,30,1,"B31");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 30 :
Commons.log(ruleStats,31,1,"B32");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 31 :
Commons.log(ruleStats,32,1,"B33");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 32 :
Commons.log(ruleStats,33,1,"B34");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 33 :
Commons.log(ruleStats,34,1,"B35");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 34 :
Commons.log(ruleStats,35,1,"B36");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 35 :
Commons.log(ruleStats,36,1,"B37");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 36 :
Commons.log(ruleStats,37,1,"B38");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 37 :
Commons.log(ruleStats,38,1,"B39");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 38 :
Commons.log(ruleStats,39,1,"B40");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 39 :
Commons.log(ruleStats,40,1,"B41");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 40 :
Commons.log(ruleStats,41,1,"B42");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 41 :
Commons.log(ruleStats,42,1,"B43");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 42 :
Commons.log(ruleStats,43,1,"B44");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 43 :
Commons.log(ruleStats,44,1,"B45");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 44 :
Commons.log(ruleStats,45,1,"B46");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 45 :
Commons.log(ruleStats,46,1,"B47");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 46 :
Commons.log(ruleStats,47,1,"B48");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 47 :
Commons.log(ruleStats,48,1,"B49");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 48 :
Commons.log(ruleStats,49,1,"B50");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 49 :
Commons.log(ruleStats,50,1,"B51");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 50 :
Commons.log(ruleStats,51,1,"B52");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 51 :
Commons.log(ruleStats,52,1,"B53");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 52 :
Commons.log(ruleStats,53,1,"B54");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 53 :
Commons.log(ruleStats,54,1,"B55");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 54 :
Commons.log(ruleStats,55,1,"B56");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 55 :
Commons.log(ruleStats,56,1,"B57");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 56 :
Commons.log(ruleStats,57,1,"B58");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 57 :
Commons.log(ruleStats,58,1,"B59");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 58 :
Commons.log(ruleStats,59,1,"B60");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 59 :
Commons.log(ruleStats,60,1,"B61");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 60 :
Commons.log(ruleStats,61,1,"B62");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 61 :
Commons.log(ruleStats,62,1,"B63");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 62 :
Commons.log(ruleStats,63,1,"B64");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 63 :
Commons.log(ruleStats,64,1,"B65");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 64 :
Commons.log(ruleStats,65,1,"B66");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 65 :
Commons.log(ruleStats,66,1,"B67");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 66 :
Commons.log(ruleStats,67,1,"B68");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 67 :
Commons.log(ruleStats,68,1,"B69");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 68 :
Commons.log(ruleStats,69,1,"B70");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 69 :
Commons.log(ruleStats,70,1,"B71");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 70 :
Commons.log(ruleStats,71,1,"B72");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 71 :
Commons.log(ruleStats,72,1,"B73");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 72 :
Commons.log(ruleStats,73,1,"B74");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 73 :
Commons.log(ruleStats,74,1,"B75");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 74 :
Commons.log(ruleStats,75,1,"B76");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 75 :
Commons.log(ruleStats,76,1,"B77");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 76 :
Commons.log(ruleStats,77,1,"B78");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 77 :
Commons.log(ruleStats,78,1,"B79");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 78 :
Commons.log(ruleStats,79,1,"B80");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 79 :
Commons.log(ruleStats,80,1,"B81");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 80 :
Commons.log(ruleStats,81,1,"B82");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 81 :
Commons.log(ruleStats,82,1,"B83");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 82 :
Commons.log(ruleStats,83,1,"B84");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 83 :
Commons.log(ruleStats,84,1,"B85");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 84 :
Commons.log(ruleStats,85,1,"B86");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 85 :
Commons.log(ruleStats,86,1,"B87");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 86 :
Commons.log(ruleStats,87,1,"B88");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 87 :
Commons.log(ruleStats,88,1,"B89");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 88 :
Commons.log(ruleStats,89,1,"B90");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 89 :
Commons.log(ruleStats,90,1,"B91");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 90 :
Commons.log(ruleStats,91,1,"B92");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 91 :
Commons.log(ruleStats,92,1,"B93");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 92 :
Commons.log(ruleStats,93,1,"B94");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 93 :
Commons.log(ruleStats,94,1,"B95");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 94 :
Commons.log(ruleStats,95,1,"B96");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 95 :
Commons.log(ruleStats,96,1,"B97");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 96 :
Commons.log(ruleStats,97,1,"B98");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 97 :
Commons.log(ruleStats,98,1,"B99");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 98 :
Commons.log(ruleStats,99,1,"B100");
requestData.setResult(__gridFunction0(requestData.getNumber(),requestData.getSmallNumber()));
break;
case 99 :
Commons.log(ruleStats,100,1,"B101");
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
public Direct1001() { this(com.act21.rule.engine.dsl.expression.functions.FunctionRegistry.empty()); }
public Direct1001(com.act21.rule.engine.dsl.expression.functions.FunctionRegistry functions) { this.registeredFunctions = java.util.Objects.requireNonNull(functions);
this.__gridFunctionTarget0 = (local.benchmark.DirectGridBenchmark.Functions) registeredFunctions.getDefinition("plus").getTarget();
}
}