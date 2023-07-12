package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Attraction {

  private Integer aid;
  private String aname;
  private String aaddress;
  private String adescription;
  private String atype;
  private double ascore;
  private double aprice;
  private String acity;
  private String apicture;

  public Attraction() {
  }

  public Integer getAid() {
    return aid;
  }

  public void setAid(Integer aid) {
    this.aid = aid;
  }


  public String getAname() {
    return aname;
  }

  public void setAname(String aname) {
    this.aname = aname;
  }


  public String getAaddress() {
    return aaddress;
  }

  public void setAaddress(String aaddress) {
    this.aaddress = aaddress;
  }


  public String getAdescription() {
    return adescription;
  }

  public void setAdescription(String adescription) {
    this.adescription = adescription;
  }


  public String getAtype() {
    return atype;
  }

  public void setAcommentNum(String atype) {
    this.atype = atype;
  }


  public double getAscore() {
    return ascore;
  }

  public void setAscore(double ascore) {
    this.ascore = ascore;
  }


  public double getAprice() {
    return aprice;
  }

  public void setAprice(double aprice) {
    this.aprice = aprice;
  }


  public String getAcity() {
    return acity;
  }

  public void setAcity(String acity) {
    this.acity = acity;
  }


  public String getApicture() {
    return apicture;
  }

  public void setApicture(String apicture) {
    this.apicture = apicture;
  }

}
