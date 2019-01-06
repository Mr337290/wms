package org.mintleaf.modules.core.entity;
import java.math.BigDecimal;
import java.util.Date;

import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2018-12-02
*/
@Table(name="mintleaf_fast.sell_details")
public class SellDetails   {
	
	private Integer id ;
	/*
	数量
	*/
	private Integer quantity ;
	/*
	批次号
	*/
	private String batchNumber ;
	/*
	币种
	*/
	private String currency ;
	/*
	单价
	*/
	private BigDecimal price ;
	/*
	网点代码
	*/
	private String shopCode ;
	/*
	产品代码
	*/
	private String sn ;
	/*
	创建时间
	*/
	private Date createTime ;
	/*
	出售时间
	*/
	private Date sellTime ;
	
	public SellDetails() {
	}
	
	public Integer getId(){
		return  id;
	}
	public void setId(Integer id ){
		this.id = id;
	}
	
	/**
	* 数量
	*@return 
	*/
	public Integer getQuantity(){
		return  quantity;
	}
	/**
	* 数量
	*@param  quantity
	*/
	public void setQuantity(Integer quantity ){
		this.quantity = quantity;
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
	
	/**
	* 单价
	*@return 
	*/
	public BigDecimal getPrice(){
		return  price;
	}
	/**
	* 单价
	*@param  price
	*/
	public void setPrice(BigDecimal price ){
		this.price = price;
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
	
	/**
	* 创建时间
	*@return 
	*/
	public Date getCreateTime(){
		return  createTime;
	}
	/**
	* 创建时间
	*@param  createTime
	*/
	public void setCreateTime(Date createTime ){
		this.createTime = createTime;
	}
	
	/**
	* 出售时间
	*@return 
	*/
	public Date getSellTime(){
		return  sellTime;
	}
	/**
	* 出售时间
	*@param  sellTime
	*/
	public void setSellTime(Date sellTime ){
		this.sellTime = sellTime;
	}
	

}
