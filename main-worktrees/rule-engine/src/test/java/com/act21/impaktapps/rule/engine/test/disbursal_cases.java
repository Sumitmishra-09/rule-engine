package com.act21.impaktapps.rule.engine.test;


import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
	import java.math.BigDecimal;
	import java.util.Date;
	
	
	public class disbursal_cases implements Serializable{
		
	   	private  String branchdesc;
	   	private  String desc_prm;
	   	private  String productflag;
	   	private  String brokername;
	   	private  String supplierdesc;
	   	private  String firstsource;
	   	private  BigDecimal assetcost;
	   	private  BigDecimal advemifromdealer;
	   	private  BigDecimal advemifromcust;
	   	private  BigDecimal ploughbk;
	   	private  BigDecimal margin_money;
	   	private  BigDecimal disbursalamount;
	   	private  BigDecimal cnc_top_up_amt;
	   	private  BigDecimal net_disbursment;
	   	private  Long branchid;
	   	private  String description_prm_code;
	   	private  BigDecimal effrate;
	   	private  BigDecimal advanceinstl;
	   	private  String assetdesc;
	   	private  BigDecimal schemeid;
	   	private  String schemedesc;
	   	private  BigDecimal gross_ltv;
	   	private  BigDecimal net_ltv;
	   	private  String customername;
	   	private  String ltsno;
	   	private  BigDecimal promotionid;
	   	private  String promotiondesc;
	   	private  String comp_name;
	   	private  Long cibil_score;
	   	private  BigDecimal agreement_no;
	   	private  BigDecimal old_agreement_no;
	   	private  BigDecimal amtfin;
	   	private  BigDecimal agreement_amount;
	   	private  String account_no_c;
	   	private  String internal_external_c;
	   	private  String laa_product_id_c;
	   	private  String product_name;
	   	private  BigDecimal amtfin_los;
	   	private  String is_dirty;
	   	private  String prm_code;
	   	private  String pdd;
	   	private  String location;
	   	private  String vendor_dvu_satus;
	   	private  String tdsVendorType;
	   	private  String otc;
	   	private  String cancel;
	   	private  String tdsvendortype;
	   	private  String gstregisteredstatus;
	   	private  String dvu;
	   	private  String carmodel;
	   	private  String vendorStatePos;
	   	private  String city;
	   	private  String hdfcBranchId;
	   	private  String hdfcBranchDesc;
	   	private  String digitalCase;
	   	private  String rebook;
	   	private  String is_delete;
	   	private  BigDecimal deduction_Amount;
	   	private  String deduction_Detail;
	   	private  String hold;
	   	private  String gl_Ac_Number;
	   	private  String recovery_Remark;
	   	private  String product;
	   	private  BigDecimal wirrLess10lakh;
	   	private  BigDecimal wirrGreater10lakh;
	   	private  String hold_status_dvu;
	   	private  String hold_status_vendorMaster;
	   	private  String disbursal_date;
	   	private  String vendormasterDetailsFlag;
	   	private  String hold_status_pe;
	   	private  String program_Name;
	   	private  String fileNo_DisbNo;
	   	private  String fileNO;
	   	private  Long disbNO;
	   	private  BigDecimal sanction_AMT;
	   	private  BigDecimal disb_AMT;
	   	private  String actualDate;
	   	private  String actualempNo;
	   	private  String cat;
	   	private  String channel;
	   	private  String empCode;
	   	private  String fresh;
	   	private  String productType;
	   	private  String month;
	   	private  Long year;
	   	private  String psl_Tagging;
	   	private  BigDecimal processing_Fee;
	   	private  String constitution;
	   	private  BigDecimal rate;
	   	private  BigDecimal commission;
	   	private  String posCode;
	   	private  String posStateName;
	   	private  String finBill;
	   	private  String payout_source;
	   	private  BigDecimal totalDisbursalAmount;
	   	private  String payoutCategory;
	   	private  String posState;
	   	private  BigDecimal totaldisinLacs;
	   	private  String checkFlag;
	   	private  BigDecimal totaldisinCr;
	   	private  String locationCode;
	   	private  String hub_branch;
	   	private  String vendorSite;
	   	private  BigDecimal gstAdditionalRate;
	   	private  String remarkAmount;
	   	private  String productRemark;
	   	private  String agreementid;
	   	private  String vendor_code;
	   	private  BigDecimal perCaseAmount;
	   	private  BigDecimal rateSlab;
	   	private  BigDecimal wirr;
	   	private  BigDecimal tenureDeductionPerc;
	   	private  Long tenure;
	   	private  BigDecimal rateslabAfterTenureded;
	   	private  String loantype;
	   	private  String carModel;
	   	private  String loancategry;
	   	private  String dsaType;
	   	private  String gsrRegistered;
	   	private  String actual_vendor_code;
	   	private  BigDecimal pddHoldAmount;
	   	private  Long id;
	   	private  BigDecimal tds;
	   	private  BigDecimal commisionBeforeGst;
	   	private  BigDecimal pretaxirr;
	   	private  BigDecimal finalWithRateGst;
	   	private  BigDecimal extraGst;
	   	private  String gst3PercentRemarks;
	   	private  String branchDesc;
	   	private  String descPrm;
	   	private  String supplierDesc;
	   	private  String firstSource;
	   	private  BigDecimal assestCost;
	   	private  BigDecimal procfee;
	   	private  BigDecimal plougHbk;
	   	private  BigDecimal marginMoney;
	   	private  BigDecimal cncTopAmount;
	   	private  String pos;
	   	private  String customerName;
	   	private  String promotionDesc;
	   	private  String compName;
	   	private  BigDecimal advEmiFromDealer;
	   	private  BigDecimal advEmiFRomCustometr;
	   	private  BigDecimal agrAfterGst;
	   	private  Long branchId;
	   	private  String hub;
	   	private  String state;
	   	private  String region;
	   	private  String zone;
	   	private  String regionHead;
	   	private  String zonalHead;
	   	private  String constitution_final;
	   	private  BigDecimal finalNetDisburseMent;
	   	private  BigDecimal amountFin;
	   	private  String loginDate;
	   	private  String promoCode;
	   	private  Long cibil;
	   	private  String vendorCodePos;
	   	private  BigDecimal cappingPerCent;
	   	private  BigDecimal totalBussinessVolumeUsedCar;
	   	private  BigDecimal netDisbursment;
	   	private  String assetDesc;
	   	private  String disbursaldate;
	   	private  BigDecimal booster;
	   	private  String cibilGrid;
	   	private  String vendor5digit;
	   	private  String regionDesc;
	   	private  String hdfcBranchid;
	   	private  BigDecimal commisionAfterAddGst;
	   	private  BigDecimal finalCommsionAfterPerCases;
	   	private  String make;
	   	private  BigDecimal perCasePercentage;
	   	private  BigDecimal perCasePerCAmount;
	   	private  Long vendorMasterId;
	   	private  BigDecimal supplierid;
	   	private  String imauthdate;
	   	private  BigDecimal manufacturerid;
	   	private  String manufacturerdesc;
	   	private  BigDecimal pa_ins_premium;
	   	private  BigDecimal ew_ins_premium;
	   	private  BigDecimal cp_ins_premium;
	   	private  BigDecimal transaction_fees_bank;
	   	private  String remarks;
	   	private  String deduction_reason;
	   	private  BigDecimal commissionBeforeGstTax;
	   	private  BigDecimal gst18;
	   	private  BigDecimal tdsAmount;
	   	private  String compostionFlag;
	   	private  String registeredUnregistered;
	   	private  String tdsType;
	   	private  BigDecimal grossBeforeGSTtaX;
	   	private  BigDecimal netValue;
	   	private  BigDecimal payableamountSum;
	   	private  String payoutMonth;
	   	private  BigDecimal pddReleaseAmount;
	   	private  String remapReason;
	   	private  BigDecimal internalPercaseAmt;
	   	private  Long source_id;
	   	private  String hold_status;
	   	private  Date modified_on;
	   	private  String release_group;
	   	private  BigDecimal payable_amount;
	   	private  String workflow_status;
	   	private  BigDecimal released_amount;
	   	private  BigDecimal hold_amount;
	   	private  String workflow_details;
	   	private  String process_business_key;
	   	private  BigDecimal payeePayableAmount;
	   	private  String type;
	   	private  String hold_reason;
	   	private  String ready_for_release;
	   	private  String name;
	   	private  Long payout_id;
	   	private  Long version;
	   	private  String status;
	   	private  Long tdsRate;
	   	private  String workflow_process_instance_id;
	   	private  BigDecimal rebookAppliedAmount;
	   	private  BigDecimal cancellationAppliedAmount;
	   	private  BigDecimal remapAppliedAmount;
	   	private  String pop;
	   	private  String vendorName;
	   	private  Long cases;
	   	private  String vendor_name;
	   	private  BigDecimal totalDsaBussinessVolume;
	   	private  String companyTypeIndvid;
	   	private  Boolean rateSlabRevisedFlag;
	   	private  Boolean gstAdditionalFlag;
	   	private  Boolean specialChannelFlag;
	   	public disbursal_cases() {
			branchdesc = "";
			desc_prm = "";
			productflag = "";
			brokername = "";
			supplierdesc = "";
			firstsource = "";
			assetcost = BigDecimal.ZERO;
			advemifromdealer = BigDecimal.ZERO;
			advemifromcust = BigDecimal.ZERO;
			ploughbk = BigDecimal.ZERO;
			margin_money = BigDecimal.ZERO;
			disbursalamount = BigDecimal.ZERO;
			cnc_top_up_amt = BigDecimal.ZERO;
			net_disbursment = BigDecimal.ZERO;
			branchid = 0L;
			description_prm_code = "";
			effrate = BigDecimal.ZERO;
			advanceinstl = BigDecimal.ZERO;
			assetdesc = "";
			schemeid = BigDecimal.ZERO;
			schemedesc = "";
			gross_ltv = BigDecimal.ZERO;
			net_ltv = BigDecimal.ZERO;
			customername = "";
			ltsno = "";
			promotionid = BigDecimal.ZERO;
			promotiondesc = "";
			comp_name = "";
			cibil_score = 0L;
			agreement_no = BigDecimal.ZERO;
			old_agreement_no = BigDecimal.ZERO;
			amtfin = BigDecimal.ZERO;
			agreement_amount = BigDecimal.ZERO;
			account_no_c = "";
			internal_external_c = "";
			laa_product_id_c = "";
			product_name = "";
			amtfin_los = BigDecimal.ZERO;
			is_dirty = "";
			prm_code = "";
			pdd = "";
			location = "";
			vendor_dvu_satus = "";
			tdsVendorType = "";
			otc = "";
			cancel = "";
			tdsvendortype = "";
			gstregisteredstatus = "";
			dvu = "";
			carmodel = "";
			vendorStatePos = "";
			city = "";
			hdfcBranchId = "";
			hdfcBranchDesc = "";
			digitalCase = "";
			rebook = "";
			is_delete = "";
			deduction_Amount = BigDecimal.ZERO;
			deduction_Detail = "";
			hold = "";
			gl_Ac_Number = "";
			recovery_Remark = "";
			product = "";
			wirrLess10lakh = BigDecimal.ZERO;
			wirrGreater10lakh = BigDecimal.ZERO;
			hold_status_dvu = "";
			hold_status_vendorMaster = "";
			disbursal_date = "";
			vendormasterDetailsFlag = "";
			hold_status_pe = "";
			program_Name = "";
			fileNo_DisbNo = "";
			fileNO = "";
			disbNO = 0L;
			sanction_AMT = BigDecimal.ZERO;
			disb_AMT = BigDecimal.ZERO;
			actualDate = "";
			actualempNo = "";
			cat = "";
			channel = "";
			empCode = "";
			fresh = "";
			productType = "";
			month = "";
			year = 0L;
			psl_Tagging = "";
			processing_Fee = BigDecimal.ZERO;
			constitution = "";
			rate = BigDecimal.ZERO;
			commission = BigDecimal.ZERO;
			posCode = "";
			posStateName = "";
			finBill = "";
			payout_source = "";
			totalDisbursalAmount = BigDecimal.ZERO;
			payoutCategory = "";
			posState = "";
			totaldisinLacs = BigDecimal.ZERO;
			checkFlag = "";
			totaldisinCr = BigDecimal.ZERO;
			locationCode = "";
			hub_branch = "";
			vendorSite = "";
			gstAdditionalRate = BigDecimal.ZERO;
			remarkAmount = "";
			productRemark = "";
			agreementid = "";
			vendor_code = "";
			perCaseAmount = BigDecimal.ZERO;
			rateSlab = BigDecimal.ZERO;
			wirr = BigDecimal.ZERO;
			tenureDeductionPerc = BigDecimal.ZERO;
			tenure = 0L;
			rateslabAfterTenureded = BigDecimal.ZERO;
			loantype = "";
			carModel = "";
			loancategry = "";
			dsaType = "";
			gsrRegistered = "";
			actual_vendor_code = "";
			pddHoldAmount = BigDecimal.ZERO;
			id = 0L;
			tds = BigDecimal.ZERO;
			commisionBeforeGst = BigDecimal.ZERO;
			pretaxirr = BigDecimal.ZERO;
			finalWithRateGst = BigDecimal.ZERO;
			extraGst = BigDecimal.ZERO;
			gst3PercentRemarks = "";
			branchDesc = "";
			descPrm = "";
			supplierDesc = "";
			firstSource = "";
			assestCost = BigDecimal.ZERO;
			procfee = BigDecimal.ZERO;
			plougHbk = BigDecimal.ZERO;
			marginMoney = BigDecimal.ZERO;
			cncTopAmount = BigDecimal.ZERO;
			pos = "";
			customerName = "";
			promotionDesc = "";
			compName = "";
			advEmiFromDealer = BigDecimal.ZERO;
			advEmiFRomCustometr = BigDecimal.ZERO;
			agrAfterGst = BigDecimal.ZERO;
			branchId = 0L;
			hub = "";
			state = "";
			region = "";
			zone = "";
			regionHead = "";
			zonalHead = "";
			constitution_final = "";
			finalNetDisburseMent = BigDecimal.ZERO;
			amountFin = BigDecimal.ZERO;
			loginDate = "";
			promoCode = "";
			cibil = 0L;
			vendorCodePos = "";
			cappingPerCent = BigDecimal.ZERO;
			totalBussinessVolumeUsedCar = BigDecimal.ZERO;
			netDisbursment = BigDecimal.ZERO;
			assetDesc = "";
			disbursaldate = "";
			booster = BigDecimal.ZERO;
			cibilGrid = "";
			vendor5digit = "";
			regionDesc = "";
			hdfcBranchid = "";
			commisionAfterAddGst = BigDecimal.ZERO;
			finalCommsionAfterPerCases = BigDecimal.ZERO;
			make = "";
			perCasePercentage = BigDecimal.ZERO;
			perCasePerCAmount = BigDecimal.ZERO;
			vendorMasterId = 0L;
			supplierid = BigDecimal.ZERO;
			imauthdate = "";
			manufacturerid = BigDecimal.ZERO;
			manufacturerdesc = "";
			pa_ins_premium = BigDecimal.ZERO;
			ew_ins_premium = BigDecimal.ZERO;
			cp_ins_premium = BigDecimal.ZERO;
			transaction_fees_bank = BigDecimal.ZERO;
			remarks = "";
			deduction_reason = "";
			commissionBeforeGstTax = BigDecimal.ZERO;
			gst18 = BigDecimal.ZERO;
			tdsAmount = BigDecimal.ZERO;
			compostionFlag = "";
			registeredUnregistered = "";
			tdsType = "";
			grossBeforeGSTtaX = BigDecimal.ZERO;
			netValue = BigDecimal.ZERO;
			payableamountSum = BigDecimal.ZERO;
			payoutMonth = "";
			pddReleaseAmount = BigDecimal.ZERO;
			remapReason = "";
			internalPercaseAmt = BigDecimal.ZERO;
			source_id = 0L;
			hold_status = "";
			modified_on = new Date();
			release_group = "";
			payable_amount = BigDecimal.ZERO;
			workflow_status = "";
			released_amount = BigDecimal.ZERO;
			hold_amount = BigDecimal.ZERO;
			workflow_details = "";
			process_business_key = "";
			payeePayableAmount = BigDecimal.ZERO;
			type = "";
			hold_reason = "";
			ready_for_release = "";
			name = "";
			payout_id = 0L;
			version = 0L;
			status = "";
			tdsRate = 0L;
			workflow_process_instance_id = "";
			rebookAppliedAmount = BigDecimal.ZERO;
			cancellationAppliedAmount = BigDecimal.ZERO;
			remapAppliedAmount = BigDecimal.ZERO;
			pop = "";
			vendorName = "";
			cases = 0L;
			vendor_name = "";
			totalDsaBussinessVolume = BigDecimal.ZERO;
			companyTypeIndvid = "";
			rateSlabRevisedFlag = false;
			gstAdditionalFlag = false;
			specialChannelFlag = false;
		}
		  	public String getBranchdesc(){
		  		return branchdesc;
		  	}
		  	public void setBranchdesc(String branchdesc){
		  	   	this.branchdesc=branchdesc;
		  	}
		  	   
		  	public String getDesc_prm(){
		  		return desc_prm;
		  	}
		  	public void setDesc_prm(String desc_prm){
		  	   	this.desc_prm=desc_prm;
		  	}
		  	   
		  	public String getProductflag(){
		  		return productflag;
		  	}
		  	public void setProductflag(String productflag){
		  	   	this.productflag=productflag;
		  	}
		  	   
		  	public String getBrokername(){
		  		return brokername;
		  	}
		  	public void setBrokername(String brokername){
		  	   	this.brokername=brokername;
		  	}
		  	   
		  	public String getSupplierdesc(){
		  		return supplierdesc;
		  	}
		  	public void setSupplierdesc(String supplierdesc){
		  	   	this.supplierdesc=supplierdesc;
		  	}
		  	   
		  	public String getFirstsource(){
		  		return firstsource;
		  	}
		  	public void setFirstsource(String firstsource){
		  	   	this.firstsource=firstsource;
		  	}
		  	   
		  	public BigDecimal getAssetcost(){
		  		return assetcost;
		  	}
		  	public void setAssetcost(BigDecimal assetcost){
		  	   	this.assetcost=assetcost;
		  	}
		  	   
		  	public BigDecimal getAdvemifromdealer(){
		  		return advemifromdealer;
		  	}
		  	public void setAdvemifromdealer(BigDecimal advemifromdealer){
		  	   	this.advemifromdealer=advemifromdealer;
		  	}
		  	   
		  	public BigDecimal getAdvemifromcust(){
		  		return advemifromcust;
		  	}
		  	public void setAdvemifromcust(BigDecimal advemifromcust){
		  	   	this.advemifromcust=advemifromcust;
		  	}
		  	   
		  	public BigDecimal getPloughbk(){
		  		return ploughbk;
		  	}
		  	public void setPloughbk(BigDecimal ploughbk){
		  	   	this.ploughbk=ploughbk;
		  	}
		  	   
		  	public BigDecimal getMargin_money(){
		  		return margin_money;
		  	}
		  	public void setMargin_money(BigDecimal margin_money){
		  	   	this.margin_money=margin_money;
		  	}
		  	   
		  	public BigDecimal getDisbursalamount(){
		  		return disbursalamount;
		  	}
		  	public void setDisbursalamount(BigDecimal disbursalamount){
		  	   	this.disbursalamount=disbursalamount;
		  	}
		  	   
		  	public BigDecimal getCnc_top_up_amt(){
		  		return cnc_top_up_amt;
		  	}
		  	public void setCnc_top_up_amt(BigDecimal cnc_top_up_amt){
		  	   	this.cnc_top_up_amt=cnc_top_up_amt;
		  	}
		  	   
		  	public BigDecimal getNet_disbursment(){
		  		return net_disbursment;
		  	}
		  	public void setNet_disbursment(BigDecimal net_disbursment){
		  	   	this.net_disbursment=net_disbursment;
		  	}
		  	   
		  	public Long getBranchid(){
		  		return branchid;
		  	}
		  	public void setBranchid(Long branchid){
		  	   	this.branchid=branchid;
		  	}
		  	   
		  	public String getDescription_prm_code(){
		  		return description_prm_code;
		  	}
		  	public void setDescription_prm_code(String description_prm_code){
		  	   	this.description_prm_code=description_prm_code;
		  	}
		  	   
		  	public BigDecimal getEffrate(){
		  		return effrate;
		  	}
		  	public void setEffrate(BigDecimal effrate){
		  	   	this.effrate=effrate;
		  	}
		  	   
		  	public BigDecimal getAdvanceinstl(){
		  		return advanceinstl;
		  	}
		  	public void setAdvanceinstl(BigDecimal advanceinstl){
		  	   	this.advanceinstl=advanceinstl;
		  	}
		  	   
		  	public String getAssetdesc(){
		  		return assetdesc;
		  	}
		  	public void setAssetdesc(String assetdesc){
		  	   	this.assetdesc=assetdesc;
		  	}
		  	   
		  	public BigDecimal getSchemeid(){
		  		return schemeid;
		  	}
		  	public void setSchemeid(BigDecimal schemeid){
		  	   	this.schemeid=schemeid;
		  	}
		  	   
		  	public String getSchemedesc(){
		  		return schemedesc;
		  	}
		  	public void setSchemedesc(String schemedesc){
		  	   	this.schemedesc=schemedesc;
		  	}
		  	   
		  	public BigDecimal getGross_ltv(){
		  		return gross_ltv;
		  	}
		  	public void setGross_ltv(BigDecimal gross_ltv){
		  	   	this.gross_ltv=gross_ltv;
		  	}
		  	   
		  	public BigDecimal getNet_ltv(){
		  		return net_ltv;
		  	}
		  	public void setNet_ltv(BigDecimal net_ltv){
		  	   	this.net_ltv=net_ltv;
		  	}
		  	   
		  	public String getCustomername(){
		  		return customername;
		  	}
		  	public void setCustomername(String customername){
		  	   	this.customername=customername;
		  	}
		  	   
		  	public String getLtsno(){
		  		return ltsno;
		  	}
		  	public void setLtsno(String ltsno){
		  	   	this.ltsno=ltsno;
		  	}
		  	   
		  	public BigDecimal getPromotionid(){
		  		return promotionid;
		  	}
		  	public void setPromotionid(BigDecimal promotionid){
		  	   	this.promotionid=promotionid;
		  	}
		  	   
		  	public String getPromotiondesc(){
		  		return promotiondesc;
		  	}
		  	public void setPromotiondesc(String promotiondesc){
		  	   	this.promotiondesc=promotiondesc;
		  	}
		  	   
		  	public String getComp_name(){
		  		return comp_name;
		  	}
		  	public void setComp_name(String comp_name){
		  	   	this.comp_name=comp_name;
		  	}
		  	   
		  	public Long getCibil_score(){
		  		return cibil_score;
		  	}
		  	public void setCibil_score(Long cibil_score){
		  	   	this.cibil_score=cibil_score;
		  	}
		  	   
		  	public BigDecimal getAgreement_no(){
		  		return agreement_no;
		  	}
		  	public void setAgreement_no(BigDecimal agreement_no){
		  	   	this.agreement_no=agreement_no;
		  	}
		  	   
		  	public BigDecimal getOld_agreement_no(){
		  		return old_agreement_no;
		  	}
		  	public void setOld_agreement_no(BigDecimal old_agreement_no){
		  	   	this.old_agreement_no=old_agreement_no;
		  	}
		  	   
		  	public BigDecimal getAmtfin(){
		  		return amtfin;
		  	}
		  	public void setAmtfin(BigDecimal amtfin){
		  	   	this.amtfin=amtfin;
		  	}
		  	   
		  	public BigDecimal getAgreement_amount(){
		  		return agreement_amount;
		  	}
		  	public void setAgreement_amount(BigDecimal agreement_amount){
		  	   	this.agreement_amount=agreement_amount;
		  	}
		  	   
		  	public String getAccount_no_c(){
		  		return account_no_c;
		  	}
		  	public void setAccount_no_c(String account_no_c){
		  	   	this.account_no_c=account_no_c;
		  	}
		  	   
		  	public String getInternal_external_c(){
		  		return internal_external_c;
		  	}
		  	public void setInternal_external_c(String internal_external_c){
		  	   	this.internal_external_c=internal_external_c;
		  	}
		  	   
		  	public String getLaa_product_id_c(){
		  		return laa_product_id_c;
		  	}
		  	public void setLaa_product_id_c(String laa_product_id_c){
		  	   	this.laa_product_id_c=laa_product_id_c;
		  	}
		  	   
		  	public String getProduct_name(){
		  		return product_name;
		  	}
		  	public void setProduct_name(String product_name){
		  	   	this.product_name=product_name;
		  	}
		  	   
		  	public BigDecimal getAmtfin_los(){
		  		return amtfin_los;
		  	}
		  	public void setAmtfin_los(BigDecimal amtfin_los){
		  	   	this.amtfin_los=amtfin_los;
		  	}
		  	   
		  	public String getIs_dirty(){
		  		return is_dirty;
		  	}
		  	public void setIs_dirty(String is_dirty){
		  	   	this.is_dirty=is_dirty;
		  	}
		  	   
		  	public String getPrm_code(){
		  		return prm_code;
		  	}
		  	public void setPrm_code(String prm_code){
		  	   	this.prm_code=prm_code;
		  	}
		  	   
		  	public String getPdd(){
		  		return pdd;
		  	}
		  	public void setPdd(String pdd){
		  	   	this.pdd=pdd;
		  	}
		  	   
		  	public String getLocation(){
		  		return location;
		  	}
		  	public void setLocation(String location){
		  	   	this.location=location;
		  	}
		  	   
		  	public String getVendor_dvu_satus(){
		  		return vendor_dvu_satus;
		  	}
		  	public void setVendor_dvu_satus(String vendor_dvu_satus){
		  	   	this.vendor_dvu_satus=vendor_dvu_satus;
		  	}
		  	   
		  	public String getTdsVendorType(){
		  		return tdsVendorType;
		  	}
		  	public void setTdsVendorType(String tdsVendorType){
		  	   	this.tdsVendorType=tdsVendorType;
		  	}
		  	   
		  	public String getOtc(){
		  		return otc;
		  	}
		  	public void setOtc(String otc){
		  	   	this.otc=otc;
		  	}
		  	   
		  	public String getCancel(){
		  		return cancel;
		  	}
		  	public void setCancel(String cancel){
		  	   	this.cancel=cancel;
		  	}
		  	   
		  	public String getTdsvendortype(){
		  		return tdsvendortype;
		  	}
		  	public void setTdsvendortype(String tdsvendortype){
		  	   	this.tdsvendortype=tdsvendortype;
		  	}
		  	   
		  	public String getGstregisteredstatus(){
		  		return gstregisteredstatus;
		  	}
		  	public void setGstregisteredstatus(String gstregisteredstatus){
		  	   	this.gstregisteredstatus=gstregisteredstatus;
		  	}
		  	   
		  	public String getDvu(){
		  		return dvu;
		  	}
		  	public void setDvu(String dvu){
		  	   	this.dvu=dvu;
		  	}
		  	   
		  	public String getCarmodel(){
		  		return carmodel;
		  	}
		  	public void setCarmodel(String carmodel){
		  	   	this.carmodel=carmodel;
		  	}
		  	   
		  	public String getVendorStatePos(){
		  		return vendorStatePos;
		  	}
		  	public void setVendorStatePos(String vendorStatePos){
		  	   	this.vendorStatePos=vendorStatePos;
		  	}
		  	   
		  	public String getCity(){
		  		return city;
		  	}
		  	public void setCity(String city){
		  	   	this.city=city;
		  	}
		  	   
		  	public String getHdfcBranchId(){
		  		return hdfcBranchId;
		  	}
		  	public void setHdfcBranchId(String hdfcBranchId){
		  	   	this.hdfcBranchId=hdfcBranchId;
		  	}
		  	   
		  	public String getHdfcBranchDesc(){
		  		return hdfcBranchDesc;
		  	}
		  	public void setHdfcBranchDesc(String hdfcBranchDesc){
		  	   	this.hdfcBranchDesc=hdfcBranchDesc;
		  	}
		  	   
		  	public String getDigitalCase(){
		  		return digitalCase;
		  	}
		  	public void setDigitalCase(String digitalCase){
		  	   	this.digitalCase=digitalCase;
		  	}
		  	   
		  	public String getRebook(){
		  		return rebook;
		  	}
		  	public void setRebook(String rebook){
		  	   	this.rebook=rebook;
		  	}
		  	   
		  	public String getIs_delete(){
		  		return is_delete;
		  	}
		  	public void setIs_delete(String is_delete){
		  	   	this.is_delete=is_delete;
		  	}
		  	   
		  	public BigDecimal getDeduction_Amount(){
		  		return deduction_Amount;
		  	}
		  	public void setDeduction_Amount(BigDecimal deduction_Amount){
		  	   	this.deduction_Amount=deduction_Amount;
		  	}
		  	   
		  	public String getDeduction_Detail(){
		  		return deduction_Detail;
		  	}
		  	public void setDeduction_Detail(String deduction_Detail){
		  	   	this.deduction_Detail=deduction_Detail;
		  	}
		  	   
		  	public String getHold(){
		  		return hold;
		  	}
		  	public void setHold(String hold){
		  	   	this.hold=hold;
		  	}
		  	   
		  	public String getGl_Ac_Number(){
		  		return gl_Ac_Number;
		  	}
		  	public void setGl_Ac_Number(String gl_Ac_Number){
		  	   	this.gl_Ac_Number=gl_Ac_Number;
		  	}
		  	   
		  	public String getRecovery_Remark(){
		  		return recovery_Remark;
		  	}
		  	public void setRecovery_Remark(String recovery_Remark){
		  	   	this.recovery_Remark=recovery_Remark;
		  	}
		  	   
		  	public String getProduct(){
		  		return product;
		  	}
		  	public void setProduct(String product){
		  	   	this.product=product;
		  	}
		  	   
		  	public BigDecimal getWirrLess10lakh(){
		  		return wirrLess10lakh;
		  	}
		  	public void setWirrLess10lakh(BigDecimal wirrLess10lakh){
		  	   	this.wirrLess10lakh=wirrLess10lakh;
		  	}
		  	   
		  	public BigDecimal getWirrGreater10lakh(){
		  		return wirrGreater10lakh;
		  	}
		  	public void setWirrGreater10lakh(BigDecimal wirrGreater10lakh){
		  	   	this.wirrGreater10lakh=wirrGreater10lakh;
		  	}
		  	   
		  	public String getHold_status_dvu(){
		  		return hold_status_dvu;
		  	}
		  	public void setHold_status_dvu(String hold_status_dvu){
		  	   	this.hold_status_dvu=hold_status_dvu;
		  	}
		  	   
		  	public String getHold_status_vendorMaster(){
		  		return hold_status_vendorMaster;
		  	}
		  	public void setHold_status_vendorMaster(String hold_status_vendorMaster){
		  	   	this.hold_status_vendorMaster=hold_status_vendorMaster;
		  	}
		  	   
		  	public String getDisbursal_date(){
		  		return disbursal_date;
		  	}
		  	public void setDisbursal_date(String disbursal_date){
		  	   	this.disbursal_date=disbursal_date;
		  	}
		  	   
		  	public String getVendormasterDetailsFlag(){
		  		return vendormasterDetailsFlag;
		  	}
		  	public void setVendormasterDetailsFlag(String vendormasterDetailsFlag){
		  	   	this.vendormasterDetailsFlag=vendormasterDetailsFlag;
		  	}
		  	   
		  	public String getHold_status_pe(){
		  		return hold_status_pe;
		  	}
		  	public void setHold_status_pe(String hold_status_pe){
		  	   	this.hold_status_pe=hold_status_pe;
		  	}
		  	   
		  	public String getProgram_Name(){
		  		return program_Name;
		  	}
		  	public void setProgram_Name(String program_Name){
		  	   	this.program_Name=program_Name;
		  	}
		  	   
		  	public String getFileNo_DisbNo(){
		  		return fileNo_DisbNo;
		  	}
		  	public void setFileNo_DisbNo(String fileNo_DisbNo){
		  	   	this.fileNo_DisbNo=fileNo_DisbNo;
		  	}
		  	   
		  	public String getFileNO(){
		  		return fileNO;
		  	}
		  	public void setFileNO(String fileNO){
		  	   	this.fileNO=fileNO;
		  	}
		  	   
		  	public Long getDisbNO(){
		  		return disbNO;
		  	}
		  	public void setDisbNO(Long disbNO){
		  	   	this.disbNO=disbNO;
		  	}
		  	   
		  	public BigDecimal getSanction_AMT(){
		  		return sanction_AMT;
		  	}
		  	public void setSanction_AMT(BigDecimal sanction_AMT){
		  	   	this.sanction_AMT=sanction_AMT;
		  	}
		  	   
		  	public BigDecimal getDisb_AMT(){
		  		return disb_AMT;
		  	}
		  	public void setDisb_AMT(BigDecimal disb_AMT){
		  	   	this.disb_AMT=disb_AMT;
		  	}
		  	   
		  	public String getActualDate(){
		  		return actualDate;
		  	}
		  	public void setActualDate(String actualDate){
		  	   	this.actualDate=actualDate;
		  	}
		  	   
		  	public String getActualempNo(){
		  		return actualempNo;
		  	}
		  	public void setActualempNo(String actualempNo){
		  	   	this.actualempNo=actualempNo;
		  	}
		  	   
		  	public String getCat(){
		  		return cat;
		  	}
		  	public void setCat(String cat){
		  	   	this.cat=cat;
		  	}
		  	   
		  	public String getChannel(){
		  		return channel;
		  	}
		  	public void setChannel(String channel){
		  	   	this.channel=channel;
		  	}
		  	   
		  	public String getEmpCode(){
		  		return empCode;
		  	}
		  	public void setEmpCode(String empCode){
		  	   	this.empCode=empCode;
		  	}
		  	   
		  	public String getFresh(){
		  		return fresh;
		  	}
		  	public void setFresh(String fresh){
		  	   	this.fresh=fresh;
		  	}
		  	   
		  	public String getProductType(){
		  		return productType;
		  	}
		  	public void setProductType(String productType){
		  	   	this.productType=productType;
		  	}
		  	   
		  	public String getMonth(){
		  		return month;
		  	}
		  	public void setMonth(String month){
		  	   	this.month=month;
		  	}
		  	   
		  	public Long getYear(){
		  		return year;
		  	}
		  	public void setYear(Long year){
		  	   	this.year=year;
		  	}
		  	   
		  	public String getPsl_Tagging(){
		  		return psl_Tagging;
		  	}
		  	public void setPsl_Tagging(String psl_Tagging){
		  	   	this.psl_Tagging=psl_Tagging;
		  	}
		  	   
		  	public BigDecimal getProcessing_Fee(){
		  		return processing_Fee;
		  	}
		  	public void setProcessing_Fee(BigDecimal processing_Fee){
		  	   	this.processing_Fee=processing_Fee;
		  	}
		  	   
		  	public String getConstitution(){
		  		return constitution;
		  	}
		  	public void setConstitution(String constitution){
		  	   	this.constitution=constitution;
		  	}
		  	   
		  	public BigDecimal getRate(){
		  		return rate;
		  	}
		  	public void setRate(BigDecimal rate){
		  	   	this.rate=rate;
		  	}
		  	   
		  	public BigDecimal getCommission(){
		  		return commission;
		  	}
		  	public void setCommission(BigDecimal commission){
		  	   	this.commission=commission;
		  	}
		  	   
		  	public String getPosCode(){
		  		return posCode;
		  	}
		  	public void setPosCode(String posCode){
		  	   	this.posCode=posCode;
		  	}
		  	   
		  	public String getPosStateName(){
		  		return posStateName;
		  	}
		  	public void setPosStateName(String posStateName){
		  	   	this.posStateName=posStateName;
		  	}
		  	   
		  	public String getFinBill(){
		  		return finBill;
		  	}
		  	public void setFinBill(String finBill){
		  	   	this.finBill=finBill;
		  	}
		  	   
		  	public String getPayout_source(){
		  		return payout_source;
		  	}
		  	public void setPayout_source(String payout_source){
		  	   	this.payout_source=payout_source;
		  	}
		  	   
		  	public BigDecimal getTotalDisbursalAmount(){
		  		return totalDisbursalAmount;
		  	}
		  	public void setTotalDisbursalAmount(BigDecimal totalDisbursalAmount){
		  	   	this.totalDisbursalAmount=totalDisbursalAmount;
		  	}
		  	   
		  	public String getPayoutCategory(){
		  		return payoutCategory;
		  	}
		  	public void setPayoutCategory(String payoutCategory){
		  	   	this.payoutCategory=payoutCategory;
		  	}
		  	   
		  	public String getPosState(){
		  		return posState;
		  	}
		  	public void setPosState(String posState){
		  	   	this.posState=posState;
		  	}
		  	   
		  	public BigDecimal getTotaldisinLacs(){
		  		return totaldisinLacs;
		  	}
		  	public void setTotaldisinLacs(BigDecimal totaldisinLacs){
		  	   	this.totaldisinLacs=totaldisinLacs;
		  	}
		  	   
		  	public String getCheckFlag(){
		  		return checkFlag;
		  	}
		  	public void setCheckFlag(String checkFlag){
		  	   	this.checkFlag=checkFlag;
		  	}
		  	   
		  	public BigDecimal getTotaldisinCr(){
		  		return totaldisinCr;
		  	}
		  	public void setTotaldisinCr(BigDecimal totaldisinCr){
		  	   	this.totaldisinCr=totaldisinCr;
		  	}
		  	   
		  	public String getLocationCode(){
		  		return locationCode;
		  	}
		  	public void setLocationCode(String locationCode){
		  	   	this.locationCode=locationCode;
		  	}
		  	   
		  	public String getHub_branch(){
		  		return hub_branch;
		  	}
		  	public void setHub_branch(String hub_branch){
		  	   	this.hub_branch=hub_branch;
		  	}
		  	   
		  	public String getVendorSite(){
		  		return vendorSite;
		  	}
		  	public void setVendorSite(String vendorSite){
		  	   	this.vendorSite=vendorSite;
		  	}
		  	   
		  	public BigDecimal getGstAdditionalRate(){
		  		return gstAdditionalRate;
		  	}
		  	public void setGstAdditionalRate(BigDecimal gstAdditionalRate){
		  	   	this.gstAdditionalRate=gstAdditionalRate;
		  	}
		  	   
		  	public String getRemarkAmount(){
		  		return remarkAmount;
		  	}
		  	public void setRemarkAmount(String remarkAmount){
		  	   	this.remarkAmount=remarkAmount;
		  	}
		  	   
		  	public String getProductRemark(){
		  		return productRemark;
		  	}
		  	public void setProductRemark(String productRemark){
		  	   	this.productRemark=productRemark;
		  	}
		  	   
		  	public String getAgreementid(){
		  		return agreementid;
		  	}
		  	public void setAgreementid(String agreementid){
		  	   	this.agreementid=agreementid;
		  	}
		  	   
		  	public String getVendor_code(){
		  		return vendor_code;
		  	}
		  	public void setVendor_code(String vendor_code){
		  	   	this.vendor_code=vendor_code;
		  	}
		  	   
		  	public BigDecimal getPerCaseAmount(){
		  		return perCaseAmount;
		  	}
		  	public void setPerCaseAmount(BigDecimal perCaseAmount){
		  	   	this.perCaseAmount=perCaseAmount;
		  	}
		  	   
		  	public BigDecimal getRateSlab(){
		  		return rateSlab;
		  	}
		  	public void setRateSlab(BigDecimal rateSlab){
		  	   	this.rateSlab=rateSlab;
		  	}
		  	   
		  	public BigDecimal getWirr(){
		  		return wirr;
		  	}
		  	public void setWirr(BigDecimal wirr){
		  	   	this.wirr=wirr;
		  	}
		  	   
		  	public BigDecimal getTenureDeductionPerc(){
		  		return tenureDeductionPerc;
		  	}
		  	public void setTenureDeductionPerc(BigDecimal tenureDeductionPerc){
		  	   	this.tenureDeductionPerc=tenureDeductionPerc;
		  	}
		  	   
		  	public Long getTenure(){
		  		return tenure;
		  	}
		  	public void setTenure(Long tenure){
		  	   	this.tenure=tenure;
		  	}
		  	   
		  	public BigDecimal getRateslabAfterTenureded(){
		  		return rateslabAfterTenureded;
		  	}
		  	public void setRateslabAfterTenureded(BigDecimal rateslabAfterTenureded){
		  	   	this.rateslabAfterTenureded=rateslabAfterTenureded;
		  	}
		  	   
		  	public String getLoantype(){
		  		return loantype;
		  	}
		  	public void setLoantype(String loantype){
		  	   	this.loantype=loantype;
		  	}
		  	   
		  	public String getCarModel(){
		  		return carModel;
		  	}
		  	public void setCarModel(String carModel){
		  	   	this.carModel=carModel;
		  	}
		  	   
		  	public String getLoancategry(){
		  		return loancategry;
		  	}
		  	public void setLoancategry(String loancategry){
		  	   	this.loancategry=loancategry;
		  	}
		  	   
		  	public String getDsaType(){
		  		return dsaType;
		  	}
		  	public void setDsaType(String dsaType){
		  	   	this.dsaType=dsaType;
		  	}
		  	   
		  	public String getGsrRegistered(){
		  		return gsrRegistered;
		  	}
		  	public void setGsrRegistered(String gsrRegistered){
		  	   	this.gsrRegistered=gsrRegistered;
		  	}
		  	   
		  	public String getActual_vendor_code(){
		  		return actual_vendor_code;
		  	}
		  	public void setActual_vendor_code(String actual_vendor_code){
		  	   	this.actual_vendor_code=actual_vendor_code;
		  	}
		  	   
		  	public BigDecimal getPddHoldAmount(){
		  		return pddHoldAmount;
		  	}
		  	public void setPddHoldAmount(BigDecimal pddHoldAmount){
		  	   	this.pddHoldAmount=pddHoldAmount;
		  	}
		  	   
		  	public Long getId(){
		  		return id;
		  	}
		  	public void setId(Long id){
		  	   	this.id=id;
		  	}
		  	   
		  	public BigDecimal getTds(){
		  		return tds;
		  	}
		  	public void setTds(BigDecimal tds){
		  	   	this.tds=tds;
		  	}
		  	   
		  	public BigDecimal getCommisionBeforeGst(){
		  		return commisionBeforeGst;
		  	}
		  	public void setCommisionBeforeGst(BigDecimal commisionBeforeGst){
		  	   	this.commisionBeforeGst=commisionBeforeGst;
		  	}
		  	   
		  	public BigDecimal getPretaxirr(){
		  		return pretaxirr;
		  	}
		  	public void setPretaxirr(BigDecimal pretaxirr){
		  	   	this.pretaxirr=pretaxirr;
		  	}
		  	   
		  	public BigDecimal getFinalWithRateGst(){
		  		return finalWithRateGst;
		  	}
		  	public void setFinalWithRateGst(BigDecimal finalWithRateGst){
		  	   	this.finalWithRateGst=finalWithRateGst;
		  	}
		  	   
		  	public BigDecimal getExtraGst(){
		  		return extraGst;
		  	}
		  	public void setExtraGst(BigDecimal extraGst){
		  	   	this.extraGst=extraGst;
		  	}
		  	   
		  	public String getGst3PercentRemarks(){
		  		return gst3PercentRemarks;
		  	}
		  	public void setGst3PercentRemarks(String gst3PercentRemarks){
		  	   	this.gst3PercentRemarks=gst3PercentRemarks;
		  	}
		  	   
		  	public String getBranchDesc(){
		  		return branchDesc;
		  	}
		  	public void setBranchDesc(String branchDesc){
		  	   	this.branchDesc=branchDesc;
		  	}
		  	   
		  	public String getDescPrm(){
		  		return descPrm;
		  	}
		  	public void setDescPrm(String descPrm){
		  	   	this.descPrm=descPrm;
		  	}
		  	   
		  	public String getSupplierDesc(){
		  		return supplierDesc;
		  	}
		  	public void setSupplierDesc(String supplierDesc){
		  	   	this.supplierDesc=supplierDesc;
		  	}
		  	   
		  	public String getFirstSource(){
		  		return firstSource;
		  	}
		  	public void setFirstSource(String firstSource){
		  	   	this.firstSource=firstSource;
		  	}
		  	   
		  	public BigDecimal getAssestCost(){
		  		return assestCost;
		  	}
		  	public void setAssestCost(BigDecimal assestCost){
		  	   	this.assestCost=assestCost;
		  	}
		  	   
		  	public BigDecimal getProcfee(){
		  		return procfee;
		  	}
		  	public void setProcfee(BigDecimal procfee){
		  	   	this.procfee=procfee;
		  	}
		  	   
		  	public BigDecimal getPlougHbk(){
		  		return plougHbk;
		  	}
		  	public void setPlougHbk(BigDecimal plougHbk){
		  	   	this.plougHbk=plougHbk;
		  	}
		  	   
		  	public BigDecimal getMarginMoney(){
		  		return marginMoney;
		  	}
		  	public void setMarginMoney(BigDecimal marginMoney){
		  	   	this.marginMoney=marginMoney;
		  	}
		  	   
		  	public BigDecimal getCncTopAmount(){
		  		return cncTopAmount;
		  	}
		  	public void setCncTopAmount(BigDecimal cncTopAmount){
		  	   	this.cncTopAmount=cncTopAmount;
		  	}
		  	   
		  	public String getPos(){
		  		return pos;
		  	}
		  	public void setPos(String pos){
		  	   	this.pos=pos;
		  	}
		  	   
		  	public String getCustomerName(){
		  		return customerName;
		  	}
		  	public void setCustomerName(String customerName){
		  	   	this.customerName=customerName;
		  	}
		  	   
		  	public String getPromotionDesc(){
		  		return promotionDesc;
		  	}
		  	public void setPromotionDesc(String promotionDesc){
		  	   	this.promotionDesc=promotionDesc;
		  	}
		  	   
		  	public String getCompName(){
		  		return compName;
		  	}
		  	public void setCompName(String compName){
		  	   	this.compName=compName;
		  	}
		  	   
		  	public BigDecimal getAdvEmiFromDealer(){
		  		return advEmiFromDealer;
		  	}
		  	public void setAdvEmiFromDealer(BigDecimal advEmiFromDealer){
		  	   	this.advEmiFromDealer=advEmiFromDealer;
		  	}
		  	   
		  	public BigDecimal getAdvEmiFRomCustometr(){
		  		return advEmiFRomCustometr;
		  	}
		  	public void setAdvEmiFRomCustometr(BigDecimal advEmiFRomCustometr){
		  	   	this.advEmiFRomCustometr=advEmiFRomCustometr;
		  	}
		  	   
		  	public BigDecimal getAgrAfterGst(){
		  		return agrAfterGst;
		  	}
		  	public void setAgrAfterGst(BigDecimal agrAfterGst){
		  	   	this.agrAfterGst=agrAfterGst;
		  	}
		  	   
		  	public Long getBranchId(){
		  		return branchId;
		  	}
		  	public void setBranchId(Long branchId){
		  	   	this.branchId=branchId;
		  	}
		  	   
		  	public String getHub(){
		  		return hub;
		  	}
		  	public void setHub(String hub){
		  	   	this.hub=hub;
		  	}
		  	   
		  	public String getState(){
		  		return state;
		  	}
		  	public void setState(String state){
		  	   	this.state=state;
		  	}
		  	   
		  	public String getRegion(){
		  		return region;
		  	}
		  	public void setRegion(String region){
		  	   	this.region=region;
		  	}
		  	   
		  	public String getZone(){
		  		return zone;
		  	}
		  	public void setZone(String zone){
		  	   	this.zone=zone;
		  	}
		  	   
		  	public String getRegionHead(){
		  		return regionHead;
		  	}
		  	public void setRegionHead(String regionHead){
		  	   	this.regionHead=regionHead;
		  	}
		  	   
		  	public String getZonalHead(){
		  		return zonalHead;
		  	}
		  	public void setZonalHead(String zonalHead){
		  	   	this.zonalHead=zonalHead;
		  	}
		  	   
		  	public String getConstitution_final(){
		  		return constitution_final;
		  	}
		  	public void setConstitution_final(String constitution_final){
		  	   	this.constitution_final=constitution_final;
		  	}
		  	   
		  	public BigDecimal getFinalNetDisburseMent(){
		  		return finalNetDisburseMent;
		  	}
		  	public void setFinalNetDisburseMent(BigDecimal finalNetDisburseMent){
		  	   	this.finalNetDisburseMent=finalNetDisburseMent;
		  	}
		  	   
		  	public BigDecimal getAmountFin(){
		  		return amountFin;
		  	}
		  	public void setAmountFin(BigDecimal amountFin){
		  	   	this.amountFin=amountFin;
		  	}
		  	   
		  	public String getLoginDate(){
		  		return loginDate;
		  	}
		  	public void setLoginDate(String loginDate){
		  	   	this.loginDate=loginDate;
		  	}
		  	   
		  	public String getPromoCode(){
		  		return promoCode;
		  	}
		  	public void setPromoCode(String promoCode){
		  	   	this.promoCode=promoCode;
		  	}
		  	   
		  	public Long getCibil(){
		  		return cibil;
		  	}
		  	public void setCibil(Long cibil){
		  	   	this.cibil=cibil;
		  	}
		  	   
		  	public String getVendorCodePos(){
		  		return vendorCodePos;
		  	}
		  	public void setVendorCodePos(String vendorCodePos){
		  	   	this.vendorCodePos=vendorCodePos;
		  	}
		  	   
		  	public BigDecimal getCappingPerCent(){
		  		return cappingPerCent;
		  	}
		  	public void setCappingPerCent(BigDecimal cappingPerCent){
		  	   	this.cappingPerCent=cappingPerCent;
		  	}
		  	   
		  	public BigDecimal getTotalBussinessVolumeUsedCar(){
		  		return totalBussinessVolumeUsedCar;
		  	}
		  	public void setTotalBussinessVolumeUsedCar(BigDecimal totalBussinessVolumeUsedCar){
		  	   	this.totalBussinessVolumeUsedCar=totalBussinessVolumeUsedCar;
		  	}
		  	   
		  	public BigDecimal getNetDisbursment(){
		  		return netDisbursment;
		  	}
		  	public void setNetDisbursment(BigDecimal netDisbursment){
		  	   	this.netDisbursment=netDisbursment;
		  	}
		  	   
		  	public String getAssetDesc(){
		  		return assetDesc;
		  	}
		  	public void setAssetDesc(String assetDesc){
		  	   	this.assetDesc=assetDesc;
		  	}
		  	   
		  	public String getDisbursaldate(){
		  		return disbursaldate;
		  	}
		  	public void setDisbursaldate(String disbursaldate){
		  	   	this.disbursaldate=disbursaldate;
		  	}
		  	   
		  	public BigDecimal getBooster(){
		  		return booster;
		  	}
		  	public void setBooster(BigDecimal booster){
		  	   	this.booster=booster;
		  	}
		  	   
		  	public String getCibilGrid(){
		  		return cibilGrid;
		  	}
		  	public void setCibilGrid(String cibilGrid){
		  	   	this.cibilGrid=cibilGrid;
		  	}
		  	   
		  	public String getVendor5digit(){
		  		return vendor5digit;
		  	}
		  	public void setVendor5digit(String vendor5digit){
		  	   	this.vendor5digit=vendor5digit;
		  	}
		  	   
		  	public String getRegionDesc(){
		  		return regionDesc;
		  	}
		  	public void setRegionDesc(String regionDesc){
		  	   	this.regionDesc=regionDesc;
		  	}
		  	   
		  	public String getHdfcBranchid(){
		  		return hdfcBranchid;
		  	}
		  	public void setHdfcBranchid(String hdfcBranchid){
		  	   	this.hdfcBranchid=hdfcBranchid;
		  	}
		  	   
		  	public BigDecimal getCommisionAfterAddGst(){
		  		return commisionAfterAddGst;
		  	}
		  	public void setCommisionAfterAddGst(BigDecimal commisionAfterAddGst){
		  	   	this.commisionAfterAddGst=commisionAfterAddGst;
		  	}
		  	   
		  	public BigDecimal getFinalCommsionAfterPerCases(){
		  		return finalCommsionAfterPerCases;
		  	}
		  	public void setFinalCommsionAfterPerCases(BigDecimal finalCommsionAfterPerCases){
		  	   	this.finalCommsionAfterPerCases=finalCommsionAfterPerCases;
		  	}
		  	   
		  	public String getMake(){
		  		return make;
		  	}
		  	public void setMake(String make){
		  	   	this.make=make;
		  	}
		  	   
		  	public BigDecimal getPerCasePercentage(){
		  		return perCasePercentage;
		  	}
		  	public void setPerCasePercentage(BigDecimal perCasePercentage){
		  	   	this.perCasePercentage=perCasePercentage;
		  	}
		  	   
		  	public BigDecimal getPerCasePerCAmount(){
		  		return perCasePerCAmount;
		  	}
		  	public void setPerCasePerCAmount(BigDecimal perCasePerCAmount){
		  	   	this.perCasePerCAmount=perCasePerCAmount;
		  	}
		  	   
		  	public Long getVendorMasterId(){
		  		return vendorMasterId;
		  	}
		  	public void setVendorMasterId(Long vendorMasterId){
		  	   	this.vendorMasterId=vendorMasterId;
		  	}
		  	   
		  	public BigDecimal getSupplierid(){
		  		return supplierid;
		  	}
		  	public void setSupplierid(BigDecimal supplierid){
		  	   	this.supplierid=supplierid;
		  	}
		  	   
		  	public String getImauthdate(){
		  		return imauthdate;
		  	}
		  	public void setImauthdate(String imauthdate){
		  	   	this.imauthdate=imauthdate;
		  	}
		  	   
		  	public BigDecimal getManufacturerid(){
		  		return manufacturerid;
		  	}
		  	public void setManufacturerid(BigDecimal manufacturerid){
		  	   	this.manufacturerid=manufacturerid;
		  	}
		  	   
		  	public String getManufacturerdesc(){
		  		return manufacturerdesc;
		  	}
		  	public void setManufacturerdesc(String manufacturerdesc){
		  	   	this.manufacturerdesc=manufacturerdesc;
		  	}
		  	   
		  	public BigDecimal getPa_ins_premium(){
		  		return pa_ins_premium;
		  	}
		  	public void setPa_ins_premium(BigDecimal pa_ins_premium){
		  	   	this.pa_ins_premium=pa_ins_premium;
		  	}
		  	   
		  	public BigDecimal getEw_ins_premium(){
		  		return ew_ins_premium;
		  	}
		  	public void setEw_ins_premium(BigDecimal ew_ins_premium){
		  	   	this.ew_ins_premium=ew_ins_premium;
		  	}
		  	   
		  	public BigDecimal getCp_ins_premium(){
		  		return cp_ins_premium;
		  	}
		  	public void setCp_ins_premium(BigDecimal cp_ins_premium){
		  	   	this.cp_ins_premium=cp_ins_premium;
		  	}
		  	   
		  	public BigDecimal getTransaction_fees_bank(){
		  		return transaction_fees_bank;
		  	}
		  	public void setTransaction_fees_bank(BigDecimal transaction_fees_bank){
		  	   	this.transaction_fees_bank=transaction_fees_bank;
		  	}
		  	   
		  	public String getRemarks(){
		  		return remarks;
		  	}
		  	public void setRemarks(String remarks){
		  	   	this.remarks=remarks;
		  	}
		  	   
		  	public String getDeduction_reason(){
		  		return deduction_reason;
		  	}
		  	public void setDeduction_reason(String deduction_reason){
		  	   	this.deduction_reason=deduction_reason;
		  	}
		  	   
		  	public BigDecimal getCommissionBeforeGstTax(){
		  		return commissionBeforeGstTax;
		  	}
		  	public void setCommissionBeforeGstTax(BigDecimal commissionBeforeGstTax){
		  	   	this.commissionBeforeGstTax=commissionBeforeGstTax;
		  	}
		  	   
		  	public BigDecimal getGst18(){
		  		return gst18;
		  	}
		  	public void setGst18(BigDecimal gst18){
		  	   	this.gst18=gst18;
		  	}
		  	   
		  	public BigDecimal getTdsAmount(){
		  		return tdsAmount;
		  	}
		  	public void setTdsAmount(BigDecimal tdsAmount){
		  	   	this.tdsAmount=tdsAmount;
		  	}
		  	   
		  	public String getCompostionFlag(){
		  		return compostionFlag;
		  	}
		  	public void setCompostionFlag(String compostionFlag){
		  	   	this.compostionFlag=compostionFlag;
		  	}
		  	   
		  	public String getRegisteredUnregistered(){
		  		return registeredUnregistered;
		  	}
		  	public void setRegisteredUnregistered(String registeredUnregistered){
		  	   	this.registeredUnregistered=registeredUnregistered;
		  	}
		  	   
		  	public String getTdsType(){
		  		return tdsType;
		  	}
		  	public void setTdsType(String tdsType){
		  	   	this.tdsType=tdsType;
		  	}
		  	   
		  	public BigDecimal getGrossBeforeGSTtaX(){
		  		return grossBeforeGSTtaX;
		  	}
		  	public void setGrossBeforeGSTtaX(BigDecimal grossBeforeGSTtaX){
		  	   	this.grossBeforeGSTtaX=grossBeforeGSTtaX;
		  	}
		  	   
		  	public BigDecimal getNetValue(){
		  		return netValue;
		  	}
		  	public void setNetValue(BigDecimal netValue){
		  	   	this.netValue=netValue;
		  	}
		  	   
		  	public BigDecimal getPayableamountSum(){
		  		return payableamountSum;
		  	}
		  	public void setPayableamountSum(BigDecimal payableamountSum){
		  	   	this.payableamountSum=payableamountSum;
		  	}
		  	   
		  	public String getPayoutMonth(){
		  		return payoutMonth;
		  	}
		  	public void setPayoutMonth(String payoutMonth){
		  	   	this.payoutMonth=payoutMonth;
		  	}
		  	   
		  	public BigDecimal getPddReleaseAmount(){
		  		return pddReleaseAmount;
		  	}
		  	public void setPddReleaseAmount(BigDecimal pddReleaseAmount){
		  	   	this.pddReleaseAmount=pddReleaseAmount;
		  	}
		  	   
		  	public String getRemapReason(){
		  		return remapReason;
		  	}
		  	public void setRemapReason(String remapReason){
		  	   	this.remapReason=remapReason;
		  	}
		  	   
		  	public BigDecimal getInternalPercaseAmt(){
		  		return internalPercaseAmt;
		  	}
		  	public void setInternalPercaseAmt(BigDecimal internalPercaseAmt){
		  	   	this.internalPercaseAmt=internalPercaseAmt;
		  	}
		  	   
		  	public Long getSource_id(){
		  		return source_id;
		  	}
		  	public void setSource_id(Long source_id){
		  	   	this.source_id=source_id;
		  	}
		  	   
		  	public String getHold_status(){
		  		return hold_status;
		  	}
		  	public void setHold_status(String hold_status){
		  	   	this.hold_status=hold_status;
		  	}
		  	   
		  	public Date getModified_on(){
		  		return modified_on;
		  	}
		  	public void setModified_on(Date modified_on){
		  	   	this.modified_on=modified_on;
		  	}
		  	   
		  	public String getRelease_group(){
		  		return release_group;
		  	}
		  	public void setRelease_group(String release_group){
		  	   	this.release_group=release_group;
		  	}
		  	   
		  	public BigDecimal getPayable_amount(){
		  		return payable_amount;
		  	}
		  	public void setPayable_amount(BigDecimal payable_amount){
		  	   	this.payable_amount=payable_amount;
		  	}
		  	   
		  	public String getWorkflow_status(){
		  		return workflow_status;
		  	}
		  	public void setWorkflow_status(String workflow_status){
		  	   	this.workflow_status=workflow_status;
		  	}
		  	   
		  	public BigDecimal getReleased_amount(){
		  		return released_amount;
		  	}
		  	public void setReleased_amount(BigDecimal released_amount){
		  	   	this.released_amount=released_amount;
		  	}
		  	   
		  	public BigDecimal getHold_amount(){
		  		return hold_amount;
		  	}
		  	public void setHold_amount(BigDecimal hold_amount){
		  	   	this.hold_amount=hold_amount;
		  	}
		  	   
		  	public String getWorkflow_details(){
		  		return workflow_details;
		  	}
		  	public void setWorkflow_details(String workflow_details){
		  	   	this.workflow_details=workflow_details;
		  	}
		  	   
		  	public String getProcess_business_key(){
		  		return process_business_key;
		  	}
		  	public void setProcess_business_key(String process_business_key){
		  	   	this.process_business_key=process_business_key;
		  	}
		  	   
		  	public BigDecimal getPayeePayableAmount(){
		  		return payeePayableAmount;
		  	}
		  	public void setPayeePayableAmount(BigDecimal payeePayableAmount){
		  	   	this.payeePayableAmount=payeePayableAmount;
		  	}
		  	   
		  	public String getType(){
		  		return type;
		  	}
		  	public void setType(String type){
		  	   	this.type=type;
		  	}
		  	   
		  	public String getHold_reason(){
		  		return hold_reason;
		  	}
		  	public void setHold_reason(String hold_reason){
		  	   	this.hold_reason=hold_reason;
		  	}
		  	   
		  	public String getReady_for_release(){
		  		return ready_for_release;
		  	}
		  	public void setReady_for_release(String ready_for_release){
		  	   	this.ready_for_release=ready_for_release;
		  	}
		  	   
		  	public String getName(){
		  		return name;
		  	}
		  	public void setName(String name){
		  	   	this.name=name;
		  	}
		  	   
		  	public Long getPayout_id(){
		  		return payout_id;
		  	}
		  	public void setPayout_id(Long payout_id){
		  	   	this.payout_id=payout_id;
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
		  	   
		  	public Long getTdsRate(){
		  		return tdsRate;
		  	}
		  	public void setTdsRate(Long tdsRate){
		  	   	this.tdsRate=tdsRate;
		  	}
		  	   
		  	public String getWorkflow_process_instance_id(){
		  		return workflow_process_instance_id;
		  	}
		  	public void setWorkflow_process_instance_id(String workflow_process_instance_id){
		  	   	this.workflow_process_instance_id=workflow_process_instance_id;
		  	}
		  	   
		  	public BigDecimal getRebookAppliedAmount(){
		  		return rebookAppliedAmount;
		  	}
		  	public void setRebookAppliedAmount(BigDecimal rebookAppliedAmount){
		  	   	this.rebookAppliedAmount=rebookAppliedAmount;
		  	}
		  	   
		  	public BigDecimal getCancellationAppliedAmount(){
		  		return cancellationAppliedAmount;
		  	}
		  	public void setCancellationAppliedAmount(BigDecimal cancellationAppliedAmount){
		  	   	this.cancellationAppliedAmount=cancellationAppliedAmount;
		  	}
		  	   
		  	public BigDecimal getRemapAppliedAmount(){
		  		return remapAppliedAmount;
		  	}
		  	public void setRemapAppliedAmount(BigDecimal remapAppliedAmount){
		  	   	this.remapAppliedAmount=remapAppliedAmount;
		  	}
		  	   
		  	public String getPop(){
		  		return pop;
		  	}
		  	public void setPop(String pop){
		  	   	this.pop=pop;
		  	}
		  	   
		  	public String getVendorName(){
		  		return vendorName;
		  	}
		  	public void setVendorName(String vendorName){
		  	   	this.vendorName=vendorName;
		  	}
		  	   
		  	public Long getCases(){
		  		return cases;
		  	}
		  	public void setCases(Long cases){
		  	   	this.cases=cases;
		  	}
		  	   
		  	public String getVendor_name(){
		  		return vendor_name;
		  	}
		  	public void setVendor_name(String vendor_name){
		  	   	this.vendor_name=vendor_name;
		  	}
		  	   
		  	public BigDecimal getTotalDsaBussinessVolume(){
		  		return totalDsaBussinessVolume;
		  	}
		  	public void setTotalDsaBussinessVolume(BigDecimal totalDsaBussinessVolume){
		  	   	this.totalDsaBussinessVolume=totalDsaBussinessVolume;
		  	}
		  	   
		  	public String getCompanyTypeIndvid(){
		  		return companyTypeIndvid;
		  	}
		  	public void setCompanyTypeIndvid(String companyTypeIndvid){
		  	   	this.companyTypeIndvid=companyTypeIndvid;
		  	}
		  	   
		  	public Boolean getRateSlabRevisedFlag(){
		  		return rateSlabRevisedFlag;
		  	}
		  	public void setRateSlabRevisedFlag(Boolean rateSlabRevisedFlag){
		  	   	this.rateSlabRevisedFlag=rateSlabRevisedFlag;
		  	}
		  	   
		  	public Boolean getGstAdditionalFlag(){
		  		return gstAdditionalFlag;
		  	}
		  	public void setGstAdditionalFlag(Boolean gstAdditionalFlag){
		  	   	this.gstAdditionalFlag=gstAdditionalFlag;
		  	}
		  	   
		  	public Boolean getSpecialChannelFlag(){
		  		return specialChannelFlag;
		  	}
		  	public void setSpecialChannelFlag(Boolean specialChannelFlag){
		  	   	this.specialChannelFlag=specialChannelFlag;
		  	}
		  	   
	}
