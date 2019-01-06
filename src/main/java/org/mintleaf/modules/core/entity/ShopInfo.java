package org.mintleaf.modules.core.entity;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;
import org.beetl.sql.core.annotatoin.Table;


/* 
* 
* gen by beetlsql 2018-12-01
*/
@Table(name="mintleaf_fast.shop_info")
public class ShopInfo   {
	
	private Integer id ;
	/*
	状态
	*/
	private Integer status ;
	/*
	地址
	*/
	private String address ;
	/*
	代码
	*/
	private String code ;
	/*
	邮箱
	*/
	private String mail ;
	/*
	负责人
	*/
	private String managers ;
	/*
	名称
	*/
	private String name ;
	/*
	电话
	*/
	private String phone ;
	
	public ShopInfo() {
	}
	
	public Integer getId(){
		return  id;
	}
	public void setId(Integer id ){
		this.id = id;
	}
	
	/**
	* 状态
	*@return 
	*/
	public Integer getStatus(){
		return  status;
	}
	/**
	* 状态
	*@param  status
	*/
	public void setStatus(Integer status ){
		this.status = status;
	}
	
	/**
	* 地址
	*@return 
	*/
	public String getAddress(){
		return  address;
	}
	/**
	* 地址
	*@param  address
	*/
	public void setAddress(String address ){
		this.address = address;
	}
	
	/**
	* 代码
	*@return 
	*/
	public String getCode(){
		return  code;
	}
	/**
	* 代码
	*@param  code
	*/
	public void setCode(String code ){
		this.code = code;
	}
	
	/**
	* 邮箱
	*@return 
	*/
	public String getMail(){
		return  mail;
	}
	/**
	* 邮箱
	*@param  mail
	*/
	public void setMail(String mail ){
		this.mail = mail;
	}
	
	/**
	* 负责人
	*@return 
	*/
	public String getManagers(){
		return  managers;
	}
	/**
	* 负责人
	*@param  managers
	*/
	public void setManagers(String managers ){
		this.managers = managers;
	}
	
	/**
	* 名称
	*@return 
	*/
	public String getName(){
		return  name;
	}
	/**
	* 名称
	*@param  name
	*/
	public void setName(String name ){
		this.name = name;
	}
	
	/**
	* 电话
	*@return 
	*/
	public String getPhone(){
		return  phone;
	}
	/**
	* 电话
	*@param  phone
	*/
	public void setPhone(String phone ){
		this.phone = phone;
	}
	

}
