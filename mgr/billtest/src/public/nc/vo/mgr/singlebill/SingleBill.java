package nc.vo.mgr.singlebill;

import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;

public class SingleBill extends SuperVO {
/**
	 * 
	 */
	private static final long serialVersionUID = -7143891464422760772L;
/**
*id
*/
public static final String ID="id";
/**
*name
*/
public static final String NAME="name";
/**
*pid
*/
public static final String PID="pid";
/**
*主键
*/
public static final String PK="pk";
/**
*时间戳
*/
public static final String TS="ts";
/**
*value
*/
public static final String VALUE="value";
/** 
* 获取id
*
* @return id
*/
public String getId () {
return (String) this.getAttributeValue( SingleBill.ID);
 } 

/** 
* 设置id
*
* @param id id
*/
public void setId ( String id) {
this.setAttributeValue( SingleBill.ID,id);
 } 

/** 
* 获取name
*
* @return name
*/
public String getName () {
return (String) this.getAttributeValue( SingleBill.NAME);
 } 

/** 
* 设置name
*
* @param name name
*/
public void setName ( String name) {
this.setAttributeValue( SingleBill.NAME,name);
 } 

/** 
* 获取pid
*
* @return pid
*/
public String getPid () {
return (String) this.getAttributeValue( SingleBill.PID);
 } 

/** 
* 设置pid
*
* @param pid pid
*/
public void setPid ( String pid) {
this.setAttributeValue( SingleBill.PID,pid);
 } 

/** 
* 获取主键
*
* @return 主键
*/
public String getPk () {
return (String) this.getAttributeValue( SingleBill.PK);
 } 

/** 
* 设置主键
*
* @param pk 主键
*/
public void setPk ( String pk) {
this.setAttributeValue( SingleBill.PK,pk);
 } 

/** 
* 获取时间戳
*
* @return 时间戳
*/
public UFDateTime getTs () {
return (UFDateTime) this.getAttributeValue( SingleBill.TS);
 } 

/** 
* 设置时间戳
*
* @param ts 时间戳
*/
public void setTs ( UFDateTime ts) {
this.setAttributeValue( SingleBill.TS,ts);
 } 

/** 
* 获取value
*
* @return value
*/
public String getValue () {
return (String) this.getAttributeValue( SingleBill.VALUE);
 } 

/** 
* 设置value
*
* @param value value
*/
public void setValue ( String value) {
this.setAttributeValue( SingleBill.VALUE,value);
 } 


  @Override
  public IVOMeta getMetaData() {
    return VOMetaFactory.getInstance().getVOMeta("mgr.SingleBill");
  }
}