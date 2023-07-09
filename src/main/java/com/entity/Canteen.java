package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Canteen {

  private Integer rcid;
  private String rcname;
  private String rcaddress;
  private String rcIntegerroduce;
  private String rcphone;
  private String rctime;
  private double rcprice;
  private String rccity;
  private String rcpicture;


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


  public String getRcIntegerroduce() {
    return rcIntegerroduce;
  }

  public void setRcIntegerroduce(String rcIntegerroduce) {
    this.rcIntegerroduce = rcIntegerroduce;
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
