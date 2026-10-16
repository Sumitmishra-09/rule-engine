package com.act21.impaktapps.rule.engine.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class usgi {

	private  String endorsementNo;
   	private  String varient;
   	private  BigDecimal usgiNetPremium;
   	private  String subImdCode;
   	private  BigDecimal netOdPremium;
   	private  String policyType;
   	private  BigDecimal gvw;
   	private  String rtoLocation;
   	private  String rtoState;
   	private  String businessType;
   	private  String additional;
   	private  BigDecimal discount;
   	private  BigDecimal irdaiCommissionPerc;
   	private  BigDecimal subImdCommissionSlab;
   	private  String policyNo;
   	private  String systemSubImdCode;
   	private  String subImdComputationType;
   	private  BigDecimal addOnPer;
   	private  BigDecimal tppd;
   	private  BigDecimal cpa;
   	private  BigDecimal subImdCommission;
   	private  String imdCode;
   	private  String locationTag;
   	private  String imdComputationType;
   	private  BigDecimal imdCommissionSlab;
   	private  String intermediatoryCat;
   	private  BigDecimal addonAmount;
   	private  BigDecimal imdCommission;
   	private  String productName;
   	private  BigDecimal weightage;
   	private  String cartype;
   	private  Date polReportingDate;
   	private  Long payoutComponentId;
   	private  String policy_Issue_Month_Year;
   	private  Date policy_Issue_Date;
   	private  BigDecimal policyDuration;
   	private  String policy_Status;
   	private  String policy_Flag;
   	private  String inforce_Policy;
   	private  String final_Policy_No;
   	private  String mid_Policy_No;
   	private  String ilpos_policy_number;
   	private  String proposal_Number;
   	private  String source_System;
   	private  String line_Of_Business;
   	private  String lob_Code;
   	private  String num_Product_Code;
   	private  String saod_Satp;
   	private  String calculation_Type;
   	private  BigDecimal endorsement_Count;
   	private  String endorsement_Category;
   	private  String endorsement_Type;
   	private  String endorsement_Wording;
   	private  String risk_Start_Date;
   	private  String risk_Expiry_Date;
   	private  String policy_Endorsement_Issue_Date;
   	private  String co_Insurance_Type;
   	private  String co_Insurance_Status;
   	private  String share_Pct;
   	private  String previous_Year_Insurer_Company;
   	private  String previous_Policy_Start_Date;
   	private  String previous_Policy_End_Date;
   	private  String previous_Policy_Number;
   	private  String intermediary_Code;
   	private  String intermediary;
   	private  String intermediary_State;
   	private  String intermediary_Category;
   	private  String intermediary_Type;
   	private  String multiple_Intermediaries;
   	private  String sub_Imd_Name;
   	private  String branch_Name;
   	private  String dealer_Group;
   	private  String subvertical_Channel;
   	private  String vertical_Channel_Map;
   	private  String channel_Details;
   	private  String primary_Sm_Details;
   	private  String txt_Office_Name;
   	private  String usgi_Branch_State;
   	private  String usgi_Branch_State_Code;
   	private  String ba_Name;
   	private  String primary_Sales_Manger_Id;
   	private  String primary_Sales_Manger_Name;
   	private  String customer_Name;
   	private  String insured_Age;
   	private  String customer_State;
   	private  String customer_State_Code;
   	private  String customer_Pin_Code;
   	private  String txt_Ind_Corp_Flag;
   	private  Long yr_Of_Manufacturing;
   	private  String make;
   	private  String model;
   	private  String model_Cluster;
   	private  String segment;
   	private  String geography_Of_The_Vehicle;
   	private  String registration_Date;
   	private  String motor_Registration_No;
   	private  String rto_Cluster;
   	private  String risk_Zone;
   	private  String engine_No;
   	private  String chassis_No;
   	private  String fuel_Type;
   	private  String body_Type;
   	private  Long age_Band;
   	private  String no_Claims_In_Last_3_Years;
   	private  String colour_Of_The_Vehicle;
   	private  String no_Of_Wheels;
   	private  String no_Of_Trailers;
   	private  String trailer_Type;
   	private  String vehicle_Sub_Class;
   	private  BigDecimal showroomprice_New;
   	private  BigDecimal cubic_Capacity_Amp;
   	private  Long carrying_Capacity;
   	private  String usage;
   	private  String live_Count;
   	private  String vehicle_Idv;
   	private  BigDecimal total_Si;
   	private  String breakin_Policy_Flag;
   	private  BigDecimal num_Net_Tp_Premium;
   	private  BigDecimal add_On_Premium;
   	private  BigDecimal net_Premium;
   	private  String endorsement_Od_Prem;
   	private  String endorsement_Tp_Prem;
   	private  String endorsement_Prem;
   	private  String igst;
   	private  String cgst;
   	private  String sgst;
   	private  BigDecimal usgi_Gross_Premium;
   	private  BigDecimal consolidated_Amount_Multiyr;
   	private  BigDecimal loading_Percentage;
   	private  BigDecimal loading_On_Premium;
   	private  BigDecimal discount_Percentage;
   	private  String other_Disc_Percentage;
   	private  BigDecimal discount_On_Premium;
   	private  String system_Commission_Per;
   	private  BigDecimal system_Commission_Amount;
   	private  BigDecimal advance_Premium;
   	private  BigDecimal ncb_Amount;
   	private  String ncb_Applicability;
   	private  String ncb_Percentage;
   	private  String usgi_Gstin_No;
   	private  String imd_Gstin_No;
   	private  BigDecimal terrorism_Premium;
   	private  String terrerism_Share;
   	private  String premium_Greater_Than_1_Lac;
   	private  String payment_Mode;
   	private  String payment_Frequency;
   	private  String discripancies_Raised_Count;
   	private  String discripancy_Resolved_Count;
   	private  String fleet_Name_Owner_Name;
   	private  String vle_Details_For_Csc;
   	private  String loss_Ratio;
   	private  String severity;
   	private  String frequency;
   	private  String close_Proximity;
   	private  String fraud_Claim_Reported_If_Any;
   	private  String deviations_Availed;
   	private  String deviations_Details;
   	private  String preffered_Garage;
   	private  String break_In_Period;
   	private  String insured_Details;
   	private  String insured_Details2;
   	private  String risk_Details;
   	private  String risk_Location;
   	private  String occupancy;
   	private  BigDecimal cover_Details;
   	private  String ld_Details;
   	private  String add_On_Covers;
   	private  String add_On_Plan_Name;
   	private  String add_On_Flag;
   	private  String cpa_Flag;
   	private  String financier;
   	private  String preffered_Reffered;
   	private  String inwarding_Details;
   	private  String vehicle_Group_Name;
   	private  String tonnage;
   	private  String state_Group_Name;
   	private  String declined_flag;
   	private  BigDecimal commission_Perc;
   	private  BigDecimal net_Commission;
   	private  String gwp_slab;
   	private  String state_code;
   	private  BigDecimal rate;
   	private  BigDecimal additional_Percentage;
   	private  BigDecimal no_of_health_policies;
   	private  BigDecimal total_health_gwp;
   	private  BigDecimal od_Commission;
   	private  String name;
   	private  String payeeName;
   	private  String type;
   	private  String policy_type_new;
   	private  BigDecimal id;
   	private  String rto_code;
   	private  String considered_flag;
   	private  BigDecimal grid_percentage;
   	private  BigDecimal grid_amount_on_OD;
   	private  BigDecimal grid_amount_on_TP;
   	private  BigDecimal total_grid_amount;
   	private  BigDecimal grid_amount_health_on_OD;
   	private  BigDecimal grid_amount_health_on_TP;
   	private  BigDecimal total_grid_amount_health;
   	private  BigDecimal total_grid_amount_on_od_per;
   	private  BigDecimal total_grid_amount_on_tp_per;
   	private  BigDecimal net_total_grid_amount;
   	private  BigDecimal grid_on_OD_pr_discount;
   	private  BigDecimal grid_on_TP_pr_discount;
   	private  BigDecimal grid_on_total_pr_discount;
   	private  BigDecimal final_grid_payable_on_OD;
   	private  BigDecimal final_grid_payable_on_TP;
   	private  BigDecimal final_grid_payable;
   	private  BigDecimal irdai_amount_on_OD;
   	private  BigDecimal irdai_amount_on_TP;
   	private  BigDecimal total_irdai_amount;
   	private  BigDecimal cgstPercentage;
   	private  BigDecimal sgstPercentage;
   	private  BigDecimal igstPercentage;
   	private  BigDecimal cgstAmount;
   	private  BigDecimal sgstAmount;
   	private  BigDecimal igstAmount;
   	private  String gst_applicable;
   	private  BigDecimal final_amount;
   	private  String imd_code_state;
   	private  String agency_name;
   	private  String gstin;
   	private  String imd_code_gstin;
   	private  String bankaccno;
   	private  String bank_ifsc_code;
   	private  BigDecimal total_non_motor_gwp;
   	private  BigDecimal total_non_motor_count;
   	private  String processbusinessKey;
   	private  String eom_cluster;
   	private  String asm;
   	private  String csm;
   	private  String vehicle_segment;
   	private  String exception_applicable_grid;
   	private  BigDecimal exception_additional_percentage;
   	private  BigDecimal exception_flat_percentage;
   	private  String exception_applicable_on_od_net;
   	private  String pan_no;
   	private  BigDecimal tds_rate;
   	private  BigDecimal tds_exemption_limit;
   	private  BigDecimal tds_exemption_rate;
   	private  Date tds_certificate_start_date;
   	private  Date tds_certificate_end_date;
   	private  BigDecimal tds;
   	private  BigDecimal imdTotalCommissionAmount;
   	private  BigDecimal imdTotalGridPercentage;
   	private  BigDecimal manual_updation_final_amount;
   	private  String manual_updation_flag;
   	private  BigDecimal total_amount;
   	private  String case_type;
   	private  BigDecimal irda_od_perc;
   	private  BigDecimal irda_tp_perc;
   	private  String vehicle_model;
   	private  String vehicle_make;
   	private  BigDecimal total_gwp_new_tractor;
   	private  BigDecimal total_gwp_lcv_lte_2_pt_5;
   	private  BigDecimal total_gwp_lcv_lte_3_pt_5;
   	private  BigDecimal total_gwp_pvt_car;
   	private  BigDecimal final_grid_percentage;
   	private  BigDecimal final_additional_percentage;
   	private  String pvt_car_state_group;
   	private  BigDecimal gwp;
   	private  BigDecimal total_lcv_premium;
   	private  String gwp_consider;
   	private  String gwp_calculation_formula;
   	private  BigDecimal max_capping_perc;
   	private  Map<String,BigDecimal> premium_map;
   	private  Map<String,BigDecimal> gwp_map;
   	private  Long date_of_policy_issue;
   	private  BigDecimal final_gwp;
   	private  BigDecimal exception_gwp;
   	private  BigDecimal non_bolero_contribution;
   	private  BigDecimal non_bolero_business;
   	private  String exception_id;
   	private  BigDecimal special_deduction;
   	private  String remarks;
   	private  BigDecimal new_var;
   	private  BigDecimal capping_grid_percentage;
   	private  String readyForRelease;
   	private  Long componentSourceId;
   	private  Long sourceId;
   	private  Date modifiedOn;
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
   	private  String computation;
   	private  BigDecimal vehicle_age;
   	private  BigDecimal irda_percentage;
   	private  BigDecimal fresh_business_perc;
   	private  BigDecimal default_percentage;
   	private  BigDecimal usgi_net_pr_less_tp_pr;
   	private  Long seating_capacity;
   	private  String direct_code_flag;
   	private  BigDecimal pre_final_grid_percentage;
   	private  String pre_computation;
   	private  Long long_term_year;
   	private  String long_term_flag;
   	private  BigDecimal long_term_percentage;
   	private  BigDecimal long_term_amount;
   	private  Date purchase_date;
   	private  String breaking_flag;
   	private  String final_dealer_code;
   	private  String preferred_referred;
   	private  BigDecimal health_fresh_premium;
   	private  String grid_id;
   	private  Date policy_start_date;
   	private  Date policy_end_date;
   	private  Long no_of_days;
   	private  String policy_issuance_state;
   	private  BigDecimal agent_mentor_percentage;
   	private  BigDecimal agent_mentor_final_percentage;
   	private  String agent_mentor_computation;
   	private  BigDecimal agent_mentor_amount;
   	private  BigDecimal total_dealer_amount;
   	private  String agent_mentor_id;
   	private  BigDecimal topline;
   	private  BigDecimal bottomline;
   	private  BigDecimal lossratio;
   	private  BigDecimal commission_check;
   	private  String concat_column;
   	private  String sub_channel_flag;
   	private  String product_flag;
   	private  Long sub_lob;
   	private  BigDecimal sum_insured;
   	private  String gridLog;
   	
   	private String marks_on_range;
   	private BigDecimal total_marks;
   	private String performance_level;
   	
   	
   	
   	public String getMarks_on_range() {
		return marks_on_range;
	}
	public void setMarks_on_range(String marks_on_range) {
		this.marks_on_range = marks_on_range;
	}
	public BigDecimal getTotal_marks() {
		return total_marks;
	}
	public void setTotal_marks(BigDecimal total_marks) {
		this.total_marks = total_marks;
	}
	public String getPerformance_level() {
		return performance_level;
	}
	public void setPerformance_level(String performance_level) {
		this.performance_level = performance_level;
	}
	public usgi() {
		endorsementNo = "";
		varient = "";
		usgiNetPremium = BigDecimal.ZERO;
		subImdCode = "";
		netOdPremium = BigDecimal.ZERO;
		policyType = "";
		gvw = BigDecimal.ZERO;
		rtoLocation = "";
		rtoState = "";
		businessType = "";
		additional = "";
		discount = BigDecimal.ZERO;
		irdaiCommissionPerc = BigDecimal.ZERO;
		subImdCommissionSlab = BigDecimal.ZERO;
		policyNo = "";
		systemSubImdCode = "";
		subImdComputationType = "";
		addOnPer = BigDecimal.ZERO;
		tppd = BigDecimal.ZERO;
		cpa = BigDecimal.ZERO;
		subImdCommission = BigDecimal.ZERO;
		imdCode = "";
		locationTag = "";
		imdComputationType = "";
		imdCommissionSlab = BigDecimal.ZERO;
		intermediatoryCat = "";
		addonAmount = BigDecimal.ZERO;
		imdCommission = BigDecimal.ZERO;
		productName = "";
		weightage = BigDecimal.ZERO;
		cartype = "";
		polReportingDate = new Date();
		payoutComponentId = 0L;
		policy_Issue_Month_Year = "";
		policy_Issue_Date = new Date();
		policyDuration = BigDecimal.ZERO;
		policy_Status = "";
		policy_Flag = "";
		inforce_Policy = "";
		final_Policy_No = "";
		mid_Policy_No = "";
		ilpos_policy_number = "";
		proposal_Number = "";
		source_System = "";
		line_Of_Business = "";
		lob_Code = "";
		num_Product_Code = "";
		saod_Satp = "";
		calculation_Type = "";
		endorsement_Count = BigDecimal.ZERO;
		endorsement_Category = "";
		endorsement_Type = "";
		endorsement_Wording = "";
		risk_Start_Date = "";
		risk_Expiry_Date = "";
		policy_Endorsement_Issue_Date = "";
		co_Insurance_Type = "";
		co_Insurance_Status = "";
		share_Pct = "";
		previous_Year_Insurer_Company = "";
		previous_Policy_Start_Date = "";
		previous_Policy_End_Date = "";
		previous_Policy_Number = "";
		intermediary_Code = "";
		intermediary = "";
		intermediary_State = "";
		intermediary_Category = "";
		intermediary_Type = "";
		multiple_Intermediaries = "";
		sub_Imd_Name = "";
		branch_Name = "";
		dealer_Group = "";
		subvertical_Channel = "";
		vertical_Channel_Map = "";
		channel_Details = "";
		primary_Sm_Details = "";
		txt_Office_Name = "";
		usgi_Branch_State = "";
		usgi_Branch_State_Code = "";
		ba_Name = "";
		primary_Sales_Manger_Id = "";
		primary_Sales_Manger_Name = "";
		customer_Name = "";
		insured_Age = "";
		customer_State = "";
		customer_State_Code = "";
		customer_Pin_Code = "";
		txt_Ind_Corp_Flag = "";
		yr_Of_Manufacturing = 0L;
		make = "";
		model = "";
		model_Cluster = "";
		segment = "";
		geography_Of_The_Vehicle = "";
		registration_Date = "";
		motor_Registration_No = "";
		rto_Cluster = "";
		risk_Zone = "";
		engine_No = "";
		chassis_No = "";
		fuel_Type = "";
		body_Type = "";
		age_Band = 0L;
		no_Claims_In_Last_3_Years = "";
		colour_Of_The_Vehicle = "";
		no_Of_Wheels = "";
		no_Of_Trailers = "";
		trailer_Type = "";
		vehicle_Sub_Class = "";
		showroomprice_New = BigDecimal.ZERO;
		cubic_Capacity_Amp = BigDecimal.ZERO;
		carrying_Capacity = 0L;
		usage = "";
		live_Count = "";
		vehicle_Idv = "";
		total_Si = BigDecimal.ZERO;
		breakin_Policy_Flag = "";
		num_Net_Tp_Premium = BigDecimal.ZERO;
		add_On_Premium = BigDecimal.ZERO;
		net_Premium = BigDecimal.ZERO;
		endorsement_Od_Prem = "";
		endorsement_Tp_Prem = "";
		endorsement_Prem = "";
		igst = "";
		cgst = "";
		sgst = "";
		usgi_Gross_Premium = BigDecimal.ZERO;
		consolidated_Amount_Multiyr = BigDecimal.ZERO;
		loading_Percentage = BigDecimal.ZERO;
		loading_On_Premium = BigDecimal.ZERO;
		discount_Percentage = BigDecimal.ZERO;
		other_Disc_Percentage = "";
		discount_On_Premium = BigDecimal.ZERO;
		system_Commission_Per = "";
		system_Commission_Amount = BigDecimal.ZERO;
		advance_Premium = BigDecimal.ZERO;
		ncb_Amount = BigDecimal.ZERO;
		ncb_Applicability = "";
		ncb_Percentage = "";
		usgi_Gstin_No = "";
		imd_Gstin_No = "";
		terrorism_Premium = BigDecimal.ZERO;
		terrerism_Share = "";
		premium_Greater_Than_1_Lac = "";
		payment_Mode = "";
		payment_Frequency = "";
		discripancies_Raised_Count = "";
		discripancy_Resolved_Count = "";
		fleet_Name_Owner_Name = "";
		vle_Details_For_Csc = "";
		loss_Ratio = "";
		severity = "";
		frequency = "";
		close_Proximity = "";
		fraud_Claim_Reported_If_Any = "";
		deviations_Availed = "";
		deviations_Details = "";
		preffered_Garage = "";
		break_In_Period = "";
		insured_Details = "";
		insured_Details2 = "";
		risk_Details = "";
		risk_Location = "";
		occupancy = "";
		cover_Details = BigDecimal.ZERO;
		ld_Details = "";
		add_On_Covers = "";
		add_On_Plan_Name = "";
		add_On_Flag = "";
		cpa_Flag = "";
		financier = "";
		preffered_Reffered = "";
		inwarding_Details = "";
		vehicle_Group_Name = "";
		tonnage = "";
		state_Group_Name = "";
		declined_flag = "";
		commission_Perc = BigDecimal.ZERO;
		net_Commission = BigDecimal.ZERO;
		gwp_slab = "";
		state_code = "";
		rate = BigDecimal.ZERO;
		additional_Percentage = BigDecimal.ZERO;
		no_of_health_policies = BigDecimal.ZERO;
		total_health_gwp = BigDecimal.ZERO;
		od_Commission = BigDecimal.ZERO;
		name = "";
		payeeName = "";
		type = "";
		policy_type_new = "";
		id = BigDecimal.ZERO;
		rto_code = "";
		considered_flag = "";
		grid_percentage = BigDecimal.ZERO;
		grid_amount_on_OD = BigDecimal.ZERO;
		grid_amount_on_TP = BigDecimal.ZERO;
		total_grid_amount = BigDecimal.ZERO;
		grid_amount_health_on_OD = BigDecimal.ZERO;
		grid_amount_health_on_TP = BigDecimal.ZERO;
		total_grid_amount_health = BigDecimal.ZERO;
		total_grid_amount_on_od_per = BigDecimal.ZERO;
		total_grid_amount_on_tp_per = BigDecimal.ZERO;
		net_total_grid_amount = BigDecimal.ZERO;
		grid_on_OD_pr_discount = BigDecimal.ZERO;
		grid_on_TP_pr_discount = BigDecimal.ZERO;
		grid_on_total_pr_discount = BigDecimal.ZERO;
		final_grid_payable_on_OD = BigDecimal.ZERO;
		final_grid_payable_on_TP = BigDecimal.ZERO;
		final_grid_payable = BigDecimal.ZERO;
		irdai_amount_on_OD = BigDecimal.ZERO;
		irdai_amount_on_TP = BigDecimal.ZERO;
		total_irdai_amount = BigDecimal.ZERO;
		cgstPercentage = BigDecimal.ZERO;
		sgstPercentage = BigDecimal.ZERO;
		igstPercentage = BigDecimal.ZERO;
		cgstAmount = BigDecimal.ZERO;
		sgstAmount = BigDecimal.ZERO;
		igstAmount = BigDecimal.ZERO;
		gst_applicable = "";
		final_amount = BigDecimal.ZERO;
		imd_code_state = "";
		agency_name = "";
		gstin = "";
		imd_code_gstin = "";
		bankaccno = "";
		bank_ifsc_code = "";
		total_non_motor_gwp = BigDecimal.ZERO;
		total_non_motor_count = BigDecimal.ZERO;
		processbusinessKey = "";
		eom_cluster = "";
		asm = "";
		csm = "";
		vehicle_segment = "";
		exception_applicable_grid = "";
		exception_additional_percentage = BigDecimal.ZERO;
		exception_flat_percentage = BigDecimal.ZERO;
		exception_applicable_on_od_net = "";
		pan_no = "";
		tds_rate = BigDecimal.ZERO;
		tds_exemption_limit = BigDecimal.ZERO;
		tds_exemption_rate = BigDecimal.ZERO;
		tds_certificate_start_date = new Date();
		tds_certificate_end_date = new Date();
		tds = BigDecimal.ZERO;
		imdTotalCommissionAmount = BigDecimal.ZERO;
		imdTotalGridPercentage = BigDecimal.ZERO;
		manual_updation_final_amount = BigDecimal.ZERO;
		manual_updation_flag = "";
		total_amount = BigDecimal.ZERO;
		case_type = "";
		irda_od_perc = BigDecimal.ZERO;
		irda_tp_perc = BigDecimal.ZERO;
		vehicle_model = "";
		vehicle_make = "";
		total_gwp_new_tractor = BigDecimal.ZERO;
		total_gwp_lcv_lte_2_pt_5 = BigDecimal.ZERO;
		total_gwp_lcv_lte_3_pt_5 = BigDecimal.ZERO;
		total_gwp_pvt_car = BigDecimal.ZERO;
		final_grid_percentage = BigDecimal.ZERO;
		final_additional_percentage = BigDecimal.ZERO;
		pvt_car_state_group = "";
		gwp = BigDecimal.ZERO;
		total_lcv_premium = BigDecimal.ZERO;
		gwp_consider = "";
		gwp_calculation_formula = "";
		max_capping_perc = BigDecimal.ZERO;
		premium_map = new HashMap<>();
		gwp_map = new HashMap<>();
		date_of_policy_issue = 0L;
		final_gwp = BigDecimal.ZERO;
		exception_gwp = BigDecimal.ZERO;
		non_bolero_contribution = BigDecimal.ZERO;
		non_bolero_business = BigDecimal.ZERO;
		exception_id = "";
		special_deduction = BigDecimal.ZERO;
		remarks = "";
		new_var = BigDecimal.ZERO;
		capping_grid_percentage = BigDecimal.ZERO;
		readyForRelease = "";
		componentSourceId = 0L;
		sourceId = 0L;
		modifiedOn = new Date();
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
		computation = "";
		vehicle_age = BigDecimal.ZERO;
		irda_percentage = BigDecimal.ZERO;
		fresh_business_perc = BigDecimal.ZERO;
		default_percentage = BigDecimal.ZERO;
		usgi_net_pr_less_tp_pr = BigDecimal.ZERO;
		seating_capacity = 0L;
		direct_code_flag = "";
		pre_final_grid_percentage = BigDecimal.ZERO;
		pre_computation = "";
		long_term_year = 0L;
		long_term_flag = "";
		long_term_percentage = BigDecimal.ZERO;
		long_term_amount = BigDecimal.ZERO;
		purchase_date = new Date();
		breaking_flag = "";
		final_dealer_code = "";
		preferred_referred = "";
		health_fresh_premium = BigDecimal.ZERO;
		grid_id = "";
		policy_start_date = new Date();
		policy_end_date = new Date();
		no_of_days = 0L;
		policy_issuance_state = "";
		agent_mentor_percentage = BigDecimal.ZERO;
		agent_mentor_final_percentage = BigDecimal.ZERO;
		agent_mentor_computation = "";
		agent_mentor_amount = BigDecimal.ZERO;
		total_dealer_amount = BigDecimal.ZERO;
		agent_mentor_id = "";
		topline = BigDecimal.ZERO;
		bottomline = BigDecimal.ZERO;
		lossratio = BigDecimal.ZERO;
		commission_check = BigDecimal.ZERO;
		concat_column = "";
		sub_channel_flag = "";
		product_flag = "";
		sub_lob = 0L;
		sum_insured = BigDecimal.ZERO;
		gridLog = "";
	}
	  	public String getEndorsementNo(){
	  		return endorsementNo;
	  	}
	  	public void setEndorsementNo(String endorsementNo){
	  	   	this.endorsementNo=endorsementNo;
	  	}
	  	   
	  	public String getVarient(){
	  		return varient;
	  	}
	  	public void setVarient(String varient){
	  	   	this.varient=varient;
	  	}
	  	   
	  	public BigDecimal getUsgiNetPremium(){
	  		return usgiNetPremium;
	  	}
	  	public void setUsgiNetPremium(BigDecimal usgiNetPremium){
	  	   	this.usgiNetPremium=usgiNetPremium;
	  	}
	  	   
	  	public String getSubImdCode(){
	  		return subImdCode;
	  	}
	  	public void setSubImdCode(String subImdCode){
	  	   	this.subImdCode=subImdCode;
	  	}
	  	   
	  	public BigDecimal getNetOdPremium(){
	  		return netOdPremium;
	  	}
	  	public void setNetOdPremium(BigDecimal netOdPremium){
	  	   	this.netOdPremium=netOdPremium;
	  	}
	  	   
	  	public String getPolicyType(){
	  		return policyType;
	  	}
	  	public void setPolicyType(String policyType){
	  	   	this.policyType=policyType;
	  	}
	  	   
	  	public BigDecimal getGvw(){
	  		return gvw;
	  	}
	  	public void setGvw(BigDecimal gvw){
	  	   	this.gvw=gvw;
	  	}
	  	   
	  	public String getRtoLocation(){
	  		return rtoLocation;
	  	}
	  	public void setRtoLocation(String rtoLocation){
	  	   	this.rtoLocation=rtoLocation;
	  	}
	  	   
	  	public String getRtoState(){
	  		return rtoState;
	  	}
	  	public void setRtoState(String rtoState){
	  	   	this.rtoState=rtoState;
	  	}
	  	   
	  	public String getBusinessType(){
	  		return businessType;
	  	}
	  	public void setBusinessType(String businessType){
	  	   	this.businessType=businessType;
	  	}
	  	   
	  	public String getAdditional(){
	  		return additional;
	  	}
	  	public void setAdditional(String additional){
	  	   	this.additional=additional;
	  	}
	  	   
	  	public BigDecimal getDiscount(){
	  		return discount;
	  	}
	  	public void setDiscount(BigDecimal discount){
	  	   	this.discount=discount;
	  	}
	  	   
	  	public BigDecimal getIrdaiCommissionPerc(){
	  		return irdaiCommissionPerc;
	  	}
	  	public void setIrdaiCommissionPerc(BigDecimal irdaiCommissionPerc){
	  	   	this.irdaiCommissionPerc=irdaiCommissionPerc;
	  	}
	  	   
	  	public BigDecimal getSubImdCommissionSlab(){
	  		return subImdCommissionSlab;
	  	}
	  	public void setSubImdCommissionSlab(BigDecimal subImdCommissionSlab){
	  	   	this.subImdCommissionSlab=subImdCommissionSlab;
	  	}
	  	   
	  	public String getPolicyNo(){
	  		return policyNo;
	  	}
	  	public void setPolicyNo(String policyNo){
	  	   	this.policyNo=policyNo;
	  	}
	  	   
	  	public String getSystemSubImdCode(){
	  		return systemSubImdCode;
	  	}
	  	public void setSystemSubImdCode(String systemSubImdCode){
	  	   	this.systemSubImdCode=systemSubImdCode;
	  	}
	  	   
	  	public String getSubImdComputationType(){
	  		return subImdComputationType;
	  	}
	  	public void setSubImdComputationType(String subImdComputationType){
	  	   	this.subImdComputationType=subImdComputationType;
	  	}
	  	   
	  	public BigDecimal getAddOnPer(){
	  		return addOnPer;
	  	}
	  	public void setAddOnPer(BigDecimal addOnPer){
	  	   	this.addOnPer=addOnPer;
	  	}
	  	   
	  	public BigDecimal getTppd(){
	  		return tppd;
	  	}
	  	public void setTppd(BigDecimal tppd){
	  	   	this.tppd=tppd;
	  	}
	  	   
	  	public BigDecimal getCpa(){
	  		return cpa;
	  	}
	  	public void setCpa(BigDecimal cpa){
	  	   	this.cpa=cpa;
	  	}
	  	   
	  	public BigDecimal getSubImdCommission(){
	  		return subImdCommission;
	  	}
	  	public void setSubImdCommission(BigDecimal subImdCommission){
	  	   	this.subImdCommission=subImdCommission;
	  	}
	  	   
	  	public String getImdCode(){
	  		return imdCode;
	  	}
	  	public void setImdCode(String imdCode){
	  	   	this.imdCode=imdCode;
	  	}
	  	   
	  	public String getLocationTag(){
	  		return locationTag;
	  	}
	  	public void setLocationTag(String locationTag){
	  	   	this.locationTag=locationTag;
	  	}
	  	   
	  	public String getImdComputationType(){
	  		return imdComputationType;
	  	}
	  	public void setImdComputationType(String imdComputationType){
	  	   	this.imdComputationType=imdComputationType;
	  	}
	  	   
	  	public BigDecimal getImdCommissionSlab(){
	  		return imdCommissionSlab;
	  	}
	  	public void setImdCommissionSlab(BigDecimal imdCommissionSlab){
	  	   	this.imdCommissionSlab=imdCommissionSlab;
	  	}
	  	   
	  	public String getIntermediatoryCat(){
	  		return intermediatoryCat;
	  	}
	  	public void setIntermediatoryCat(String intermediatoryCat){
	  	   	this.intermediatoryCat=intermediatoryCat;
	  	}
	  	   
	  	public BigDecimal getAddonAmount(){
	  		return addonAmount;
	  	}
	  	public void setAddonAmount(BigDecimal addonAmount){
	  	   	this.addonAmount=addonAmount;
	  	}
	  	   
	  	public BigDecimal getImdCommission(){
	  		return imdCommission;
	  	}
	  	public void setImdCommission(BigDecimal imdCommission){
	  	   	this.imdCommission=imdCommission;
	  	}
	  	   
	  	public String getProductName(){
	  		return productName;
	  	}
	  	public void setProductName(String productName){
	  	   	this.productName=productName;
	  	}
	  	   
	  	public BigDecimal getWeightage(){
	  		return weightage;
	  	}
	  	public void setWeightage(BigDecimal weightage){
	  	   	this.weightage=weightage;
	  	}
	  	   
	  	public String getCartype(){
	  		return cartype;
	  	}
	  	public void setCartype(String cartype){
	  	   	this.cartype=cartype;
	  	}
	  	   
	  	public Date getPolReportingDate(){
	  		return polReportingDate;
	  	}
	  	public void setPolReportingDate(Date polReportingDate){
	  	   	this.polReportingDate=polReportingDate;
	  	}
	  	   
	  	public Long getPayoutComponentId(){
	  		return payoutComponentId;
	  	}
	  	public void setPayoutComponentId(Long payoutComponentId){
	  	   	this.payoutComponentId=payoutComponentId;
	  	}
	  	   
	  	public String getPolicy_Issue_Month_Year(){
	  		return policy_Issue_Month_Year;
	  	}
	  	public void setPolicy_Issue_Month_Year(String policy_Issue_Month_Year){
	  	   	this.policy_Issue_Month_Year=policy_Issue_Month_Year;
	  	}
	  	   
	  	public Date getPolicy_Issue_Date(){
	  		return policy_Issue_Date;
	  	}
	  	public void setPolicy_Issue_Date(Date policy_Issue_Date){
	  	   	this.policy_Issue_Date=policy_Issue_Date;
	  	}
	  	   
	  	public BigDecimal getPolicyDuration(){
	  		return policyDuration;
	  	}
	  	public void setPolicyDuration(BigDecimal policyDuration){
	  	   	this.policyDuration=policyDuration;
	  	}
	  	   
	  	public String getPolicy_Status(){
	  		return policy_Status;
	  	}
	  	public void setPolicy_Status(String policy_Status){
	  	   	this.policy_Status=policy_Status;
	  	}
	  	   
	  	public String getPolicy_Flag(){
	  		return policy_Flag;
	  	}
	  	public void setPolicy_Flag(String policy_Flag){
	  	   	this.policy_Flag=policy_Flag;
	  	}
	  	   
	  	public String getInforce_Policy(){
	  		return inforce_Policy;
	  	}
	  	public void setInforce_Policy(String inforce_Policy){
	  	   	this.inforce_Policy=inforce_Policy;
	  	}
	  	   
	  	public String getFinal_Policy_No(){
	  		return final_Policy_No;
	  	}
	  	public void setFinal_Policy_No(String final_Policy_No){
	  	   	this.final_Policy_No=final_Policy_No;
	  	}
	  	   
	  	public String getMid_Policy_No(){
	  		return mid_Policy_No;
	  	}
	  	public void setMid_Policy_No(String mid_Policy_No){
	  	   	this.mid_Policy_No=mid_Policy_No;
	  	}
	  	   
	  	public String getIlpos_policy_number(){
	  		return ilpos_policy_number;
	  	}
	  	public void setIlpos_policy_number(String ilpos_policy_number){
	  	   	this.ilpos_policy_number=ilpos_policy_number;
	  	}
	  	   
	  	public String getProposal_Number(){
	  		return proposal_Number;
	  	}
	  	public void setProposal_Number(String proposal_Number){
	  	   	this.proposal_Number=proposal_Number;
	  	}
	  	   
	  	public String getSource_System(){
	  		return source_System;
	  	}
	  	public void setSource_System(String source_System){
	  	   	this.source_System=source_System;
	  	}
	  	   
	  	public String getLine_Of_Business(){
	  		return line_Of_Business;
	  	}
	  	public void setLine_Of_Business(String line_Of_Business){
	  	   	this.line_Of_Business=line_Of_Business;
	  	}
	  	   
	  	public String getLob_Code(){
	  		return lob_Code;
	  	}
	  	public void setLob_Code(String lob_Code){
	  	   	this.lob_Code=lob_Code;
	  	}
	  	   
	  	public String getNum_Product_Code(){
	  		return num_Product_Code;
	  	}
	  	public void setNum_Product_Code(String num_Product_Code){
	  	   	this.num_Product_Code=num_Product_Code;
	  	}
	  	   
	  	public String getSaod_Satp(){
	  		return saod_Satp;
	  	}
	  	public void setSaod_Satp(String saod_Satp){
	  	   	this.saod_Satp=saod_Satp;
	  	}
	  	   
	  	public String getCalculation_Type(){
	  		return calculation_Type;
	  	}
	  	public void setCalculation_Type(String calculation_Type){
	  	   	this.calculation_Type=calculation_Type;
	  	}
	  	   
	  	public BigDecimal getEndorsement_Count(){
	  		return endorsement_Count;
	  	}
	  	public void setEndorsement_Count(BigDecimal endorsement_Count){
	  	   	this.endorsement_Count=endorsement_Count;
	  	}
	  	   
	  	public String getEndorsement_Category(){
	  		return endorsement_Category;
	  	}
	  	public void setEndorsement_Category(String endorsement_Category){
	  	   	this.endorsement_Category=endorsement_Category;
	  	}
	  	   
	  	public String getEndorsement_Type(){
	  		return endorsement_Type;
	  	}
	  	public void setEndorsement_Type(String endorsement_Type){
	  	   	this.endorsement_Type=endorsement_Type;
	  	}
	  	   
	  	public String getEndorsement_Wording(){
	  		return endorsement_Wording;
	  	}
	  	public void setEndorsement_Wording(String endorsement_Wording){
	  	   	this.endorsement_Wording=endorsement_Wording;
	  	}
	  	   
	  	public String getRisk_Start_Date(){
	  		return risk_Start_Date;
	  	}
	  	public void setRisk_Start_Date(String risk_Start_Date){
	  	   	this.risk_Start_Date=risk_Start_Date;
	  	}
	  	   
	  	public String getRisk_Expiry_Date(){
	  		return risk_Expiry_Date;
	  	}
	  	public void setRisk_Expiry_Date(String risk_Expiry_Date){
	  	   	this.risk_Expiry_Date=risk_Expiry_Date;
	  	}
	  	   
	  	public String getPolicy_Endorsement_Issue_Date(){
	  		return policy_Endorsement_Issue_Date;
	  	}
	  	public void setPolicy_Endorsement_Issue_Date(String policy_Endorsement_Issue_Date){
	  	   	this.policy_Endorsement_Issue_Date=policy_Endorsement_Issue_Date;
	  	}
	  	   
	  	public String getCo_Insurance_Type(){
	  		return co_Insurance_Type;
	  	}
	  	public void setCo_Insurance_Type(String co_Insurance_Type){
	  	   	this.co_Insurance_Type=co_Insurance_Type;
	  	}
	  	   
	  	public String getCo_Insurance_Status(){
	  		return co_Insurance_Status;
	  	}
	  	public void setCo_Insurance_Status(String co_Insurance_Status){
	  	   	this.co_Insurance_Status=co_Insurance_Status;
	  	}
	  	   
	  	public String getShare_Pct(){
	  		return share_Pct;
	  	}
	  	public void setShare_Pct(String share_Pct){
	  	   	this.share_Pct=share_Pct;
	  	}
	  	   
	  	public String getPrevious_Year_Insurer_Company(){
	  		return previous_Year_Insurer_Company;
	  	}
	  	public void setPrevious_Year_Insurer_Company(String previous_Year_Insurer_Company){
	  	   	this.previous_Year_Insurer_Company=previous_Year_Insurer_Company;
	  	}
	  	   
	  	public String getPrevious_Policy_Start_Date(){
	  		return previous_Policy_Start_Date;
	  	}
	  	public void setPrevious_Policy_Start_Date(String previous_Policy_Start_Date){
	  	   	this.previous_Policy_Start_Date=previous_Policy_Start_Date;
	  	}
	  	   
	  	public String getPrevious_Policy_End_Date(){
	  		return previous_Policy_End_Date;
	  	}
	  	public void setPrevious_Policy_End_Date(String previous_Policy_End_Date){
	  	   	this.previous_Policy_End_Date=previous_Policy_End_Date;
	  	}
	  	   
	  	public String getPrevious_Policy_Number(){
	  		return previous_Policy_Number;
	  	}
	  	public void setPrevious_Policy_Number(String previous_Policy_Number){
	  	   	this.previous_Policy_Number=previous_Policy_Number;
	  	}
	  	   
	  	public String getIntermediary_Code(){
	  		return intermediary_Code;
	  	}
	  	public void setIntermediary_Code(String intermediary_Code){
	  	   	this.intermediary_Code=intermediary_Code;
	  	}
	  	   
	  	public String getIntermediary(){
	  		return intermediary;
	  	}
	  	public void setIntermediary(String intermediary){
	  	   	this.intermediary=intermediary;
	  	}
	  	   
	  	public String getIntermediary_State(){
	  		return intermediary_State;
	  	}
	  	public void setIntermediary_State(String intermediary_State){
	  	   	this.intermediary_State=intermediary_State;
	  	}
	  	   
	  	public String getIntermediary_Category(){
	  		return intermediary_Category;
	  	}
	  	public void setIntermediary_Category(String intermediary_Category){
	  	   	this.intermediary_Category=intermediary_Category;
	  	}
	  	   
	  	public String getIntermediary_Type(){
	  		return intermediary_Type;
	  	}
	  	public void setIntermediary_Type(String intermediary_Type){
	  	   	this.intermediary_Type=intermediary_Type;
	  	}
	  	   
	  	public String getMultiple_Intermediaries(){
	  		return multiple_Intermediaries;
	  	}
	  	public void setMultiple_Intermediaries(String multiple_Intermediaries){
	  	   	this.multiple_Intermediaries=multiple_Intermediaries;
	  	}
	  	   
	  	public String getSub_Imd_Name(){
	  		return sub_Imd_Name;
	  	}
	  	public void setSub_Imd_Name(String sub_Imd_Name){
	  	   	this.sub_Imd_Name=sub_Imd_Name;
	  	}
	  	   
	  	public String getBranch_Name(){
	  		return branch_Name;
	  	}
	  	public void setBranch_Name(String branch_Name){
	  	   	this.branch_Name=branch_Name;
	  	}
	  	   
	  	public String getDealer_Group(){
	  		return dealer_Group;
	  	}
	  	public void setDealer_Group(String dealer_Group){
	  	   	this.dealer_Group=dealer_Group;
	  	}
	  	   
	  	public String getSubvertical_Channel(){
	  		return subvertical_Channel;
	  	}
	  	public void setSubvertical_Channel(String subvertical_Channel){
	  	   	this.subvertical_Channel=subvertical_Channel;
	  	}
	  	   
	  	public String getVertical_Channel_Map(){
	  		return vertical_Channel_Map;
	  	}
	  	public void setVertical_Channel_Map(String vertical_Channel_Map){
	  	   	this.vertical_Channel_Map=vertical_Channel_Map;
	  	}
	  	   
	  	public String getChannel_Details(){
	  		return channel_Details;
	  	}
	  	public void setChannel_Details(String channel_Details){
	  	   	this.channel_Details=channel_Details;
	  	}
	  	   
	  	public String getPrimary_Sm_Details(){
	  		return primary_Sm_Details;
	  	}
	  	public void setPrimary_Sm_Details(String primary_Sm_Details){
	  	   	this.primary_Sm_Details=primary_Sm_Details;
	  	}
	  	   
	  	public String getTxt_Office_Name(){
	  		return txt_Office_Name;
	  	}
	  	public void setTxt_Office_Name(String txt_Office_Name){
	  	   	this.txt_Office_Name=txt_Office_Name;
	  	}
	  	   
	  	public String getUsgi_Branch_State(){
	  		return usgi_Branch_State;
	  	}
	  	public void setUsgi_Branch_State(String usgi_Branch_State){
	  	   	this.usgi_Branch_State=usgi_Branch_State;
	  	}
	  	   
	  	public String getUsgi_Branch_State_Code(){
	  		return usgi_Branch_State_Code;
	  	}
	  	public void setUsgi_Branch_State_Code(String usgi_Branch_State_Code){
	  	   	this.usgi_Branch_State_Code=usgi_Branch_State_Code;
	  	}
	  	   
	  	public String getBa_Name(){
	  		return ba_Name;
	  	}
	  	public void setBa_Name(String ba_Name){
	  	   	this.ba_Name=ba_Name;
	  	}
	  	   
	  	public String getPrimary_Sales_Manger_Id(){
	  		return primary_Sales_Manger_Id;
	  	}
	  	public void setPrimary_Sales_Manger_Id(String primary_Sales_Manger_Id){
	  	   	this.primary_Sales_Manger_Id=primary_Sales_Manger_Id;
	  	}
	  	   
	  	public String getPrimary_Sales_Manger_Name(){
	  		return primary_Sales_Manger_Name;
	  	}
	  	public void setPrimary_Sales_Manger_Name(String primary_Sales_Manger_Name){
	  	   	this.primary_Sales_Manger_Name=primary_Sales_Manger_Name;
	  	}
	  	   
	  	public String getCustomer_Name(){
	  		return customer_Name;
	  	}
	  	public void setCustomer_Name(String customer_Name){
	  	   	this.customer_Name=customer_Name;
	  	}
	  	   
	  	public String getInsured_Age(){
	  		return insured_Age;
	  	}
	  	public void setInsured_Age(String insured_Age){
	  	   	this.insured_Age=insured_Age;
	  	}
	  	   
	  	public String getCustomer_State(){
	  		return customer_State;
	  	}
	  	public void setCustomer_State(String customer_State){
	  	   	this.customer_State=customer_State;
	  	}
	  	   
	  	public String getCustomer_State_Code(){
	  		return customer_State_Code;
	  	}
	  	public void setCustomer_State_Code(String customer_State_Code){
	  	   	this.customer_State_Code=customer_State_Code;
	  	}
	  	   
	  	public String getCustomer_Pin_Code(){
	  		return customer_Pin_Code;
	  	}
	  	public void setCustomer_Pin_Code(String customer_Pin_Code){
	  	   	this.customer_Pin_Code=customer_Pin_Code;
	  	}
	  	   
	  	public String getTxt_Ind_Corp_Flag(){
	  		return txt_Ind_Corp_Flag;
	  	}
	  	public void setTxt_Ind_Corp_Flag(String txt_Ind_Corp_Flag){
	  	   	this.txt_Ind_Corp_Flag=txt_Ind_Corp_Flag;
	  	}
	  	   
	  	public Long getYr_Of_Manufacturing(){
	  		return yr_Of_Manufacturing;
	  	}
	  	public void setYr_Of_Manufacturing(Long yr_Of_Manufacturing){
	  	   	this.yr_Of_Manufacturing=yr_Of_Manufacturing;
	  	}
	  	   
	  	public String getMake(){
	  		return make;
	  	}
	  	public void setMake(String make){
	  	   	this.make=make;
	  	}
	  	   
	  	public String getModel(){
	  		return model;
	  	}
	  	public void setModel(String model){
	  	   	this.model=model;
	  	}
	  	   
	  	public String getModel_Cluster(){
	  		return model_Cluster;
	  	}
	  	public void setModel_Cluster(String model_Cluster){
	  	   	this.model_Cluster=model_Cluster;
	  	}
	  	   
	  	public String getSegment(){
	  		return segment;
	  	}
	  	public void setSegment(String segment){
	  	   	this.segment=segment;
	  	}
	  	   
	  	public String getGeography_Of_The_Vehicle(){
	  		return geography_Of_The_Vehicle;
	  	}
	  	public void setGeography_Of_The_Vehicle(String geography_Of_The_Vehicle){
	  	   	this.geography_Of_The_Vehicle=geography_Of_The_Vehicle;
	  	}
	  	   
	  	public String getRegistration_Date(){
	  		return registration_Date;
	  	}
	  	public void setRegistration_Date(String registration_Date){
	  	   	this.registration_Date=registration_Date;
	  	}
	  	   
	  	public String getMotor_Registration_No(){
	  		return motor_Registration_No;
	  	}
	  	public void setMotor_Registration_No(String motor_Registration_No){
	  	   	this.motor_Registration_No=motor_Registration_No;
	  	}
	  	   
	  	public String getRto_Cluster(){
	  		return rto_Cluster;
	  	}
	  	public void setRto_Cluster(String rto_Cluster){
	  	   	this.rto_Cluster=rto_Cluster;
	  	}
	  	   
	  	public String getRisk_Zone(){
	  		return risk_Zone;
	  	}
	  	public void setRisk_Zone(String risk_Zone){
	  	   	this.risk_Zone=risk_Zone;
	  	}
	  	   
	  	public String getEngine_No(){
	  		return engine_No;
	  	}
	  	public void setEngine_No(String engine_No){
	  	   	this.engine_No=engine_No;
	  	}
	  	   
	  	public String getChassis_No(){
	  		return chassis_No;
	  	}
	  	public void setChassis_No(String chassis_No){
	  	   	this.chassis_No=chassis_No;
	  	}
	  	   
	  	public String getFuel_Type(){
	  		return fuel_Type;
	  	}
	  	public void setFuel_Type(String fuel_Type){
	  	   	this.fuel_Type=fuel_Type;
	  	}
	  	   
	  	public String getBody_Type(){
	  		return body_Type;
	  	}
	  	public void setBody_Type(String body_Type){
	  	   	this.body_Type=body_Type;
	  	}
	  	   
	  	public Long getAge_Band(){
	  		return age_Band;
	  	}
	  	public void setAge_Band(Long age_Band){
	  	   	this.age_Band=age_Band;
	  	}
	  	   
	  	public String getNo_Claims_In_Last_3_Years(){
	  		return no_Claims_In_Last_3_Years;
	  	}
	  	public void setNo_Claims_In_Last_3_Years(String no_Claims_In_Last_3_Years){
	  	   	this.no_Claims_In_Last_3_Years=no_Claims_In_Last_3_Years;
	  	}
	  	   
	  	public String getColour_Of_The_Vehicle(){
	  		return colour_Of_The_Vehicle;
	  	}
	  	public void setColour_Of_The_Vehicle(String colour_Of_The_Vehicle){
	  	   	this.colour_Of_The_Vehicle=colour_Of_The_Vehicle;
	  	}
	  	   
	  	public String getNo_Of_Wheels(){
	  		return no_Of_Wheels;
	  	}
	  	public void setNo_Of_Wheels(String no_Of_Wheels){
	  	   	this.no_Of_Wheels=no_Of_Wheels;
	  	}
	  	   
	  	public String getNo_Of_Trailers(){
	  		return no_Of_Trailers;
	  	}
	  	public void setNo_Of_Trailers(String no_Of_Trailers){
	  	   	this.no_Of_Trailers=no_Of_Trailers;
	  	}
	  	   
	  	public String getTrailer_Type(){
	  		return trailer_Type;
	  	}
	  	public void setTrailer_Type(String trailer_Type){
	  	   	this.trailer_Type=trailer_Type;
	  	}
	  	   
	  	public String getVehicle_Sub_Class(){
	  		return vehicle_Sub_Class;
	  	}
	  	public void setVehicle_Sub_Class(String vehicle_Sub_Class){
	  	   	this.vehicle_Sub_Class=vehicle_Sub_Class;
	  	}
	  	   
	  	public BigDecimal getShowroomprice_New(){
	  		return showroomprice_New;
	  	}
	  	public void setShowroomprice_New(BigDecimal showroomprice_New){
	  	   	this.showroomprice_New=showroomprice_New;
	  	}
	  	   
	  	public BigDecimal getCubic_Capacity_Amp(){
	  		return cubic_Capacity_Amp;
	  	}
	  	public void setCubic_Capacity_Amp(BigDecimal cubic_Capacity_Amp){
	  	   	this.cubic_Capacity_Amp=cubic_Capacity_Amp;
	  	}
	  	   
	  	public Long getCarrying_Capacity(){
	  		return carrying_Capacity;
	  	}
	  	public void setCarrying_Capacity(Long carrying_Capacity){
	  	   	this.carrying_Capacity=carrying_Capacity;
	  	}
	  	   
	  	public String getUsage(){
	  		return usage;
	  	}
	  	public void setUsage(String usage){
	  	   	this.usage=usage;
	  	}
	  	   
	  	public String getLive_Count(){
	  		return live_Count;
	  	}
	  	public void setLive_Count(String live_Count){
	  	   	this.live_Count=live_Count;
	  	}
	  	   
	  	public String getVehicle_Idv(){
	  		return vehicle_Idv;
	  	}
	  	public void setVehicle_Idv(String vehicle_Idv){
	  	   	this.vehicle_Idv=vehicle_Idv;
	  	}
	  	   
	  	public BigDecimal getTotal_Si(){
	  		return total_Si;
	  	}
	  	public void setTotal_Si(BigDecimal total_Si){
	  	   	this.total_Si=total_Si;
	  	}
	  	   
	  	public String getBreakin_Policy_Flag(){
	  		return breakin_Policy_Flag;
	  	}
	  	public void setBreakin_Policy_Flag(String breakin_Policy_Flag){
	  	   	this.breakin_Policy_Flag=breakin_Policy_Flag;
	  	}
	  	   
	  	public BigDecimal getNum_Net_Tp_Premium(){
	  		return num_Net_Tp_Premium;
	  	}
	  	public void setNum_Net_Tp_Premium(BigDecimal num_Net_Tp_Premium){
	  	   	this.num_Net_Tp_Premium=num_Net_Tp_Premium;
	  	}
	  	   
	  	public BigDecimal getAdd_On_Premium(){
	  		return add_On_Premium;
	  	}
	  	public void setAdd_On_Premium(BigDecimal add_On_Premium){
	  	   	this.add_On_Premium=add_On_Premium;
	  	}
	  	   
	  	public BigDecimal getNet_Premium(){
	  		return net_Premium;
	  	}
	  	public void setNet_Premium(BigDecimal net_Premium){
	  	   	this.net_Premium=net_Premium;
	  	}
	  	   
	  	public String getEndorsement_Od_Prem(){
	  		return endorsement_Od_Prem;
	  	}
	  	public void setEndorsement_Od_Prem(String endorsement_Od_Prem){
	  	   	this.endorsement_Od_Prem=endorsement_Od_Prem;
	  	}
	  	   
	  	public String getEndorsement_Tp_Prem(){
	  		return endorsement_Tp_Prem;
	  	}
	  	public void setEndorsement_Tp_Prem(String endorsement_Tp_Prem){
	  	   	this.endorsement_Tp_Prem=endorsement_Tp_Prem;
	  	}
	  	   
	  	public String getEndorsement_Prem(){
	  		return endorsement_Prem;
	  	}
	  	public void setEndorsement_Prem(String endorsement_Prem){
	  	   	this.endorsement_Prem=endorsement_Prem;
	  	}
	  	   
	  	public String getIgst(){
	  		return igst;
	  	}
	  	public void setIgst(String igst){
	  	   	this.igst=igst;
	  	}
	  	   
	  	public String getCgst(){
	  		return cgst;
	  	}
	  	public void setCgst(String cgst){
	  	   	this.cgst=cgst;
	  	}
	  	   
	  	public String getSgst(){
	  		return sgst;
	  	}
	  	public void setSgst(String sgst){
	  	   	this.sgst=sgst;
	  	}
	  	   
	  	public BigDecimal getUsgi_Gross_Premium(){
	  		return usgi_Gross_Premium;
	  	}
	  	public void setUsgi_Gross_Premium(BigDecimal usgi_Gross_Premium){
	  	   	this.usgi_Gross_Premium=usgi_Gross_Premium;
	  	}
	  	   
	  	public BigDecimal getConsolidated_Amount_Multiyr(){
	  		return consolidated_Amount_Multiyr;
	  	}
	  	public void setConsolidated_Amount_Multiyr(BigDecimal consolidated_Amount_Multiyr){
	  	   	this.consolidated_Amount_Multiyr=consolidated_Amount_Multiyr;
	  	}
	  	   
	  	public BigDecimal getLoading_Percentage(){
	  		return loading_Percentage;
	  	}
	  	public void setLoading_Percentage(BigDecimal loading_Percentage){
	  	   	this.loading_Percentage=loading_Percentage;
	  	}
	  	   
	  	public BigDecimal getLoading_On_Premium(){
	  		return loading_On_Premium;
	  	}
	  	public void setLoading_On_Premium(BigDecimal loading_On_Premium){
	  	   	this.loading_On_Premium=loading_On_Premium;
	  	}
	  	   
	  	public BigDecimal getDiscount_Percentage(){
	  		return discount_Percentage;
	  	}
	  	public void setDiscount_Percentage(BigDecimal discount_Percentage){
	  	   	this.discount_Percentage=discount_Percentage;
	  	}
	  	   
	  	public String getOther_Disc_Percentage(){
	  		return other_Disc_Percentage;
	  	}
	  	public void setOther_Disc_Percentage(String other_Disc_Percentage){
	  	   	this.other_Disc_Percentage=other_Disc_Percentage;
	  	}
	  	   
	  	public BigDecimal getDiscount_On_Premium(){
	  		return discount_On_Premium;
	  	}
	  	public void setDiscount_On_Premium(BigDecimal discount_On_Premium){
	  	   	this.discount_On_Premium=discount_On_Premium;
	  	}
	  	   
	  	public String getSystem_Commission_Per(){
	  		return system_Commission_Per;
	  	}
	  	public void setSystem_Commission_Per(String system_Commission_Per){
	  	   	this.system_Commission_Per=system_Commission_Per;
	  	}
	  	   
	  	public BigDecimal getSystem_Commission_Amount(){
	  		return system_Commission_Amount;
	  	}
	  	public void setSystem_Commission_Amount(BigDecimal system_Commission_Amount){
	  	   	this.system_Commission_Amount=system_Commission_Amount;
	  	}
	  	   
	  	public BigDecimal getAdvance_Premium(){
	  		return advance_Premium;
	  	}
	  	public void setAdvance_Premium(BigDecimal advance_Premium){
	  	   	this.advance_Premium=advance_Premium;
	  	}
	  	   
	  	public BigDecimal getNcb_Amount(){
	  		return ncb_Amount;
	  	}
	  	public void setNcb_Amount(BigDecimal ncb_Amount){
	  	   	this.ncb_Amount=ncb_Amount;
	  	}
	  	   
	  	public String getNcb_Applicability(){
	  		return ncb_Applicability;
	  	}
	  	public void setNcb_Applicability(String ncb_Applicability){
	  	   	this.ncb_Applicability=ncb_Applicability;
	  	}
	  	   
	  	public String getNcb_Percentage(){
	  		return ncb_Percentage;
	  	}
	  	public void setNcb_Percentage(String ncb_Percentage){
	  	   	this.ncb_Percentage=ncb_Percentage;
	  	}
	  	   
	  	public String getUsgi_Gstin_No(){
	  		return usgi_Gstin_No;
	  	}
	  	public void setUsgi_Gstin_No(String usgi_Gstin_No){
	  	   	this.usgi_Gstin_No=usgi_Gstin_No;
	  	}
	  	   
	  	public String getImd_Gstin_No(){
	  		return imd_Gstin_No;
	  	}
	  	public void setImd_Gstin_No(String imd_Gstin_No){
	  	   	this.imd_Gstin_No=imd_Gstin_No;
	  	}
	  	   
	  	public BigDecimal getTerrorism_Premium(){
	  		return terrorism_Premium;
	  	}
	  	public void setTerrorism_Premium(BigDecimal terrorism_Premium){
	  	   	this.terrorism_Premium=terrorism_Premium;
	  	}
	  	   
	  	public String getTerrerism_Share(){
	  		return terrerism_Share;
	  	}
	  	public void setTerrerism_Share(String terrerism_Share){
	  	   	this.terrerism_Share=terrerism_Share;
	  	}
	  	   
	  	public String getPremium_Greater_Than_1_Lac(){
	  		return premium_Greater_Than_1_Lac;
	  	}
	  	public void setPremium_Greater_Than_1_Lac(String premium_Greater_Than_1_Lac){
	  	   	this.premium_Greater_Than_1_Lac=premium_Greater_Than_1_Lac;
	  	}
	  	   
	  	public String getPayment_Mode(){
	  		return payment_Mode;
	  	}
	  	public void setPayment_Mode(String payment_Mode){
	  	   	this.payment_Mode=payment_Mode;
	  	}
	  	   
	  	public String getPayment_Frequency(){
	  		return payment_Frequency;
	  	}
	  	public void setPayment_Frequency(String payment_Frequency){
	  	   	this.payment_Frequency=payment_Frequency;
	  	}
	  	   
	  	public String getDiscripancies_Raised_Count(){
	  		return discripancies_Raised_Count;
	  	}
	  	public void setDiscripancies_Raised_Count(String discripancies_Raised_Count){
	  	   	this.discripancies_Raised_Count=discripancies_Raised_Count;
	  	}
	  	   
	  	public String getDiscripancy_Resolved_Count(){
	  		return discripancy_Resolved_Count;
	  	}
	  	public void setDiscripancy_Resolved_Count(String discripancy_Resolved_Count){
	  	   	this.discripancy_Resolved_Count=discripancy_Resolved_Count;
	  	}
	  	   
	  	public String getFleet_Name_Owner_Name(){
	  		return fleet_Name_Owner_Name;
	  	}
	  	public void setFleet_Name_Owner_Name(String fleet_Name_Owner_Name){
	  	   	this.fleet_Name_Owner_Name=fleet_Name_Owner_Name;
	  	}
	  	   
	  	public String getVle_Details_For_Csc(){
	  		return vle_Details_For_Csc;
	  	}
	  	public void setVle_Details_For_Csc(String vle_Details_For_Csc){
	  	   	this.vle_Details_For_Csc=vle_Details_For_Csc;
	  	}
	  	   
	  	public String getLoss_Ratio(){
	  		return loss_Ratio;
	  	}
	  	public void setLoss_Ratio(String loss_Ratio){
	  	   	this.loss_Ratio=loss_Ratio;
	  	}
	  	   
	  	public String getSeverity(){
	  		return severity;
	  	}
	  	public void setSeverity(String severity){
	  	   	this.severity=severity;
	  	}
	  	   
	  	public String getFrequency(){
	  		return frequency;
	  	}
	  	public void setFrequency(String frequency){
	  	   	this.frequency=frequency;
	  	}
	  	   
	  	public String getClose_Proximity(){
	  		return close_Proximity;
	  	}
	  	public void setClose_Proximity(String close_Proximity){
	  	   	this.close_Proximity=close_Proximity;
	  	}
	  	   
	  	public String getFraud_Claim_Reported_If_Any(){
	  		return fraud_Claim_Reported_If_Any;
	  	}
	  	public void setFraud_Claim_Reported_If_Any(String fraud_Claim_Reported_If_Any){
	  	   	this.fraud_Claim_Reported_If_Any=fraud_Claim_Reported_If_Any;
	  	}
	  	   
	  	public String getDeviations_Availed(){
	  		return deviations_Availed;
	  	}
	  	public void setDeviations_Availed(String deviations_Availed){
	  	   	this.deviations_Availed=deviations_Availed;
	  	}
	  	   
	  	public String getDeviations_Details(){
	  		return deviations_Details;
	  	}
	  	public void setDeviations_Details(String deviations_Details){
	  	   	this.deviations_Details=deviations_Details;
	  	}
	  	   
	  	public String getPreffered_Garage(){
	  		return preffered_Garage;
	  	}
	  	public void setPreffered_Garage(String preffered_Garage){
	  	   	this.preffered_Garage=preffered_Garage;
	  	}
	  	   
	  	public String getBreak_In_Period(){
	  		return break_In_Period;
	  	}
	  	public void setBreak_In_Period(String break_In_Period){
	  	   	this.break_In_Period=break_In_Period;
	  	}
	  	   
	  	public String getInsured_Details(){
	  		return insured_Details;
	  	}
	  	public void setInsured_Details(String insured_Details){
	  	   	this.insured_Details=insured_Details;
	  	}
	  	   
	  	public String getInsured_Details2(){
	  		return insured_Details2;
	  	}
	  	public void setInsured_Details2(String insured_Details2){
	  	   	this.insured_Details2=insured_Details2;
	  	}
	  	   
	  	public String getRisk_Details(){
	  		return risk_Details;
	  	}
	  	public void setRisk_Details(String risk_Details){
	  	   	this.risk_Details=risk_Details;
	  	}
	  	   
	  	public String getRisk_Location(){
	  		return risk_Location;
	  	}
	  	public void setRisk_Location(String risk_Location){
	  	   	this.risk_Location=risk_Location;
	  	}
	  	   
	  	public String getOccupancy(){
	  		return occupancy;
	  	}
	  	public void setOccupancy(String occupancy){
	  	   	this.occupancy=occupancy;
	  	}
	  	   
	  	public BigDecimal getCover_Details(){
	  		return cover_Details;
	  	}
	  	public void setCover_Details(BigDecimal cover_Details){
	  	   	this.cover_Details=cover_Details;
	  	}
	  	   
	  	public String getLd_Details(){
	  		return ld_Details;
	  	}
	  	public void setLd_Details(String ld_Details){
	  	   	this.ld_Details=ld_Details;
	  	}
	  	   
	  	public String getAdd_On_Covers(){
	  		return add_On_Covers;
	  	}
	  	public void setAdd_On_Covers(String add_On_Covers){
	  	   	this.add_On_Covers=add_On_Covers;
	  	}
	  	   
	  	public String getAdd_On_Plan_Name(){
	  		return add_On_Plan_Name;
	  	}
	  	public void setAdd_On_Plan_Name(String add_On_Plan_Name){
	  	   	this.add_On_Plan_Name=add_On_Plan_Name;
	  	}
	  	   
	  	public String getAdd_On_Flag(){
	  		return add_On_Flag;
	  	}
	  	public void setAdd_On_Flag(String add_On_Flag){
	  	   	this.add_On_Flag=add_On_Flag;
	  	}
	  	   
	  	public String getCpa_Flag(){
	  		return cpa_Flag;
	  	}
	  	public void setCpa_Flag(String cpa_Flag){
	  	   	this.cpa_Flag=cpa_Flag;
	  	}
	  	   
	  	public String getFinancier(){
	  		return financier;
	  	}
	  	public void setFinancier(String financier){
	  	   	this.financier=financier;
	  	}
	  	   
	  	public String getPreffered_Reffered(){
	  		return preffered_Reffered;
	  	}
	  	public void setPreffered_Reffered(String preffered_Reffered){
	  	   	this.preffered_Reffered=preffered_Reffered;
	  	}
	  	   
	  	public String getInwarding_Details(){
	  		return inwarding_Details;
	  	}
	  	public void setInwarding_Details(String inwarding_Details){
	  	   	this.inwarding_Details=inwarding_Details;
	  	}
	  	   
	  	public String getVehicle_Group_Name(){
	  		return vehicle_Group_Name;
	  	}
	  	public void setVehicle_Group_Name(String vehicle_Group_Name){
	  	   	this.vehicle_Group_Name=vehicle_Group_Name;
	  	}
	  	   
	  	public String getTonnage(){
	  		return tonnage;
	  	}
	  	public void setTonnage(String tonnage){
	  	   	this.tonnage=tonnage;
	  	}
	  	   
	  	public String getState_Group_Name(){
	  		return state_Group_Name;
	  	}
	  	public void setState_Group_Name(String state_Group_Name){
	  	   	this.state_Group_Name=state_Group_Name;
	  	}
	  	   
	  	public String getDeclined_flag(){
	  		return declined_flag;
	  	}
	  	public void setDeclined_flag(String declined_flag){
	  	   	this.declined_flag=declined_flag;
	  	}
	  	   
	  	public BigDecimal getCommission_Perc(){
	  		return commission_Perc;
	  	}
	  	public void setCommission_Perc(BigDecimal commission_Perc){
	  	   	this.commission_Perc=commission_Perc;
	  	}
	  	   
	  	public BigDecimal getNet_Commission(){
	  		return net_Commission;
	  	}
	  	public void setNet_Commission(BigDecimal net_Commission){
	  	   	this.net_Commission=net_Commission;
	  	}
	  	   
	  	public String getGwp_slab(){
	  		return gwp_slab;
	  	}
	  	public void setGwp_slab(String gwp_slab){
	  	   	this.gwp_slab=gwp_slab;
	  	}
	  	   
	  	public String getState_code(){
	  		return state_code;
	  	}
	  	public void setState_code(String state_code){
	  	   	this.state_code=state_code;
	  	}
	  	   
	  	public BigDecimal getRate(){
	  		return rate;
	  	}
	  	public void setRate(BigDecimal rate){
	  	   	this.rate=rate;
	  	}
	  	   
	  	public BigDecimal getAdditional_Percentage(){
	  		return additional_Percentage;
	  	}
	  	public void setAdditional_Percentage(BigDecimal additional_Percentage){
	  	   	this.additional_Percentage=additional_Percentage;
	  	}
	  	   
	  	public BigDecimal getNo_of_health_policies(){
	  		return no_of_health_policies;
	  	}
	  	public void setNo_of_health_policies(BigDecimal no_of_health_policies){
	  	   	this.no_of_health_policies=no_of_health_policies;
	  	}
	  	   
	  	public BigDecimal getTotal_health_gwp(){
	  		return total_health_gwp;
	  	}
	  	public void setTotal_health_gwp(BigDecimal total_health_gwp){
	  	   	this.total_health_gwp=total_health_gwp;
	  	}
	  	   
	  	public BigDecimal getOd_Commission(){
	  		return od_Commission;
	  	}
	  	public void setOd_Commission(BigDecimal od_Commission){
	  	   	this.od_Commission=od_Commission;
	  	}
	  	   
	  	public String getName(){
	  		return name;
	  	}
	  	public void setName(String name){
	  	   	this.name=name;
	  	}
	  	   
	  	public String getPayeeName(){
	  		return payeeName;
	  	}
	  	public void setPayeeName(String payeeName){
	  	   	this.payeeName=payeeName;
	  	}
	  	   
	  	public String getType(){
	  		return type;
	  	}
	  	public void setType(String type){
	  	   	this.type=type;
	  	}
	  	   
	  	public String getPolicy_type_new(){
	  		return policy_type_new;
	  	}
	  	public void setPolicy_type_new(String policy_type_new){
	  	   	this.policy_type_new=policy_type_new;
	  	}
	  	   
	  	public BigDecimal getId(){
	  		return id;
	  	}
	  	public void setId(BigDecimal id){
	  	   	this.id=id;
	  	}
	  	   
	  	public String getRto_code(){
	  		return rto_code;
	  	}
	  	public void setRto_code(String rto_code){
	  	   	this.rto_code=rto_code;
	  	}
	  	   
	  	public String getConsidered_flag(){
	  		return considered_flag;
	  	}
	  	public void setConsidered_flag(String considered_flag){
	  	   	this.considered_flag=considered_flag;
	  	}
	  	   
	  	public BigDecimal getGrid_percentage(){
	  		return grid_percentage;
	  	}
	  	public void setGrid_percentage(BigDecimal grid_percentage){
	  	   	this.grid_percentage=grid_percentage;
	  	}
	  	   
	  	public BigDecimal getGrid_amount_on_OD(){
	  		return grid_amount_on_OD;
	  	}
	  	public void setGrid_amount_on_OD(BigDecimal grid_amount_on_OD){
	  	   	this.grid_amount_on_OD=grid_amount_on_OD;
	  	}
	  	   
	  	public BigDecimal getGrid_amount_on_TP(){
	  		return grid_amount_on_TP;
	  	}
	  	public void setGrid_amount_on_TP(BigDecimal grid_amount_on_TP){
	  	   	this.grid_amount_on_TP=grid_amount_on_TP;
	  	}
	  	   
	  	public BigDecimal getTotal_grid_amount(){
	  		return total_grid_amount;
	  	}
	  	public void setTotal_grid_amount(BigDecimal total_grid_amount){
	  	   	this.total_grid_amount=total_grid_amount;
	  	}
	  	   
	  	public BigDecimal getGrid_amount_health_on_OD(){
	  		return grid_amount_health_on_OD;
	  	}
	  	public void setGrid_amount_health_on_OD(BigDecimal grid_amount_health_on_OD){
	  	   	this.grid_amount_health_on_OD=grid_amount_health_on_OD;
	  	}
	  	   
	  	public BigDecimal getGrid_amount_health_on_TP(){
	  		return grid_amount_health_on_TP;
	  	}
	  	public void setGrid_amount_health_on_TP(BigDecimal grid_amount_health_on_TP){
	  	   	this.grid_amount_health_on_TP=grid_amount_health_on_TP;
	  	}
	  	   
	  	public BigDecimal getTotal_grid_amount_health(){
	  		return total_grid_amount_health;
	  	}
	  	public void setTotal_grid_amount_health(BigDecimal total_grid_amount_health){
	  	   	this.total_grid_amount_health=total_grid_amount_health;
	  	}
	  	   
	  	public BigDecimal getTotal_grid_amount_on_od_per(){
	  		return total_grid_amount_on_od_per;
	  	}
	  	public void setTotal_grid_amount_on_od_per(BigDecimal total_grid_amount_on_od_per){
	  	   	this.total_grid_amount_on_od_per=total_grid_amount_on_od_per;
	  	}
	  	   
	  	public BigDecimal getTotal_grid_amount_on_tp_per(){
	  		return total_grid_amount_on_tp_per;
	  	}
	  	public void setTotal_grid_amount_on_tp_per(BigDecimal total_grid_amount_on_tp_per){
	  	   	this.total_grid_amount_on_tp_per=total_grid_amount_on_tp_per;
	  	}
	  	   
	  	public BigDecimal getNet_total_grid_amount(){
	  		return net_total_grid_amount;
	  	}
	  	public void setNet_total_grid_amount(BigDecimal net_total_grid_amount){
	  	   	this.net_total_grid_amount=net_total_grid_amount;
	  	}
	  	   
	  	public BigDecimal getGrid_on_OD_pr_discount(){
	  		return grid_on_OD_pr_discount;
	  	}
	  	public void setGrid_on_OD_pr_discount(BigDecimal grid_on_OD_pr_discount){
	  	   	this.grid_on_OD_pr_discount=grid_on_OD_pr_discount;
	  	}
	  	   
	  	public BigDecimal getGrid_on_TP_pr_discount(){
	  		return grid_on_TP_pr_discount;
	  	}
	  	public void setGrid_on_TP_pr_discount(BigDecimal grid_on_TP_pr_discount){
	  	   	this.grid_on_TP_pr_discount=grid_on_TP_pr_discount;
	  	}
	  	   
	  	public BigDecimal getGrid_on_total_pr_discount(){
	  		return grid_on_total_pr_discount;
	  	}
	  	public void setGrid_on_total_pr_discount(BigDecimal grid_on_total_pr_discount){
	  	   	this.grid_on_total_pr_discount=grid_on_total_pr_discount;
	  	}
	  	   
	  	public BigDecimal getFinal_grid_payable_on_OD(){
	  		return final_grid_payable_on_OD;
	  	}
	  	public void setFinal_grid_payable_on_OD(BigDecimal final_grid_payable_on_OD){
	  	   	this.final_grid_payable_on_OD=final_grid_payable_on_OD;
	  	}
	  	   
	  	public BigDecimal getFinal_grid_payable_on_TP(){
	  		return final_grid_payable_on_TP;
	  	}
	  	public void setFinal_grid_payable_on_TP(BigDecimal final_grid_payable_on_TP){
	  	   	this.final_grid_payable_on_TP=final_grid_payable_on_TP;
	  	}
	  	   
	  	public BigDecimal getFinal_grid_payable(){
	  		return final_grid_payable;
	  	}
	  	public void setFinal_grid_payable(BigDecimal final_grid_payable){
	  	   	this.final_grid_payable=final_grid_payable;
	  	}
	  	   
	  	public BigDecimal getIrdai_amount_on_OD(){
	  		return irdai_amount_on_OD;
	  	}
	  	public void setIrdai_amount_on_OD(BigDecimal irdai_amount_on_OD){
	  	   	this.irdai_amount_on_OD=irdai_amount_on_OD;
	  	}
	  	   
	  	public BigDecimal getIrdai_amount_on_TP(){
	  		return irdai_amount_on_TP;
	  	}
	  	public void setIrdai_amount_on_TP(BigDecimal irdai_amount_on_TP){
	  	   	this.irdai_amount_on_TP=irdai_amount_on_TP;
	  	}
	  	   
	  	public BigDecimal getTotal_irdai_amount(){
	  		return total_irdai_amount;
	  	}
	  	public void setTotal_irdai_amount(BigDecimal total_irdai_amount){
	  	   	this.total_irdai_amount=total_irdai_amount;
	  	}
	  	   
	  	public BigDecimal getCgstPercentage(){
	  		return cgstPercentage;
	  	}
	  	public void setCgstPercentage(BigDecimal cgstPercentage){
	  	   	this.cgstPercentage=cgstPercentage;
	  	}
	  	   
	  	public BigDecimal getSgstPercentage(){
	  		return sgstPercentage;
	  	}
	  	public void setSgstPercentage(BigDecimal sgstPercentage){
	  	   	this.sgstPercentage=sgstPercentage;
	  	}
	  	   
	  	public BigDecimal getIgstPercentage(){
	  		return igstPercentage;
	  	}
	  	public void setIgstPercentage(BigDecimal igstPercentage){
	  	   	this.igstPercentage=igstPercentage;
	  	}
	  	   
	  	public BigDecimal getCgstAmount(){
	  		return cgstAmount;
	  	}
	  	public void setCgstAmount(BigDecimal cgstAmount){
	  	   	this.cgstAmount=cgstAmount;
	  	}
	  	   
	  	public BigDecimal getSgstAmount(){
	  		return sgstAmount;
	  	}
	  	public void setSgstAmount(BigDecimal sgstAmount){
	  	   	this.sgstAmount=sgstAmount;
	  	}
	  	   
	  	public BigDecimal getIgstAmount(){
	  		return igstAmount;
	  	}
	  	public void setIgstAmount(BigDecimal igstAmount){
	  	   	this.igstAmount=igstAmount;
	  	}
	  	   
	  	public String getGst_applicable(){
	  		return gst_applicable;
	  	}
	  	public void setGst_applicable(String gst_applicable){
	  	   	this.gst_applicable=gst_applicable;
	  	}
	  	   
	  	public BigDecimal getFinal_amount(){
	  		return final_amount;
	  	}
	  	public void setFinal_amount(BigDecimal final_amount){
	  	   	this.final_amount=final_amount;
	  	}
	  	   
	  	public String getImd_code_state(){
	  		return imd_code_state;
	  	}
	  	public void setImd_code_state(String imd_code_state){
	  	   	this.imd_code_state=imd_code_state;
	  	}
	  	   
	  	public String getAgency_name(){
	  		return agency_name;
	  	}
	  	public void setAgency_name(String agency_name){
	  	   	this.agency_name=agency_name;
	  	}
	  	   
	  	public String getGstin(){
	  		return gstin;
	  	}
	  	public void setGstin(String gstin){
	  	   	this.gstin=gstin;
	  	}
	  	   
	  	public String getImd_code_gstin(){
	  		return imd_code_gstin;
	  	}
	  	public void setImd_code_gstin(String imd_code_gstin){
	  	   	this.imd_code_gstin=imd_code_gstin;
	  	}
	  	   
	  	public String getBankaccno(){
	  		return bankaccno;
	  	}
	  	public void setBankaccno(String bankaccno){
	  	   	this.bankaccno=bankaccno;
	  	}
	  	   
	  	public String getBank_ifsc_code(){
	  		return bank_ifsc_code;
	  	}
	  	public void setBank_ifsc_code(String bank_ifsc_code){
	  	   	this.bank_ifsc_code=bank_ifsc_code;
	  	}
	  	   
	  	public BigDecimal getTotal_non_motor_gwp(){
	  		return total_non_motor_gwp;
	  	}
	  	public void setTotal_non_motor_gwp(BigDecimal total_non_motor_gwp){
	  	   	this.total_non_motor_gwp=total_non_motor_gwp;
	  	}
	  	   
	  	public BigDecimal getTotal_non_motor_count(){
	  		return total_non_motor_count;
	  	}
	  	public void setTotal_non_motor_count(BigDecimal total_non_motor_count){
	  	   	this.total_non_motor_count=total_non_motor_count;
	  	}
	  	   
	  	public String getProcessbusinessKey(){
	  		return processbusinessKey;
	  	}
	  	public void setProcessbusinessKey(String processbusinessKey){
	  	   	this.processbusinessKey=processbusinessKey;
	  	}
	  	   
	  	public String getEom_cluster(){
	  		return eom_cluster;
	  	}
	  	public void setEom_cluster(String eom_cluster){
	  	   	this.eom_cluster=eom_cluster;
	  	}
	  	   
	  	public String getAsm(){
	  		return asm;
	  	}
	  	public void setAsm(String asm){
	  	   	this.asm=asm;
	  	}
	  	   
	  	public String getCsm(){
	  		return csm;
	  	}
	  	public void setCsm(String csm){
	  	   	this.csm=csm;
	  	}
	  	   
	  	public String getVehicle_segment(){
	  		return vehicle_segment;
	  	}
	  	public void setVehicle_segment(String vehicle_segment){
	  	   	this.vehicle_segment=vehicle_segment;
	  	}
	  	   
	  	public String getException_applicable_grid(){
	  		return exception_applicable_grid;
	  	}
	  	public void setException_applicable_grid(String exception_applicable_grid){
	  	   	this.exception_applicable_grid=exception_applicable_grid;
	  	}
	  	   
	  	public BigDecimal getException_additional_percentage(){
	  		return exception_additional_percentage;
	  	}
	  	public void setException_additional_percentage(BigDecimal exception_additional_percentage){
	  	   	this.exception_additional_percentage=exception_additional_percentage;
	  	}
	  	   
	  	public BigDecimal getException_flat_percentage(){
	  		return exception_flat_percentage;
	  	}
	  	public void setException_flat_percentage(BigDecimal exception_flat_percentage){
	  	   	this.exception_flat_percentage=exception_flat_percentage;
	  	}
	  	   
	  	public String getException_applicable_on_od_net(){
	  		return exception_applicable_on_od_net;
	  	}
	  	public void setException_applicable_on_od_net(String exception_applicable_on_od_net){
	  	   	this.exception_applicable_on_od_net=exception_applicable_on_od_net;
	  	}
	  	   
	  	public String getPan_no(){
	  		return pan_no;
	  	}
	  	public void setPan_no(String pan_no){
	  	   	this.pan_no=pan_no;
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
	  	   
	  	public Date getTds_certificate_start_date(){
	  		return tds_certificate_start_date;
	  	}
	  	public void setTds_certificate_start_date(Date tds_certificate_start_date){
	  	   	this.tds_certificate_start_date=tds_certificate_start_date;
	  	}
	  	   
	  	public Date getTds_certificate_end_date(){
	  		return tds_certificate_end_date;
	  	}
	  	public void setTds_certificate_end_date(Date tds_certificate_end_date){
	  	   	this.tds_certificate_end_date=tds_certificate_end_date;
	  	}
	  	   
	  	public BigDecimal getTds(){
	  		return tds;
	  	}
	  	public void setTds(BigDecimal tds){
	  	   	this.tds=tds;
	  	}
	  	   
	  	public BigDecimal getImdTotalCommissionAmount(){
	  		return imdTotalCommissionAmount;
	  	}
	  	public void setImdTotalCommissionAmount(BigDecimal imdTotalCommissionAmount){
	  	   	this.imdTotalCommissionAmount=imdTotalCommissionAmount;
	  	}
	  	   
	  	public BigDecimal getImdTotalGridPercentage(){
	  		return imdTotalGridPercentage;
	  	}
	  	public void setImdTotalGridPercentage(BigDecimal imdTotalGridPercentage){
	  	   	this.imdTotalGridPercentage=imdTotalGridPercentage;
	  	}
	  	   
	  	public BigDecimal getManual_updation_final_amount(){
	  		return manual_updation_final_amount;
	  	}
	  	public void setManual_updation_final_amount(BigDecimal manual_updation_final_amount){
	  	   	this.manual_updation_final_amount=manual_updation_final_amount;
	  	}
	  	   
	  	public String getManual_updation_flag(){
	  		return manual_updation_flag;
	  	}
	  	public void setManual_updation_flag(String manual_updation_flag){
	  	   	this.manual_updation_flag=manual_updation_flag;
	  	}
	  	   
	  	public BigDecimal getTotal_amount(){
	  		return total_amount;
	  	}
	  	public void setTotal_amount(BigDecimal total_amount){
	  	   	this.total_amount=total_amount;
	  	}
	  	   
	  	public String getCase_type(){
	  		return case_type;
	  	}
	  	public void setCase_type(String case_type){
	  	   	this.case_type=case_type;
	  	}
	  	   
	  	public BigDecimal getIrda_od_perc(){
	  		return irda_od_perc;
	  	}
	  	public void setIrda_od_perc(BigDecimal irda_od_perc){
	  	   	this.irda_od_perc=irda_od_perc;
	  	}
	  	   
	  	public BigDecimal getIrda_tp_perc(){
	  		return irda_tp_perc;
	  	}
	  	public void setIrda_tp_perc(BigDecimal irda_tp_perc){
	  	   	this.irda_tp_perc=irda_tp_perc;
	  	}
	  	   
	  	public String getVehicle_model(){
	  		return vehicle_model;
	  	}
	  	public void setVehicle_model(String vehicle_model){
	  	   	this.vehicle_model=vehicle_model;
	  	}
	  	   
	  	public String getVehicle_make(){
	  		return vehicle_make;
	  	}
	  	public void setVehicle_make(String vehicle_make){
	  	   	this.vehicle_make=vehicle_make;
	  	}
	  	   
	  	public BigDecimal getTotal_gwp_new_tractor(){
	  		return total_gwp_new_tractor;
	  	}
	  	public void setTotal_gwp_new_tractor(BigDecimal total_gwp_new_tractor){
	  	   	this.total_gwp_new_tractor=total_gwp_new_tractor;
	  	}
	  	   
	  	public BigDecimal getTotal_gwp_lcv_lte_2_pt_5(){
	  		return total_gwp_lcv_lte_2_pt_5;
	  	}
	  	public void setTotal_gwp_lcv_lte_2_pt_5(BigDecimal total_gwp_lcv_lte_2_pt_5){
	  	   	this.total_gwp_lcv_lte_2_pt_5=total_gwp_lcv_lte_2_pt_5;
	  	}
	  	   
	  	public BigDecimal getTotal_gwp_lcv_lte_3_pt_5(){
	  		return total_gwp_lcv_lte_3_pt_5;
	  	}
	  	public void setTotal_gwp_lcv_lte_3_pt_5(BigDecimal total_gwp_lcv_lte_3_pt_5){
	  	   	this.total_gwp_lcv_lte_3_pt_5=total_gwp_lcv_lte_3_pt_5;
	  	}
	  	   
	  	public BigDecimal getTotal_gwp_pvt_car(){
	  		return total_gwp_pvt_car;
	  	}
	  	public void setTotal_gwp_pvt_car(BigDecimal total_gwp_pvt_car){
	  	   	this.total_gwp_pvt_car=total_gwp_pvt_car;
	  	}
	  	   
	  	public BigDecimal getFinal_grid_percentage(){
	  		return final_grid_percentage;
	  	}
	  	public void setFinal_grid_percentage(BigDecimal final_grid_percentage){
	  	   	this.final_grid_percentage=final_grid_percentage;
	  	}
	  	   
	  	public BigDecimal getFinal_additional_percentage(){
	  		return final_additional_percentage;
	  	}
	  	public void setFinal_additional_percentage(BigDecimal final_additional_percentage){
	  	   	this.final_additional_percentage=final_additional_percentage;
	  	}
	  	   
	  	public String getPvt_car_state_group(){
	  		return pvt_car_state_group;
	  	}
	  	public void setPvt_car_state_group(String pvt_car_state_group){
	  	   	this.pvt_car_state_group=pvt_car_state_group;
	  	}
	  	   
	  	public BigDecimal getGwp(){
	  		return gwp;
	  	}
	  	public void setGwp(BigDecimal gwp){
	  	   	this.gwp=gwp;
	  	}
	  	   
	  	public BigDecimal getTotal_lcv_premium(){
	  		return total_lcv_premium;
	  	}
	  	public void setTotal_lcv_premium(BigDecimal total_lcv_premium){
	  	   	this.total_lcv_premium=total_lcv_premium;
	  	}
	  	   
	  	public String getGwp_consider(){
	  		return gwp_consider;
	  	}
	  	public void setGwp_consider(String gwp_consider){
	  	   	this.gwp_consider=gwp_consider;
	  	}
	  	   
	  	public String getGwp_calculation_formula(){
	  		return gwp_calculation_formula;
	  	}
	  	public void setGwp_calculation_formula(String gwp_calculation_formula){
	  	   	this.gwp_calculation_formula=gwp_calculation_formula;
	  	}
	  	   
	  	public BigDecimal getMax_capping_perc(){
	  		return max_capping_perc;
	  	}
	  	public void setMax_capping_perc(BigDecimal max_capping_perc){
	  	   	this.max_capping_perc=max_capping_perc;
	  	}
	  	   
	  	public Map<String,BigDecimal> getPremium_map(){
	  		return premium_map;
	  	}
	  	public void setPremium_map(Map<String,BigDecimal> premium_map){
	  	   	this.premium_map=premium_map;
	  	}
	  	   
	  	public Map<String,BigDecimal> getGwp_map(){
	  		return gwp_map;
	  	}
	  	public void setGwp_map(Map<String,BigDecimal> gwp_map){
	  	   	this.gwp_map=gwp_map;
	  	}
	  	   
	  	public Long getDate_of_policy_issue(){
	  		return date_of_policy_issue;
	  	}
	  	public void setDate_of_policy_issue(Long date_of_policy_issue){
	  	   	this.date_of_policy_issue=date_of_policy_issue;
	  	}
	  	   
	  	public BigDecimal getFinal_gwp(){
	  		return final_gwp;
	  	}
	  	public void setFinal_gwp(BigDecimal final_gwp){
	  	   	this.final_gwp=final_gwp;
	  	}
	  	   
	  	public BigDecimal getException_gwp(){
	  		return exception_gwp;
	  	}
	  	public void setException_gwp(BigDecimal exception_gwp){
	  	   	this.exception_gwp=exception_gwp;
	  	}
	  	   
	  	public BigDecimal getNon_bolero_contribution(){
	  		return non_bolero_contribution;
	  	}
	  	public void setNon_bolero_contribution(BigDecimal non_bolero_contribution){
	  	   	this.non_bolero_contribution=non_bolero_contribution;
	  	}
	  	   
	  	public BigDecimal getNon_bolero_business(){
	  		return non_bolero_business;
	  	}
	  	public void setNon_bolero_business(BigDecimal non_bolero_business){
	  	   	this.non_bolero_business=non_bolero_business;
	  	}
	  	   
	  	public String getException_id(){
	  		return exception_id;
	  	}
	  	public void setException_id(String exception_id){
	  	   	this.exception_id=exception_id;
	  	}
	  	   
	  	public BigDecimal getSpecial_deduction(){
	  		return special_deduction;
	  	}
	  	public void setSpecial_deduction(BigDecimal special_deduction){
	  	   	this.special_deduction=special_deduction;
	  	}
	  	   
	  	public String getRemarks(){
	  		return remarks;
	  	}
	  	public void setRemarks(String remarks){
	  	   	this.remarks=remarks;
	  	}
	  	   
	  	public BigDecimal getNew_var(){
	  		return new_var;
	  	}
	  	public void setNew_var(BigDecimal new_var){
	  	   	this.new_var=new_var;
	  	}
	  	   
	  	public BigDecimal getCapping_grid_percentage(){
	  		return capping_grid_percentage;
	  	}
	  	public void setCapping_grid_percentage(BigDecimal capping_grid_percentage){
	  	   	this.capping_grid_percentage=capping_grid_percentage;
	  	}
	  	   
	  	public String getReadyForRelease(){
	  		return readyForRelease;
	  	}
	  	public void setReadyForRelease(String readyForRelease){
	  	   	this.readyForRelease=readyForRelease;
	  	}
	  	   
	  	public Long getComponentSourceId(){
	  		return componentSourceId;
	  	}
	  	public void setComponentSourceId(Long componentSourceId){
	  	   	this.componentSourceId=componentSourceId;
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
	  	   
	  	public String getComputation(){
	  		return computation;
	  	}
	  	public void setComputation(String computation){
	  	   	this.computation=computation;
	  	}
	  	   
	  	public BigDecimal getVehicle_age(){
	  		return vehicle_age;
	  	}
	  	public void setVehicle_age(BigDecimal vehicle_age){
	  	   	this.vehicle_age=vehicle_age;
	  	}
	  	   
	  	public BigDecimal getIrda_percentage(){
	  		return irda_percentage;
	  	}
	  	public void setIrda_percentage(BigDecimal irda_percentage){
	  	   	this.irda_percentage=irda_percentage;
	  	}
	  	   
	  	public BigDecimal getFresh_business_perc(){
	  		return fresh_business_perc;
	  	}
	  	public void setFresh_business_perc(BigDecimal fresh_business_perc){
	  	   	this.fresh_business_perc=fresh_business_perc;
	  	}
	  	   
	  	public BigDecimal getDefault_percentage(){
	  		return default_percentage;
	  	}
	  	public void setDefault_percentage(BigDecimal default_percentage){
	  	   	this.default_percentage=default_percentage;
	  	}
	  	   
	  	public BigDecimal getUsgi_net_pr_less_tp_pr(){
	  		return usgi_net_pr_less_tp_pr;
	  	}
	  	public void setUsgi_net_pr_less_tp_pr(BigDecimal usgi_net_pr_less_tp_pr){
	  	   	this.usgi_net_pr_less_tp_pr=usgi_net_pr_less_tp_pr;
	  	}
	  	   
	  	public Long getSeating_capacity(){
	  		return seating_capacity;
	  	}
	  	public void setSeating_capacity(Long seating_capacity){
	  	   	this.seating_capacity=seating_capacity;
	  	}
	  	   
	  	public String getDirect_code_flag(){
	  		return direct_code_flag;
	  	}
	  	public void setDirect_code_flag(String direct_code_flag){
	  	   	this.direct_code_flag=direct_code_flag;
	  	}
	  	   
	  	public BigDecimal getPre_final_grid_percentage(){
	  		return pre_final_grid_percentage;
	  	}
	  	public void setPre_final_grid_percentage(BigDecimal pre_final_grid_percentage){
	  	   	this.pre_final_grid_percentage=pre_final_grid_percentage;
	  	}
	  	   
	  	public String getPre_computation(){
	  		return pre_computation;
	  	}
	  	public void setPre_computation(String pre_computation){
	  	   	this.pre_computation=pre_computation;
	  	}
	  	   
	  	public Long getLong_term_year(){
	  		return long_term_year;
	  	}
	  	public void setLong_term_year(Long long_term_year){
	  	   	this.long_term_year=long_term_year;
	  	}
	  	   
	  	public String getLong_term_flag(){
	  		return long_term_flag;
	  	}
	  	public void setLong_term_flag(String long_term_flag){
	  	   	this.long_term_flag=long_term_flag;
	  	}
	  	   
	  	public BigDecimal getLong_term_percentage(){
	  		return long_term_percentage;
	  	}
	  	public void setLong_term_percentage(BigDecimal long_term_percentage){
	  	   	this.long_term_percentage=long_term_percentage;
	  	}
	  	   
	  	public BigDecimal getLong_term_amount(){
	  		return long_term_amount;
	  	}
	  	public void setLong_term_amount(BigDecimal long_term_amount){
	  	   	this.long_term_amount=long_term_amount;
	  	}
	  	   
	  	public Date getPurchase_date(){
	  		return purchase_date;
	  	}
	  	public void setPurchase_date(Date purchase_date){
	  	   	this.purchase_date=purchase_date;
	  	}
	  	   
	  	public String getBreaking_flag(){
	  		return breaking_flag;
	  	}
	  	public void setBreaking_flag(String breaking_flag){
	  	   	this.breaking_flag=breaking_flag;
	  	}
	  	   
	  	public String getFinal_dealer_code(){
	  		return final_dealer_code;
	  	}
	  	public void setFinal_dealer_code(String final_dealer_code){
	  	   	this.final_dealer_code=final_dealer_code;
	  	}
	  	   
	  	public String getPreferred_referred(){
	  		return preferred_referred;
	  	}
	  	public void setPreferred_referred(String preferred_referred){
	  	   	this.preferred_referred=preferred_referred;
	  	}
	  	   
	  	public BigDecimal getHealth_fresh_premium(){
	  		return health_fresh_premium;
	  	}
	  	public void setHealth_fresh_premium(BigDecimal health_fresh_premium){
	  	   	this.health_fresh_premium=health_fresh_premium;
	  	}
	  	   
	  	public String getGrid_id(){
	  		return grid_id;
	  	}
	  	public void setGrid_id(String grid_id){
	  	   	this.grid_id=grid_id;
	  	}
	  	   
	  	public Date getPolicy_start_date(){
	  		return policy_start_date;
	  	}
	  	public void setPolicy_start_date(Date policy_start_date){
	  	   	this.policy_start_date=policy_start_date;
	  	}
	  	   
	  	public Date getPolicy_end_date(){
	  		return policy_end_date;
	  	}
	  	public void setPolicy_end_date(Date policy_end_date){
	  	   	this.policy_end_date=policy_end_date;
	  	}
	  	   
	  	public Long getNo_of_days(){
	  		return no_of_days;
	  	}
	  	public void setNo_of_days(Long no_of_days){
	  	   	this.no_of_days=no_of_days;
	  	}
	  	   
	  	public String getPolicy_issuance_state(){
	  		return policy_issuance_state;
	  	}
	  	public void setPolicy_issuance_state(String policy_issuance_state){
	  	   	this.policy_issuance_state=policy_issuance_state;
	  	}
	  	   
	  	public BigDecimal getAgent_mentor_percentage(){
	  		return agent_mentor_percentage;
	  	}
	  	public void setAgent_mentor_percentage(BigDecimal agent_mentor_percentage){
	  	   	this.agent_mentor_percentage=agent_mentor_percentage;
	  	}
	  	   
	  	public BigDecimal getAgent_mentor_final_percentage(){
	  		return agent_mentor_final_percentage;
	  	}
	  	public void setAgent_mentor_final_percentage(BigDecimal agent_mentor_final_percentage){
	  	   	this.agent_mentor_final_percentage=agent_mentor_final_percentage;
	  	}
	  	   
	  	public String getAgent_mentor_computation(){
	  		return agent_mentor_computation;
	  	}
	  	public void setAgent_mentor_computation(String agent_mentor_computation){
	  	   	this.agent_mentor_computation=agent_mentor_computation;
	  	}
	  	   
	  	public BigDecimal getAgent_mentor_amount(){
	  		return agent_mentor_amount;
	  	}
	  	public void setAgent_mentor_amount(BigDecimal agent_mentor_amount){
	  	   	this.agent_mentor_amount=agent_mentor_amount;
	  	}
	  	   
	  	public BigDecimal getTotal_dealer_amount(){
	  		return total_dealer_amount;
	  	}
	  	public void setTotal_dealer_amount(BigDecimal total_dealer_amount){
	  	   	this.total_dealer_amount=total_dealer_amount;
	  	}
	  	   
	  	public String getAgent_mentor_id(){
	  		return agent_mentor_id;
	  	}
	  	public void setAgent_mentor_id(String agent_mentor_id){
	  	   	this.agent_mentor_id=agent_mentor_id;
	  	}
	  	   
	  	public BigDecimal getTopline(){
	  		return topline;
	  	}
	  	public void setTopline(BigDecimal topline){
	  	   	this.topline=topline;
	  	}
	  	   
	  	public BigDecimal getBottomline(){
	  		return bottomline;
	  	}
	  	public void setBottomline(BigDecimal bottomline){
	  	   	this.bottomline=bottomline;
	  	}
	  	   
	  	public BigDecimal getLossratio(){
	  		return lossratio;
	  	}
	  	public void setLossratio(BigDecimal lossratio){
	  	   	this.lossratio=lossratio;
	  	}
	  	   
	  	public BigDecimal getCommission_check(){
	  		return commission_check;
	  	}
	  	public void setCommission_check(BigDecimal commission_check){
	  	   	this.commission_check=commission_check;
	  	}
	  	   
	  	public String getConcat_column(){
	  		return concat_column;
	  	}
	  	public void setConcat_column(String concat_column){
	  	   	this.concat_column=concat_column;
	  	}
	  	   
	  	public String getSub_channel_flag(){
	  		return sub_channel_flag;
	  	}
	  	public void setSub_channel_flag(String sub_channel_flag){
	  	   	this.sub_channel_flag=sub_channel_flag;
	  	}
	  	   
	  	public String getProduct_flag(){
	  		return product_flag;
	  	}
	  	public void setProduct_flag(String product_flag){
	  	   	this.product_flag=product_flag;
	  	}
	  	   
	  	public Long getSub_lob(){
	  		return sub_lob;
	  	}
	  	public void setSub_lob(Long sub_lob){
	  	   	this.sub_lob=sub_lob;
	  	}
	  	   
	  	public BigDecimal getSum_insured(){
	  		return sum_insured;
	  	}
	  	public void setSum_insured(BigDecimal sum_insured){
	  	   	this.sum_insured=sum_insured;
	  	}
	  	   
	  	public String getGridLog(){
	  		return gridLog;
	  	}
	  	public void setGridLog(String gridLog){
	  	   	this.gridLog=gridLog;
	  	}

}
