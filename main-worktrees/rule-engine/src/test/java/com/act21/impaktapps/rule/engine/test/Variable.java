package com.act21.impaktapps.rule.engine.test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Variable implements Serializable {

	private String pol_rk;
	private String policy_no;
	private String pol_endorsement_type;
	private String policy_type_new;
	private String pol_business_type_lt;
	private String vertical_desc;
	private BigDecimal pol_mot_engine_cc;
	private String segment_type;
	private BigDecimal pol_gross_veh_wt;
	private String pol_fuel_type;
	private String irda_product_name;
	private String pol_calculated_constitution;
	private BigDecimal gwp;
	private String pol_mot_veh_registration_num;
	private BigDecimal tp;
	private String pol_mot_rto_code;
	private String pol_mot_rto_location;
	private BigDecimal basic_od;
	private BigDecimal electrical_od;
	private BigDecimal non_electrical_od;
	private BigDecimal bi_fuel_od;
	private BigDecimal age_discount;
	private BigDecimal occupation_discount;
	private BigDecimal other_loadings;
	private BigDecimal other_discounts;
	private BigDecimal pol_tot_sum_insured_amt;
	private BigDecimal pol_tariff_rate;
	private BigDecimal cpa;
	private String pol_mot_model_code;
	private BigDecimal od;
	private String pol_mot_manufacturer_name;
	private String pol_system_product_code;
	private String long_term_pol_tag;
	private String pol_multiyear_status;
	private String pol_start_date;
	private String pol_end_date;
	private String pol_reporting_date;
	private String mdm_branch_name;
	private String pol_financier_name;
	private String deal_rcm_branch_earthcode;
	private String pol_certificate_number;
	private BigDecimal pol_ncb_percentage;
	private String pol_type_of_usage;
	private String pol_user_group;
	private String pol_breakin_id;
	private String pol_mot_registration_date;
	private String pol_plan_name;
	private String pol_registration_zone;
	private String pol_sub_class_desc;
	private String pol_carrying_type;
	private BigDecimal pol_no_of_wheels;
	private String pol_prev_end_date;
	private String pol_mot_manufacturer_year;
	private String pol_prev_insurer_name;
	private String pol_docket_desc;
	private String pol_effective_date;
	private String pol_transaction_date;
	private String pol_endorse_request_type;
	private String pol_mot_seating_capacity;
	private String cust_full_name;
	private String pol_passenger_carry_cap;
	private String agent_full_name_x;
	private BigDecimal zd_offered_amt;
	private BigDecimal zd_actual_amt;
	private BigDecimal coc_offered_amt;
	private BigDecimal ncb_pro_offered_amt;
	private BigDecimal ncb_pro_actual_amt;
	private BigDecimal eng_offered_amt;
	private BigDecimal eng_actual_amt;
	private BigDecimal rti_offered_amt;
	private BigDecimal lossofuse_offered_amt;
	private BigDecimal lossofuse_actual_amt;
	private BigDecimal ea_offered_amt;
	private BigDecimal ea_actual_amt;
	private BigDecimal ea_wider_offered_amt;
	private BigDecimal ea_wider_actual_amt;
	private BigDecimal emi_offered_amt;
	private BigDecimal emi_actual_amt;
	private BigDecimal high_prot_offered_amt;
	private BigDecimal high_prot_actual_amt;
	private BigDecimal basic_tp;
	private BigDecimal pa_cover;
	private BigDecimal pa_owner;
	private BigDecimal paid_driver;
	private BigDecimal ll_to_paid_driver_clr_condt;
	private BigDecimal trailers_tp;
	private BigDecimal employeesofinsured_tp;
	private BigDecimal coverage_si;
	private BigDecimal break_in_loadng_amt;
	private BigDecimal over_turning_amt;
	private BigDecimal geo_ext_amt;
	private BigDecimal high_tonnage_amt;
	private BigDecimal tppd_disc_amt;
	private BigDecimal theft_conversion_imt_43;
	private BigDecimal private_use_total;
	private BigDecimal private_use_tp;
	private BigDecimal ncb_amt;
	private BigDecimal pol_loading_imt23_amt;
	private BigDecimal pol_loading_imt47_amt;
	private BigDecimal trailers_od;
	private BigDecimal non_electrical_od_si;
	private BigDecimal nop;
	private BigDecimal total_collected_gwp;
	private String pol_od_start_date;
	private String pol_od_end_date;
	private String pol_mot_multiyear_tag;
	private String oem_online_renewal_flag;
	private String agent_full_name_y;
	private String pol_portal_cscid;
	private String v12;
	private String sp_credit;
	private String pol_vendor_pie_flag;
	private String pol_super_parent_code;
	private String pol_mot_model_name;
	private String pol_mot_manufacturer_code;
	private BigDecimal coc_actual_amt;
	private String gc_code;
	private String ncb_flag;
	private String pol_business_type;
	private BigDecimal rti_actual_amt;
	private String state_name;
	private String state_rank;
	private BigDecimal total_od;
	private BigDecimal total_gwp;
	private BigDecimal total_tp;
	private BigDecimal tp_payout_percentage;
	private BigDecimal tp_payout_amount;
	private String remarks;
	private String rto_code;
	private String location_name;
	private String segment_type_model;
	private BigDecimal total_gwp_payout_amount;
	private BigDecimal gwp_payout_percentage;
	private BigDecimal final_discount_per;
	private String state_type;
	private BigDecimal total_od_amount;
	private BigDecimal od_payout_percentage;
	private BigDecimal od_payout_amount;
	private BigDecimal years_diff;
	private BigDecimal od_comm_perc;
	private BigDecimal tp_comm_perc;
	private BigDecimal od_prov_perc;
	private BigDecimal tp_prov_perc;
	private BigDecimal campaign_perc;
	private BigDecimal total_campaign;
	private BigDecimal corp_other_payout_perc;
	private BigDecimal corp_other_payout_amount;
	private BigDecimal od_rew_percentage;
	private BigDecimal tp_rew_percentage;
	private BigDecimal od_rew_payout_amount;
	private BigDecimal tp_rew_payout_amount;
	private BigDecimal commission;
	private BigDecimal total_payout_amount;
	private BigDecimal additional_commission;
	private BigDecimal service_fees;
	private String ia_code;
	private BigDecimal factor;
	private BigDecimal net_discount;
	private BigDecimal net_od;
	private BigDecimal net_rate;
	private String rank_ll;
	private String computation_type;
	private BigDecimal spec_val_perc;
	private String pol_agent_code;
	private String final_segment_type;
	private BigDecimal cubic_capacity;
	private String grid;
	private BigDecimal veh_age;
	private BigDecimal tariff_rate;
	private BigDecimal final_tarrif_rate;
	private BigDecimal dev_amount;
	private BigDecimal output_basic_od;
	private BigDecimal sum_ins;
	private BigDecimal t_rate;
	private BigDecimal basic_od1;
	private BigDecimal si;
	private BigDecimal gcv_tariff;
	private BigDecimal elec_nonelec;
	private BigDecimal prod_od;
	private BigDecimal elec_ratio;
	private BigDecimal ota;
	private BigDecimal tci_43;
	private BigDecimal put;
	private BigDecimal pli_23;
	private BigDecimal total_covers;
	private BigDecimal net_od_si;
	private BigDecimal t_disc;
	private BigDecimal calc_basic_od;
	private BigDecimal total_comm_prov;
	private BigDecimal final_multiyear_status;
	private String ncb_flag1;
	private BigDecimal final_comm_payout_amount;
	private String misp_flag;
	private BigDecimal sf_comm_perc;
	private BigDecimal sf_prov_perc;
	private BigDecimal sf_payout_amount;
	private String computation_type_manager;
	private BigDecimal t_irda;
	private BigDecimal sf_perc;
	private BigDecimal sf_prov_amount;
	private String grid_manager;
	private String misp_flag_manager;
	private String ncb_segment;
	private String hierarchy_remark;
	private String bde_perc;
	private BigDecimal bde_amount;
	private String dealer;
	private BigDecimal tp_prov_amount;
	private BigDecimal od_prov_amount;
	private BigDecimal dc_commission;
	private BigDecimal final_sf_oe;
	private String web_cases_flag;
	private BigDecimal total_prov_amount;
	private BigDecimal tp_irda_percentage;
	private BigDecimal od_irda_percentage;
	private BigDecimal od_irda;
	private BigDecimal tp_irda;
	private BigDecimal total_sa_tp;
	private BigDecimal total_pvt_car;
	private BigDecimal total_tw;
	private BigDecimal total_misc;
	private BigDecimal total_gcv;
	private BigDecimal total_pcv;
	private BigDecimal rsa_hero_amount;
	private BigDecimal reserve_od_final;
	private String payment_logic;
	private BigDecimal wp_percent;
	private BigDecimal wp_sf;
	private BigDecimal wp_tp;
	private BigDecimal wp_od;
	private BigDecimal direct_wp_percent;
	private BigDecimal direct_wp_sf;
	private BigDecimal direct_wp_tp;
	private BigDecimal direct_wp_od;
	private BigDecimal direct_rnr_percent;
	private BigDecimal direct_rnr;
	private BigDecimal hmsi_campaign_amt;
	private String pol_agent_code_flag;
	private BigDecimal auto_escort_perc;
	private BigDecimal auto_escort_amt;
	private BigDecimal annual_campaign_perc;
	private BigDecimal annual_campaign_amt;
	private BigDecimal tvs_campaign_perc;
	private BigDecimal tvs_campaign_amt;
	private String computation_type_campaign;
	private String misp_flag_campaign;
	private Long payoutComponentId;
	private Long id;
	private BigDecimal slab;
	private Long payout_id;
	private String pol_super_parent_name;
	private BigDecimal cbp_percent;
	private BigDecimal cbp_sf;
	private BigDecimal cbp_tp;
	private BigDecimal cbp_od;
	private BigDecimal wp_rnr_percent;
	private BigDecimal wp_rnr;
	private BigDecimal wp_tp_rnr;
	private BigDecimal wp_od_rnr;
	private String computation_type_banca;
	private BigDecimal direct_od_payout_percentage;
	private BigDecimal direct_tp_payout_percentage;
	private BigDecimal direct_od_prov_perc;
	private BigDecimal direct_tp_prov_perc;
	private BigDecimal direct_od_payout_amount;
	private BigDecimal direct_tp_payout_amount;
	private BigDecimal direct_od_prov_amount;
	private BigDecimal direct_tp_prov_amount;
	private BigDecimal direct_total_payout_amount;
	private BigDecimal direct_total_prov_amount;
	private String discount_slab;
	private String veh_slab;
	private String business_type;
	private String sa_od_renewal_flag;
	private String disc_slab;
	private String payeeName;
	private String name;
	private String type;
	private String discount_slab_flag;
	private BigDecimal final_prov_amount;
	private BigDecimal tvs_gwp_sum;
	private BigDecimal hmsi_gwp_sum;
	private BigDecimal prev_ia_code_provision_amount;
	private String p_tax_flag;
	private String date_of_birth;
	private String dat_intermediary_start_date;
	private BigDecimal p_tax_amt;
	private BigDecimal limit_amount;
	private String anx_state;
	private String reserver_od_renewal_lt_flag;
	private String final_vertical_desc;
	private BigDecimal final_commission;
	private String manual_updation_flag;
	private BigDecimal final_commission_manual_updation;
	private BigDecimal final_commission_updated;
	private BigDecimal final_commission_perc_manual_updation;
	private BigDecimal cgstPercentage;
	private BigDecimal sgstPercentage;
	private BigDecimal igstPercentage;
	private BigDecimal cgstAmount;
	private BigDecimal sgstAmount;
	private BigDecimal igstAmount;
	private String workflow_status;
	private BigDecimal released_amount;
	private String ready_for_release;
	private String release_group;
	private BigDecimal program_id;
	private String processBusinessKey;
	private String bankname;
	private String bankaccno;
	private String bank_ifsc_code;
	private String ia_code_state;
	private String ia_code_gstno;
	private String agency_name;
	private String gstin;
	private String license_expiry_date;
	private BigDecimal provisionAmount;
	private String gst_applicable;
	private BigDecimal commAmt;
	private BigDecimal totalGstAmount;
	private String oem_vertical;
	private String business_group;
	private BigDecimal final_commission_perc;
	private BigDecimal final_provision_perc;
	private BigDecimal manufacturer_prov_amt;
	private BigDecimal csc_prov_amt;
	private BigDecimal manufacturer_prov_sum;
	private BigDecimal csc_prov_sum;
	private String igstApplicable;
	private String sgstApplicable;
	private String cgstApplicable;
	private String hdfc_state;
	private String broker;
	private BigDecimal excess_of_annx_perc;
	private BigDecimal proRateAmt;
	private BigDecimal toyota_campaign_gwp_sum;
	private BigDecimal honda_4w_campaigngwp_sum;
	private BigDecimal final_commission_od;
	private BigDecimal final_commission_tp;
	private BigDecimal final_prov_od;
	private BigDecimal final_prov_tp;
	private BigDecimal cbp_od_perc;
	private BigDecimal cbp_tp_perc;
	private String vertical_name;
	private BigDecimal cbp_amount;
	private BigDecimal cbp_tp_amount;
	private BigDecimal cbp_od_amount;
	private BigDecimal cpa_flag;
	private String annx6_effective_date;
	private String anx1_segment;
	private String txt_sate_sub_name;
	private String state_num;
	private String num_sate_sub_code;
	private String txt_display_caption;
	private String cg1_segment;
	private String cg1_slab;
	private String a2_zone;
	private String cg2_fuel_type;
	private String cg3_segment;
	private String cg3_cpa_flag;
	private String derr_txt_segment_type;
	private String cg4_discount;
	private String cg4_slab;
	private String a3_zone;
	private String cg5_ncb_flag;
	private String cg5_fuel_type;
	private String cg5_slab;
	private String a4_segment;
	private String a4_discount;
	private String cg6_segment;
	private String cg6_slab;
	private String cg6_discount;
	private String cg7_discount;
	private String cg7_segment;
	private String a5_segment;
	private String a5_policy_type;
	private String a5_business_type;
	private String WP_No;
	private String effective;
	private String ending_on;
	private String status;
	private String agency_Grid_No;
	private String agency_Name;
	private BigDecimal comm_od;
	private BigDecimal comm_tp;
	private BigDecimal prov_od;
	private BigDecimal prov_tp;
	private String flag;
	private String bancaM_policy_type;
	private String bancaM_business_type;
	private BigDecimal bancaM_cpa;
	private String bancaM_discount;
	private String a9_product;
	private String a9_constitution;
	private BigDecimal a9_percentage;
	private String a12_product;
	private String a12_veh_age;
	private String a12_policy_type;
	private String a6_discount_slab;
	private String a6_policy_type;
	private String a6_business_type;
	private String a6_segment;
	private String witheffectfrom;
	private String upto_Date;
	private String exp_GWP_lacs;
	private String exp_MCOR;
	private String a6_fuel_type;
	private String ver_Geo;
	private String location;
	private String dealer_Name;
	private String vehicle_Age;
	private String noofWheels;
	private String a14_product;
	private String policy_type_state_mst;
	private String txt_location_code;
	private String location_code;
	private String state_code;
	private String ncb_flag_anx6;
	private String anx4_state;
	private String Commission_Campaign_Name;
	private String Commission_Campaign;
	private String Campaign_type;
	private String Excluding_Including_Annex_9;
	private String With_Effect_Dt;
	private String With_End_Dt;
	private String Excluding_Business_Type_LT;
	private String Excluding_Vertical;
	private String Excluding_Model;
	private String Excluding_Segment;
	private String Excluding_Fuel_Type;
	private String Release_Provision;
	private String Attachement_Ref;
	private String annual_campaign_broker;
	private String afterAnnx_6_effective_flag;
	private List<String> a5_business_type_list;
	private String location_state_name;
	private BigDecimal highest_sf_comm_perc;
	private List<String> cbp_list;
	private List<String> computation_type_list;
	private String cbg_slab;
	private String cbg_policy_type;
	private List<String> a5_segment_list;
	private String hdfc_address;
	private String hdfc_pan;
	private String hdfc_state_code;
	private BigDecimal sf_od;
	private BigDecimal sf_tp;
	private String payee_login;
	private String mdm_product_name;
	private String pol_endorsement_num;
	private String pol_deal_num;
	private String pol_src_state;
	private String pol_destn_state;
	private String pol_insurance_type;
	private String pol_tag;
	private String terrorism_premium;
	private BigDecimal cbp_total_amount;
	private String pcv_rto_code_flag;
	private String renewal_flag;
	private BigDecimal final_bde;
	private String policy_no_with_backslash;
	private String pol_agent_code_with_backslash;
	private String pol_certificate_number_with_backslah;
	private String pol_super_parent_code_with_backslah;
	private String pid_status;
	private BigDecimal payableAmount;
	private BigDecimal holdAmount;
	private String policy_hold_flag;
	private String policy_hold_remark;
	private String license_flag;
	private String agent_inactive_flag;
	private String invoiceFlag;
	private String pid_hold_status;
	private String holdStatus;
	private String hold_reason;
	private Long payout_comp_id;
	private String readyForRelease;
	private BigDecimal releasedAmount;
	private Object outputData;
	private Date modifiedOn;
	private Object inputData;
	private Long version;
	private Long payout_processing_request_id;
	private String workflow_details;
	private Long component_source_id;
	private String releaseGroup;
	private BigDecimal prev_final_percentage;
	private BigDecimal prev_final_commision;
	private String agency_constitution;
	private String lic_exp_hold_status;
	private String input1;
	private List<String> output1;
	private String product;
	private String loan_class;
	private String loan_points_per_1k;
	private String input2;
	private String input3;
	private String input4;
	private String output2;
	private String input5;

	private String restrictedCharactersInput;
	private String restrictedCharactersOutput;

	private Long minLongVal;
	private Long minLongVal1;
	private Long minLongVal2;
	private Long minLongVal3;

	private BigDecimal minBigDecimalVal;
	private BigDecimal minBigDecimalVal1;
	private BigDecimal minBigDecimalVal2;
	private BigDecimal minBigDecimalVal3;

	private Long maxLongVal;
	private Long maxLongVal1;
	private Long maxLongVal2;
	private Long maxLongVal3;

	private BigDecimal maxBigDecimalVal;
	private BigDecimal maxBigDecimalVal1;
	private BigDecimal maxBigDecimalVal2;
	private BigDecimal maxBigDecimalVal3;

	private BigDecimal avgLongVal;
	private Long avgLongVal1;
	private Long avgLongVal2;
	private Long avgLongVal3;

	private BigDecimal avgBigDecimalVal;
	private BigDecimal avgBigDecimalVal1;
	private BigDecimal avgBigDecimalVal2;
	private BigDecimal avgBigDecimalVal3;

	private String notOperandInput;
	private String notOperandOutput;
	
	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	private Date date1;
	private Date date2;

	public String getNotOperandInput() {
		return notOperandInput;
	}

	public void setNotOperandInput(String notOperandInput) {
		this.notOperandInput = notOperandInput;
	}

	public String getNotOperandOutput() {
		return notOperandOutput;
	}

	public void setNotOperandOutput(String notOperandOutput) {
		this.notOperandOutput = notOperandOutput;
	}

	public String getRestrictedCharactersInput() {
		return restrictedCharactersInput;
	}

	public void setRestrictedCharactersInput(String restrictedCharactersInput) {
		this.restrictedCharactersInput = restrictedCharactersInput;
	}

	public String getRestrictedCharactersOutput() {
		return restrictedCharactersOutput;
	}

	public void setRestrictedCharactersOutput(String restrictedCharactersOutput) {
		this.restrictedCharactersOutput = restrictedCharactersOutput;
	}

	public BigDecimal getAvgLongVal() {
		return avgLongVal;
	}

	public void setAvgLongVal(BigDecimal avgLongVal) {
		this.avgLongVal = avgLongVal;
	}

	public BigDecimal getMaxBigDecimalVal() {
		return maxBigDecimalVal;
	}

	public BigDecimal getAvgBigDecimalVal() {
		return avgBigDecimalVal;
	}

	public void setAvgBigDecimalVal(BigDecimal avgBigDecimalVal) {
		this.avgBigDecimalVal = avgBigDecimalVal;
	}

	public void setMaxBigDecimalVal(BigDecimal maxBigDecimalVal) {
		this.maxBigDecimalVal = maxBigDecimalVal;
	}

	public Long getMaxLongVal() {
		return maxLongVal;
	}

	public void setMaxLongVal(Long maxLongVal) {
		this.maxLongVal = maxLongVal;
	}

	public BigDecimal getMinBigDecimalVal() {
		return minBigDecimalVal;
	}

	public void setMinBigDecimalVal(BigDecimal minBigDecimalVal) {
		this.minBigDecimalVal = minBigDecimalVal;
	}

	public Long getMinLongVal() {
		return minLongVal;
	}

	public void setMinLongVal(Long minLongVal) {
		this.minLongVal = minLongVal;
	}

	public Long getMinLongVal1() {
		return minLongVal1;
	}

	public void setMinLongVal1(Long minLongVal1) {
		this.minLongVal1 = minLongVal1;
	}

	public Long getMinLongVal2() {
		return minLongVal2;
	}

	public void setMinLongVal2(Long minLongVal2) {
		this.minLongVal2 = minLongVal2;
	}

	public Long getMinLongVal3() {
		return minLongVal3;
	}

	public void setMinLongVal3(Long minLongVal3) {
		this.minLongVal3 = minLongVal3;
	}

	public BigDecimal getMinBigDecimalVal1() {
		return minBigDecimalVal1;
	}

	public void setMinBigDecimalVal1(BigDecimal minBigDecimalVal1) {
		this.minBigDecimalVal1 = minBigDecimalVal1;
	}

	public BigDecimal getMinBigDecimalVal2() {
		return minBigDecimalVal2;
	}

	public void setMinBigDecimalVal2(BigDecimal minBigDecimalVal2) {
		this.minBigDecimalVal2 = minBigDecimalVal2;
	}

	public BigDecimal getMinBigDecimalVal3() {
		return minBigDecimalVal3;
	}

	public void setMinBigDecimalVal3(BigDecimal minBigDecimalVal3) {
		this.minBigDecimalVal3 = minBigDecimalVal3;
	}

	public Long getMaxLongVal1() {
		return maxLongVal1;
	}

	public void setMaxLongVal1(Long maxLongVal1) {
		this.maxLongVal1 = maxLongVal1;
	}

	public Long getMaxLongVal2() {
		return maxLongVal2;
	}

	public void setMaxLongVal2(Long maxLongVal2) {
		this.maxLongVal2 = maxLongVal2;
	}

	public Long getMaxLongVal3() {
		return maxLongVal3;
	}

	public void setMaxLongVal3(Long maxLongVal3) {
		this.maxLongVal3 = maxLongVal3;
	}

	public BigDecimal getMaxBigDecimalVal1() {
		return maxBigDecimalVal1;
	}

	public void setMaxBigDecimalVal1(BigDecimal maxBigDecimalVal1) {
		this.maxBigDecimalVal1 = maxBigDecimalVal1;
	}

	public BigDecimal getMaxBigDecimalVal2() {
		return maxBigDecimalVal2;
	}

	public void setMaxBigDecimalVal2(BigDecimal maxBigDecimalVal2) {
		this.maxBigDecimalVal2 = maxBigDecimalVal2;
	}

	public BigDecimal getMaxBigDecimalVal3() {
		return maxBigDecimalVal3;
	}

	public void setMaxBigDecimalVal3(BigDecimal maxBigDecimalVal3) {
		this.maxBigDecimalVal3 = maxBigDecimalVal3;
	}

	public Long getAvgLongVal1() {
		return avgLongVal1;
	}

	public void setAvgLongVal1(Long avgLongVal1) {
		this.avgLongVal1 = avgLongVal1;
	}

	public Long getAvgLongVal2() {
		return avgLongVal2;
	}

	public void setAvgLongVal2(Long avgLongVal2) {
		this.avgLongVal2 = avgLongVal2;
	}

	public Long getAvgLongVal3() {
		return avgLongVal3;
	}

	public void setAvgLongVal3(Long avgLongVal3) {
		this.avgLongVal3 = avgLongVal3;
	}

	public BigDecimal getAvgBigDecimalVal1() {
		return avgBigDecimalVal1;
	}

	public void setAvgBigDecimalVal1(BigDecimal avgBigDecimalVal1) {
		this.avgBigDecimalVal1 = avgBigDecimalVal1;
	}

	public BigDecimal getAvgBigDecimalVal2() {
		return avgBigDecimalVal2;
	}

	public void setAvgBigDecimalVal2(BigDecimal avgBigDecimalVal2) {
		this.avgBigDecimalVal2 = avgBigDecimalVal2;
	}

	public BigDecimal getAvgBigDecimalVal3() {
		return avgBigDecimalVal3;
	}

	public void setAvgBigDecimalVal3(BigDecimal avgBigDecimalVal3) {
		this.avgBigDecimalVal3 = avgBigDecimalVal3;
	}

	public String getInput2() {
		return input2;
	}

	public void setInput2(String input2) {
		this.input2 = input2;
	}

	public String getInput3() {
		return input3;
	}

	public void setInput3(String input3) {
		this.input3 = input3;
	}

	public String getInput4() {
		return input4;
	}

	public void setInput4(String input4) {
		this.input4 = input4;
	}

	public String getOutput2() {
		return output2;
	}

	public void setOutput2(String output2) {
		this.output2 = output2;
	}

	public String getInput5() {
		return input5;
	}

	public void setInput5(String input5) {
		this.input5 = input5;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getLoan_class() {
		return loan_class;
	}

	public void setLoan_class(String loan_class) {
		this.loan_class = loan_class;
	}

	public String getLoan_points_per_1k() {
		return loan_points_per_1k;
	}

	public void setLoan_points_per_1k(String loan_points_per_1k) {
		this.loan_points_per_1k = loan_points_per_1k;
	}

	public Variable() {
		pol_rk = "";
		policy_no = "";
		pol_endorsement_type = "";
		policy_type_new = "";
		pol_business_type_lt = "";
		vertical_desc = "";
		pol_mot_engine_cc = BigDecimal.ZERO;
		segment_type = "";
		pol_gross_veh_wt = BigDecimal.ZERO;
		pol_fuel_type = "";
		irda_product_name = "";
		pol_calculated_constitution = "";
		gwp = BigDecimal.ZERO;
		pol_mot_veh_registration_num = "";
		tp = BigDecimal.ZERO;
		pol_mot_rto_code = "";
		pol_mot_rto_location = "";
		basic_od = BigDecimal.ZERO;
		electrical_od = BigDecimal.ZERO;
		non_electrical_od = BigDecimal.ZERO;
		bi_fuel_od = BigDecimal.ZERO;
		age_discount = BigDecimal.ZERO;
		occupation_discount = BigDecimal.ZERO;
		other_loadings = BigDecimal.ZERO;
		other_discounts = BigDecimal.ZERO;
		pol_tot_sum_insured_amt = BigDecimal.ZERO;
		pol_tariff_rate = BigDecimal.ZERO;
		cpa = BigDecimal.ZERO;
		pol_mot_model_code = "";
		od = BigDecimal.ZERO;
		pol_mot_manufacturer_name = "";
		pol_system_product_code = "";
		long_term_pol_tag = "";
		pol_multiyear_status = "";
		pol_start_date = "";
		pol_end_date = "";
		pol_reporting_date = "";
		mdm_branch_name = "";
		pol_financier_name = "";
		deal_rcm_branch_earthcode = "";
		pol_certificate_number = "";
		pol_ncb_percentage = BigDecimal.ZERO;
		pol_type_of_usage = "";
		pol_user_group = "";
		pol_breakin_id = "";
		pol_mot_registration_date = "";
		pol_plan_name = "";
		pol_registration_zone = "";
		pol_sub_class_desc = "";
		pol_carrying_type = "";
		pol_no_of_wheels = BigDecimal.ZERO;
		pol_prev_end_date = "";
		pol_mot_manufacturer_year = "";
		pol_prev_insurer_name = "";
		pol_docket_desc = "";
		pol_effective_date = "";
		pol_transaction_date = "";
		pol_endorse_request_type = "";
		pol_mot_seating_capacity = "";
		cust_full_name = "";
		pol_passenger_carry_cap = "";
		agent_full_name_x = "";
		zd_offered_amt = BigDecimal.ZERO;
		zd_actual_amt = BigDecimal.ZERO;
		coc_offered_amt = BigDecimal.ZERO;
		ncb_pro_offered_amt = BigDecimal.ZERO;
		ncb_pro_actual_amt = BigDecimal.ZERO;
		eng_offered_amt = BigDecimal.ZERO;
		eng_actual_amt = BigDecimal.ZERO;
		rti_offered_amt = BigDecimal.ZERO;
		lossofuse_offered_amt = BigDecimal.ZERO;
		lossofuse_actual_amt = BigDecimal.ZERO;
		ea_offered_amt = BigDecimal.ZERO;
		ea_actual_amt = BigDecimal.ZERO;
		ea_wider_offered_amt = BigDecimal.ZERO;
		ea_wider_actual_amt = BigDecimal.ZERO;
		emi_offered_amt = BigDecimal.ZERO;
		emi_actual_amt = BigDecimal.ZERO;
		high_prot_offered_amt = BigDecimal.ZERO;
		high_prot_actual_amt = BigDecimal.ZERO;
		basic_tp = BigDecimal.ZERO;
		pa_cover = BigDecimal.ZERO;
		pa_owner = BigDecimal.ZERO;
		paid_driver = BigDecimal.ZERO;
		ll_to_paid_driver_clr_condt = BigDecimal.ZERO;
		trailers_tp = BigDecimal.ZERO;
		employeesofinsured_tp = BigDecimal.ZERO;
		coverage_si = BigDecimal.ZERO;
		break_in_loadng_amt = BigDecimal.ZERO;
		over_turning_amt = BigDecimal.ZERO;
		geo_ext_amt = BigDecimal.ZERO;
		high_tonnage_amt = BigDecimal.ZERO;
		tppd_disc_amt = BigDecimal.ZERO;
		theft_conversion_imt_43 = BigDecimal.ZERO;
		private_use_total = BigDecimal.ZERO;
		private_use_tp = BigDecimal.ZERO;
		ncb_amt = BigDecimal.ZERO;
		pol_loading_imt23_amt = BigDecimal.ZERO;
		pol_loading_imt47_amt = BigDecimal.ZERO;
		trailers_od = BigDecimal.ZERO;
		non_electrical_od_si = BigDecimal.ZERO;
		nop = BigDecimal.ZERO;
		total_collected_gwp = BigDecimal.ZERO;
		pol_od_start_date = "";
		pol_od_end_date = "";
		pol_mot_multiyear_tag = "";
		oem_online_renewal_flag = "";
		agent_full_name_y = "";
		pol_portal_cscid = "";
		v12 = "";
		sp_credit = "";
		pol_vendor_pie_flag = "";
		pol_super_parent_code = "";
		pol_mot_model_name = "";
		pol_mot_manufacturer_code = "";
		coc_actual_amt = BigDecimal.ZERO;
		gc_code = "";
		ncb_flag = "";
		pol_business_type = "";
		rti_actual_amt = BigDecimal.ZERO;
		state_name = "";
		state_rank = "";
		total_od = BigDecimal.ZERO;
		total_gwp = BigDecimal.ZERO;
		total_tp = BigDecimal.ZERO;
		tp_payout_percentage = BigDecimal.ZERO;
		tp_payout_amount = BigDecimal.ZERO;
		remarks = "";
		rto_code = "";
		location_name = "";
		segment_type_model = "";
		total_gwp_payout_amount = BigDecimal.ZERO;
		gwp_payout_percentage = BigDecimal.ZERO;
		final_discount_per = BigDecimal.ZERO;
		state_type = "";
		total_od_amount = BigDecimal.ZERO;
		od_payout_percentage = BigDecimal.ZERO;
		od_payout_amount = BigDecimal.ZERO;
		years_diff = BigDecimal.ZERO;
		od_comm_perc = BigDecimal.ZERO;
		tp_comm_perc = BigDecimal.ZERO;
		od_prov_perc = BigDecimal.ZERO;
		tp_prov_perc = BigDecimal.ZERO;
		campaign_perc = BigDecimal.ZERO;
		total_campaign = BigDecimal.ZERO;
		corp_other_payout_perc = BigDecimal.ZERO;
		corp_other_payout_amount = BigDecimal.ZERO;
		od_rew_percentage = BigDecimal.ZERO;
		tp_rew_percentage = BigDecimal.ZERO;
		od_rew_payout_amount = BigDecimal.ZERO;
		tp_rew_payout_amount = BigDecimal.ZERO;
		commission = BigDecimal.ZERO;
		total_payout_amount = BigDecimal.ZERO;
		additional_commission = BigDecimal.ZERO;
		service_fees = BigDecimal.ZERO;
		ia_code = "";
		factor = BigDecimal.ZERO;
		net_discount = BigDecimal.ZERO;
		net_od = BigDecimal.ZERO;
		net_rate = BigDecimal.ZERO;
		rank_ll = "";
		computation_type = "";
		spec_val_perc = BigDecimal.ZERO;
		pol_agent_code = "";
		final_segment_type = "";
		cubic_capacity = BigDecimal.ZERO;
		grid = "";
		veh_age = BigDecimal.ZERO;
		tariff_rate = BigDecimal.ZERO;
		final_tarrif_rate = BigDecimal.ZERO;
		dev_amount = BigDecimal.ZERO;
		output_basic_od = BigDecimal.ZERO;
		sum_ins = BigDecimal.ZERO;
		t_rate = BigDecimal.ZERO;
		basic_od1 = BigDecimal.ZERO;
		si = BigDecimal.ZERO;
		gcv_tariff = BigDecimal.ZERO;
		elec_nonelec = BigDecimal.ZERO;
		prod_od = BigDecimal.ZERO;
		elec_ratio = BigDecimal.ZERO;
		ota = BigDecimal.ZERO;
		tci_43 = BigDecimal.ZERO;
		put = BigDecimal.ZERO;
		pli_23 = BigDecimal.ZERO;
		total_covers = BigDecimal.ZERO;
		net_od_si = BigDecimal.ZERO;
		t_disc = BigDecimal.ZERO;
		calc_basic_od = BigDecimal.ZERO;
		total_comm_prov = BigDecimal.ZERO;
		final_multiyear_status = BigDecimal.ZERO;
		ncb_flag1 = "";
		final_comm_payout_amount = BigDecimal.ZERO;
		misp_flag = "";
		sf_comm_perc = BigDecimal.ZERO;
		sf_prov_perc = BigDecimal.ZERO;
		sf_payout_amount = BigDecimal.ZERO;
		computation_type_manager = "";
		t_irda = BigDecimal.ZERO;
		sf_perc = BigDecimal.ZERO;
		sf_prov_amount = BigDecimal.ZERO;
		grid_manager = "";
		misp_flag_manager = "";
		ncb_segment = "";
		hierarchy_remark = "";
		bde_perc = "";
		bde_amount = BigDecimal.ZERO;
		dealer = "";
		tp_prov_amount = BigDecimal.ZERO;
		od_prov_amount = BigDecimal.ZERO;
		dc_commission = BigDecimal.ZERO;
		final_sf_oe = BigDecimal.ZERO;
		web_cases_flag = "";
		total_prov_amount = BigDecimal.ZERO;
		tp_irda_percentage = BigDecimal.ZERO;
		od_irda_percentage = BigDecimal.ZERO;
		od_irda = BigDecimal.ZERO;
		tp_irda = BigDecimal.ZERO;
		total_sa_tp = BigDecimal.ZERO;
		total_pvt_car = BigDecimal.ZERO;
		total_tw = BigDecimal.ZERO;
		total_misc = BigDecimal.ZERO;
		total_gcv = BigDecimal.ZERO;
		total_pcv = BigDecimal.ZERO;
		rsa_hero_amount = BigDecimal.ZERO;
		reserve_od_final = BigDecimal.ZERO;
		payment_logic = "";
		wp_percent = BigDecimal.ZERO;
		wp_sf = BigDecimal.ZERO;
		wp_tp = BigDecimal.ZERO;
		wp_od = BigDecimal.ZERO;
		direct_wp_percent = BigDecimal.ZERO;
		direct_wp_sf = BigDecimal.ZERO;
		direct_wp_tp = BigDecimal.ZERO;
		direct_wp_od = BigDecimal.ZERO;
		direct_rnr_percent = BigDecimal.ZERO;
		direct_rnr = BigDecimal.ZERO;
		hmsi_campaign_amt = BigDecimal.ZERO;
		pol_agent_code_flag = "";
		auto_escort_perc = BigDecimal.ZERO;
		auto_escort_amt = BigDecimal.ZERO;
		annual_campaign_perc = BigDecimal.ZERO;
		annual_campaign_amt = BigDecimal.ZERO;
		tvs_campaign_perc = BigDecimal.ZERO;
		tvs_campaign_amt = BigDecimal.ZERO;
		computation_type_campaign = "";
		misp_flag_campaign = "";
		payoutComponentId = 0L;
		id = 0L;
		slab = BigDecimal.ZERO;
		payout_id = 0L;
		pol_super_parent_name = "";
		cbp_percent = BigDecimal.ZERO;
		cbp_sf = BigDecimal.ZERO;
		cbp_tp = BigDecimal.ZERO;
		cbp_od = BigDecimal.ZERO;
		wp_rnr_percent = BigDecimal.ZERO;
		wp_rnr = BigDecimal.ZERO;
		wp_tp_rnr = BigDecimal.ZERO;
		wp_od_rnr = BigDecimal.ZERO;
		computation_type_banca = "";
		direct_od_payout_percentage = BigDecimal.ZERO;
		direct_tp_payout_percentage = BigDecimal.ZERO;
		direct_od_prov_perc = BigDecimal.ZERO;
		direct_tp_prov_perc = BigDecimal.ZERO;
		direct_od_payout_amount = BigDecimal.ZERO;
		direct_tp_payout_amount = BigDecimal.ZERO;
		direct_od_prov_amount = BigDecimal.ZERO;
		direct_tp_prov_amount = BigDecimal.ZERO;
		direct_total_payout_amount = BigDecimal.ZERO;
		direct_total_prov_amount = BigDecimal.ZERO;
		discount_slab = "";
		veh_slab = "";
		business_type = "";
		sa_od_renewal_flag = "";
		disc_slab = "";
		payeeName = "";
		name = "";
		type = "";
		discount_slab_flag = "";
		final_prov_amount = BigDecimal.ZERO;
		tvs_gwp_sum = BigDecimal.ZERO;
		hmsi_gwp_sum = BigDecimal.ZERO;
		prev_ia_code_provision_amount = BigDecimal.ZERO;
		p_tax_flag = "";
		date_of_birth = "";
		dat_intermediary_start_date = "";
		p_tax_amt = BigDecimal.ZERO;
		limit_amount = BigDecimal.ZERO;
		anx_state = "";
		reserver_od_renewal_lt_flag = "";
		final_vertical_desc = "";
		final_commission = BigDecimal.ZERO;
		manual_updation_flag = "";
		final_commission_manual_updation = BigDecimal.ZERO;
		final_commission_updated = BigDecimal.ZERO;
		final_commission_perc_manual_updation = BigDecimal.ZERO;
		cgstPercentage = BigDecimal.ZERO;
		sgstPercentage = BigDecimal.ZERO;
		igstPercentage = BigDecimal.ZERO;
		cgstAmount = BigDecimal.ZERO;
		sgstAmount = BigDecimal.ZERO;
		igstAmount = BigDecimal.ZERO;
		workflow_status = "";
		released_amount = BigDecimal.ZERO;
		ready_for_release = "";
		release_group = "";
		program_id = BigDecimal.ZERO;
		processBusinessKey = "";
		bankname = "";
		bankaccno = "";
		bank_ifsc_code = "";
		ia_code_state = "";
		ia_code_gstno = "";
		agency_name = "";
		gstin = "";
		license_expiry_date = "";
		provisionAmount = BigDecimal.ZERO;
		gst_applicable = "";
		commAmt = BigDecimal.ZERO;
		totalGstAmount = BigDecimal.ZERO;
		oem_vertical = "";
		business_group = "";
		final_commission_perc = BigDecimal.ZERO;
		final_provision_perc = BigDecimal.ZERO;
		manufacturer_prov_amt = BigDecimal.ZERO;
		csc_prov_amt = BigDecimal.ZERO;
		manufacturer_prov_sum = BigDecimal.ZERO;
		csc_prov_sum = BigDecimal.ZERO;
		igstApplicable = "";
		sgstApplicable = "";
		cgstApplicable = "";
		hdfc_state = "";
		broker = "";
		excess_of_annx_perc = BigDecimal.ZERO;
		proRateAmt = BigDecimal.ZERO;
		toyota_campaign_gwp_sum = BigDecimal.ZERO;
		honda_4w_campaigngwp_sum = BigDecimal.ZERO;
		final_commission_od = BigDecimal.ZERO;
		final_commission_tp = BigDecimal.ZERO;
		final_prov_od = BigDecimal.ZERO;
		final_prov_tp = BigDecimal.ZERO;
		cbp_od_perc = BigDecimal.ZERO;
		cbp_tp_perc = BigDecimal.ZERO;
		vertical_name = "";
		cbp_amount = BigDecimal.ZERO;
		cbp_tp_amount = BigDecimal.ZERO;
		cbp_od_amount = BigDecimal.ZERO;
		cpa_flag = BigDecimal.ZERO;
		annx6_effective_date = "";
		anx1_segment = "";
		txt_sate_sub_name = "";
		state_num = "";
		num_sate_sub_code = "";
		txt_display_caption = "";
		cg1_segment = "";
		cg1_slab = "";
		a2_zone = "";
		cg2_fuel_type = "";
		cg3_segment = "";
		cg3_cpa_flag = "";
		derr_txt_segment_type = "";
		cg4_discount = "";
		cg4_slab = "";
		a3_zone = "";
		cg5_ncb_flag = "";
		cg5_fuel_type = "";
		cg5_slab = "";
		a4_segment = "";
		a4_discount = "";
		cg6_segment = "";
		cg6_slab = "";
		cg6_discount = "";
		cg7_discount = "";
		cg7_segment = "";
		a5_segment = "";
		a5_policy_type = "";
		a5_business_type = "";
		WP_No = "";
		effective = "";
		ending_on = "";
		status = "";
		agency_Grid_No = "";
		agency_Name = "";
		comm_od = BigDecimal.ZERO;
		comm_tp = BigDecimal.ZERO;
		prov_od = BigDecimal.ZERO;
		prov_tp = BigDecimal.ZERO;
		flag = "";
		bancaM_policy_type = "";
		bancaM_business_type = "";
		bancaM_cpa = BigDecimal.ZERO;
		bancaM_discount = "";
		a9_product = "";
		a9_constitution = "";
		a9_percentage = BigDecimal.ZERO;
		a12_product = "";
		a12_veh_age = "";
		a12_policy_type = "";
		a6_discount_slab = "";
		a6_policy_type = "";
		a6_business_type = "";
		a6_segment = "";
		witheffectfrom = "";
		upto_Date = "";
		exp_GWP_lacs = "";
		exp_MCOR = "";
		a6_fuel_type = "";
		ver_Geo = "";
		location = "";
		dealer_Name = "";
		vehicle_Age = "";
		noofWheels = "";
		a14_product = "";
		policy_type_state_mst = "";
		txt_location_code = "";
		location_code = "";
		state_code = "";
		ncb_flag_anx6 = "";
		anx4_state = "";
		Commission_Campaign_Name = "";
		Commission_Campaign = "";
		Campaign_type = "";
		Excluding_Including_Annex_9 = "";
		With_Effect_Dt = "";
		With_End_Dt = "";
		Excluding_Business_Type_LT = "";
		Excluding_Vertical = "";
		Excluding_Model = "";
		Excluding_Segment = "";
		Excluding_Fuel_Type = "";
		Release_Provision = "";
		Attachement_Ref = "";
		annual_campaign_broker = "";
		afterAnnx_6_effective_flag = "";
		a5_business_type_list = new ArrayList<>();
		location_state_name = "";
		highest_sf_comm_perc = BigDecimal.ZERO;
		cbp_list = new ArrayList<>();
		computation_type_list = new ArrayList<>();
		cbg_slab = "";
		cbg_policy_type = "";
		a5_segment_list = new ArrayList<>();
		hdfc_address = "";
		hdfc_pan = "";
		hdfc_state_code = "";
		sf_od = BigDecimal.ZERO;
		sf_tp = BigDecimal.ZERO;
		payee_login = "";
		mdm_product_name = "";
		pol_endorsement_num = "";
		pol_deal_num = "";
		pol_src_state = "";
		pol_destn_state = "";
		pol_insurance_type = "";
		pol_tag = "";
		terrorism_premium = "";
		cbp_total_amount = BigDecimal.ZERO;
		pcv_rto_code_flag = "";
		renewal_flag = "";
		final_bde = BigDecimal.ZERO;
		policy_no_with_backslash = "";
		pol_agent_code_with_backslash = "";
		pol_certificate_number_with_backslah = "";
		pol_super_parent_code_with_backslah = "";
		pid_status = "";
		payableAmount = BigDecimal.ZERO;
		holdAmount = BigDecimal.ZERO;
		policy_hold_flag = "";
		policy_hold_remark = "";
		license_flag = "";
		agent_inactive_flag = "";
		invoiceFlag = "";
		pid_hold_status = "";
		holdStatus = "";
		hold_reason = "";
		payout_comp_id = 0L;
		readyForRelease = "";
		releasedAmount = BigDecimal.ZERO;
		outputData = new Object();
		modifiedOn = new Date();
		inputData = new Object();
		version = 0L;
		payout_processing_request_id = 0L;
		workflow_details = "";
		component_source_id = 0L;
		releaseGroup = "";
		prev_final_percentage = BigDecimal.ZERO;
		prev_final_commision = BigDecimal.ZERO;
		agency_constitution = "";
		lic_exp_hold_status = "";
		input1 = "";
		output1 = new ArrayList<>();
		output2 = "";
		input2 = "";
		input3 = "";
		input4 = "";
		input5 = "";
		product = "";
		loan_points_per_1k = "";
		loan_class = "";
	}

	public String getPol_rk() {
		return pol_rk;
	}

	public void setPol_rk(String pol_rk) {
		this.pol_rk = pol_rk;
	}

	public String getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(String policy_no) {
		this.policy_no = policy_no;
	}

	public String getPol_endorsement_type() {
		return pol_endorsement_type;
	}

	public void setPol_endorsement_type(String pol_endorsement_type) {
		this.pol_endorsement_type = pol_endorsement_type;
	}

	public String getPolicy_type_new() {
		return policy_type_new;
	}

	public void setPolicy_type_new(String policy_type_new) {
		this.policy_type_new = policy_type_new;
	}

	public String getPol_business_type_lt() {
		return pol_business_type_lt;
	}

	public void setPol_business_type_lt(String pol_business_type_lt) {
		this.pol_business_type_lt = pol_business_type_lt;
	}

	public String getVertical_desc() {
		return vertical_desc;
	}

	public void setVertical_desc(String vertical_desc) {
		this.vertical_desc = vertical_desc;
	}

	public BigDecimal getPol_mot_engine_cc() {
		return pol_mot_engine_cc;
	}

	public void setPol_mot_engine_cc(BigDecimal pol_mot_engine_cc) {
		this.pol_mot_engine_cc = pol_mot_engine_cc;
	}

	public String getSegment_type() {
		return segment_type;
	}

	public void setSegment_type(String segment_type) {
		this.segment_type = segment_type;
	}

	public BigDecimal getPol_gross_veh_wt() {
		return pol_gross_veh_wt;
	}

	public void setPol_gross_veh_wt(BigDecimal pol_gross_veh_wt) {
		this.pol_gross_veh_wt = pol_gross_veh_wt;
	}

	public String getPol_fuel_type() {
		return pol_fuel_type;
	}

	public void setPol_fuel_type(String pol_fuel_type) {
		this.pol_fuel_type = pol_fuel_type;
	}

	public String getIrda_product_name() {
		return irda_product_name;
	}

	public void setIrda_product_name(String irda_product_name) {
		this.irda_product_name = irda_product_name;
	}

	public String getPol_calculated_constitution() {
		return pol_calculated_constitution;
	}

	public void setPol_calculated_constitution(String pol_calculated_constitution) {
		this.pol_calculated_constitution = pol_calculated_constitution;
	}

	public BigDecimal getGwp() {
		return gwp;
	}

	public void setGwp(BigDecimal gwp) {
		this.gwp = gwp;
	}

	public String getPol_mot_veh_registration_num() {
		return pol_mot_veh_registration_num;
	}

	public void setPol_mot_veh_registration_num(String pol_mot_veh_registration_num) {
		this.pol_mot_veh_registration_num = pol_mot_veh_registration_num;
	}

	public BigDecimal getTp() {
		return tp;
	}

	public void setTp(BigDecimal tp) {
		this.tp = tp;
	}

	public String getPol_mot_rto_code() {
		return pol_mot_rto_code;
	}

	public void setPol_mot_rto_code(String pol_mot_rto_code) {
		this.pol_mot_rto_code = pol_mot_rto_code;
	}

	public String getPol_mot_rto_location() {
		return pol_mot_rto_location;
	}

	public void setPol_mot_rto_location(String pol_mot_rto_location) {
		this.pol_mot_rto_location = pol_mot_rto_location;
	}

	public BigDecimal getBasic_od() {
		return basic_od;
	}

	public void setBasic_od(BigDecimal basic_od) {
		this.basic_od = basic_od;
	}

	public BigDecimal getElectrical_od() {
		return electrical_od;
	}

	public void setElectrical_od(BigDecimal electrical_od) {
		this.electrical_od = electrical_od;
	}

	public BigDecimal getNon_electrical_od() {
		return non_electrical_od;
	}

	public void setNon_electrical_od(BigDecimal non_electrical_od) {
		this.non_electrical_od = non_electrical_od;
	}

	public BigDecimal getBi_fuel_od() {
		return bi_fuel_od;
	}

	public void setBi_fuel_od(BigDecimal bi_fuel_od) {
		this.bi_fuel_od = bi_fuel_od;
	}

	public BigDecimal getAge_discount() {
		return age_discount;
	}

	public void setAge_discount(BigDecimal age_discount) {
		this.age_discount = age_discount;
	}

	public BigDecimal getOccupation_discount() {
		return occupation_discount;
	}

	public void setOccupation_discount(BigDecimal occupation_discount) {
		this.occupation_discount = occupation_discount;
	}

	public BigDecimal getOther_loadings() {
		return other_loadings;
	}

	public void setOther_loadings(BigDecimal other_loadings) {
		this.other_loadings = other_loadings;
	}

	public BigDecimal getOther_discounts() {
		return other_discounts;
	}

	public void setOther_discounts(BigDecimal other_discounts) {
		this.other_discounts = other_discounts;
	}

	public BigDecimal getPol_tot_sum_insured_amt() {
		return pol_tot_sum_insured_amt;
	}

	public void setPol_tot_sum_insured_amt(BigDecimal pol_tot_sum_insured_amt) {
		this.pol_tot_sum_insured_amt = pol_tot_sum_insured_amt;
	}

	public BigDecimal getPol_tariff_rate() {
		return pol_tariff_rate;
	}

	public void setPol_tariff_rate(BigDecimal pol_tariff_rate) {
		this.pol_tariff_rate = pol_tariff_rate;
	}

	public BigDecimal getCpa() {
		return cpa;
	}

	public void setCpa(BigDecimal cpa) {
		this.cpa = cpa;
	}

	public String getPol_mot_model_code() {
		return pol_mot_model_code;
	}

	public void setPol_mot_model_code(String pol_mot_model_code) {
		this.pol_mot_model_code = pol_mot_model_code;
	}

	public BigDecimal getOd() {
		return od;
	}

	public void setOd(BigDecimal od) {
		this.od = od;
	}

	public String getPol_mot_manufacturer_name() {
		return pol_mot_manufacturer_name;
	}

	public void setPol_mot_manufacturer_name(String pol_mot_manufacturer_name) {
		this.pol_mot_manufacturer_name = pol_mot_manufacturer_name;
	}

	public String getPol_system_product_code() {
		return pol_system_product_code;
	}

	public void setPol_system_product_code(String pol_system_product_code) {
		this.pol_system_product_code = pol_system_product_code;
	}

	public String getLong_term_pol_tag() {
		return long_term_pol_tag;
	}

	public void setLong_term_pol_tag(String long_term_pol_tag) {
		this.long_term_pol_tag = long_term_pol_tag;
	}

	public String getPol_multiyear_status() {
		return pol_multiyear_status;
	}

	public void setPol_multiyear_status(String pol_multiyear_status) {
		this.pol_multiyear_status = pol_multiyear_status;
	}

	public String getPol_start_date() {
		return pol_start_date;
	}

	public void setPol_start_date(String pol_start_date) {
		this.pol_start_date = pol_start_date;
	}

	public String getPol_end_date() {
		return pol_end_date;
	}

	public void setPol_end_date(String pol_end_date) {
		this.pol_end_date = pol_end_date;
	}

	public String getPol_reporting_date() {
		return pol_reporting_date;
	}

	public void setPol_reporting_date(String pol_reporting_date) {
		this.pol_reporting_date = pol_reporting_date;
	}

	public String getMdm_branch_name() {
		return mdm_branch_name;
	}

	public void setMdm_branch_name(String mdm_branch_name) {
		this.mdm_branch_name = mdm_branch_name;
	}

	public String getPol_financier_name() {
		return pol_financier_name;
	}

	public void setPol_financier_name(String pol_financier_name) {
		this.pol_financier_name = pol_financier_name;
	}

	public String getDeal_rcm_branch_earthcode() {
		return deal_rcm_branch_earthcode;
	}

	public void setDeal_rcm_branch_earthcode(String deal_rcm_branch_earthcode) {
		this.deal_rcm_branch_earthcode = deal_rcm_branch_earthcode;
	}

	public String getPol_certificate_number() {
		return pol_certificate_number;
	}

	public void setPol_certificate_number(String pol_certificate_number) {
		this.pol_certificate_number = pol_certificate_number;
	}

	public BigDecimal getPol_ncb_percentage() {
		return pol_ncb_percentage;
	}

	public void setPol_ncb_percentage(BigDecimal pol_ncb_percentage) {
		this.pol_ncb_percentage = pol_ncb_percentage;
	}

	public String getPol_type_of_usage() {
		return pol_type_of_usage;
	}

	public void setPol_type_of_usage(String pol_type_of_usage) {
		this.pol_type_of_usage = pol_type_of_usage;
	}

	public String getPol_user_group() {
		return pol_user_group;
	}

	public void setPol_user_group(String pol_user_group) {
		this.pol_user_group = pol_user_group;
	}

	public String getPol_breakin_id() {
		return pol_breakin_id;
	}

	public void setPol_breakin_id(String pol_breakin_id) {
		this.pol_breakin_id = pol_breakin_id;
	}

	public String getPol_mot_registration_date() {
		return pol_mot_registration_date;
	}

	public void setPol_mot_registration_date(String pol_mot_registration_date) {
		this.pol_mot_registration_date = pol_mot_registration_date;
	}

	public String getPol_plan_name() {
		return pol_plan_name;
	}

	public void setPol_plan_name(String pol_plan_name) {
		this.pol_plan_name = pol_plan_name;
	}

	public String getPol_registration_zone() {
		return pol_registration_zone;
	}

	public void setPol_registration_zone(String pol_registration_zone) {
		this.pol_registration_zone = pol_registration_zone;
	}

	public String getPol_sub_class_desc() {
		return pol_sub_class_desc;
	}

	public void setPol_sub_class_desc(String pol_sub_class_desc) {
		this.pol_sub_class_desc = pol_sub_class_desc;
	}

	public String getPol_carrying_type() {
		return pol_carrying_type;
	}

	public void setPol_carrying_type(String pol_carrying_type) {
		this.pol_carrying_type = pol_carrying_type;
	}

	public BigDecimal getPol_no_of_wheels() {
		return pol_no_of_wheels;
	}

	public void setPol_no_of_wheels(BigDecimal pol_no_of_wheels) {
		this.pol_no_of_wheels = pol_no_of_wheels;
	}

	public String getPol_prev_end_date() {
		return pol_prev_end_date;
	}

	public void setPol_prev_end_date(String pol_prev_end_date) {
		this.pol_prev_end_date = pol_prev_end_date;
	}

	public String getPol_mot_manufacturer_year() {
		return pol_mot_manufacturer_year;
	}

	public void setPol_mot_manufacturer_year(String pol_mot_manufacturer_year) {
		this.pol_mot_manufacturer_year = pol_mot_manufacturer_year;
	}

	public String getPol_prev_insurer_name() {
		return pol_prev_insurer_name;
	}

	public void setPol_prev_insurer_name(String pol_prev_insurer_name) {
		this.pol_prev_insurer_name = pol_prev_insurer_name;
	}

	public String getPol_docket_desc() {
		return pol_docket_desc;
	}

	public void setPol_docket_desc(String pol_docket_desc) {
		this.pol_docket_desc = pol_docket_desc;
	}

	public String getPol_effective_date() {
		return pol_effective_date;
	}

	public void setPol_effective_date(String pol_effective_date) {
		this.pol_effective_date = pol_effective_date;
	}

	public String getPol_transaction_date() {
		return pol_transaction_date;
	}

	public void setPol_transaction_date(String pol_transaction_date) {
		this.pol_transaction_date = pol_transaction_date;
	}

	public String getPol_endorse_request_type() {
		return pol_endorse_request_type;
	}

	public void setPol_endorse_request_type(String pol_endorse_request_type) {
		this.pol_endorse_request_type = pol_endorse_request_type;
	}

	public String getPol_mot_seating_capacity() {
		return pol_mot_seating_capacity;
	}

	public void setPol_mot_seating_capacity(String pol_mot_seating_capacity) {
		this.pol_mot_seating_capacity = pol_mot_seating_capacity;
	}

	public String getCust_full_name() {
		return cust_full_name;
	}

	public void setCust_full_name(String cust_full_name) {
		this.cust_full_name = cust_full_name;
	}

	public String getPol_passenger_carry_cap() {
		return pol_passenger_carry_cap;
	}

	public void setPol_passenger_carry_cap(String pol_passenger_carry_cap) {
		this.pol_passenger_carry_cap = pol_passenger_carry_cap;
	}

	public String getAgent_full_name_x() {
		return agent_full_name_x;
	}

	public void setAgent_full_name_x(String agent_full_name_x) {
		this.agent_full_name_x = agent_full_name_x;
	}

	public BigDecimal getZd_offered_amt() {
		return zd_offered_amt;
	}

	public void setZd_offered_amt(BigDecimal zd_offered_amt) {
		this.zd_offered_amt = zd_offered_amt;
	}

	public BigDecimal getZd_actual_amt() {
		return zd_actual_amt;
	}

	public void setZd_actual_amt(BigDecimal zd_actual_amt) {
		this.zd_actual_amt = zd_actual_amt;
	}

	public BigDecimal getCoc_offered_amt() {
		return coc_offered_amt;
	}

	public void setCoc_offered_amt(BigDecimal coc_offered_amt) {
		this.coc_offered_amt = coc_offered_amt;
	}

	public BigDecimal getNcb_pro_offered_amt() {
		return ncb_pro_offered_amt;
	}

	public void setNcb_pro_offered_amt(BigDecimal ncb_pro_offered_amt) {
		this.ncb_pro_offered_amt = ncb_pro_offered_amt;
	}

	public BigDecimal getNcb_pro_actual_amt() {
		return ncb_pro_actual_amt;
	}

	public void setNcb_pro_actual_amt(BigDecimal ncb_pro_actual_amt) {
		this.ncb_pro_actual_amt = ncb_pro_actual_amt;
	}

	public BigDecimal getEng_offered_amt() {
		return eng_offered_amt;
	}

	public void setEng_offered_amt(BigDecimal eng_offered_amt) {
		this.eng_offered_amt = eng_offered_amt;
	}

	public BigDecimal getEng_actual_amt() {
		return eng_actual_amt;
	}

	public void setEng_actual_amt(BigDecimal eng_actual_amt) {
		this.eng_actual_amt = eng_actual_amt;
	}

	public BigDecimal getRti_offered_amt() {
		return rti_offered_amt;
	}

	public void setRti_offered_amt(BigDecimal rti_offered_amt) {
		this.rti_offered_amt = rti_offered_amt;
	}

	public BigDecimal getLossofuse_offered_amt() {
		return lossofuse_offered_amt;
	}

	public void setLossofuse_offered_amt(BigDecimal lossofuse_offered_amt) {
		this.lossofuse_offered_amt = lossofuse_offered_amt;
	}

	public BigDecimal getLossofuse_actual_amt() {
		return lossofuse_actual_amt;
	}

	public void setLossofuse_actual_amt(BigDecimal lossofuse_actual_amt) {
		this.lossofuse_actual_amt = lossofuse_actual_amt;
	}

	public BigDecimal getEa_offered_amt() {
		return ea_offered_amt;
	}

	public void setEa_offered_amt(BigDecimal ea_offered_amt) {
		this.ea_offered_amt = ea_offered_amt;
	}

	public BigDecimal getEa_actual_amt() {
		return ea_actual_amt;
	}

	public void setEa_actual_amt(BigDecimal ea_actual_amt) {
		this.ea_actual_amt = ea_actual_amt;
	}

	public BigDecimal getEa_wider_offered_amt() {
		return ea_wider_offered_amt;
	}

	public void setEa_wider_offered_amt(BigDecimal ea_wider_offered_amt) {
		this.ea_wider_offered_amt = ea_wider_offered_amt;
	}

	public BigDecimal getEa_wider_actual_amt() {
		return ea_wider_actual_amt;
	}

	public void setEa_wider_actual_amt(BigDecimal ea_wider_actual_amt) {
		this.ea_wider_actual_amt = ea_wider_actual_amt;
	}

	public BigDecimal getEmi_offered_amt() {
		return emi_offered_amt;
	}

	public void setEmi_offered_amt(BigDecimal emi_offered_amt) {
		this.emi_offered_amt = emi_offered_amt;
	}

	public BigDecimal getEmi_actual_amt() {
		return emi_actual_amt;
	}

	public void setEmi_actual_amt(BigDecimal emi_actual_amt) {
		this.emi_actual_amt = emi_actual_amt;
	}

	public BigDecimal getHigh_prot_offered_amt() {
		return high_prot_offered_amt;
	}

	public void setHigh_prot_offered_amt(BigDecimal high_prot_offered_amt) {
		this.high_prot_offered_amt = high_prot_offered_amt;
	}

	public BigDecimal getHigh_prot_actual_amt() {
		return high_prot_actual_amt;
	}

	public void setHigh_prot_actual_amt(BigDecimal high_prot_actual_amt) {
		this.high_prot_actual_amt = high_prot_actual_amt;
	}

	public BigDecimal getBasic_tp() {
		return basic_tp;
	}

	public void setBasic_tp(BigDecimal basic_tp) {
		this.basic_tp = basic_tp;
	}

	public BigDecimal getPa_cover() {
		return pa_cover;
	}

	public void setPa_cover(BigDecimal pa_cover) {
		this.pa_cover = pa_cover;
	}

	public BigDecimal getPa_owner() {
		return pa_owner;
	}

	public void setPa_owner(BigDecimal pa_owner) {
		this.pa_owner = pa_owner;
	}

	public BigDecimal getPaid_driver() {
		return paid_driver;
	}

	public void setPaid_driver(BigDecimal paid_driver) {
		this.paid_driver = paid_driver;
	}

	public BigDecimal getLl_to_paid_driver_clr_condt() {
		return ll_to_paid_driver_clr_condt;
	}

	public void setLl_to_paid_driver_clr_condt(BigDecimal ll_to_paid_driver_clr_condt) {
		this.ll_to_paid_driver_clr_condt = ll_to_paid_driver_clr_condt;
	}

	public BigDecimal getTrailers_tp() {
		return trailers_tp;
	}

	public void setTrailers_tp(BigDecimal trailers_tp) {
		this.trailers_tp = trailers_tp;
	}

	public BigDecimal getEmployeesofinsured_tp() {
		return employeesofinsured_tp;
	}

	public void setEmployeesofinsured_tp(BigDecimal employeesofinsured_tp) {
		this.employeesofinsured_tp = employeesofinsured_tp;
	}

	public BigDecimal getCoverage_si() {
		return coverage_si;
	}

	public void setCoverage_si(BigDecimal coverage_si) {
		this.coverage_si = coverage_si;
	}

	public BigDecimal getBreak_in_loadng_amt() {
		return break_in_loadng_amt;
	}

	public void setBreak_in_loadng_amt(BigDecimal break_in_loadng_amt) {
		this.break_in_loadng_amt = break_in_loadng_amt;
	}

	public BigDecimal getOver_turning_amt() {
		return over_turning_amt;
	}

	public void setOver_turning_amt(BigDecimal over_turning_amt) {
		this.over_turning_amt = over_turning_amt;
	}

	public BigDecimal getGeo_ext_amt() {
		return geo_ext_amt;
	}

	public void setGeo_ext_amt(BigDecimal geo_ext_amt) {
		this.geo_ext_amt = geo_ext_amt;
	}

	public BigDecimal getHigh_tonnage_amt() {
		return high_tonnage_amt;
	}

	public void setHigh_tonnage_amt(BigDecimal high_tonnage_amt) {
		this.high_tonnage_amt = high_tonnage_amt;
	}

	public BigDecimal getTppd_disc_amt() {
		return tppd_disc_amt;
	}

	public void setTppd_disc_amt(BigDecimal tppd_disc_amt) {
		this.tppd_disc_amt = tppd_disc_amt;
	}

	public BigDecimal getTheft_conversion_imt_43() {
		return theft_conversion_imt_43;
	}

	public void setTheft_conversion_imt_43(BigDecimal theft_conversion_imt_43) {
		this.theft_conversion_imt_43 = theft_conversion_imt_43;
	}

	public BigDecimal getPrivate_use_total() {
		return private_use_total;
	}

	public void setPrivate_use_total(BigDecimal private_use_total) {
		this.private_use_total = private_use_total;
	}

	public BigDecimal getPrivate_use_tp() {
		return private_use_tp;
	}

	public void setPrivate_use_tp(BigDecimal private_use_tp) {
		this.private_use_tp = private_use_tp;
	}

	public BigDecimal getNcb_amt() {
		return ncb_amt;
	}

	public void setNcb_amt(BigDecimal ncb_amt) {
		this.ncb_amt = ncb_amt;
	}

	public BigDecimal getPol_loading_imt23_amt() {
		return pol_loading_imt23_amt;
	}

	public void setPol_loading_imt23_amt(BigDecimal pol_loading_imt23_amt) {
		this.pol_loading_imt23_amt = pol_loading_imt23_amt;
	}

	public BigDecimal getPol_loading_imt47_amt() {
		return pol_loading_imt47_amt;
	}

	public void setPol_loading_imt47_amt(BigDecimal pol_loading_imt47_amt) {
		this.pol_loading_imt47_amt = pol_loading_imt47_amt;
	}

	public BigDecimal getTrailers_od() {
		return trailers_od;
	}

	public void setTrailers_od(BigDecimal trailers_od) {
		this.trailers_od = trailers_od;
	}

	public BigDecimal getNon_electrical_od_si() {
		return non_electrical_od_si;
	}

	public void setNon_electrical_od_si(BigDecimal non_electrical_od_si) {
		this.non_electrical_od_si = non_electrical_od_si;
	}

	public BigDecimal getNop() {
		return nop;
	}

	public void setNop(BigDecimal nop) {
		this.nop = nop;
	}

	public BigDecimal getTotal_collected_gwp() {
		return total_collected_gwp;
	}

	public void setTotal_collected_gwp(BigDecimal total_collected_gwp) {
		this.total_collected_gwp = total_collected_gwp;
	}

	public String getPol_od_start_date() {
		return pol_od_start_date;
	}

	public void setPol_od_start_date(String pol_od_start_date) {
		this.pol_od_start_date = pol_od_start_date;
	}

	public String getPol_od_end_date() {
		return pol_od_end_date;
	}

	public void setPol_od_end_date(String pol_od_end_date) {
		this.pol_od_end_date = pol_od_end_date;
	}

	public String getPol_mot_multiyear_tag() {
		return pol_mot_multiyear_tag;
	}

	public void setPol_mot_multiyear_tag(String pol_mot_multiyear_tag) {
		this.pol_mot_multiyear_tag = pol_mot_multiyear_tag;
	}

	public String getOem_online_renewal_flag() {
		return oem_online_renewal_flag;
	}

	public void setOem_online_renewal_flag(String oem_online_renewal_flag) {
		this.oem_online_renewal_flag = oem_online_renewal_flag;
	}

	public String getAgent_full_name_y() {
		return agent_full_name_y;
	}

	public void setAgent_full_name_y(String agent_full_name_y) {
		this.agent_full_name_y = agent_full_name_y;
	}

	public String getPol_portal_cscid() {
		return pol_portal_cscid;
	}

	public void setPol_portal_cscid(String pol_portal_cscid) {
		this.pol_portal_cscid = pol_portal_cscid;
	}

	public String getV12() {
		return v12;
	}

	public void setV12(String v12) {
		this.v12 = v12;
	}

	public String getSp_credit() {
		return sp_credit;
	}

	public void setSp_credit(String sp_credit) {
		this.sp_credit = sp_credit;
	}

	public String getPol_vendor_pie_flag() {
		return pol_vendor_pie_flag;
	}

	public void setPol_vendor_pie_flag(String pol_vendor_pie_flag) {
		this.pol_vendor_pie_flag = pol_vendor_pie_flag;
	}

	public String getPol_super_parent_code() {
		return pol_super_parent_code;
	}

	public void setPol_super_parent_code(String pol_super_parent_code) {
		this.pol_super_parent_code = pol_super_parent_code;
	}

	public String getPol_mot_model_name() {
		return pol_mot_model_name;
	}

	public void setPol_mot_model_name(String pol_mot_model_name) {
		this.pol_mot_model_name = pol_mot_model_name;
	}

	public String getPol_mot_manufacturer_code() {
		return pol_mot_manufacturer_code;
	}

	public void setPol_mot_manufacturer_code(String pol_mot_manufacturer_code) {
		this.pol_mot_manufacturer_code = pol_mot_manufacturer_code;
	}

	public BigDecimal getCoc_actual_amt() {
		return coc_actual_amt;
	}

	public void setCoc_actual_amt(BigDecimal coc_actual_amt) {
		this.coc_actual_amt = coc_actual_amt;
	}

	public String getGc_code() {
		return gc_code;
	}

	public void setGc_code(String gc_code) {
		this.gc_code = gc_code;
	}

	public String getNcb_flag() {
		return ncb_flag;
	}

	public void setNcb_flag(String ncb_flag) {
		this.ncb_flag = ncb_flag;
	}

	public String getPol_business_type() {
		return pol_business_type;
	}

	public void setPol_business_type(String pol_business_type) {
		this.pol_business_type = pol_business_type;
	}

	public BigDecimal getRti_actual_amt() {
		return rti_actual_amt;
	}

	public void setRti_actual_amt(BigDecimal rti_actual_amt) {
		this.rti_actual_amt = rti_actual_amt;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getState_rank() {
		return state_rank;
	}

	public void setState_rank(String state_rank) {
		this.state_rank = state_rank;
	}

	public BigDecimal getTotal_od() {
		return total_od;
	}

	public void setTotal_od(BigDecimal total_od) {
		this.total_od = total_od;
	}

	public BigDecimal getTotal_gwp() {
		return total_gwp;
	}

	public void setTotal_gwp(BigDecimal total_gwp) {
		this.total_gwp = total_gwp;
	}

	public BigDecimal getTotal_tp() {
		return total_tp;
	}

	public void setTotal_tp(BigDecimal total_tp) {
		this.total_tp = total_tp;
	}

	public BigDecimal getTp_payout_percentage() {
		return tp_payout_percentage;
	}

	public void setTp_payout_percentage(BigDecimal tp_payout_percentage) {
		this.tp_payout_percentage = tp_payout_percentage;
	}

	public BigDecimal getTp_payout_amount() {
		return tp_payout_amount;
	}

	public void setTp_payout_amount(BigDecimal tp_payout_amount) {
		this.tp_payout_amount = tp_payout_amount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRto_code() {
		return rto_code;
	}

	public void setRto_code(String rto_code) {
		this.rto_code = rto_code;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public String getSegment_type_model() {
		return segment_type_model;
	}

	public void setSegment_type_model(String segment_type_model) {
		this.segment_type_model = segment_type_model;
	}

	public BigDecimal getTotal_gwp_payout_amount() {
		return total_gwp_payout_amount;
	}

	public void setTotal_gwp_payout_amount(BigDecimal total_gwp_payout_amount) {
		this.total_gwp_payout_amount = total_gwp_payout_amount;
	}

	public BigDecimal getGwp_payout_percentage() {
		return gwp_payout_percentage;
	}

	public void setGwp_payout_percentage(BigDecimal gwp_payout_percentage) {
		this.gwp_payout_percentage = gwp_payout_percentage;
	}

	public BigDecimal getFinal_discount_per() {
		return final_discount_per;
	}

	public void setFinal_discount_per(BigDecimal final_discount_per) {
		this.final_discount_per = final_discount_per;
	}

	public String getState_type() {
		return state_type;
	}

	public void setState_type(String state_type) {
		this.state_type = state_type;
	}

	public BigDecimal getTotal_od_amount() {
		return total_od_amount;
	}

	public void setTotal_od_amount(BigDecimal total_od_amount) {
		this.total_od_amount = total_od_amount;
	}

	public BigDecimal getOd_payout_percentage() {
		return od_payout_percentage;
	}

	public void setOd_payout_percentage(BigDecimal od_payout_percentage) {
		this.od_payout_percentage = od_payout_percentage;
	}

	public BigDecimal getOd_payout_amount() {
		return od_payout_amount;
	}

	public void setOd_payout_amount(BigDecimal od_payout_amount) {
		this.od_payout_amount = od_payout_amount;
	}

	public BigDecimal getYears_diff() {
		return years_diff;
	}

	public void setYears_diff(BigDecimal years_diff) {
		this.years_diff = years_diff;
	}

	public BigDecimal getOd_comm_perc() {
		return od_comm_perc;
	}

	public void setOd_comm_perc(BigDecimal od_comm_perc) {
		this.od_comm_perc = od_comm_perc;
	}

	public BigDecimal getTp_comm_perc() {
		return tp_comm_perc;
	}

	public void setTp_comm_perc(BigDecimal tp_comm_perc) {
		this.tp_comm_perc = tp_comm_perc;
	}

	public BigDecimal getOd_prov_perc() {
		return od_prov_perc;
	}

	public void setOd_prov_perc(BigDecimal od_prov_perc) {
		this.od_prov_perc = od_prov_perc;
	}

	public BigDecimal getTp_prov_perc() {
		return tp_prov_perc;
	}

	public void setTp_prov_perc(BigDecimal tp_prov_perc) {
		this.tp_prov_perc = tp_prov_perc;
	}

	public BigDecimal getCampaign_perc() {
		return campaign_perc;
	}

	public void setCampaign_perc(BigDecimal campaign_perc) {
		this.campaign_perc = campaign_perc;
	}

	public BigDecimal getTotal_campaign() {
		return total_campaign;
	}

	public void setTotal_campaign(BigDecimal total_campaign) {
		this.total_campaign = total_campaign;
	}

	public BigDecimal getCorp_other_payout_perc() {
		return corp_other_payout_perc;
	}

	public void setCorp_other_payout_perc(BigDecimal corp_other_payout_perc) {
		this.corp_other_payout_perc = corp_other_payout_perc;
	}

	public BigDecimal getCorp_other_payout_amount() {
		return corp_other_payout_amount;
	}

	public void setCorp_other_payout_amount(BigDecimal corp_other_payout_amount) {
		this.corp_other_payout_amount = corp_other_payout_amount;
	}

	public BigDecimal getOd_rew_percentage() {
		return od_rew_percentage;
	}

	public void setOd_rew_percentage(BigDecimal od_rew_percentage) {
		this.od_rew_percentage = od_rew_percentage;
	}

	public BigDecimal getTp_rew_percentage() {
		return tp_rew_percentage;
	}

	public void setTp_rew_percentage(BigDecimal tp_rew_percentage) {
		this.tp_rew_percentage = tp_rew_percentage;
	}

	public BigDecimal getOd_rew_payout_amount() {
		return od_rew_payout_amount;
	}

	public void setOd_rew_payout_amount(BigDecimal od_rew_payout_amount) {
		this.od_rew_payout_amount = od_rew_payout_amount;
	}

	public BigDecimal getTp_rew_payout_amount() {
		return tp_rew_payout_amount;
	}

	public void setTp_rew_payout_amount(BigDecimal tp_rew_payout_amount) {
		this.tp_rew_payout_amount = tp_rew_payout_amount;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public BigDecimal getTotal_payout_amount() {
		return total_payout_amount;
	}

	public void setTotal_payout_amount(BigDecimal total_payout_amount) {
		this.total_payout_amount = total_payout_amount;
	}

	public BigDecimal getAdditional_commission() {
		return additional_commission;
	}

	public void setAdditional_commission(BigDecimal additional_commission) {
		this.additional_commission = additional_commission;
	}

	public BigDecimal getService_fees() {
		return service_fees;
	}

	public void setService_fees(BigDecimal service_fees) {
		this.service_fees = service_fees;
	}

	public String getIa_code() {
		return ia_code;
	}

	public void setIa_code(String ia_code) {
		this.ia_code = ia_code;
	}

	public BigDecimal getFactor() {
		return factor;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}

	public BigDecimal getNet_discount() {
		return net_discount;
	}

	public void setNet_discount(BigDecimal net_discount) {
		this.net_discount = net_discount;
	}

	public BigDecimal getNet_od() {
		return net_od;
	}

	public void setNet_od(BigDecimal net_od) {
		this.net_od = net_od;
	}

	public BigDecimal getNet_rate() {
		return net_rate;
	}

	public void setNet_rate(BigDecimal net_rate) {
		this.net_rate = net_rate;
	}

	public String getRank_ll() {
		return rank_ll;
	}

	public void setRank_ll(String rank_ll) {
		this.rank_ll = rank_ll;
	}

	public String getComputation_type() {
		return computation_type;
	}

	public void setComputation_type(String computation_type) {
		this.computation_type = computation_type;
	}

	public BigDecimal getSpec_val_perc() {
		return spec_val_perc;
	}

	public void setSpec_val_perc(BigDecimal spec_val_perc) {
		this.spec_val_perc = spec_val_perc;
	}

	public String getPol_agent_code() {
		return pol_agent_code;
	}

	public void setPol_agent_code(String pol_agent_code) {
		this.pol_agent_code = pol_agent_code;
	}

	public String getFinal_segment_type() {
		return final_segment_type;
	}

	public void setFinal_segment_type(String final_segment_type) {
		this.final_segment_type = final_segment_type;
	}

	public BigDecimal getCubic_capacity() {
		return cubic_capacity;
	}

	public void setCubic_capacity(BigDecimal cubic_capacity) {
		this.cubic_capacity = cubic_capacity;
	}

	public String getGrid() {
		return grid;
	}

	public void setGrid(String grid) {
		this.grid = grid;
	}

	public BigDecimal getVeh_age() {
		return veh_age;
	}

	public void setVeh_age(BigDecimal veh_age) {
		this.veh_age = veh_age;
	}

	public BigDecimal getTariff_rate() {
		return tariff_rate;
	}

	public void setTariff_rate(BigDecimal tariff_rate) {
		this.tariff_rate = tariff_rate;
	}

	public BigDecimal getFinal_tarrif_rate() {
		return final_tarrif_rate;
	}

	public void setFinal_tarrif_rate(BigDecimal final_tarrif_rate) {
		this.final_tarrif_rate = final_tarrif_rate;
	}

	public BigDecimal getDev_amount() {
		return dev_amount;
	}

	public void setDev_amount(BigDecimal dev_amount) {
		this.dev_amount = dev_amount;
	}

	public BigDecimal getOutput_basic_od() {
		return output_basic_od;
	}

	public void setOutput_basic_od(BigDecimal output_basic_od) {
		this.output_basic_od = output_basic_od;
	}

	public BigDecimal getSum_ins() {
		return sum_ins;
	}

	public void setSum_ins(BigDecimal sum_ins) {
		this.sum_ins = sum_ins;
	}

	public BigDecimal getT_rate() {
		return t_rate;
	}

	public void setT_rate(BigDecimal t_rate) {
		this.t_rate = t_rate;
	}

	public BigDecimal getBasic_od1() {
		return basic_od1;
	}

	public void setBasic_od1(BigDecimal basic_od1) {
		this.basic_od1 = basic_od1;
	}

	public BigDecimal getSi() {
		return si;
	}

	public void setSi(BigDecimal si) {
		this.si = si;
	}

	public BigDecimal getGcv_tariff() {
		return gcv_tariff;
	}

	public void setGcv_tariff(BigDecimal gcv_tariff) {
		this.gcv_tariff = gcv_tariff;
	}

	public BigDecimal getElec_nonelec() {
		return elec_nonelec;
	}

	public void setElec_nonelec(BigDecimal elec_nonelec) {
		this.elec_nonelec = elec_nonelec;
	}

	public BigDecimal getProd_od() {
		return prod_od;
	}

	public void setProd_od(BigDecimal prod_od) {
		this.prod_od = prod_od;
	}

	public BigDecimal getElec_ratio() {
		return elec_ratio;
	}

	public void setElec_ratio(BigDecimal elec_ratio) {
		this.elec_ratio = elec_ratio;
	}

	public BigDecimal getOta() {
		return ota;
	}

	public void setOta(BigDecimal ota) {
		this.ota = ota;
	}

	public BigDecimal getTci_43() {
		return tci_43;
	}

	public void setTci_43(BigDecimal tci_43) {
		this.tci_43 = tci_43;
	}

	public BigDecimal getPut() {
		return put;
	}

	public void setPut(BigDecimal put) {
		this.put = put;
	}

	public BigDecimal getPli_23() {
		return pli_23;
	}

	public void setPli_23(BigDecimal pli_23) {
		this.pli_23 = pli_23;
	}

	public BigDecimal getTotal_covers() {
		return total_covers;
	}

	public void setTotal_covers(BigDecimal total_covers) {
		this.total_covers = total_covers;
	}

	public BigDecimal getNet_od_si() {
		return net_od_si;
	}

	public void setNet_od_si(BigDecimal net_od_si) {
		this.net_od_si = net_od_si;
	}

	public BigDecimal getT_disc() {
		return t_disc;
	}

	public void setT_disc(BigDecimal t_disc) {
		this.t_disc = t_disc;
	}

	public BigDecimal getCalc_basic_od() {
		return calc_basic_od;
	}

	public void setCalc_basic_od(BigDecimal calc_basic_od) {
		this.calc_basic_od = calc_basic_od;
	}

	public BigDecimal getTotal_comm_prov() {
		return total_comm_prov;
	}

	public void setTotal_comm_prov(BigDecimal total_comm_prov) {
		this.total_comm_prov = total_comm_prov;
	}

	public BigDecimal getFinal_multiyear_status() {
		return final_multiyear_status;
	}

	public void setFinal_multiyear_status(BigDecimal final_multiyear_status) {
		this.final_multiyear_status = final_multiyear_status;
	}

	public String getNcb_flag1() {
		return ncb_flag1;
	}

	public void setNcb_flag1(String ncb_flag1) {
		this.ncb_flag1 = ncb_flag1;
	}

	public BigDecimal getFinal_comm_payout_amount() {
		return final_comm_payout_amount;
	}

	public void setFinal_comm_payout_amount(BigDecimal final_comm_payout_amount) {
		this.final_comm_payout_amount = final_comm_payout_amount;
	}

	public String getMisp_flag() {
		return misp_flag;
	}

	public void setMisp_flag(String misp_flag) {
		this.misp_flag = misp_flag;
	}

	public BigDecimal getSf_comm_perc() {
		return sf_comm_perc;
	}

	public void setSf_comm_perc(BigDecimal sf_comm_perc) {
		this.sf_comm_perc = sf_comm_perc;
	}

	public BigDecimal getSf_prov_perc() {
		return sf_prov_perc;
	}

	public void setSf_prov_perc(BigDecimal sf_prov_perc) {
		this.sf_prov_perc = sf_prov_perc;
	}

	public BigDecimal getSf_payout_amount() {
		return sf_payout_amount;
	}

	public void setSf_payout_amount(BigDecimal sf_payout_amount) {
		this.sf_payout_amount = sf_payout_amount;
	}

	public String getComputation_type_manager() {
		return computation_type_manager;
	}

	public void setComputation_type_manager(String computation_type_manager) {
		this.computation_type_manager = computation_type_manager;
	}

	public BigDecimal getT_irda() {
		return t_irda;
	}

	public void setT_irda(BigDecimal t_irda) {
		this.t_irda = t_irda;
	}

	public BigDecimal getSf_perc() {
		return sf_perc;
	}

	public void setSf_perc(BigDecimal sf_perc) {
		this.sf_perc = sf_perc;
	}

	public BigDecimal getSf_prov_amount() {
		return sf_prov_amount;
	}

	public void setSf_prov_amount(BigDecimal sf_prov_amount) {
		this.sf_prov_amount = sf_prov_amount;
	}

	public String getGrid_manager() {
		return grid_manager;
	}

	public void setGrid_manager(String grid_manager) {
		this.grid_manager = grid_manager;
	}

	public String getMisp_flag_manager() {
		return misp_flag_manager;
	}

	public void setMisp_flag_manager(String misp_flag_manager) {
		this.misp_flag_manager = misp_flag_manager;
	}

	public String getNcb_segment() {
		return ncb_segment;
	}

	public void setNcb_segment(String ncb_segment) {
		this.ncb_segment = ncb_segment;
	}

	public String getHierarchy_remark() {
		return hierarchy_remark;
	}

	public void setHierarchy_remark(String hierarchy_remark) {
		this.hierarchy_remark = hierarchy_remark;
	}

	public String getBde_perc() {
		return bde_perc;
	}

	public void setBde_perc(String bde_perc) {
		this.bde_perc = bde_perc;
	}

	public BigDecimal getBde_amount() {
		return bde_amount;
	}

	public void setBde_amount(BigDecimal bde_amount) {
		this.bde_amount = bde_amount;
	}

	public String getDealer() {
		return dealer;
	}

	public void setDealer(String dealer) {
		this.dealer = dealer;
	}

	public BigDecimal getTp_prov_amount() {
		return tp_prov_amount;
	}

	public void setTp_prov_amount(BigDecimal tp_prov_amount) {
		this.tp_prov_amount = tp_prov_amount;
	}

	public BigDecimal getOd_prov_amount() {
		return od_prov_amount;
	}

	public void setOd_prov_amount(BigDecimal od_prov_amount) {
		this.od_prov_amount = od_prov_amount;
	}

	public BigDecimal getDc_commission() {
		return dc_commission;
	}

	public void setDc_commission(BigDecimal dc_commission) {
		this.dc_commission = dc_commission;
	}

	public BigDecimal getFinal_sf_oe() {
		return final_sf_oe;
	}

	public void setFinal_sf_oe(BigDecimal final_sf_oe) {
		this.final_sf_oe = final_sf_oe;
	}

	public String getWeb_cases_flag() {
		return web_cases_flag;
	}

	public void setWeb_cases_flag(String web_cases_flag) {
		this.web_cases_flag = web_cases_flag;
	}

	public BigDecimal getTotal_prov_amount() {
		return total_prov_amount;
	}

	public void setTotal_prov_amount(BigDecimal total_prov_amount) {
		this.total_prov_amount = total_prov_amount;
	}

	public BigDecimal getTp_irda_percentage() {
		return tp_irda_percentage;
	}

	public void setTp_irda_percentage(BigDecimal tp_irda_percentage) {
		this.tp_irda_percentage = tp_irda_percentage;
	}

	public BigDecimal getOd_irda_percentage() {
		return od_irda_percentage;
	}

	public void setOd_irda_percentage(BigDecimal od_irda_percentage) {
		this.od_irda_percentage = od_irda_percentage;
	}

	public BigDecimal getOd_irda() {
		return od_irda;
	}

	public void setOd_irda(BigDecimal od_irda) {
		this.od_irda = od_irda;
	}

	public BigDecimal getTp_irda() {
		return tp_irda;
	}

	public void setTp_irda(BigDecimal tp_irda) {
		this.tp_irda = tp_irda;
	}

	public BigDecimal getTotal_sa_tp() {
		return total_sa_tp;
	}

	public void setTotal_sa_tp(BigDecimal total_sa_tp) {
		this.total_sa_tp = total_sa_tp;
	}

	public BigDecimal getTotal_pvt_car() {
		return total_pvt_car;
	}

	public void setTotal_pvt_car(BigDecimal total_pvt_car) {
		this.total_pvt_car = total_pvt_car;
	}

	public BigDecimal getTotal_tw() {
		return total_tw;
	}

	public void setTotal_tw(BigDecimal total_tw) {
		this.total_tw = total_tw;
	}

	public BigDecimal getTotal_misc() {
		return total_misc;
	}

	public void setTotal_misc(BigDecimal total_misc) {
		this.total_misc = total_misc;
	}

	public BigDecimal getTotal_gcv() {
		return total_gcv;
	}

	public void setTotal_gcv(BigDecimal total_gcv) {
		this.total_gcv = total_gcv;
	}

	public BigDecimal getTotal_pcv() {
		return total_pcv;
	}

	public void setTotal_pcv(BigDecimal total_pcv) {
		this.total_pcv = total_pcv;
	}

	public BigDecimal getRsa_hero_amount() {
		return rsa_hero_amount;
	}

	public void setRsa_hero_amount(BigDecimal rsa_hero_amount) {
		this.rsa_hero_amount = rsa_hero_amount;
	}

	public BigDecimal getReserve_od_final() {
		return reserve_od_final;
	}

	public void setReserve_od_final(BigDecimal reserve_od_final) {
		this.reserve_od_final = reserve_od_final;
	}

	public String getPayment_logic() {
		return payment_logic;
	}

	public void setPayment_logic(String payment_logic) {
		this.payment_logic = payment_logic;
	}

	public BigDecimal getWp_percent() {
		return wp_percent;
	}

	public void setWp_percent(BigDecimal wp_percent) {
		this.wp_percent = wp_percent;
	}

	public BigDecimal getWp_sf() {
		return wp_sf;
	}

	public void setWp_sf(BigDecimal wp_sf) {
		this.wp_sf = wp_sf;
	}

	public BigDecimal getWp_tp() {
		return wp_tp;
	}

	public void setWp_tp(BigDecimal wp_tp) {
		this.wp_tp = wp_tp;
	}

	public BigDecimal getWp_od() {
		return wp_od;
	}

	public void setWp_od(BigDecimal wp_od) {
		this.wp_od = wp_od;
	}

	public BigDecimal getDirect_wp_percent() {
		return direct_wp_percent;
	}

	public void setDirect_wp_percent(BigDecimal direct_wp_percent) {
		this.direct_wp_percent = direct_wp_percent;
	}

	public BigDecimal getDirect_wp_sf() {
		return direct_wp_sf;
	}

	public void setDirect_wp_sf(BigDecimal direct_wp_sf) {
		this.direct_wp_sf = direct_wp_sf;
	}

	public BigDecimal getDirect_wp_tp() {
		return direct_wp_tp;
	}

	public void setDirect_wp_tp(BigDecimal direct_wp_tp) {
		this.direct_wp_tp = direct_wp_tp;
	}

	public BigDecimal getDirect_wp_od() {
		return direct_wp_od;
	}

	public void setDirect_wp_od(BigDecimal direct_wp_od) {
		this.direct_wp_od = direct_wp_od;
	}

	public BigDecimal getDirect_rnr_percent() {
		return direct_rnr_percent;
	}

	public void setDirect_rnr_percent(BigDecimal direct_rnr_percent) {
		this.direct_rnr_percent = direct_rnr_percent;
	}

	public BigDecimal getDirect_rnr() {
		return direct_rnr;
	}

	public void setDirect_rnr(BigDecimal direct_rnr) {
		this.direct_rnr = direct_rnr;
	}

	public BigDecimal getHmsi_campaign_amt() {
		return hmsi_campaign_amt;
	}

	public void setHmsi_campaign_amt(BigDecimal hmsi_campaign_amt) {
		this.hmsi_campaign_amt = hmsi_campaign_amt;
	}

	public String getPol_agent_code_flag() {
		return pol_agent_code_flag;
	}

	public void setPol_agent_code_flag(String pol_agent_code_flag) {
		this.pol_agent_code_flag = pol_agent_code_flag;
	}

	public BigDecimal getAuto_escort_perc() {
		return auto_escort_perc;
	}

	public void setAuto_escort_perc(BigDecimal auto_escort_perc) {
		this.auto_escort_perc = auto_escort_perc;
	}

	public BigDecimal getAuto_escort_amt() {
		return auto_escort_amt;
	}

	public void setAuto_escort_amt(BigDecimal auto_escort_amt) {
		this.auto_escort_amt = auto_escort_amt;
	}

	public BigDecimal getAnnual_campaign_perc() {
		return annual_campaign_perc;
	}

	public void setAnnual_campaign_perc(BigDecimal annual_campaign_perc) {
		this.annual_campaign_perc = annual_campaign_perc;
	}

	public BigDecimal getAnnual_campaign_amt() {
		return annual_campaign_amt;
	}

	public void setAnnual_campaign_amt(BigDecimal annual_campaign_amt) {
		this.annual_campaign_amt = annual_campaign_amt;
	}

	public BigDecimal getTvs_campaign_perc() {
		return tvs_campaign_perc;
	}

	public void setTvs_campaign_perc(BigDecimal tvs_campaign_perc) {
		this.tvs_campaign_perc = tvs_campaign_perc;
	}

	public BigDecimal getTvs_campaign_amt() {
		return tvs_campaign_amt;
	}

	public void setTvs_campaign_amt(BigDecimal tvs_campaign_amt) {
		this.tvs_campaign_amt = tvs_campaign_amt;
	}

	public String getComputation_type_campaign() {
		return computation_type_campaign;
	}

	public void setComputation_type_campaign(String computation_type_campaign) {
		this.computation_type_campaign = computation_type_campaign;
	}

	public String getMisp_flag_campaign() {
		return misp_flag_campaign;
	}

	public void setMisp_flag_campaign(String misp_flag_campaign) {
		this.misp_flag_campaign = misp_flag_campaign;
	}

	public Long getPayoutComponentId() {
		return payoutComponentId;
	}

	public void setPayoutComponentId(Long payoutComponentId) {
		this.payoutComponentId = payoutComponentId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getSlab() {
		return slab;
	}

	public void setSlab(BigDecimal slab) {
		this.slab = slab;
	}

	public Long getPayout_id() {
		return payout_id;
	}

	public void setPayout_id(Long payout_id) {
		this.payout_id = payout_id;
	}

	public String getPol_super_parent_name() {
		return pol_super_parent_name;
	}

	public void setPol_super_parent_name(String pol_super_parent_name) {
		this.pol_super_parent_name = pol_super_parent_name;
	}

	public BigDecimal getCbp_percent() {
		return cbp_percent;
	}

	public void setCbp_percent(BigDecimal cbp_percent) {
		this.cbp_percent = cbp_percent;
	}

	public BigDecimal getCbp_sf() {
		return cbp_sf;
	}

	public void setCbp_sf(BigDecimal cbp_sf) {
		this.cbp_sf = cbp_sf;
	}

	public BigDecimal getCbp_tp() {
		return cbp_tp;
	}

	public void setCbp_tp(BigDecimal cbp_tp) {
		this.cbp_tp = cbp_tp;
	}

	public BigDecimal getCbp_od() {
		return cbp_od;
	}

	public void setCbp_od(BigDecimal cbp_od) {
		this.cbp_od = cbp_od;
	}

	public BigDecimal getWp_rnr_percent() {
		return wp_rnr_percent;
	}

	public void setWp_rnr_percent(BigDecimal wp_rnr_percent) {
		this.wp_rnr_percent = wp_rnr_percent;
	}

	public BigDecimal getWp_rnr() {
		return wp_rnr;
	}

	public void setWp_rnr(BigDecimal wp_rnr) {
		this.wp_rnr = wp_rnr;
	}

	public BigDecimal getWp_tp_rnr() {
		return wp_tp_rnr;
	}

	public void setWp_tp_rnr(BigDecimal wp_tp_rnr) {
		this.wp_tp_rnr = wp_tp_rnr;
	}

	public BigDecimal getWp_od_rnr() {
		return wp_od_rnr;
	}

	public void setWp_od_rnr(BigDecimal wp_od_rnr) {
		this.wp_od_rnr = wp_od_rnr;
	}

	public String getComputation_type_banca() {
		return computation_type_banca;
	}

	public void setComputation_type_banca(String computation_type_banca) {
		this.computation_type_banca = computation_type_banca;
	}

	public BigDecimal getDirect_od_payout_percentage() {
		return direct_od_payout_percentage;
	}

	public void setDirect_od_payout_percentage(BigDecimal direct_od_payout_percentage) {
		this.direct_od_payout_percentage = direct_od_payout_percentage;
	}

	public BigDecimal getDirect_tp_payout_percentage() {
		return direct_tp_payout_percentage;
	}

	public void setDirect_tp_payout_percentage(BigDecimal direct_tp_payout_percentage) {
		this.direct_tp_payout_percentage = direct_tp_payout_percentage;
	}

	public BigDecimal getDirect_od_prov_perc() {
		return direct_od_prov_perc;
	}

	public void setDirect_od_prov_perc(BigDecimal direct_od_prov_perc) {
		this.direct_od_prov_perc = direct_od_prov_perc;
	}

	public BigDecimal getDirect_tp_prov_perc() {
		return direct_tp_prov_perc;
	}

	public void setDirect_tp_prov_perc(BigDecimal direct_tp_prov_perc) {
		this.direct_tp_prov_perc = direct_tp_prov_perc;
	}

	public BigDecimal getDirect_od_payout_amount() {
		return direct_od_payout_amount;
	}

	public void setDirect_od_payout_amount(BigDecimal direct_od_payout_amount) {
		this.direct_od_payout_amount = direct_od_payout_amount;
	}

	public BigDecimal getDirect_tp_payout_amount() {
		return direct_tp_payout_amount;
	}

	public void setDirect_tp_payout_amount(BigDecimal direct_tp_payout_amount) {
		this.direct_tp_payout_amount = direct_tp_payout_amount;
	}

	public BigDecimal getDirect_od_prov_amount() {
		return direct_od_prov_amount;
	}

	public void setDirect_od_prov_amount(BigDecimal direct_od_prov_amount) {
		this.direct_od_prov_amount = direct_od_prov_amount;
	}

	public BigDecimal getDirect_tp_prov_amount() {
		return direct_tp_prov_amount;
	}

	public void setDirect_tp_prov_amount(BigDecimal direct_tp_prov_amount) {
		this.direct_tp_prov_amount = direct_tp_prov_amount;
	}

	public BigDecimal getDirect_total_payout_amount() {
		return direct_total_payout_amount;
	}

	public void setDirect_total_payout_amount(BigDecimal direct_total_payout_amount) {
		this.direct_total_payout_amount = direct_total_payout_amount;
	}

	public BigDecimal getDirect_total_prov_amount() {
		return direct_total_prov_amount;
	}

	public void setDirect_total_prov_amount(BigDecimal direct_total_prov_amount) {
		this.direct_total_prov_amount = direct_total_prov_amount;
	}

	public String getDiscount_slab() {
		return discount_slab;
	}

	public void setDiscount_slab(String discount_slab) {
		this.discount_slab = discount_slab;
	}

	public String getVeh_slab() {
		return veh_slab;
	}

	public void setVeh_slab(String veh_slab) {
		this.veh_slab = veh_slab;
	}

	public String getBusiness_type() {
		return business_type;
	}

	public void setBusiness_type(String business_type) {
		this.business_type = business_type;
	}

	public String getSa_od_renewal_flag() {
		return sa_od_renewal_flag;
	}

	public void setSa_od_renewal_flag(String sa_od_renewal_flag) {
		this.sa_od_renewal_flag = sa_od_renewal_flag;
	}

	public String getDisc_slab() {
		return disc_slab;
	}

	public void setDisc_slab(String disc_slab) {
		this.disc_slab = disc_slab;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDiscount_slab_flag() {
		return discount_slab_flag;
	}

	public void setDiscount_slab_flag(String discount_slab_flag) {
		this.discount_slab_flag = discount_slab_flag;
	}

	public BigDecimal getFinal_prov_amount() {
		return final_prov_amount;
	}

	public void setFinal_prov_amount(BigDecimal final_prov_amount) {
		this.final_prov_amount = final_prov_amount;
	}

	public BigDecimal getTvs_gwp_sum() {
		return tvs_gwp_sum;
	}

	public void setTvs_gwp_sum(BigDecimal tvs_gwp_sum) {
		this.tvs_gwp_sum = tvs_gwp_sum;
	}

	public BigDecimal getHmsi_gwp_sum() {
		return hmsi_gwp_sum;
	}

	public void setHmsi_gwp_sum(BigDecimal hmsi_gwp_sum) {
		this.hmsi_gwp_sum = hmsi_gwp_sum;
	}

	public BigDecimal getPrev_ia_code_provision_amount() {
		return prev_ia_code_provision_amount;
	}

	public void setPrev_ia_code_provision_amount(BigDecimal prev_ia_code_provision_amount) {
		this.prev_ia_code_provision_amount = prev_ia_code_provision_amount;
	}

	public String getP_tax_flag() {
		return p_tax_flag;
	}

	public void setP_tax_flag(String p_tax_flag) {
		this.p_tax_flag = p_tax_flag;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getDat_intermediary_start_date() {
		return dat_intermediary_start_date;
	}

	public void setDat_intermediary_start_date(String dat_intermediary_start_date) {
		this.dat_intermediary_start_date = dat_intermediary_start_date;
	}

	public BigDecimal getP_tax_amt() {
		return p_tax_amt;
	}

	public void setP_tax_amt(BigDecimal p_tax_amt) {
		this.p_tax_amt = p_tax_amt;
	}

	public BigDecimal getLimit_amount() {
		return limit_amount;
	}

	public void setLimit_amount(BigDecimal limit_amount) {
		this.limit_amount = limit_amount;
	}

	public String getAnx_state() {
		return anx_state;
	}

	public void setAnx_state(String anx_state) {
		this.anx_state = anx_state;
	}

	public String getReserver_od_renewal_lt_flag() {
		return reserver_od_renewal_lt_flag;
	}

	public void setReserver_od_renewal_lt_flag(String reserver_od_renewal_lt_flag) {
		this.reserver_od_renewal_lt_flag = reserver_od_renewal_lt_flag;
	}

	public String getFinal_vertical_desc() {
		return final_vertical_desc;
	}

	public void setFinal_vertical_desc(String final_vertical_desc) {
		this.final_vertical_desc = final_vertical_desc;
	}

	public BigDecimal getFinal_commission() {
		return final_commission;
	}

	public void setFinal_commission(BigDecimal final_commission) {
		this.final_commission = final_commission;
	}

	public String getManual_updation_flag() {
		return manual_updation_flag;
	}

	public void setManual_updation_flag(String manual_updation_flag) {
		this.manual_updation_flag = manual_updation_flag;
	}

	public BigDecimal getFinal_commission_manual_updation() {
		return final_commission_manual_updation;
	}

	public void setFinal_commission_manual_updation(BigDecimal final_commission_manual_updation) {
		this.final_commission_manual_updation = final_commission_manual_updation;
	}

	public BigDecimal getFinal_commission_updated() {
		return final_commission_updated;
	}

	public void setFinal_commission_updated(BigDecimal final_commission_updated) {
		this.final_commission_updated = final_commission_updated;
	}

	public BigDecimal getFinal_commission_perc_manual_updation() {
		return final_commission_perc_manual_updation;
	}

	public void setFinal_commission_perc_manual_updation(BigDecimal final_commission_perc_manual_updation) {
		this.final_commission_perc_manual_updation = final_commission_perc_manual_updation;
	}

	public BigDecimal getCgstPercentage() {
		return cgstPercentage;
	}

	public void setCgstPercentage(BigDecimal cgstPercentage) {
		this.cgstPercentage = cgstPercentage;
	}

	public BigDecimal getSgstPercentage() {
		return sgstPercentage;
	}

	public void setSgstPercentage(BigDecimal sgstPercentage) {
		this.sgstPercentage = sgstPercentage;
	}

	public BigDecimal getIgstPercentage() {
		return igstPercentage;
	}

	public void setIgstPercentage(BigDecimal igstPercentage) {
		this.igstPercentage = igstPercentage;
	}

	public BigDecimal getCgstAmount() {
		return cgstAmount;
	}

	public void setCgstAmount(BigDecimal cgstAmount) {
		this.cgstAmount = cgstAmount;
	}

	public BigDecimal getSgstAmount() {
		return sgstAmount;
	}

	public void setSgstAmount(BigDecimal sgstAmount) {
		this.sgstAmount = sgstAmount;
	}

	public BigDecimal getIgstAmount() {
		return igstAmount;
	}

	public void setIgstAmount(BigDecimal igstAmount) {
		this.igstAmount = igstAmount;
	}

	public String getWorkflow_status() {
		return workflow_status;
	}

	public void setWorkflow_status(String workflow_status) {
		this.workflow_status = workflow_status;
	}

	public BigDecimal getReleased_amount() {
		return released_amount;
	}

	public void setReleased_amount(BigDecimal released_amount) {
		this.released_amount = released_amount;
	}

	public String getReady_for_release() {
		return ready_for_release;
	}

	public void setReady_for_release(String ready_for_release) {
		this.ready_for_release = ready_for_release;
	}

	public String getRelease_group() {
		return release_group;
	}

	public void setRelease_group(String release_group) {
		this.release_group = release_group;
	}

	public BigDecimal getProgram_id() {
		return program_id;
	}

	public void setProgram_id(BigDecimal program_id) {
		this.program_id = program_id;
	}

	public String getProcessBusinessKey() {
		return processBusinessKey;
	}

	public void setProcessBusinessKey(String processBusinessKey) {
		this.processBusinessKey = processBusinessKey;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBankaccno() {
		return bankaccno;
	}

	public void setBankaccno(String bankaccno) {
		this.bankaccno = bankaccno;
	}

	public String getBank_ifsc_code() {
		return bank_ifsc_code;
	}

	public void setBank_ifsc_code(String bank_ifsc_code) {
		this.bank_ifsc_code = bank_ifsc_code;
	}

	public String getIa_code_state() {
		return ia_code_state;
	}

	public void setIa_code_state(String ia_code_state) {
		this.ia_code_state = ia_code_state;
	}

	public String getIa_code_gstno() {
		return ia_code_gstno;
	}

	public void setIa_code_gstno(String ia_code_gstno) {
		this.ia_code_gstno = ia_code_gstno;
	}

	public String getAgency_name() {
		return agency_name;
	}

	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getLicense_expiry_date() {
		return license_expiry_date;
	}

	public void setLicense_expiry_date(String license_expiry_date) {
		this.license_expiry_date = license_expiry_date;
	}

	public BigDecimal getProvisionAmount() {
		return provisionAmount;
	}

	public void setProvisionAmount(BigDecimal provisionAmount) {
		this.provisionAmount = provisionAmount;
	}

	public String getGst_applicable() {
		return gst_applicable;
	}

	public void setGst_applicable(String gst_applicable) {
		this.gst_applicable = gst_applicable;
	}

	public BigDecimal getCommAmt() {
		return commAmt;
	}

	public void setCommAmt(BigDecimal commAmt) {
		this.commAmt = commAmt;
	}

	public BigDecimal getTotalGstAmount() {
		return totalGstAmount;
	}

	public void setTotalGstAmount(BigDecimal totalGstAmount) {
		this.totalGstAmount = totalGstAmount;
	}

	public String getOem_vertical() {
		return oem_vertical;
	}

	public void setOem_vertical(String oem_vertical) {
		this.oem_vertical = oem_vertical;
	}

	public String getBusiness_group() {
		return business_group;
	}

	public void setBusiness_group(String business_group) {
		this.business_group = business_group;
	}

	public BigDecimal getFinal_commission_perc() {
		return final_commission_perc;
	}

	public void setFinal_commission_perc(BigDecimal final_commission_perc) {
		this.final_commission_perc = final_commission_perc;
	}

	public BigDecimal getFinal_provision_perc() {
		return final_provision_perc;
	}

	public void setFinal_provision_perc(BigDecimal final_provision_perc) {
		this.final_provision_perc = final_provision_perc;
	}

	public BigDecimal getManufacturer_prov_amt() {
		return manufacturer_prov_amt;
	}

	public void setManufacturer_prov_amt(BigDecimal manufacturer_prov_amt) {
		this.manufacturer_prov_amt = manufacturer_prov_amt;
	}

	public BigDecimal getCsc_prov_amt() {
		return csc_prov_amt;
	}

	public void setCsc_prov_amt(BigDecimal csc_prov_amt) {
		this.csc_prov_amt = csc_prov_amt;
	}

	public BigDecimal getManufacturer_prov_sum() {
		return manufacturer_prov_sum;
	}

	public void setManufacturer_prov_sum(BigDecimal manufacturer_prov_sum) {
		this.manufacturer_prov_sum = manufacturer_prov_sum;
	}

	public BigDecimal getCsc_prov_sum() {
		return csc_prov_sum;
	}

	public void setCsc_prov_sum(BigDecimal csc_prov_sum) {
		this.csc_prov_sum = csc_prov_sum;
	}

	public String getIgstApplicable() {
		return igstApplicable;
	}

	public void setIgstApplicable(String igstApplicable) {
		this.igstApplicable = igstApplicable;
	}

	public String getSgstApplicable() {
		return sgstApplicable;
	}

	public void setSgstApplicable(String sgstApplicable) {
		this.sgstApplicable = sgstApplicable;
	}

	public String getCgstApplicable() {
		return cgstApplicable;
	}

	public void setCgstApplicable(String cgstApplicable) {
		this.cgstApplicable = cgstApplicable;
	}

	public String getHdfc_state() {
		return hdfc_state;
	}

	public void setHdfc_state(String hdfc_state) {
		this.hdfc_state = hdfc_state;
	}

	public String getBroker() {
		return broker;
	}

	public void setBroker(String broker) {
		this.broker = broker;
	}

	public BigDecimal getExcess_of_annx_perc() {
		return excess_of_annx_perc;
	}

	public void setExcess_of_annx_perc(BigDecimal excess_of_annx_perc) {
		this.excess_of_annx_perc = excess_of_annx_perc;
	}

	public BigDecimal getProRateAmt() {
		return proRateAmt;
	}

	public void setProRateAmt(BigDecimal proRateAmt) {
		this.proRateAmt = proRateAmt;
	}

	public BigDecimal getToyota_campaign_gwp_sum() {
		return toyota_campaign_gwp_sum;
	}

	public void setToyota_campaign_gwp_sum(BigDecimal toyota_campaign_gwp_sum) {
		this.toyota_campaign_gwp_sum = toyota_campaign_gwp_sum;
	}

	public BigDecimal getHonda_4w_campaigngwp_sum() {
		return honda_4w_campaigngwp_sum;
	}

	public void setHonda_4w_campaigngwp_sum(BigDecimal honda_4w_campaigngwp_sum) {
		this.honda_4w_campaigngwp_sum = honda_4w_campaigngwp_sum;
	}

	public BigDecimal getFinal_commission_od() {
		return final_commission_od;
	}

	public void setFinal_commission_od(BigDecimal final_commission_od) {
		this.final_commission_od = final_commission_od;
	}

	public BigDecimal getFinal_commission_tp() {
		return final_commission_tp;
	}

	public void setFinal_commission_tp(BigDecimal final_commission_tp) {
		this.final_commission_tp = final_commission_tp;
	}

	public BigDecimal getFinal_prov_od() {
		return final_prov_od;
	}

	public void setFinal_prov_od(BigDecimal final_prov_od) {
		this.final_prov_od = final_prov_od;
	}

	public BigDecimal getFinal_prov_tp() {
		return final_prov_tp;
	}

	public void setFinal_prov_tp(BigDecimal final_prov_tp) {
		this.final_prov_tp = final_prov_tp;
	}

	public BigDecimal getCbp_od_perc() {
		return cbp_od_perc;
	}

	public void setCbp_od_perc(BigDecimal cbp_od_perc) {
		this.cbp_od_perc = cbp_od_perc;
	}

	public BigDecimal getCbp_tp_perc() {
		return cbp_tp_perc;
	}

	public void setCbp_tp_perc(BigDecimal cbp_tp_perc) {
		this.cbp_tp_perc = cbp_tp_perc;
	}

	public String getVertical_name() {
		return vertical_name;
	}

	public void setVertical_name(String vertical_name) {
		this.vertical_name = vertical_name;
	}

	public BigDecimal getCbp_amount() {
		return cbp_amount;
	}

	public void setCbp_amount(BigDecimal cbp_amount) {
		this.cbp_amount = cbp_amount;
	}

	public BigDecimal getCbp_tp_amount() {
		return cbp_tp_amount;
	}

	public void setCbp_tp_amount(BigDecimal cbp_tp_amount) {
		this.cbp_tp_amount = cbp_tp_amount;
	}

	public BigDecimal getCbp_od_amount() {
		return cbp_od_amount;
	}

	public void setCbp_od_amount(BigDecimal cbp_od_amount) {
		this.cbp_od_amount = cbp_od_amount;
	}

	public BigDecimal getCpa_flag() {
		return cpa_flag;
	}

	public void setCpa_flag(BigDecimal cpa_flag) {
		this.cpa_flag = cpa_flag;
	}

	public String getAnnx6_effective_date() {
		return annx6_effective_date;
	}

	public void setAnnx6_effective_date(String annx6_effective_date) {
		this.annx6_effective_date = annx6_effective_date;
	}

	public String getAnx1_segment() {
		return anx1_segment;
	}

	public void setAnx1_segment(String anx1_segment) {
		this.anx1_segment = anx1_segment;
	}

	public String getTxt_sate_sub_name() {
		return txt_sate_sub_name;
	}

	public void setTxt_sate_sub_name(String txt_sate_sub_name) {
		this.txt_sate_sub_name = txt_sate_sub_name;
	}

	public String getState_num() {
		return state_num;
	}

	public void setState_num(String state_num) {
		this.state_num = state_num;
	}

	public String getNum_sate_sub_code() {
		return num_sate_sub_code;
	}

	public void setNum_sate_sub_code(String num_sate_sub_code) {
		this.num_sate_sub_code = num_sate_sub_code;
	}

	public String getTxt_display_caption() {
		return txt_display_caption;
	}

	public void setTxt_display_caption(String txt_display_caption) {
		this.txt_display_caption = txt_display_caption;
	}

	public String getCg1_segment() {
		return cg1_segment;
	}

	public void setCg1_segment(String cg1_segment) {
		this.cg1_segment = cg1_segment;
	}

	public String getCg1_slab() {
		return cg1_slab;
	}

	public void setCg1_slab(String cg1_slab) {
		this.cg1_slab = cg1_slab;
	}

	public String getA2_zone() {
		return a2_zone;
	}

	public void setA2_zone(String a2_zone) {
		this.a2_zone = a2_zone;
	}

	public String getCg2_fuel_type() {
		return cg2_fuel_type;
	}

	public void setCg2_fuel_type(String cg2_fuel_type) {
		this.cg2_fuel_type = cg2_fuel_type;
	}

	public String getCg3_segment() {
		return cg3_segment;
	}

	public void setCg3_segment(String cg3_segment) {
		this.cg3_segment = cg3_segment;
	}

	public String getCg3_cpa_flag() {
		return cg3_cpa_flag;
	}

	public void setCg3_cpa_flag(String cg3_cpa_flag) {
		this.cg3_cpa_flag = cg3_cpa_flag;
	}

	public String getDerr_txt_segment_type() {
		return derr_txt_segment_type;
	}

	public void setDerr_txt_segment_type(String derr_txt_segment_type) {
		this.derr_txt_segment_type = derr_txt_segment_type;
	}

	public String getCg4_discount() {
		return cg4_discount;
	}

	public void setCg4_discount(String cg4_discount) {
		this.cg4_discount = cg4_discount;
	}

	public String getCg4_slab() {
		return cg4_slab;
	}

	public void setCg4_slab(String cg4_slab) {
		this.cg4_slab = cg4_slab;
	}

	public String getA3_zone() {
		return a3_zone;
	}

	public void setA3_zone(String a3_zone) {
		this.a3_zone = a3_zone;
	}

	public String getCg5_ncb_flag() {
		return cg5_ncb_flag;
	}

	public void setCg5_ncb_flag(String cg5_ncb_flag) {
		this.cg5_ncb_flag = cg5_ncb_flag;
	}

	public String getCg5_fuel_type() {
		return cg5_fuel_type;
	}

	public void setCg5_fuel_type(String cg5_fuel_type) {
		this.cg5_fuel_type = cg5_fuel_type;
	}

	public String getCg5_slab() {
		return cg5_slab;
	}

	public void setCg5_slab(String cg5_slab) {
		this.cg5_slab = cg5_slab;
	}

	public String getA4_segment() {
		return a4_segment;
	}

	public void setA4_segment(String a4_segment) {
		this.a4_segment = a4_segment;
	}

	public String getA4_discount() {
		return a4_discount;
	}

	public void setA4_discount(String a4_discount) {
		this.a4_discount = a4_discount;
	}

	public String getCg6_segment() {
		return cg6_segment;
	}

	public void setCg6_segment(String cg6_segment) {
		this.cg6_segment = cg6_segment;
	}

	public String getCg6_slab() {
		return cg6_slab;
	}

	public void setCg6_slab(String cg6_slab) {
		this.cg6_slab = cg6_slab;
	}

	public String getCg6_discount() {
		return cg6_discount;
	}

	public void setCg6_discount(String cg6_discount) {
		this.cg6_discount = cg6_discount;
	}

	public String getCg7_discount() {
		return cg7_discount;
	}

	public void setCg7_discount(String cg7_discount) {
		this.cg7_discount = cg7_discount;
	}

	public String getCg7_segment() {
		return cg7_segment;
	}

	public void setCg7_segment(String cg7_segment) {
		this.cg7_segment = cg7_segment;
	}

	public String getA5_segment() {
		return a5_segment;
	}

	public void setA5_segment(String a5_segment) {
		this.a5_segment = a5_segment;
	}

	public String getA5_policy_type() {
		return a5_policy_type;
	}

	public void setA5_policy_type(String a5_policy_type) {
		this.a5_policy_type = a5_policy_type;
	}

	public String getA5_business_type() {
		return a5_business_type;
	}

	public void setA5_business_type(String a5_business_type) {
		this.a5_business_type = a5_business_type;
	}

	public String getWP_No() {
		return WP_No;
	}

	public void setWP_No(String WP_No) {
		this.WP_No = WP_No;
	}

	public String getEffective() {
		return effective;
	}

	public void setEffective(String effective) {
		this.effective = effective;
	}

	public String getEnding_on() {
		return ending_on;
	}

	public void setEnding_on(String ending_on) {
		this.ending_on = ending_on;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAgency_Grid_No() {
		return agency_Grid_No;
	}

	public void setAgency_Grid_No(String agency_Grid_No) {
		this.agency_Grid_No = agency_Grid_No;
	}

	public String getAgency_Name() {
		return agency_Name;
	}

	public void setAgency_Name(String agency_Name) {
		this.agency_Name = agency_Name;
	}

	public BigDecimal getComm_od() {
		return comm_od;
	}

	public void setComm_od(BigDecimal comm_od) {
		this.comm_od = comm_od;
	}

	public BigDecimal getComm_tp() {
		return comm_tp;
	}

	public void setComm_tp(BigDecimal comm_tp) {
		this.comm_tp = comm_tp;
	}

	public BigDecimal getProv_od() {
		return prov_od;
	}

	public void setProv_od(BigDecimal prov_od) {
		this.prov_od = prov_od;
	}

	public BigDecimal getProv_tp() {
		return prov_tp;
	}

	public void setProv_tp(BigDecimal prov_tp) {
		this.prov_tp = prov_tp;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getBancaM_policy_type() {
		return bancaM_policy_type;
	}

	public void setBancaM_policy_type(String bancaM_policy_type) {
		this.bancaM_policy_type = bancaM_policy_type;
	}

	public String getBancaM_business_type() {
		return bancaM_business_type;
	}

	public void setBancaM_business_type(String bancaM_business_type) {
		this.bancaM_business_type = bancaM_business_type;
	}

	public BigDecimal getBancaM_cpa() {
		return bancaM_cpa;
	}

	public void setBancaM_cpa(BigDecimal bancaM_cpa) {
		this.bancaM_cpa = bancaM_cpa;
	}

	public String getBancaM_discount() {
		return bancaM_discount;
	}

	public void setBancaM_discount(String bancaM_discount) {
		this.bancaM_discount = bancaM_discount;
	}

	public String getA9_product() {
		return a9_product;
	}

	public void setA9_product(String a9_product) {
		this.a9_product = a9_product;
	}

	public String getA9_constitution() {
		return a9_constitution;
	}

	public void setA9_constitution(String a9_constitution) {
		this.a9_constitution = a9_constitution;
	}

	public BigDecimal getA9_percentage() {
		return a9_percentage;
	}

	public void setA9_percentage(BigDecimal a9_percentage) {
		this.a9_percentage = a9_percentage;
	}

	public String getA12_product() {
		return a12_product;
	}

	public void setA12_product(String a12_product) {
		this.a12_product = a12_product;
	}

	public String getA12_veh_age() {
		return a12_veh_age;
	}

	public void setA12_veh_age(String a12_veh_age) {
		this.a12_veh_age = a12_veh_age;
	}

	public String getA12_policy_type() {
		return a12_policy_type;
	}

	public void setA12_policy_type(String a12_policy_type) {
		this.a12_policy_type = a12_policy_type;
	}

	public String getA6_discount_slab() {
		return a6_discount_slab;
	}

	public void setA6_discount_slab(String a6_discount_slab) {
		this.a6_discount_slab = a6_discount_slab;
	}

	public String getA6_policy_type() {
		return a6_policy_type;
	}

	public void setA6_policy_type(String a6_policy_type) {
		this.a6_policy_type = a6_policy_type;
	}

	public String getA6_business_type() {
		return a6_business_type;
	}

	public void setA6_business_type(String a6_business_type) {
		this.a6_business_type = a6_business_type;
	}

	public String getA6_segment() {
		return a6_segment;
	}

	public void setA6_segment(String a6_segment) {
		this.a6_segment = a6_segment;
	}

	public String getWitheffectfrom() {
		return witheffectfrom;
	}

	public void setWitheffectfrom(String witheffectfrom) {
		this.witheffectfrom = witheffectfrom;
	}

	public String getUpto_Date() {
		return upto_Date;
	}

	public void setUpto_Date(String upto_Date) {
		this.upto_Date = upto_Date;
	}

	public String getExp_GWP_lacs() {
		return exp_GWP_lacs;
	}

	public void setExp_GWP_lacs(String exp_GWP_lacs) {
		this.exp_GWP_lacs = exp_GWP_lacs;
	}

	public String getExp_MCOR() {
		return exp_MCOR;
	}

	public void setExp_MCOR(String exp_MCOR) {
		this.exp_MCOR = exp_MCOR;
	}

	public String getA6_fuel_type() {
		return a6_fuel_type;
	}

	public void setA6_fuel_type(String a6_fuel_type) {
		this.a6_fuel_type = a6_fuel_type;
	}

	public String getVer_Geo() {
		return ver_Geo;
	}

	public void setVer_Geo(String ver_Geo) {
		this.ver_Geo = ver_Geo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDealer_Name() {
		return dealer_Name;
	}

	public void setDealer_Name(String dealer_Name) {
		this.dealer_Name = dealer_Name;
	}

	public String getVehicle_Age() {
		return vehicle_Age;
	}

	public void setVehicle_Age(String vehicle_Age) {
		this.vehicle_Age = vehicle_Age;
	}

	public String getNoofWheels() {
		return noofWheels;
	}

	public void setNoofWheels(String noofWheels) {
		this.noofWheels = noofWheels;
	}

	public String getA14_product() {
		return a14_product;
	}

	public void setA14_product(String a14_product) {
		this.a14_product = a14_product;
	}

	public String getPolicy_type_state_mst() {
		return policy_type_state_mst;
	}

	public void setPolicy_type_state_mst(String policy_type_state_mst) {
		this.policy_type_state_mst = policy_type_state_mst;
	}

	public String getTxt_location_code() {
		return txt_location_code;
	}

	public void setTxt_location_code(String txt_location_code) {
		this.txt_location_code = txt_location_code;
	}

	public String getLocation_code() {
		return location_code;
	}

	public void setLocation_code(String location_code) {
		this.location_code = location_code;
	}

	public String getState_code() {
		return state_code;
	}

	public void setState_code(String state_code) {
		this.state_code = state_code;
	}

	public String getNcb_flag_anx6() {
		return ncb_flag_anx6;
	}

	public void setNcb_flag_anx6(String ncb_flag_anx6) {
		this.ncb_flag_anx6 = ncb_flag_anx6;
	}

	public String getAnx4_state() {
		return anx4_state;
	}

	public void setAnx4_state(String anx4_state) {
		this.anx4_state = anx4_state;
	}

	public String getCommission_Campaign_Name() {
		return Commission_Campaign_Name;
	}

	public void setCommission_Campaign_Name(String Commission_Campaign_Name) {
		this.Commission_Campaign_Name = Commission_Campaign_Name;
	}

	public String getCommission_Campaign() {
		return Commission_Campaign;
	}

	public void setCommission_Campaign(String Commission_Campaign) {
		this.Commission_Campaign = Commission_Campaign;
	}

	public String getCampaign_type() {
		return Campaign_type;
	}

	public void setCampaign_type(String Campaign_type) {
		this.Campaign_type = Campaign_type;
	}

	public String getExcluding_Including_Annex_9() {
		return Excluding_Including_Annex_9;
	}

	public void setExcluding_Including_Annex_9(String Excluding_Including_Annex_9) {
		this.Excluding_Including_Annex_9 = Excluding_Including_Annex_9;
	}

	public String getWith_Effect_Dt() {
		return With_Effect_Dt;
	}

	public void setWith_Effect_Dt(String With_Effect_Dt) {
		this.With_Effect_Dt = With_Effect_Dt;
	}

	public String getWith_End_Dt() {
		return With_End_Dt;
	}

	public void setWith_End_Dt(String With_End_Dt) {
		this.With_End_Dt = With_End_Dt;
	}

	public String getExcluding_Business_Type_LT() {
		return Excluding_Business_Type_LT;
	}

	public void setExcluding_Business_Type_LT(String Excluding_Business_Type_LT) {
		this.Excluding_Business_Type_LT = Excluding_Business_Type_LT;
	}

	public String getExcluding_Vertical() {
		return Excluding_Vertical;
	}

	public void setExcluding_Vertical(String Excluding_Vertical) {
		this.Excluding_Vertical = Excluding_Vertical;
	}

	public String getExcluding_Model() {
		return Excluding_Model;
	}

	public void setExcluding_Model(String Excluding_Model) {
		this.Excluding_Model = Excluding_Model;
	}

	public String getExcluding_Segment() {
		return Excluding_Segment;
	}

	public void setExcluding_Segment(String Excluding_Segment) {
		this.Excluding_Segment = Excluding_Segment;
	}

	public String getExcluding_Fuel_Type() {
		return Excluding_Fuel_Type;
	}

	public void setExcluding_Fuel_Type(String Excluding_Fuel_Type) {
		this.Excluding_Fuel_Type = Excluding_Fuel_Type;
	}

	public String getRelease_Provision() {
		return Release_Provision;
	}

	public void setRelease_Provision(String Release_Provision) {
		this.Release_Provision = Release_Provision;
	}

	public String getAttachement_Ref() {
		return Attachement_Ref;
	}

	public void setAttachement_Ref(String Attachement_Ref) {
		this.Attachement_Ref = Attachement_Ref;
	}

	public String getAnnual_campaign_broker() {
		return annual_campaign_broker;
	}

	public void setAnnual_campaign_broker(String annual_campaign_broker) {
		this.annual_campaign_broker = annual_campaign_broker;
	}

	public String getAfterAnnx_6_effective_flag() {
		return afterAnnx_6_effective_flag;
	}

	public void setAfterAnnx_6_effective_flag(String afterAnnx_6_effective_flag) {
		this.afterAnnx_6_effective_flag = afterAnnx_6_effective_flag;
	}

	public List<String> getA5_business_type_list() {
		return a5_business_type_list;
	}

	public void setA5_business_type_list(List<String> a5_business_type_list) {
		this.a5_business_type_list = a5_business_type_list;
	}

	public String getLocation_state_name() {
		return location_state_name;
	}

	public void setLocation_state_name(String location_state_name) {
		this.location_state_name = location_state_name;
	}

	public BigDecimal getHighest_sf_comm_perc() {
		return highest_sf_comm_perc;
	}

	public void setHighest_sf_comm_perc(BigDecimal highest_sf_comm_perc) {
		this.highest_sf_comm_perc = highest_sf_comm_perc;
	}

	public List<String> getCbp_list() {
		return cbp_list;
	}

	public void setCbp_list(List<String> cbp_list) {
		this.cbp_list = cbp_list;
	}

	public List<String> getComputation_type_list() {
		return computation_type_list;
	}

	public void setComputation_type_list(List<String> computation_type_list) {
		this.computation_type_list = computation_type_list;
	}

	public String getCbg_slab() {
		return cbg_slab;
	}

	public void setCbg_slab(String cbg_slab) {
		this.cbg_slab = cbg_slab;
	}

	public String getCbg_policy_type() {
		return cbg_policy_type;
	}

	public void setCbg_policy_type(String cbg_policy_type) {
		this.cbg_policy_type = cbg_policy_type;
	}

	public List<String> getA5_segment_list() {
		return a5_segment_list;
	}

	public void setA5_segment_list(List<String> a5_segment_list) {
		this.a5_segment_list = a5_segment_list;
	}

	public String getHdfc_address() {
		return hdfc_address;
	}

	public void setHdfc_address(String hdfc_address) {
		this.hdfc_address = hdfc_address;
	}

	public String getHdfc_pan() {
		return hdfc_pan;
	}

	public void setHdfc_pan(String hdfc_pan) {
		this.hdfc_pan = hdfc_pan;
	}

	public String getHdfc_state_code() {
		return hdfc_state_code;
	}

	public void setHdfc_state_code(String hdfc_state_code) {
		this.hdfc_state_code = hdfc_state_code;
	}

	public BigDecimal getSf_od() {
		return sf_od;
	}

	public void setSf_od(BigDecimal sf_od) {
		this.sf_od = sf_od;
	}

	public BigDecimal getSf_tp() {
		return sf_tp;
	}

	public void setSf_tp(BigDecimal sf_tp) {
		this.sf_tp = sf_tp;
	}

	public String getPayee_login() {
		return payee_login;
	}

	public void setPayee_login(String payee_login) {
		this.payee_login = payee_login;
	}

	public String getMdm_product_name() {
		return mdm_product_name;
	}

	public void setMdm_product_name(String mdm_product_name) {
		this.mdm_product_name = mdm_product_name;
	}

	public String getPol_endorsement_num() {
		return pol_endorsement_num;
	}

	public void setPol_endorsement_num(String pol_endorsement_num) {
		this.pol_endorsement_num = pol_endorsement_num;
	}

	public String getPol_deal_num() {
		return pol_deal_num;
	}

	public void setPol_deal_num(String pol_deal_num) {
		this.pol_deal_num = pol_deal_num;
	}

	public String getPol_src_state() {
		return pol_src_state;
	}

	public void setPol_src_state(String pol_src_state) {
		this.pol_src_state = pol_src_state;
	}

	public String getPol_destn_state() {
		return pol_destn_state;
	}

	public void setPol_destn_state(String pol_destn_state) {
		this.pol_destn_state = pol_destn_state;
	}

	public String getPol_insurance_type() {
		return pol_insurance_type;
	}

	public void setPol_insurance_type(String pol_insurance_type) {
		this.pol_insurance_type = pol_insurance_type;
	}

	public String getPol_tag() {
		return pol_tag;
	}

	public void setPol_tag(String pol_tag) {
		this.pol_tag = pol_tag;
	}

	public String getTerrorism_premium() {
		return terrorism_premium;
	}

	public void setTerrorism_premium(String terrorism_premium) {
		this.terrorism_premium = terrorism_premium;
	}

	public BigDecimal getCbp_total_amount() {
		return cbp_total_amount;
	}

	public void setCbp_total_amount(BigDecimal cbp_total_amount) {
		this.cbp_total_amount = cbp_total_amount;
	}

	public String getPcv_rto_code_flag() {
		return pcv_rto_code_flag;
	}

	public void setPcv_rto_code_flag(String pcv_rto_code_flag) {
		this.pcv_rto_code_flag = pcv_rto_code_flag;
	}

	public String getRenewal_flag() {
		return renewal_flag;
	}

	public void setRenewal_flag(String renewal_flag) {
		this.renewal_flag = renewal_flag;
	}

	public BigDecimal getFinal_bde() {
		return final_bde;
	}

	public void setFinal_bde(BigDecimal final_bde) {
		this.final_bde = final_bde;
	}

	public String getPolicy_no_with_backslash() {
		return policy_no_with_backslash;
	}

	public void setPolicy_no_with_backslash(String policy_no_with_backslash) {
		this.policy_no_with_backslash = policy_no_with_backslash;
	}

	public String getPol_agent_code_with_backslash() {
		return pol_agent_code_with_backslash;
	}

	public void setPol_agent_code_with_backslash(String pol_agent_code_with_backslash) {
		this.pol_agent_code_with_backslash = pol_agent_code_with_backslash;
	}

	public String getPol_certificate_number_with_backslah() {
		return pol_certificate_number_with_backslah;
	}

	public void setPol_certificate_number_with_backslah(String pol_certificate_number_with_backslah) {
		this.pol_certificate_number_with_backslah = pol_certificate_number_with_backslah;
	}

	public String getPol_super_parent_code_with_backslah() {
		return pol_super_parent_code_with_backslah;
	}

	public void setPol_super_parent_code_with_backslah(String pol_super_parent_code_with_backslah) {
		this.pol_super_parent_code_with_backslah = pol_super_parent_code_with_backslah;
	}

	public String getPid_status() {
		return pid_status;
	}

	public void setPid_status(String pid_status) {
		this.pid_status = pid_status;
	}

	public BigDecimal getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(BigDecimal payableAmount) {
		this.payableAmount = payableAmount;
	}

	public BigDecimal getHoldAmount() {
		return holdAmount;
	}

	public void setHoldAmount(BigDecimal holdAmount) {
		this.holdAmount = holdAmount;
	}

	public String getPolicy_hold_flag() {
		return policy_hold_flag;
	}

	public void setPolicy_hold_flag(String policy_hold_flag) {
		this.policy_hold_flag = policy_hold_flag;
	}

	public String getPolicy_hold_remark() {
		return policy_hold_remark;
	}

	public void setPolicy_hold_remark(String policy_hold_remark) {
		this.policy_hold_remark = policy_hold_remark;
	}

	public String getLicense_flag() {
		return license_flag;
	}

	public void setLicense_flag(String license_flag) {
		this.license_flag = license_flag;
	}

	public String getAgent_inactive_flag() {
		return agent_inactive_flag;
	}

	public void setAgent_inactive_flag(String agent_inactive_flag) {
		this.agent_inactive_flag = agent_inactive_flag;
	}

	public String getInvoiceFlag() {
		return invoiceFlag;
	}

	public void setInvoiceFlag(String invoiceFlag) {
		this.invoiceFlag = invoiceFlag;
	}

	public String getPid_hold_status() {
		return pid_hold_status;
	}

	public void setPid_hold_status(String pid_hold_status) {
		this.pid_hold_status = pid_hold_status;
	}

	public String getHoldStatus() {
		return holdStatus;
	}

	public void setHoldStatus(String holdStatus) {
		this.holdStatus = holdStatus;
	}

	public String getHold_reason() {
		return hold_reason;
	}

	public void setHold_reason(String hold_reason) {
		this.hold_reason = hold_reason;
	}

	public Long getPayout_comp_id() {
		return payout_comp_id;
	}

	public void setPayout_comp_id(Long payout_comp_id) {
		this.payout_comp_id = payout_comp_id;
	}

	public String getReadyForRelease() {
		return readyForRelease;
	}

	public void setReadyForRelease(String readyForRelease) {
		this.readyForRelease = readyForRelease;
	}

	public BigDecimal getReleasedAmount() {
		return releasedAmount;
	}

	public void setReleasedAmount(BigDecimal releasedAmount) {
		this.releasedAmount = releasedAmount;
	}

	public Object getOutputData() {
		return outputData;
	}

	public void setOutputData(Object outputData) {
		this.outputData = outputData;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Object getInputData() {
		return inputData;
	}

	public void setInputData(Object inputData) {
		this.inputData = inputData;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getPayout_processing_request_id() {
		return payout_processing_request_id;
	}

	public void setPayout_processing_request_id(Long payout_processing_request_id) {
		this.payout_processing_request_id = payout_processing_request_id;
	}

	public String getWorkflow_details() {
		return workflow_details;
	}

	public void setWorkflow_details(String workflow_details) {
		this.workflow_details = workflow_details;
	}

	public Long getComponent_source_id() {
		return component_source_id;
	}

	public void setComponent_source_id(Long component_source_id) {
		this.component_source_id = component_source_id;
	}

	public String getReleaseGroup() {
		return releaseGroup;
	}

	public void setReleaseGroup(String releaseGroup) {
		this.releaseGroup = releaseGroup;
	}

	public BigDecimal getPrev_final_percentage() {
		return prev_final_percentage;
	}

	public void setPrev_final_percentage(BigDecimal prev_final_percentage) {
		this.prev_final_percentage = prev_final_percentage;
	}

	public BigDecimal getPrev_final_commision() {
		return prev_final_commision;
	}

	public void setPrev_final_commision(BigDecimal prev_final_commision) {
		this.prev_final_commision = prev_final_commision;
	}

	public String getAgency_constitution() {
		return agency_constitution;
	}

	public void setAgency_constitution(String agency_constitution) {
		this.agency_constitution = agency_constitution;
	}

	public String getLic_exp_hold_status() {
		return lic_exp_hold_status;
	}

	public void setLic_exp_hold_status(String lic_exp_hold_status) {
		this.lic_exp_hold_status = lic_exp_hold_status;
	}

	public String getInput1() {
		return input1;
	}

	public void setInput1(String input1) {
		this.input1 = input1;
	}

	public List<String> getOutput1() {
		return output1;
	}

	public void setOutput1(List<String> output1) {
		this.output1 = output1;
	}

}
