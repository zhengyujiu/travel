package com.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

  private Integer oid;
  private Integer aid;
  private Integer rid;
  private Integer rcid;
  private Integer uid;
  private Integer hid;
  private String ostartTime;
  private String oendTime;
  private double ototalPrice;


  public Integer getOid() {
    return oid;
  }

  public void setOid(Integer oid) {
    this.oid = oid;
  }


  public Integer getAid() {
    return aid;
  }

  public void setAid(Integer aid) {
    this.aid = aid;
  }


  public Integer getRid() {
    return rid;
  }

  public void setRid(Integer rid) {
    this.rid = rid;
  }


  public Integer getRcid() {
    return rcid;
  }

  public void setRcid(Integer rcid) {
    this.rcid = rcid;
  }


  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }


  public Integer getHid() {
    return hid;
  }

  public void setHid(Integer hid) {
    this.hid = hid;
  }


  public String getOstartTime() {
    return ostartTime;
  }

  public void setOstartTime(String ostartTime) {
    this.ostartTime = ostartTime;
  }


  public String getOendTime() {
    return oendTime;
  }

  public void setOendTime(String oendTime) {
    this.oendTime = oendTime;
  }


  public double getOtotalPrice() {
    return ototalPrice;
  }

  public void setOtotalPrice(double ototalPrice) {
    this.ototalPrice = ototalPrice;
  }

}
