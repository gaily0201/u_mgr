package cn.gaily.mgr.etl;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

public class MgrItemVO extends SuperVO {
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
*运行状态
*/
public static final String EXERESULT="exeresult";
/**
*上层单据主键
*/
public static final String FPK="fpk";
/**
*备注
*/
public static final String NOTE="note";
/**
*子表主键
*/
public static final String PK="pk";
/**
*同步类型
*/
public static final String SYNTYPE="syntype";
/**
*表注释名称
*/
public static final String TABLEINFO="tableinfo";
/**
*表名称
*/
public static final String TABLENAME="tablename";
/**
*时间戳
*/
public static final String TS="ts";
/**
*行号
*/
public static final String VROWNO="vrowno";
/** 
* 获取预留字段2
*
* @return 预留字段2
*/
public String getAttr2 () {
return (String) this.getAttributeValue( MgrItemVO.ATTR2);
 } 

/** 
* 设置预留字段2
*
* @param attr2 预留字段2
*/
public void setAttr2 ( String attr2) {
this.setAttributeValue( MgrItemVO.ATTR2,attr2);
 } 

/** 
* 获取预留字段3
*
* @return 预留字段3
*/
public String getAttr3 () {
return (String) this.getAttributeValue( MgrItemVO.ATTR3);
 } 

/** 
* 设置预留字段3
*
* @param attr3 预留字段3
*/
public void setAttr3 ( String attr3) {
this.setAttributeValue( MgrItemVO.ATTR3,attr3);
 } 

/** 
* 获取预留字段4
*
* @return 预留字段4
*/
public String getAttr4 () {
return (String) this.getAttributeValue( MgrItemVO.ATTR4);
 } 

/** 
* 设置预留字段4
*
* @param attr4 预留字段4
*/
public void setAttr4 ( String attr4) {
this.setAttributeValue( MgrItemVO.ATTR4,attr4);
 } 

/** 
* 获取预留字段5
*
* @return 预留字段5
*/
public String getAttr5 () {
return (String) this.getAttributeValue( MgrItemVO.ATTR5);
 } 

/** 
* 设置预留字段5
*
* @param attr5 预留字段5
*/
public void setAttr5 ( String attr5) {
this.setAttributeValue( MgrItemVO.ATTR5,attr5);
 } 

/** 
* 获取运行状态
*
* @return 运行状态
*/
public String getExeresult () {
return (String) this.getAttributeValue( MgrItemVO.EXERESULT);
 } 

/** 
* 设置运行状态
*
* @param exeresult 运行状态
*/
public void setExeresult ( String exeresult) {
this.setAttributeValue( MgrItemVO.EXERESULT,exeresult);
 } 

/** 
* 获取上层单据主键
*
* @return 上层单据主键
*/
public String getFpk () {
return (String) this.getAttributeValue( MgrItemVO.FPK);
 } 

/** 
* 设置上层单据主键
*
* @param fpk 上层单据主键
*/
public void setFpk ( String fpk) {
this.setAttributeValue( MgrItemVO.FPK,fpk);
 } 

/** 
* 获取备注
*
* @return 备注
*/
public String getNote () {
return (String) this.getAttributeValue( MgrItemVO.NOTE);
 } 

/** 
* 设置备注
*
* @param note 备注
*/
public void setNote ( String note) {
this.setAttributeValue( MgrItemVO.NOTE,note);
 } 

/** 
* 获取子表主键
*
* @return 子表主键
*/
public String getPk () {
return (String) this.getAttributeValue( MgrItemVO.PK);
 } 

/** 
* 设置子表主键
*
* @param pk 子表主键
*/
public void setPk ( String pk) {
this.setAttributeValue( MgrItemVO.PK,pk);
 } 

/** 
* 获取同步类型
*
* @return 同步类型
*/
public String getSyntype () {
return (String) this.getAttributeValue( MgrItemVO.SYNTYPE);
 } 

/** 
* 设置同步类型
*
* @param syntype 同步类型
*/
public void setSyntype ( String syntype) {
this.setAttributeValue( MgrItemVO.SYNTYPE,syntype);
 } 

/** 
* 获取表注释名称
*
* @return 表注释名称
*/
public String getTableinfo () {
return (String) this.getAttributeValue( MgrItemVO.TABLEINFO);
 } 

/** 
* 设置表注释名称
*
* @param tableinfo 表注释名称
*/
public void setTableinfo ( String tableinfo) {
this.setAttributeValue( MgrItemVO.TABLEINFO,tableinfo);
 } 

/** 
* 获取表名称
*
* @return 表名称
*/
public String getTablename () {
return (String) this.getAttributeValue( MgrItemVO.TABLENAME);
 } 

/** 
* 设置表名称
*
* @param tablename 表名称
*/
public void setTablename ( String tablename) {
this.setAttributeValue( MgrItemVO.TABLENAME,tablename);
 } 

/** 
* 获取时间戳
*
* @return 时间戳
*/
public UFDateTime getTs () {
return (UFDateTime) this.getAttributeValue( MgrItemVO.TS);
 } 

/** 
* 设置时间戳
*
* @param ts 时间戳
*/
public void setTs ( UFDateTime ts) {
this.setAttributeValue( MgrItemVO.TS,ts);
 } 

/** 
* 获取行号
*
* @return 行号
*/
public String getVrowno () {
return (String) this.getAttributeValue( MgrItemVO.VROWNO);
 } 

/** 
* 设置行号
*
* @param vrowno 行号
*/
public void setVrowno ( String vrowno) {
this.setAttributeValue( MgrItemVO.VROWNO,vrowno);
 } 


  @Override
  public IVOMeta getMetaData() {
    return VOMetaFactory.getInstance().getVOMeta("mgr.MgrItemVO");
  }
}