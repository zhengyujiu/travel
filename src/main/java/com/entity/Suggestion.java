package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class Suggestion {

  private Integer sgid;
  private Integer rcid;
  private Integer hid;
  private Integer aid;



  public Integer getSgid() {
    return sgid;
  }

  public void setSgid(Integer sgid) {
    this.sgid = sgid;
  }


  public Integer getRcid() {
    return rcid;
  }

  public void setRcid(Integer rcid) {
    this.rcid = rcid;
  }


  public Integer getHid() {
    return hid;
  }

  public void setHid(Integer hid) {
    this.hid = hid;
  }


  public Integer getAid() {
    return aid;
  }

  public void setAid(Integer aid) {
    this.aid = aid;
  }



  @Override
  public String toString() {
    return "Suggestion{" +
            "sgid=" + sgid +
            ", rcid=" + rcid +
            ", hid=" + hid +
            ", aid=" + aid +

            '}';
  }
}
