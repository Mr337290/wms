package org.mintleaf.modules.core.entity;
import java.util.Date;

import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2018-12-02
*/
@Table(name="mintleaf_fast.warehouse_water")
public class WarehouseWater   {
	
	private Integer id ;
	/*
	数量
	*/
	private Integer quantity ;
	/*
	操作类型
	*/
	private Integer status ;
	/*
	库存ID
	*/
	private Integer warehouseId ;
	private WarehouseInfo warehouseInfo;
	/*
	操作对象
	*/
	private String operand ;
	/*
	操作人
	*/
	private String operator ;
	/*
	创建时间
	*/
	private Date createTime ;
	
	public WarehouseWater() {
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
	* 操作类型
	*@return 
	*/
	public Integer getStatus(){
		return  status;
	}
	/**
	* 操作类型
	*@param  status
	*/
	public void setStatus(Integer status ){
		this.status = status;
	}
	
	/**
	* 库存ID
	*@return 
	*/
	public Integer getWarehouseId(){
		return  warehouseId;
	}
	/**
	* 库存ID
	*@param  warehouseId
	*/
	public void setWarehouseId(Integer warehouseId ){
		this.warehouseId = warehouseId;
	}
	
	/**
	* 操作对象
	*@return 
	*/
	public String getOperand(){
		return  operand;
	}
	/**
	* 操作对象
	*@param  operand
	*/
	public void setOperand(String operand ){
		this.operand = operand;
	}
	
	/**
	* 操作人
	*@return 
	*/
	public String getOperator(){
		return  operator;
	}
	/**
	* 操作人
	*@param  operator
	*/
	public void setOperator(String operator ){
		this.operator = operator;
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

	public WarehouseInfo getWarehouseInfo() {
		return warehouseInfo;
	}

	public void setWarehouseInfo(WarehouseInfo warehouseInfo) {
		this.warehouseInfo = warehouseInfo;
	}
}
