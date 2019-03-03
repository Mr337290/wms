package org.mintleaf.modules.core.entity;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;
import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2019-03-03
*/
@Table(name="mintleaf_fast.warehouse_info")
public class WarehouseInfo   {
	
	private Integer id ;
	/*
	库存
	*/
	private Integer inventory ;
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
	产品代码
	*/
	private String sn ;
	/*
	仓库名称
	*/
	private String wareName ;
	/*
	创建时间
	*/
	private Date createTime ;
	/*
	创建时间
	*/
	private Date modifyTime ;
	
	public WarehouseInfo() {
	}
	
	public Integer getId(){
		return  id;
	}
	public void setId(Integer id ){
		this.id = id;
	}
	
	/**
	* 库存
	*@return 
	*/
	public Integer getInventory(){
		return  inventory;
	}
	/**
	* 库存
	*@param  inventory
	*/
	public void setInventory(Integer inventory ){
		this.inventory = inventory;
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
	* 仓库名称
	*@return 
	*/
	public String getWareName(){
		return  wareName;
	}
	/**
	* 仓库名称
	*@param  wareName
	*/
	public void setWareName(String wareName ){
		this.wareName = wareName;
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
	* 创建时间
	*@return 
	*/
	public Date getModifyTime(){
		return  modifyTime;
	}
	/**
	* 创建时间
	*@param  modifyTime
	*/
	public void setModifyTime(Date modifyTime ){
		this.modifyTime = modifyTime;
	}
	

}
