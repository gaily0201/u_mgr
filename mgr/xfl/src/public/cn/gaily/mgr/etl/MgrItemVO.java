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
*����״̬
*/
public static final String EXERESULT="exeresult";
/**
*�ϲ㵥������
*/
public static final String FPK="fpk";
/**
*��ע
*/
public static final String NOTE="note";
/**
*�ӱ�����
*/
public static final String PK="pk";
/**
*ͬ������
*/
public static final String SYNTYPE="syntype";
/**
*��ע������
*/
public static final String TABLEINFO="tableinfo";
/**
*������
*/
public static final String TABLENAME="tablename";
/**
*ʱ���
*/
public static final String TS="ts";
/**
*�к�
*/
public static final String VROWNO="vrowno";
/** 
* ��ȡԤ���ֶ�2
*
* @return Ԥ���ֶ�2
*/
public String getAttr2 () {
return (String) this.getAttributeValue( MgrItemVO.ATTR2);
 } 

/** 
* ����Ԥ���ֶ�2
*
* @param attr2 Ԥ���ֶ�2
*/
public void setAttr2 ( String attr2) {
this.setAttributeValue( MgrItemVO.ATTR2,attr2);
 } 

/** 
* ��ȡԤ���ֶ�3
*
* @return Ԥ���ֶ�3
*/
public String getAttr3 () {
return (String) this.getAttributeValue( MgrItemVO.ATTR3);
 } 

/** 
* ����Ԥ���ֶ�3
*
* @param attr3 Ԥ���ֶ�3
*/
public void setAttr3 ( String attr3) {
this.setAttributeValue( MgrItemVO.ATTR3,attr3);
 } 

/** 
* ��ȡԤ���ֶ�4
*
* @return Ԥ���ֶ�4
*/
public String getAttr4 () {
return (String) this.getAttributeValue( MgrItemVO.ATTR4);
 } 

/** 
* ����Ԥ���ֶ�4
*
* @param attr4 Ԥ���ֶ�4
*/
public void setAttr4 ( String attr4) {
this.setAttributeValue( MgrItemVO.ATTR4,attr4);
 } 

/** 
* ��ȡԤ���ֶ�5
*
* @return Ԥ���ֶ�5
*/
public String getAttr5 () {
return (String) this.getAttributeValue( MgrItemVO.ATTR5);
 } 

/** 
* ����Ԥ���ֶ�5
*
* @param attr5 Ԥ���ֶ�5
*/
public void setAttr5 ( String attr5) {
this.setAttributeValue( MgrItemVO.ATTR5,attr5);
 } 

/** 
* ��ȡ����״̬
*
* @return ����״̬
*/
public String getExeresult () {
return (String) this.getAttributeValue( MgrItemVO.EXERESULT);
 } 

/** 
* ��������״̬
*
* @param exeresult ����״̬
*/
public void setExeresult ( String exeresult) {
this.setAttributeValue( MgrItemVO.EXERESULT,exeresult);
 } 

/** 
* ��ȡ�ϲ㵥������
*
* @return �ϲ㵥������
*/
public String getFpk () {
return (String) this.getAttributeValue( MgrItemVO.FPK);
 } 

/** 
* �����ϲ㵥������
*
* @param fpk �ϲ㵥������
*/
public void setFpk ( String fpk) {
this.setAttributeValue( MgrItemVO.FPK,fpk);
 } 

/** 
* ��ȡ��ע
*
* @return ��ע
*/
public String getNote () {
return (String) this.getAttributeValue( MgrItemVO.NOTE);
 } 

/** 
* ���ñ�ע
*
* @param note ��ע
*/
public void setNote ( String note) {
this.setAttributeValue( MgrItemVO.NOTE,note);
 } 

/** 
* ��ȡ�ӱ�����
*
* @return �ӱ�����
*/
public String getPk () {
return (String) this.getAttributeValue( MgrItemVO.PK);
 } 

/** 
* �����ӱ�����
*
* @param pk �ӱ�����
*/
public void setPk ( String pk) {
this.setAttributeValue( MgrItemVO.PK,pk);
 } 

/** 
* ��ȡͬ������
*
* @return ͬ������
*/
public String getSyntype () {
return (String) this.getAttributeValue( MgrItemVO.SYNTYPE);
 } 

/** 
* ����ͬ������
*
* @param syntype ͬ������
*/
public void setSyntype ( String syntype) {
this.setAttributeValue( MgrItemVO.SYNTYPE,syntype);
 } 

/** 
* ��ȡ��ע������
*
* @return ��ע������
*/
public String getTableinfo () {
return (String) this.getAttributeValue( MgrItemVO.TABLEINFO);
 } 

/** 
* ���ñ�ע������
*
* @param tableinfo ��ע������
*/
public void setTableinfo ( String tableinfo) {
this.setAttributeValue( MgrItemVO.TABLEINFO,tableinfo);
 } 

/** 
* ��ȡ������
*
* @return ������
*/
public String getTablename () {
return (String) this.getAttributeValue( MgrItemVO.TABLENAME);
 } 

/** 
* ���ñ�����
*
* @param tablename ������
*/
public void setTablename ( String tablename) {
this.setAttributeValue( MgrItemVO.TABLENAME,tablename);
 } 

/** 
* ��ȡʱ���
*
* @return ʱ���
*/
public UFDateTime getTs () {
return (UFDateTime) this.getAttributeValue( MgrItemVO.TS);
 } 

/** 
* ����ʱ���
*
* @param ts ʱ���
*/
public void setTs ( UFDateTime ts) {
this.setAttributeValue( MgrItemVO.TS,ts);
 } 

/** 
* ��ȡ�к�
*
* @return �к�
*/
public String getVrowno () {
return (String) this.getAttributeValue( MgrItemVO.VROWNO);
 } 

/** 
* �����к�
*
* @param vrowno �к�
*/
public void setVrowno ( String vrowno) {
this.setAttributeValue( MgrItemVO.VROWNO,vrowno);
 } 


  @Override
  public IVOMeta getMetaData() {
    return VOMetaFactory.getInstance().getVOMeta("mgr.MgrItemVO");
  }
}