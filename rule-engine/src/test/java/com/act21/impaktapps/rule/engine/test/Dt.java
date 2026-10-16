package com.act21.impaktapps.rule.engine.test;

import java.math.BigDecimal;
import java.util.Date;

public class Dt {

	private Long input1;
	private String input2;
	private String input3;
	private String input4;
	private String output1;
	private String output2;
	private String ruleId;
	private String ruleId2;
	private String vertical_desc;
	private String final_vertical_desc;
	private BigDecimal total_volume;
	private BigDecimal vol_payout_perc;
	private BigDecimal payable_amount;
	private BigDecimal tempperc;
	private Date disb_date;
	private String cg6_segment;
	private String cg6_discount;
    private String cg6_slab;
    private String policy_no;
    private String intermediary;
    private String intermediary_Code;
    private String pan_no;
    private String intermediary_Category;
    private String tds_rate;
    private BigDecimal tds_exemption_limit;
    private BigDecimal tds_exemption_rate;
    private Date tds_certificate_start_date;
    private Date tds_certificate_end_date;
    
    private BigDecimal bomriskbkt;
    private BigDecimal soa_eff;
    private BigDecimal soa_rate;
    
    private String policyType;
    private String vehicle_Group_Name;
    private String businessType;
    private String state_code;
    private String rto_code;
    
    private String state_Group_Name;
    private String pvt_car_state_group;
    
    private String declined_flag;
    
    private String product;
    
    private BigDecimal primeTopnetSum;
    
    private BigDecimal rateperslab;
    private String remarks;
    
    private String comp_name;
    private String desc_prm;
    
    private BigDecimal incent_rate;
    private BigDecimal bm_rate;
    private String staff_cases;
    private BigDecimal special_scheme_rate;
    
    private String siso_tagging;
    private String standard_policy;
    private String ft_status;
    private String product_type;
    private BigDecimal fp;
    private Long c_booking_frequency;
    
    private String product_code;
    private Long premium_term;
    
    private String premium_payment_type;
    private String wrop_rop_flag;
    private Long benefit_term;
    private BigDecimal product_credit;
    
    private BigDecimal persistency_13_month_pct;
    private BigDecimal persistency_13_slab;
    
    private String vendor_code;
    private String totalBussinessVolumeUsedCar;
    
    private String productflag;

    private String pretaxirr;

    private String tenure;
    private Boolean specialChannelFlag;
    
    
 private BigDecimal total_ulip_premium;
 private BigDecimal ulip_payout_slab;
 
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    public String getVendor_code() {
	return vendor_code;
}

public void setVendor_code(String vendor_code) {
	this.vendor_code = vendor_code;
}

public String getTotalBussinessVolumeUsedCar() {
	return totalBussinessVolumeUsedCar;
}

public void setTotalBussinessVolumeUsedCar(String totalBussinessVolumeUsedCar) {
	this.totalBussinessVolumeUsedCar = totalBussinessVolumeUsedCar;
}

public String getProductflag() {
	return productflag;
}

public void setProductflag(String productflag) {
	this.productflag = productflag;
}

public String getPretaxirr() {
	return pretaxirr;
}

public void setPretaxirr(String pretaxirr) {
	this.pretaxirr = pretaxirr;
}

public String getTenure() {
	return tenure;
}

public void setTenure(String tenure) {
	this.tenure = tenure;
}

public Boolean getSpecialChannelFlag() {
	return specialChannelFlag;
}

public void setSpecialChannelFlag(Boolean specialChannelFlag) {
	this.specialChannelFlag = specialChannelFlag;
}

public BigDecimal getTotal_ulip_premium() {
	return total_ulip_premium;
}

public void setTotal_ulip_premium(BigDecimal total_ulip_premium) {
	this.total_ulip_premium = total_ulip_premium;
}

public BigDecimal getUlip_payout_slab() {
	return ulip_payout_slab;
}

public void setUlip_payout_slab(BigDecimal ulip_payout_slab) {
	this.ulip_payout_slab = ulip_payout_slab;
}

	public BigDecimal getPersistency_13_month_pct() {
		return persistency_13_month_pct;
	}

	public void setPersistency_13_month_pct(BigDecimal persistency_13_month_pct) {
		this.persistency_13_month_pct = persistency_13_month_pct;
	}

	public BigDecimal getPersistency_13_slab() {
		return persistency_13_slab;
	}

