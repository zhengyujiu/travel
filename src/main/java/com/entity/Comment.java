package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {

  private Integer cid;
  private Integer uid;
  private Integer aid;
  private Integer uscore;
  private String cdate;
  private String ccontent;


  public Integer getCid() {
    return cid;
  }

  public void setCid(Integer cid) {
    this.cid = cid;
  }


  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }


  public Integer getAid() {
    return aid;
  }

  public void setAid(Integer aid) {
    this.aid = aid;
  }


  public Integer getUscore() {
    return uscore;
  }

  public void setUscore(Integer uscore) {
    this.uscore = uscore;
  }


  public String getCdate() {
    return cdate;
  }

  public void setCdate(String cdate) {
    this.cdate = cdate;
  }


  public String getCcontent() {
    return ccontent;
  }

  public void setCcontent(String ccontent) {
    this.ccontent = ccontent;
  }

}
