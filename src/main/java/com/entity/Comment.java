package com.entity;


public class Comment {

  private int cid;
  private int uid;
  private int aid;
  private int uscore;
  private java.sql.Date cdate;
  private String ccontent;


  public int getCid() {
    return cid;
  }

  public void setCid(int cid) {
    this.cid = cid;
  }


  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }


  public int getAid() {
    return aid;
  }

  public void setAid(int aid) {
    this.aid = aid;
  }


  public int getUscore() {
    return uscore;
  }

  public void setUscore(int uscore) {
    this.uscore = uscore;
  }


  public java.sql.Date getCdate() {
    return cdate;
  }

  public void setCdate(java.sql.Date cdate) {
    this.cdate = cdate;
  }


  public String getCcontent() {
    return ccontent;
  }

  public void setCcontent(String ccontent) {
    this.ccontent = ccontent;
  }

}
