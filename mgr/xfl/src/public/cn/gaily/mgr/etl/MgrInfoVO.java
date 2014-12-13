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
*Ԥ���ֶ�1
*/
public static final String ATTR1="attr1";
/**
*Ԥ���ֶ�2
*/
public static final String ATTR2="attr2";
/**
*Ԥ���ֶ�3
*/
public static final String ATTR3="attr3";
/**
*Ԥ���ֶ�4
*/
public static final String ATTR4="attr4";
/**
*Ԥ���ֶ�5
*/
public static final String ATTR5="attr5";
/**
*��ע��Ϣ
*/
public static final String NOTE="note";
/**
*����
*/
public static final String PK="pk";
/**
*Դ���ݿ�ip
*/
public static final String SCRIP="scrip";
/**
*Դ���ݿ�����
*/
public static final String SRCNAME="srcname";
/**
*Դ���ݿ�����
*/
public static final String SRCPASSWORD="srcpassword";
/**
*Դ���ݿ�˿�
*/
public static final String SRCPORT="srcport";
/**
*Դ���ݿ��û�
*/
public static final String SRCUSERNAME="srcusername";
/**
*ͬ������
*/
public static final String SYNTYPE="syntype";
/**
*Ŀ�����ݿ�ip
*/
public static final String TARIP="tarip";
/**
*Ŀ�����ݿ�����
*/
public static final String TARNAME="tarname";
/**
*Ŀ�����ݿ�����
*/
public static final String TARPASSWORD="tarpassword";
/**
*Ŀ�����ݿ�˿�
*/
public static final String TARPORT="tarport";
/**
*Ŀ�����ݿ��û�
*/
public static final String TARUSERNAME="tarusername";
/**
*ʱ���
*/
public static final String TS="ts";
/** 
* ��ȡԤ���ֶ�1
*
* @return Ԥ���ֶ�1
*/
public String getAttr1 () {
return (String) this.getAttributeValue( MgrInfoVO.ATTR1);
 } 

/** 
* ����Ԥ���ֶ�1
*
* @param attr1 Ԥ���ֶ�1
*/
public void setAttr1 ( String attr1) {
this.setAttributeValue( MgrInfoVO.ATTR1,attr1);
 } 

/** 
* ��ȡԤ���ֶ�2
*
* @return Ԥ���ֶ�2
*/
public String getAttr2 () {
return (String) this.getAttributeValue( MgrInfoVO.ATTR2);
 } 

/** 
* ����Ԥ���ֶ�2
*
* @param attr2 Ԥ���ֶ�2
*/
public void setAttr2 ( String attr2) {
this.setAttributeValue( MgrInfoVO.ATTR2,attr2);
 } 

/** 
* ��ȡԤ���ֶ�3
*
* @return Ԥ���ֶ�3
*/
public String getAttr3 () {
return (String) this.getAttributeValue( MgrInfoVO.ATTR3);
 } 

/** 
* ����Ԥ���ֶ�3
*
* @param attr3 Ԥ���ֶ�3
*/
public void setAttr3 ( String attr3) {
this.setAttributeValue( MgrInfoVO.ATTR3,attr3);
 } 

/** 
* ��ȡԤ���ֶ�4
*
* @return Ԥ���ֶ�4
*/
public String getAttr4 () {
return (String) this.getAttributeValue( MgrInfoVO.ATTR4);
 } 

/** 
* ����Ԥ���ֶ�4
*
* @param attr4 Ԥ���ֶ�4
*/
public void setAttr4 ( String attr4) {
this.setAttributeValue( MgrInfoVO.ATTR4,attr4);
 } 

/** 
* ��ȡԤ���ֶ�5
*
* @return Ԥ���ֶ�5
*/
public String getAttr5 () {
return (String) this.getAttributeValue( MgrInfoVO.ATTR5);
 } 

/** 
* ����Ԥ���ֶ�5
*
* @param attr5 Ԥ���ֶ�5
*/
public void setAttr5 ( String attr5) {
this.setAttributeValue( MgrInfoVO.ATTR5,attr5);
 } 

/** 
* ��ȡ��ע��Ϣ
*
* @return ��ע��Ϣ
*/
public String getNote () {
return (String) this.getAttributeValue( MgrInfoVO.NOTE);
 } 

/** 
* ���ñ�ע��Ϣ
*
* @param note ��ע��Ϣ
*/
public void setNote ( String note) {
this.setAttributeValue( MgrInfoVO.NOTE,note);
 } 

/** 
* ��ȡ����
*
* @return ����
*/
public String getPk () {
return (String) this.getAttributeValue( MgrInfoVO.PK);
 } 

/** 
* ��������
*
* @param pk ����
*/
public void setPk ( String pk) {
this.setAttributeValue( MgrInfoVO.PK,pk);
 } 

/** 
* ��ȡԴ���ݿ�ip
*
* @return Դ���ݿ�ip
*/
public String getScrip () {
return (String) this.getAttributeValue( MgrInfoVO.SCRIP);
 } 

/** 
* ����Դ���ݿ�ip
*
* @param scrip Դ���ݿ�ip
*/
public void setScrip ( String scrip) {
this.setAttributeValue( MgrInfoVO.SCRIP,scrip);
 } 

