package com.entity;


public class Order {

  private int oid;
  private int aid;
  private int rid;
  private int rcid;
  private int uid;
  private int hid;
  private java.sql.Date ostartTime;
  private java.sql.Date oendTime;
  private double ototalPrice;


  public int getOid() {
    return oid;
  }

  public void setOid(int oid) {
    this.oid = oid;
  }


  public int getAid() {
    return aid;
  }

  public void setAid(int aid) {
    this.aid = aid;
  }


  public int getRid() {
    return rid;
  }

  public void setRid(int rid) {
    this.rid = rid;
  }


  public int getRcid() {
    return rcid;
  }

  public void setRcid(int rcid) {
    this.rcid = rcid;
  }


  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }


  public int getHid() {
    return hid;
  }

  public void setHid(int hid) {
    this.hid = hid;
  }


  public java.sql.Date getOstartTime() {
    return ostartTime;
  }

  public void setOstartTime(java.sql.Date ostartTime) {
    this.ostartTime = ostartTime;
  }


  public java.sql.Date getOendTime() {
    return oendTime;
  }

  public void setOendTime(java.sql.Date oendTime) {
    this.oendTime = oendTime;
  }


  public double getOtotalPrice() {
    return ototalPrice;
  }

  public void setOtotalPrice(double ototalPrice) {
    this.ototalPrice = ototalPrice;
  }

}
