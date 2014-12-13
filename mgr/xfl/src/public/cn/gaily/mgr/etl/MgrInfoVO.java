package cn.gaily.mgr.etl;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

public class MgrInfoVO extends SuperVO {
/**
*预留字段1
*/
public static final String ATTR1="attr1";
/**
*预留字段2
*/
public static final String ATTR2="attr2";
/**
*预留字段3
*/
public static final String ATTR3="attr3";
/**
*预留字段4
*/
public static final String ATTR4="attr4";
/**
*预留字段5
*/
public static final String ATTR5="attr5";
/**
*备注信息
*/
public static final String NOTE="note";
/**
*主键
*/
public static final String PK="pk";
/**
*源数据库ip
*/
public static final String SCRIP="scrip";
/**
*源数据库名称
*/
public static final String SRCNAME="srcname";
/**
*源数据库密码
*/
public static final String SRCPASSWORD="srcpassword";
/**
*源数据库端口
*/
public static final String SRCPORT="srcport";
/**
*源数据库用户
*/
public static final String SRCUSERNAME="srcusername";
/**
*同步类型
*/
public static final String SYNTYPE="syntype";
/**
*目标数据库ip
*/
public static final String TARIP="tarip";
/**
*目标数据库名称
*/
public static final String TARNAME="tarname";
/**
*目标数据库密码
*/
public static final String TARPASSWORD="tarpassword";
/**
*目标数据库端口
*/
public static final String TARPORT="tarport";
/**
*目标数据库用户
*/
public static final String TARUSERNAME="tarusername";
/**
*时间戳
*/
public static final String TS="ts";
/** 
* 获取预留字段1
*
* @return 预留字段1
*/
public String getAttr1 () {
return (String) this.getAttributeValue( MgrInfoVO.ATTR1);
 } 

/** 
* 设置预留字段1
*
* @param attr1 预留字段1
*/
public void setAttr1 ( String attr1) {
this.setAttributeValue( MgrInfoVO.ATTR1,attr1);
 } 

/** 
* 获取预留字段2
*
* @return 预留字段2
*/
public String getAttr2 () {
return (String) this.getAttributeValue( MgrInfoVO.ATTR2);
 } 

/** 
* 设置预留字段2
*
* @param attr2 预留字段2
*/
public void setAttr2 ( String attr2) {
this.setAttributeValue( MgrInfoVO.ATTR2,attr2);
 } 

/** 
* 获取预留字段3
*
* @return 预留字段3
*/
public String getAttr3 () {
return (String) this.getAttributeValue( MgrInfoVO.ATTR3);
 } 

/** 
* 设置预留字段3
*
* @param attr3 预留字段3
*/
public void setAttr3 ( String attr3) {
this.setAttributeValue( MgrInfoVO.ATTR3,attr3);
 } 

/** 
* 获取预留字段4
*
* @return 预留字段4
*/
public String getAttr4 () {
return (String) this.getAttributeValue( MgrInfoVO.ATTR4);
 } 

/** 
* 设置预留字段4
*
* @param attr4 预留字段4
*/
public void setAttr4 ( String attr4) {
this.setAttributeValue( MgrInfoVO.ATTR4,attr4);
 } 

/** 
* 获取预留字段5
*
* @return 预留字段5
*/
public String getAttr5 () {
return (String) this.getAttributeValue( MgrInfoVO.ATTR5);
 } 

/** 
* 设置预留字段5
*
* @param attr5 预留字段5
*/
public void setAttr5 ( String attr5) {
this.setAttributeValue( MgrInfoVO.ATTR5,attr5);
 } 

/** 
* 获取备注信息
*
* @return 备注信息
*/
public String getNote () {
return (String) this.getAttributeValue( MgrInfoVO.NOTE);
 } 

/** 
* 设置备注信息
*
* @param note 备注信息
*/
public void setNote ( String note) {
this.setAttributeValue( MgrInfoVO.NOTE,note);
 } 

/** 
* 获取主键
*
* @return 主键
*/
public String getPk () {
return (String) this.getAttributeValue( MgrInfoVO.PK);
 } 

/** 
* 设置主键
*
* @param pk 主键
*/
public void setPk ( String pk) {
this.setAttributeValue( MgrInfoVO.PK,pk);
 } 

/** 
* 获取源数据库ip
*
* @return 源数据库ip
*/
public String getScrip () {
return (String) this.getAttributeValue( MgrInfoVO.SCRIP);
 } 

/** 
* 设置源数据库ip
*
* @param scrip 源数据库ip
*/
public void setScrip ( String scrip) {
this.setAttributeValue( MgrInfoVO.SCRIP,scrip);
 } 

/** 
* 获取源数据库名称
*
* @return 源数据库名称
*/
public String getSrcname () {
return (String) this.getAttributeValue( MgrInfoVO.SRCNAME);
 } 

/** 
* 设置源数据库名称
*
* @param srcname 源数据库名称
*/
public void setSrcname ( String srcname) {
this.setAttributeValue( MgrInfoVO.SRCNAME,srcname);
 } 

/** 
* 获取源数据库密码
*
* @return 源数据库密码
*/
public String getSrcpassword () {
return (String) this.getAttributeValue( MgrInfoVO.SRCPASSWORD);
 } 

/** 
* 设置源数据库密码
*
* @param srcpassword 源数据库密码
*/
public void setSrcpassword ( String srcpassword) {
this.setAttributeValue( MgrInfoVO.SRCPASSWORD,srcpassword);
 } 

/** 
* 获取源数据库端口
*
* @return 源数据库端口
*/
public String getSrcport () {
return (String) this.getAttributeValue( MgrInfoVO.SRCPORT);
 } 

/** 
* 设置源数据库端口
*
* @param srcport 源数据库端口
*/
public void setSrcport ( String srcport) {
this.setAttributeValue( MgrInfoVO.SRCPORT,srcport);
 } 

/** 
* 获取源数据库用户
*
* @return 源数据库用户
*/
public String getSrcusername () {
return (String) this.getAttributeValue( MgrInfoVO.SRCUSERNAME);
 } 

/** 
* 设置源数据库用户
*
* @param srcusername 源数据库用户
*/
public void setSrcusername ( String srcusername) {
this.setAttributeValue( MgrInfoVO.SRCUSERNAME,srcusername);
 } 

/** 
* 获取同步类型
*
* @return 同步类型
*/
public String getSyntype () {
return (String) this.getAttributeValue( MgrInfoVO.SYNTYPE);
 } 

/** 
* 设置同步类型
*
* @param syntype 同步类型
*/
public void setSyntype ( String syntype) {
this.setAttributeValue( MgrInfoVO.SYNTYPE,syntype);
 } 

/** 
* 获取目标数据库ip
*
* @return 目标数据库ip
*/
public String getTarip () {
return (String) this.getAttributeValue( MgrInfoVO.TARIP);
 } 

/** 
* 设置目标数据库ip
*
* @param tarip 目标数据库ip
*/
public void setTarip ( String tarip) {
this.setAttributeValue( MgrInfoVO.TARIP,tarip);
 } 

/** 
* 获取目标数据库名称
*
* @return 目标数据库名称
*/
public String getTarname () {
return (String) this.getAttributeValue( MgrInfoVO.TARNAME);
 } 

/** 
* 设置目标数据库名称
*
* @param tarname 目标数据库名称
*/
public void setTarname ( String tarname) {
this.setAttributeValue( MgrInfoVO.TARNAME,tarname);
 } 

/** 
* 获取目标数据库密码
*
* @return 目标数据库密码
*/
public String getTarpassword () {
return (String) this.getAttributeValue( MgrInfoVO.TARPASSWORD);
 } 

/** 
* 设置目标数据库密码
*
* @param tarpassword 目标数据库密码
*/
public void setTarpassword ( String tarpassword) {
this.setAttributeValue( MgrInfoVO.TARPASSWORD,tarpassword);
 } 

/** 
* 获取目标数据库端口
*
* @return 目标数据库端口
*/
public String getTarport () {
return (String) this.getAttributeValue( MgrInfoVO.TARPORT);
 } 

/** 
* 设置目标数据库端口
*
* @param tarport 目标数据库端口
*/
public void setTarport ( String tarport) {
this.setAttributeValue( MgrInfoVO.TARPORT,tarport);
 } 

/** 
* 获取目标数据库用户
*
* @return 目标数据库用户
*/
public String getTarusername () {
return (String) this.getAttributeValue( MgrInfoVO.TARUSERNAME);
 } 

/** 
* 设置目标数据库用户
*
* @param tarusername 目标数据库用户
*/
public void setTarusername ( String tarusername) {
this.setAttributeValue( MgrInfoVO.TARUSERNAME,tarusername);
 } 

/** 
* 获取时间戳
*
* @return 时间戳
*/
public UFDateTime getTs () {
return (UFDateTime) this.getAttributeValue( MgrInfoVO.TS);
 } 

/** 
* 设置时间戳
*
* @param ts 时间戳
*/
public void setTs ( UFDateTime ts) {
this.setAttributeValue( MgrInfoVO.TS,ts);
 } 


  @Override
  public IVOMeta getMetaData() {
    return VOMetaFactory.getInstance().getVOMeta("mgr.MgrInfoVO");
  }
}