/** 
* ��ȡԴ���ݿ�����
*
* @return Դ���ݿ�����
*/
public String getSrcname () {
return (String) this.getAttributeValue( MgrInfoVO.SRCNAME);
 } 

/** 
* ����Դ���ݿ�����
*
* @param srcname Դ���ݿ�����
*/
public void setSrcname ( String srcname) {
this.setAttributeValue( MgrInfoVO.SRCNAME,srcname);
 } 

/** 
* ��ȡԴ���ݿ�����
*
* @return Դ���ݿ�����
*/
public String getSrcpassword () {
return (String) this.getAttributeValue( MgrInfoVO.SRCPASSWORD);
 } 

/** 
* ����Դ���ݿ�����
*
* @param srcpassword Դ���ݿ�����
*/
public void setSrcpassword ( String srcpassword) {
this.setAttributeValue( MgrInfoVO.SRCPASSWORD,srcpassword);
 } 

/** 
* ��ȡԴ���ݿ�˿�
*
* @return Դ���ݿ�˿�
*/
public String getSrcport () {
return (String) this.getAttributeValue( MgrInfoVO.SRCPORT);
 } 

/** 
* ����Դ���ݿ�˿�
*
* @param srcport Դ���ݿ�˿�
*/
public void setSrcport ( String srcport) {
this.setAttributeValue( MgrInfoVO.SRCPORT,srcport);
 } 

/** 
* ��ȡԴ���ݿ��û�
*
* @return Դ���ݿ��û�
*/
public String getSrcusername () {
return (String) this.getAttributeValue( MgrInfoVO.SRCUSERNAME);
 } 

/** 
* ����Դ���ݿ��û�
*
* @param srcusername Դ���ݿ��û�
*/
public void setSrcusername ( String srcusername) {
this.setAttributeValue( MgrInfoVO.SRCUSERNAME,srcusername);
 } 

/** 
* ��ȡͬ������
*
* @return ͬ������
*/
public String getSyntype () {
return (String) this.getAttributeValue( MgrInfoVO.SYNTYPE);
 } 

/** 
* ����ͬ������
*
* @param syntype ͬ������
*/
public void setSyntype ( String syntype) {
this.setAttributeValue( MgrInfoVO.SYNTYPE,syntype);
 } 

/** 
* ��ȡĿ�����ݿ�ip
*
* @return Ŀ�����ݿ�ip
*/
public String getTarip () {
return (String) this.getAttributeValue( MgrInfoVO.TARIP);
 } 

/** 
* ����Ŀ�����ݿ�ip
*
* @param tarip Ŀ�����ݿ�ip
*/
public void setTarip ( String tarip) {
this.setAttributeValue( MgrInfoVO.TARIP,tarip);
 } 

/** 
* ��ȡĿ�����ݿ�����
*
* @return Ŀ�����ݿ�����
*/
public String getTarname () {
return (String) this.getAttributeValue( MgrInfoVO.TARNAME);
 } 

/** 
* ����Ŀ�����ݿ�����
*
* @param tarname Ŀ�����ݿ�����
*/
public void setTarname ( String tarname) {
this.setAttributeValue( MgrInfoVO.TARNAME,tarname);
 } 

/** 
* ��ȡĿ�����ݿ�����
*
* @return Ŀ�����ݿ�����
*/
public String getTarpassword () {
return (String) this.getAttributeValue( MgrInfoVO.TARPASSWORD);
 } 

/** 
* ����Ŀ�����ݿ�����
*
* @param tarpassword Ŀ�����ݿ�����
*/
public void setTarpassword ( String tarpassword) {
this.setAttributeValue( MgrInfoVO.TARPASSWORD,tarpassword);
 } 

/** 
* ��ȡĿ�����ݿ�˿�
*
* @return Ŀ�����ݿ�˿�
*/
public String getTarport () {
return (String) this.getAttributeValue( MgrInfoVO.TARPORT);
 } 

/** 
* ����Ŀ�����ݿ�˿�
*
* @param tarport Ŀ�����ݿ�˿�
*/
public void setTarport ( String tarport) {
this.setAttributeValue( MgrInfoVO.TARPORT,tarport);
 } 

/** 
* ��ȡĿ�����ݿ��û�
*
* @return Ŀ�����ݿ��û�
*/
public String getTarusername () {
return (String) this.getAttributeValue( MgrInfoVO.TARUSERNAME);
 } 

/** 
* ����Ŀ�����ݿ��û�
*
* @param tarusername Ŀ�����ݿ��û�
*/
public void setTarusername ( String tarusername) {
this.setAttributeValue( MgrInfoVO.TARUSERNAME,tarusername);
 } 

/** 
* ��ȡʱ���
*
* @return ʱ���
*/
public UFDateTime getTs () {
return (UFDateTime) this.getAttributeValue( MgrInfoVO.TS);
 } 

/** 
* ����ʱ���
*
* @param ts ʱ���
*/
public void setTs ( UFDateTime ts) {
this.setAttributeValue( MgrInfoVO.TS,ts);
 } 


  @Override
  public IVOMeta getMetaData() {
    return VOMetaFactory.getInstance().getVOMeta("mgr.MgrInfoVO");
  }
}