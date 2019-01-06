package org.mintleaf.modules.core.entity;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;
import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2018-12-15
*/
@Table(name="mintleaf_fast.vw_sell_details_for_day")
public class VwSellDetailsForDay   {
	
	private BigDecimal amount ;
	/*
	批次号
	*/
	private String batchNumber ;
	/*
	币种
	*/
	private String currency ;
	private Long quantitys ;
	private String sellDate ;
	/*
	网点代码
	*/
	private String shopCode ;
	/*
	产品代码
	*/
	private String sn ;
	
	public VwSellDetailsForDay() {
	}
	
	public BigDecimal getAmount(){
		return  amount;
	}
	public void setAmount(BigDecimal amount ){
		this.amount = amount;
	}
	
	/**
	* 批次号
	*@return 
	*/
	public String getBatchNumber(){
		return  batchNumber;
	}
	/**
	* 批次号
	*@param  batchNumber
	*/
	public void setBatchNumber(String batchNumber ){
		this.batchNumber = batchNumber;
	}
	
	/**
	* 币种
	*@return 
	*/
	public String getCurrency(){
		return  currency;
	}
	/**
	* 币种
	*@param  currency
	*/
	public void setCurrency(String currency ){
		this.currency = currency;
	}
	
	public Long getQuantitys(){
		return  quantitys;
	}
	public void setQuantitys(Long quantitys ){
		this.quantitys = quantitys;
	}
	
	public String getSellDate(){
		return  sellDate;
	}
	public void setSellDate(String sellDate ){
		this.sellDate = sellDate;
	}
	
	/**
	* 网点代码
	*@return 
	*/
	public String getShopCode(){
		return  shopCode;
	}
	/**
	* 网点代码
	*@param  shopCode
	*/
	public void setShopCode(String shopCode ){
		this.shopCode = shopCode;
	}
	
	/**
	* 产品代码
	*@return 
	*/
	public String getSn(){
		return  sn;
	}
	/**
	* 产品代码
	*@param  sn
	*/
	public void setSn(String sn ){
		this.sn = sn;
	}
	

}
