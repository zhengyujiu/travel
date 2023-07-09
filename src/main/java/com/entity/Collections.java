package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Collections {

  private Integer clid;
  private Integer aid;
  private Integer uid;
  private Integer rcid;
  private Integer hid;
  private java.sql.Date cltime;


  public Integer getClid() {
    return clid;
  }

  public void setClid(Integer clid) {
    this.clid = clid;
  }


  public Integer getAid() {
    return aid;
  }

  public void setAid(Integer aid) {
    this.aid = aid;
  }


  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
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


  public java.sql.Date getCltime() {
    return cltime;
  }

  public void setCltime(java.sql.Date cltime) {
    this.cltime = cltime;
  }

}
