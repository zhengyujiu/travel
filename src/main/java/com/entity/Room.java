package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Room {
  @Override
  public String toString() {
    return "Room{" +
            "rid=" + rid +
            ", hid=" + hid +
            ", rprice=" + rprice +
            ", rtype='" + rtype + '\'' +
            ", rstate=" + rstate +
            '}';
  }

  private Integer rid;
  private Integer hid;
  private double rprice;
  private String rtype;
  private Integer rstate;

  public Room() {
  }

  public Integer getRid() {
    return rid;
  }

  public void setRid(Integer rid) {
    this.rid = rid;
  }


  public Integer getHid() {
    return hid;
  }

  public void setHid(Integer hid) {
    this.hid = hid;
  }


  public double getRprice() {
    return rprice;
  }

  public void setRprice(double rprice) {
    this.rprice = rprice;
  }


  public String getRtype() {
    return rtype;
  }

  public void setRtype(String rtype) {
    this.rtype = rtype;
  }


  public Integer getRstate() {
    return rstate;
  }

  public void setRstate(Integer rstate) {
    this.rstate = rstate;
  }

}