	public void setPersistency_13_slab(BigDecimal persistency_13_slab) {
		this.persistency_13_slab = persistency_13_slab;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public Long getPremium_term() {
		return premium_term;
	}

	public void setPremium_term(Long premium_term) {
		this.premium_term = premium_term;
	}

	public String getPremium_payment_type() {
		return premium_payment_type;
	}

	public void setPremium_payment_type(String premium_payment_type) {
		this.premium_payment_type = premium_payment_type;
	}

	public String getWrop_rop_flag() {
		return wrop_rop_flag;
	}

	public void setWrop_rop_flag(String wrop_rop_flag) {
		this.wrop_rop_flag = wrop_rop_flag;
	}

	public Long getBenefit_term() {
		return benefit_term;
	}

	public void setBenefit_term(Long benefit_term) {
		this.benefit_term = benefit_term;
	}

	public BigDecimal getProduct_credit() {
		return product_credit;
	}

	public void setProduct_credit(BigDecimal product_credit) {
		this.product_credit = product_credit;
	}

	public String getSiso_tagging() {
		return siso_tagging;
	}

	public void setSiso_tagging(String siso_tagging) {
		this.siso_tagging = siso_tagging;
	}

	public String getStandard_policy() {
		return standard_policy;
	}

	public void setStandard_policy(String standard_policy) {
		this.standard_policy = standard_policy;
	}

	public String getFt_status() {
		return ft_status;
	}

	public void setFt_status(String ft_status) {
		this.ft_status = ft_status;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public BigDecimal getFp() {
		return fp;
	}

	public void setFp(BigDecimal fp) {
		this.fp = fp;
	}

	public Long getC_booking_frequency() {
		return c_booking_frequency;
	}

	public void setC_booking_frequency(Long c_booking_frequency) {
		this.c_booking_frequency = c_booking_frequency;

	}

	public String getComp_name() {
		return comp_name;
	}

	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}

	public String getDesc_prm() {
		return desc_prm;
	}

	public void setDesc_prm(String desc_prm) {
		this.desc_prm = desc_prm;
	}

	public BigDecimal getIncent_rate() {
		return incent_rate;
	}

	public void setIncent_rate(BigDecimal incent_rate) {
		this.incent_rate = incent_rate;
	}

	public BigDecimal getBm_rate() {
		return bm_rate;
	}

	public void setBm_rate(BigDecimal bm_rate) {
		this.bm_rate = bm_rate;
	}

	public String getStaff_cases() {
		return staff_cases;
	}

	public void setStaff_cases(String staff_cases) {
		this.staff_cases = staff_cases;
	}

	public BigDecimal getSpecial_scheme_rate() {
		return special_scheme_rate;
	}

	public void setSpecial_scheme_rate(BigDecimal special_scheme_rate) {
		this.special_scheme_rate = special_scheme_rate;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public BigDecimal getPrimeTopnetSum() {
		return primeTopnetSum;
	}

	public void setPrimeTopnetSum(BigDecimal primeTopnetSum) {
		this.primeTopnetSum = primeTopnetSum;
	}

	public BigDecimal getRateperslab() {
		return rateperslab;
	}

	public void setRateperslab(BigDecimal rateperslab) {
		this.rateperslab = rateperslab;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getVehicle_Group_Name() {
		return vehicle_Group_Name;
	}

	public void setVehicle_Group_Name(String vehicle_Group_Name) {
		this.vehicle_Group_Name = vehicle_Group_Name;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getState_code() {
		return state_code;
	}

	public void setState_code(String state_code) {
		this.state_code = state_code;
	}

	public String getRto_code() {
		return rto_code;
	}

	public void setRto_code(String rto_code) {
		this.rto_code = rto_code;
	}

	public String getState_Group_Name() {
		return state_Group_Name;
	}

	public void setState_Group_Name(String state_Group_Name) {
		this.state_Group_Name = state_Group_Name;
	}

	public String getPvt_car_state_group() {
		return pvt_car_state_group;
	}

	public void setPvt_car_state_group(String pvt_car_state_group) {
		this.pvt_car_state_group = pvt_car_state_group;
	}

	public String getDeclined_flag() {
		return declined_flag;
	}

	public void setDeclined_flag(String declined_flag) {
		this.declined_flag = declined_flag;
	}

	private String prod;
    private String npaStage;
    private BigDecimal comm_capping;
    
    

	public String getProd() {
		return prod;
	}

	public void setProd(String prod) {
		this.prod = prod;
	}

	public String getNpaStage() {
		return npaStage;
	}

	public void setNpaStage(String npaStage) {
		this.npaStage = npaStage;
	}

	public BigDecimal getComm_capping() {
		return comm_capping;
	}

	public void setComm_capping(BigDecimal comm_capping) {
		this.comm_capping = comm_capping;
	}

	public BigDecimal getBomriskbkt() {
		return bomriskbkt;
	}

	public void setBomriskbkt(BigDecimal bomriskbkt) {
		this.bomriskbkt = bomriskbkt;
	}

	public BigDecimal getSoa_eff() {
		return soa_eff;
	}

	public void setSoa_eff(BigDecimal soa_eff) {
		this.soa_eff = soa_eff;
	}

	public BigDecimal getSoa_rate() {
		return soa_rate;
	}

	public void setSoa_rate(BigDecimal soa_rate) {
		this.soa_rate = soa_rate;
	}

	public String getIntermediary() {
		return intermediary;
	}

	public void setIntermediary(String intermediary) {
		this.intermediary = intermediary;
	}

	public String getIntermediary_Code() {
		return intermediary_Code;
	}

	public void setIntermediary_Code(String intermediary_Code) {
		this.intermediary_Code = intermediary_Code;
	}

	public String getPan_no() {
		return pan_no;
	}

	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}

	public String getIntermediary_Category() {
		return intermediary_Category;
	}

	public void setIntermediary_Category(String intermediary_Category) {
		this.intermediary_Category = intermediary_Category;
	}

	public String getTds_rate() {
		return tds_rate;
	}

	public void setTds_rate(String tds_rate) {
		this.tds_rate = tds_rate;
	}

	public BigDecimal getTds_exemption_limit() {
		return tds_exemption_limit;
	}

	public void setTds_exemption_limit(BigDecimal tds_exemption_limit) {
		this.tds_exemption_limit = tds_exemption_limit;
	}

	public BigDecimal getTds_exemption_rate() {
		return tds_exemption_rate;
	}

	public void setTds_exemption_rate(BigDecimal tds_exemption_rate) {
		this.tds_exemption_rate = tds_exemption_rate;
	}

	public Date getTds_certificate_start_date() {
		return tds_certificate_start_date;
	}

	public void setTds_certificate_start_date(Date tds_certificate_start_date) {
		this.tds_certificate_start_date = tds_certificate_start_date;
	}

	public Date getTds_certificate_end_date() {
		return tds_certificate_end_date;
	}

	public void setTds_certificate_end_date(Date tds_certificate_end_date) {
		this.tds_certificate_end_date = tds_certificate_end_date;
	}

	public String getPolicy_no() {
		return policy_no;
	}

	public void setPolicy_no(String policy_no) {
		this.policy_no = policy_no;
	}

	public Date getDisb_date() {
		return disb_date;
	}

	public void setDisb_date(Date disb_date) {
		this.disb_date = disb_date;
	}

	public BigDecimal getVol_payout_perc() {
		return vol_payout_perc;
	}

	public void setVol_payout_perc(BigDecimal vol_payout_perc) {
		this.vol_payout_perc = vol_payout_perc;
	}

	public BigDecimal getPayable_amount() {
		return payable_amount;
	}

	public void setPayable_amount(BigDecimal payable_amount) {
		this.payable_amount = payable_amount;
	}

	public synchronized BigDecimal getTempperc() {
		return tempperc;
	}

	public synchronized void setTempperc(BigDecimal tempperc) {
		this.tempperc = tempperc;
	}

	private BigDecimal sf_comm_perc;
	private String cg1_segment;
	private String state_rank;
	private String cg1_slab;
	
	

	public String getCg6_segment() {
		return cg6_segment;
	}

	public void setCg6_segment(String cg6_segment) {
		this.cg6_segment = cg6_segment;
	}

	public String getCg6_discount() {
		return cg6_discount;
	}

	public void setCg6_discount(String cg6_discount) {
		this.cg6_discount = cg6_discount;
	}

	public String getCg6_slab() {
		return cg6_slab;
	}

	public void setCg6_slab(String cg6_slab) {
		this.cg6_slab = cg6_slab;
	}

	public synchronized BigDecimal getTotal_volume() {
		return total_volume;
	}

	public synchronized void setTotal_volume(BigDecimal total_volume) {
		this.total_volume = total_volume;
	}

	

	public String getVertical_desc() {
		return vertical_desc;
	}

	public void setVertical_desc(String vertical_desc) {
		this.vertical_desc = vertical_desc;
	}

	public String getFinal_vertical_desc() {
		return final_vertical_desc;
	}

	public void setFinal_vertical_desc(String final_vertical_desc) {
		this.final_vertical_desc = final_vertical_desc;
	}

	public BigDecimal getSf_comm_perc() {
		return sf_comm_perc;
	}

	public void setSf_comm_perc(BigDecimal sf_comm_perc) {
		this.sf_comm_perc = sf_comm_perc;
	}

	public String getCg1_segment() {
		return cg1_segment;
	}

	public void setCg1_segment(String cg1_segment) {
		this.cg1_segment = cg1_segment;
	}

	public String getState_rank() {
		return state_rank;
	}

	public void setState_rank(String state_rank) {
		this.state_rank = state_rank;
	}

	public String getCg1_slab() {
		return cg1_slab;
	}

	public void setCg1_slab(String cg1_slab) {
		this.cg1_slab = cg1_slab;
	}

	public synchronized Long getInput1() {
		return input1;
	}

	public synchronized void setInput1(Long input1) {
		this.input1 = input1;
	}

	public synchronized String getOutput2() {
		return output2;
	}

	public synchronized void setOutput2(String output2) {
		this.output2 = output2;
	}

	public synchronized String getRuleId() {
		return ruleId;
	}

	public synchronized void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public synchronized String getRuleId2() {
		return ruleId2;
	}

	public synchronized void setRuleId2(String ruleId2) {
		this.ruleId2 = ruleId2;
	}

	public synchronized String getInput2() {
		return input2;
	}

	public synchronized void setInput2(String input2) {
		this.input2 = input2;
	}

	public synchronized String getInput3() {
		return input3;
	}

	public synchronized void setInput3(String input3) {
		this.input3 = input3;
	}

	public synchronized String getInput4() {
		return input4;
	}

	public synchronized void setInput4(String input4) {
		this.input4 = input4;
	}

	public synchronized String getOutput1() {
		return output1;
	}

	public synchronized void setOutput1(String output1) {
		this.output1 = output1;
	}

}
