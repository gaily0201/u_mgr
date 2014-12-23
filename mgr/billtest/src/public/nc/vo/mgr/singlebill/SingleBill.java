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
*����
*/
public static final String PK="pk";
/**
*ʱ���
*/
public static final String TS="ts";
/**
*value
*/
public static final String VALUE="value";
/** 
* ��ȡid
*
* @return id
*/
public String getId () {
return (String) this.getAttributeValue( SingleBill.ID);
 } 

/** 
* ����id
*
* @param id id
*/
public void setId ( String id) {
this.setAttributeValue( SingleBill.ID,id);
 } 

/** 
* ��ȡname
*
* @return name
*/
public String getName () {
return (String) this.getAttributeValue( SingleBill.NAME);
 } 

/** 
* ����name
*
* @param name name
*/
public void setName ( String name) {
this.setAttributeValue( SingleBill.NAME,name);
 } 

/** 
* ��ȡpid
*
* @return pid
*/
public String getPid () {
return (String) this.getAttributeValue( SingleBill.PID);
 } 

/** 
* ����pid
*
* @param pid pid
*/
public void setPid ( String pid) {
this.setAttributeValue( SingleBill.PID,pid);
 } 

/** 
* ��ȡ����
*
* @return ����
*/
public String getPk () {
return (String) this.getAttributeValue( SingleBill.PK);
 } 

/** 
* ��������
*
* @param pk ����
*/
public void setPk ( String pk) {
this.setAttributeValue( SingleBill.PK,pk);
 } 

/** 
* ��ȡʱ���
*
* @return ʱ���
*/
public UFDateTime getTs () {
return (UFDateTime) this.getAttributeValue( SingleBill.TS);
 } 

/** 
* ����ʱ���
*
* @param ts ʱ���
*/
public void setTs ( UFDateTime ts) {
this.setAttributeValue( SingleBill.TS,ts);
 } 

/** 
* ��ȡvalue
*
* @return value
*/
public String getValue () {
return (String) this.getAttributeValue( SingleBill.VALUE);
 } 

/** 
* ����value
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