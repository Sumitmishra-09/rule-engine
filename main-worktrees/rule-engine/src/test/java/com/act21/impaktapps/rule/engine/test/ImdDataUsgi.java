package com.act21.impaktapps.rule.engine.test;


import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
	import java.math.BigDecimal;
	import java.util.Date;
	
	
	public class ImdDataUsgi implements Serializable{
		
	   	private  String name;
	   	private  Long payoutComponentId;
	   	private  BigDecimal payable_amount;
	   	private  String imdName;
	   	private  BigDecimal manual_updated_amount;
	   	private  BigDecimal final_payable_amount;
	   	private  String gst_applicable;
	   	private  String imd_code_state;
	   	private  String imd_code_gstin;
	   	private  BigDecimal cgst_percentage;
	   	private  BigDecimal sgst_percentage;
	   	private  BigDecimal igst_percentage;
	   	private  BigDecimal cgst_amount;
	   	private  BigDecimal sgst_amount;
	   	private  BigDecimal igst_amount;
	   	private  String usgi_branch_state;
	   	private  String usgi_gstin;
	   	private  BigDecimal final_payable_amount_before_gst;
	   	private  String policy_month;
	   	private  BigDecimal imd_total_grid_amount;
	   	private  BigDecimal imd_total_grid_amount_health;
	   	private  BigDecimal imd_net_total_grid_amount;
	   	private  BigDecimal imd_total_irdai_amount;
	   	private  BigDecimal tds;
	   	private  BigDecimal tds_rate;
	   	private  BigDecimal tds_exemption_limit;
	   	private  BigDecimal tds_exemption_rate;
	   	private  String tds_certificate_start_date;
	   	private  String tds_certificate_end_date;
	   	private  BigDecimal final_payable_amount_after_tds;
	   	private  String intermediary_Category;
	   	private  String pan_no;
	   	private  String intermediary;
	   	private  String intermediary_Code;
	   	private  String type;
	   	private  Long payout_id;
	   	private  Long sourceId;
	   	private  Date modifiedOn;
	   	private  Long componentSourceId;
	   	private  String readyForRelease;
	   	private  Long version;
	   	private  String status;
	   	private  String processBusinessKey;
	   	private  BigDecimal payableAmount;
	   	private  BigDecimal holdAmount;
	   	private  BigDecimal releasedAmount;
	   	private  Object inputData;
	   	private  String workflowStatus;
	   	private  String releaseGroup;
	   	private  Object outputData;
	   	private  Object workflowDetails;
	   	private  String holdStatus;
	   	private  String id;
	   	private  BigDecimal final_payable_amount_motor;
	   	private  BigDecimal final_payable_amount_health;
	   	private  BigDecimal final_payable_amount_commercial;
	   	private  BigDecimal gwp_motor;
	   	private  BigDecimal gwp_health;
	   	private  BigDecimal gwp_commercial;
	   	private  String workflow_process_instance_id;
	   	private  String gridLog;
	   	public ImdDataUsgi() {
			name = "";
			payoutComponentId = 0L;
			payable_amount = BigDecimal.ZERO;
			imdName = "";
			manual_updated_amount = BigDecimal.ZERO;
			final_payable_amount = BigDecimal.ZERO;
			gst_applicable = "";
			imd_code_state = "";
			imd_code_gstin = "";
			cgst_percentage = BigDecimal.ZERO;
			sgst_percentage = BigDecimal.ZERO;
			igst_percentage = BigDecimal.ZERO;
			cgst_amount = BigDecimal.ZERO;
			sgst_amount = BigDecimal.ZERO;
			igst_amount = BigDecimal.ZERO;
			usgi_branch_state = "";
			usgi_gstin = "";
			final_payable_amount_before_gst = BigDecimal.ZERO;
			policy_month = "";
			imd_total_grid_amount = BigDecimal.ZERO;
			imd_total_grid_amount_health = BigDecimal.ZERO;
			imd_net_total_grid_amount = BigDecimal.ZERO;
			imd_total_irdai_amount = BigDecimal.ZERO;
			tds = BigDecimal.ZERO;
			tds_rate = BigDecimal.ZERO;
			tds_exemption_limit = BigDecimal.ZERO;
			tds_exemption_rate = BigDecimal.ZERO;
			tds_certificate_start_date = "";
			tds_certificate_end_date = "";
			final_payable_amount_after_tds = BigDecimal.ZERO;
			intermediary_Category = "";
			pan_no = "";
			intermediary = "";
			intermediary_Code = "";
			type = "";
			payout_id = 0L;
			sourceId = 0L;
			modifiedOn = new Date();
			componentSourceId = 0L;
			readyForRelease = "";
			version = 0L;
			status = "";
			processBusinessKey = "";
			payableAmount = BigDecimal.ZERO;
			holdAmount = BigDecimal.ZERO;
			releasedAmount = BigDecimal.ZERO;
			inputData = new Object();
			workflowStatus = "";
			releaseGroup = "";
			outputData = new Object();
			workflowDetails = new Object();
			holdStatus = "";
			id = "";
			final_payable_amount_motor = BigDecimal.ZERO;
			final_payable_amount_health = BigDecimal.ZERO;
			final_payable_amount_commercial = BigDecimal.ZERO;
			gwp_motor = BigDecimal.ZERO;
			gwp_health = BigDecimal.ZERO;
			gwp_commercial = BigDecimal.ZERO;
			workflow_process_instance_id = "";
			gridLog = "";
		}
		  	public String getName(){
		  		return name;
		  	}
		  	public void setName(String name){
		  	   	this.name=name;
		  	}
		  	   
		  	public Long getPayoutComponentId(){
		  		return payoutComponentId;
		  	}
		  	public void setPayoutComponentId(Long payoutComponentId){
		  	   	this.payoutComponentId=payoutComponentId;
		  	}
		  	   
		  	public BigDecimal getPayable_amount(){
		  		return payable_amount;
		  	}
		  	public void setPayable_amount(BigDecimal payable_amount){
		  	   	this.payable_amount=payable_amount;
		  	}
		  	   
		  	public String getImdName(){
		  		return imdName;
		  	}
		  	public void setImdName(String imdName){
		  	   	this.imdName=imdName;
		  	}
		  	   
		  	public BigDecimal getManual_updated_amount(){
		  		return manual_updated_amount;
		  	}
		  	public void setManual_updated_amount(BigDecimal manual_updated_amount){
		  	   	this.manual_updated_amount=manual_updated_amount;
		  	}
		  	   
		  	public BigDecimal getFinal_payable_amount(){
		  		return final_payable_amount;
		  	}
		  	public void setFinal_payable_amount(BigDecimal final_payable_amount){
		  	   	this.final_payable_amount=final_payable_amount;
		  	}
		  	   
		  	public String getGst_applicable(){
		  		return gst_applicable;
		  	}
		  	public void setGst_applicable(String gst_applicable){
		  	   	this.gst_applicable=gst_applicable;
		  	}
		  	   
		  	public String getImd_code_state(){
		  		return imd_code_state;
		  	}
		  	public void setImd_code_state(String imd_code_state){
		  	   	this.imd_code_state=imd_code_state;
		  	}
		  	   
		  	public String getImd_code_gstin(){
		  		return imd_code_gstin;
		  	}
		  	public void setImd_code_gstin(String imd_code_gstin){
		  	   	this.imd_code_gstin=imd_code_gstin;
		  	}
		  	   
		  	public BigDecimal getCgst_percentage(){
		  		return cgst_percentage;
		  	}
		  	public void setCgst_percentage(BigDecimal cgst_percentage){
		  	   	this.cgst_percentage=cgst_percentage;
		  	}
		  	   
		  	public BigDecimal getSgst_percentage(){
		  		return sgst_percentage;
		  	}
		  	public void setSgst_percentage(BigDecimal sgst_percentage){
		  	   	this.sgst_percentage=sgst_percentage;
		  	}
		  	   
		  	public BigDecimal getIgst_percentage(){
		  		return igst_percentage;
		  	}
		  	public void setIgst_percentage(BigDecimal igst_percentage){
		  	   	this.igst_percentage=igst_percentage;
		  	}
		  	   
		  	public BigDecimal getCgst_amount(){
		  		return cgst_amount;
		  	}
		  	public void setCgst_amount(BigDecimal cgst_amount){
		  	   	this.cgst_amount=cgst_amount;
		  	}
		  	   
		  	public BigDecimal getSgst_amount(){
		  		return sgst_amount;
		  	}
		  	public void setSgst_amount(BigDecimal sgst_amount){
		  	   	this.sgst_amount=sgst_amount;
		  	}
		  	   
		  	public BigDecimal getIgst_amount(){
		  		return igst_amount;
		  	}
		  	public void setIgst_amount(BigDecimal igst_amount){
		  	   	this.igst_amount=igst_amount;
		  	}
		  	   
		  	public String getUsgi_branch_state(){
		  		return usgi_branch_state;
		  	}
		  	public void setUsgi_branch_state(String usgi_branch_state){
		  	   	this.usgi_branch_state=usgi_branch_state;
		  	}
		  	   
		  	public String getUsgi_gstin(){
		  		return usgi_gstin;
		  	}
		  	public void setUsgi_gstin(String usgi_gstin){
		  	   	this.usgi_gstin=usgi_gstin;
		  	}
		  	   
		  	public BigDecimal getFinal_payable_amount_before_gst(){
		  		return final_payable_amount_before_gst;
		  	}
		  	public void setFinal_payable_amount_before_gst(BigDecimal final_payable_amount_before_gst){
		  	   	this.final_payable_amount_before_gst=final_payable_amount_before_gst;
		  	}
		  	   
		  	public String getPolicy_month(){
		  		return policy_month;
		  	}
		  	public void setPolicy_month(String policy_month){
		  	   	this.policy_month=policy_month;
		  	}
		  	   
		  	public BigDecimal getImd_total_grid_amount(){
		  		return imd_total_grid_amount;
		  	}
		  	public void setImd_total_grid_amount(BigDecimal imd_total_grid_amount){
		  	   	this.imd_total_grid_amount=imd_total_grid_amount;
		  	}
		  	   
		  	public BigDecimal getImd_total_grid_amount_health(){
		  		return imd_total_grid_amount_health;
		  	}
		  	public void setImd_total_grid_amount_health(BigDecimal imd_total_grid_amount_health){
		  	   	this.imd_total_grid_amount_health=imd_total_grid_amount_health;
		  	}
		  	   
		  	public BigDecimal getImd_net_total_grid_amount(){
		  		return imd_net_total_grid_amount;
		  	}
		  	public void setImd_net_total_grid_amount(BigDecimal imd_net_total_grid_amount){
		  	   	this.imd_net_total_grid_amount=imd_net_total_grid_amount;
		  	}
		  	   
		  	public BigDecimal getImd_total_irdai_amount(){
		  		return imd_total_irdai_amount;
		  	}
		  	public void setImd_total_irdai_amount(BigDecimal imd_total_irdai_amount){
		  	   	this.imd_total_irdai_amount=imd_total_irdai_amount;
		  	}
		  	   
		  	public BigDecimal getTds(){
		  		return tds;
		  	}
		  	public void setTds(BigDecimal tds){
		  	   	this.tds=tds;
		  	}
		  	   
		  	public BigDecimal getTds_rate(){
		  		return tds_rate;
		  	}
		  	public void setTds_rate(BigDecimal tds_rate){
		  	   	this.tds_rate=tds_rate;
		  	}
		  	   
		  	public BigDecimal getTds_exemption_limit(){
		  		return tds_exemption_limit;
		  	}
		  	public void setTds_exemption_limit(BigDecimal tds_exemption_limit){
		  	   	this.tds_exemption_limit=tds_exemption_limit;
		  	}
		  	   
		  	public BigDecimal getTds_exemption_rate(){
		  		return tds_exemption_rate;
		  	}
		  	public void setTds_exemption_rate(BigDecimal tds_exemption_rate){
		  	   	this.tds_exemption_rate=tds_exemption_rate;
		  	}
		  	   
		  	public String getTds_certificate_start_date(){
		  		return tds_certificate_start_date;
		  	}
		  	public void setTds_certificate_start_date(String tds_certificate_start_date){
		  	   	this.tds_certificate_start_date=tds_certificate_start_date;
		  	}
		  	   
		  	public String getTds_certificate_end_date(){
		  		return tds_certificate_end_date;
		  	}
		  	public void setTds_certificate_end_date(String tds_certificate_end_date){
		  	   	this.tds_certificate_end_date=tds_certificate_end_date;
		  	}
		  	   
		  	public BigDecimal getFinal_payable_amount_after_tds(){
		  		return final_payable_amount_after_tds;
		  	}
		  	public void setFinal_payable_amount_after_tds(BigDecimal final_payable_amount_after_tds){
		  	   	this.final_payable_amount_after_tds=final_payable_amount_after_tds;
		  	}
		  	   
		  	public String getIntermediary_Category(){
		  		return intermediary_Category;
		  	}
		  	public void setIntermediary_Category(String intermediary_Category){
		  	   	this.intermediary_Category=intermediary_Category;
		  	}
		  	   
		  	public String getPan_no(){
		  		return pan_no;
		  	}
		  	public void setPan_no(String pan_no){
		  	   	this.pan_no=pan_no;
		  	}
		  	   
		  	public String getIntermediary(){
		  		return intermediary;
		  	}
		  	public void setIntermediary(String intermediary){
		  	   	this.intermediary=intermediary;
		  	}
		  	   
		  	public String getIntermediary_Code(){
		  		return intermediary_Code;
		  	}
		  	public void setIntermediary_Code(String intermediary_Code){
		  	   	this.intermediary_Code=intermediary_Code;
		  	}
		  	   
		  	public String getType(){
		  		return type;
		  	}
		  	public void setType(String type){
		  	   	this.type=type;
		  	}
		  	   
		  	public Long getPayout_id(){
		  		return payout_id;
		  	}
		  	public void setPayout_id(Long payout_id){
		  	   	this.payout_id=payout_id;
		  	}
		  	   
		  	public Long getSourceId(){
		  		return sourceId;
		  	}
		  	public void setSourceId(Long sourceId){
		  	   	this.sourceId=sourceId;
		  	}
		  	   
		  	public Date getModifiedOn(){
		  		return modifiedOn;
		  	}
		  	public void setModifiedOn(Date modifiedOn){
		  	   	this.modifiedOn=modifiedOn;
		  	}
		  	   
		  	public Long getComponentSourceId(){
		  		return componentSourceId;
		  	}
		  	public void setComponentSourceId(Long componentSourceId){
		  	   	this.componentSourceId=componentSourceId;
		  	}
		  	   
		  	public String getReadyForRelease(){
		  		return readyForRelease;
		  	}
		  	public void setReadyForRelease(String readyForRelease){
		  	   	this.readyForRelease=readyForRelease;
		  	}
		  	   
		  	public Long getVersion(){
		  		return version;
		  	}
		  	public void setVersion(Long version){
		  	   	this.version=version;
		  	}
		  	   
		  	public String getStatus(){
		  		return status;
		  	}
		  	public void setStatus(String status){
		  	   	this.status=status;
		  	}
		  	   
		  	public String getProcessBusinessKey(){
		  		return processBusinessKey;
		  	}
		  	public void setProcessBusinessKey(String processBusinessKey){
		  	   	this.processBusinessKey=processBusinessKey;
		  	}
		  	   
		  	public BigDecimal getPayableAmount(){
		  		return payableAmount;
		  	}
		  	public void setPayableAmount(BigDecimal payableAmount){
		  	   	this.payableAmount=payableAmount;
		  	}
		  	   
		  	public BigDecimal getHoldAmount(){
		  		return holdAmount;
		  	}
		  	public void setHoldAmount(BigDecimal holdAmount){
		  	   	this.holdAmount=holdAmount;
		  	}
		  	   
		  	public BigDecimal getReleasedAmount(){
		  		return releasedAmount;
		  	}
		  	public void setReleasedAmount(BigDecimal releasedAmount){
		  	   	this.releasedAmount=releasedAmount;
		  	}
		  	   
		  	public Object getInputData(){
		  		return inputData;
		  	}
		  	public void setInputData(Object inputData){
		  	   	this.inputData=inputData;
		  	}
		  	   
		  	public String getWorkflowStatus(){
		  		return workflowStatus;
		  	}
		  	public void setWorkflowStatus(String workflowStatus){
		  	   	this.workflowStatus=workflowStatus;
		  	}
		  	   
		  	public String getReleaseGroup(){
		  		return releaseGroup;
		  	}
		  	public void setReleaseGroup(String releaseGroup){
		  	   	this.releaseGroup=releaseGroup;
		  	}
		  	   
		  	public Object getOutputData(){
		  		return outputData;
		  	}
		  	public void setOutputData(Object outputData){
		  	   	this.outputData=outputData;
		  	}
		  	   
		  	public Object getWorkflowDetails(){
		  		return workflowDetails;
		  	}
		  	public void setWorkflowDetails(Object workflowDetails){
		  	   	this.workflowDetails=workflowDetails;
		  	}
		  	   
		  	public String getHoldStatus(){
		  		return holdStatus;
		  	}
		  	public void setHoldStatus(String holdStatus){
		  	   	this.holdStatus=holdStatus;
		  	}
		  	   
		  	public String getId(){
		  		return id;
		  	}
		  	public void setId(String id){
		  	   	this.id=id;
		  	}
		  	   
		  	public BigDecimal getFinal_payable_amount_motor(){
		  		return final_payable_amount_motor;
		  	}
		  	public void setFinal_payable_amount_motor(BigDecimal final_payable_amount_motor){
		  	   	this.final_payable_amount_motor=final_payable_amount_motor;
		  	}
		  	   
		  	public BigDecimal getFinal_payable_amount_health(){
		  		return final_payable_amount_health;
		  	}
		  	public void setFinal_payable_amount_health(BigDecimal final_payable_amount_health){
		  	   	this.final_payable_amount_health=final_payable_amount_health;
		  	}
		  	   
		  	public BigDecimal getFinal_payable_amount_commercial(){
		  		return final_payable_amount_commercial;
		  	}
		  	public void setFinal_payable_amount_commercial(BigDecimal final_payable_amount_commercial){
		  	   	this.final_payable_amount_commercial=final_payable_amount_commercial;
		  	}
		  	   
		  	public BigDecimal getGwp_motor(){
		  		return gwp_motor;
		  	}
		  	public void setGwp_motor(BigDecimal gwp_motor){
		  	   	this.gwp_motor=gwp_motor;
		  	}
		  	   
		  	public BigDecimal getGwp_health(){
		  		return gwp_health;
		  	}
		  	public void setGwp_health(BigDecimal gwp_health){
		  	   	this.gwp_health=gwp_health;
		  	}
		  	   
		  	public BigDecimal getGwp_commercial(){
		  		return gwp_commercial;
		  	}
		  	public void setGwp_commercial(BigDecimal gwp_commercial){
		  	   	this.gwp_commercial=gwp_commercial;
		  	}
		  	   
		  	public String getWorkflow_process_instance_id(){
		  		return workflow_process_instance_id;
		  	}
		  	public void setWorkflow_process_instance_id(String workflow_process_instance_id){
		  	   	this.workflow_process_instance_id=workflow_process_instance_id;
		  	}
		  	   
		  	public String getGridLog(){
		  		return gridLog;
		  	}
		  	public void setGridLog(String gridLog){
		  	   	this.gridLog=gridLog;
		  	}
		  	   
	}
