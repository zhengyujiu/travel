package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Canteen {

  private Integer rcid;
  private String rcname;
  private String rcaddress;
  private String rcintroduce;
  private String rcphone;
  private String rctime;
  private double rcprice;
  private String rccity;
  private String rcpicture;

  public Canteen() {
  }

  public Integer getRcid() {
    return rcid;
  }

  public void setRcid(Integer rcid) {
    this.rcid = rcid;
  }


  public String getRcname() {
    return rcname;
  }

  public void setRcname(String rcname) {
    this.rcname = rcname;
  }


  public String getRcaddress() {
    return rcaddress;
  }

  public void setRcaddress(String rcaddress) {
    this.rcaddress = rcaddress;
  }


  public String getrcintroduce() {
    return rcintroduce;
  }

  public void setrcintroduce(String rcintroduce) {
    this.rcintroduce = rcintroduce;
  }


  public String getRcphone() {
    return rcphone;
  }

  public void setRcphone(String rcphone) {
    this.rcphone = rcphone;
  }


  public String getRctime() {
    return rctime;
  }

  public void setRctime(String rctime) {
    this.rctime = rctime;
  }


  public double getRcprice() {
    return rcprice;
  }

  public void setRcprice(double rcprice) {
    this.rcprice = rcprice;
  }


  public String getRccity() {
    return rccity;
  }

  public void setRccity(String rccity) {
    this.rccity = rccity;
  }


  public String getRcpicture() {
    return rcpicture;
  }

  public void setRcpicture(String rcpicture) {
    this.rcpicture = rcpicture;
  }

}
