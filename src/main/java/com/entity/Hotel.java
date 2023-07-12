package com.entity;






public class Hotel {
  private Integer hid;
  private String hname;
  private String haddress1;
  private String hemail;
  private String hphone;
  private String hcity;
  private String hpicture;

  @Override
  public String toString() {
    return "Hotel{" +
            "hid=" + hid +
            ", hname='" + hname + '\'' +
            ", haddress1='" + haddress1 + '\'' +
            ", hemail='" + hemail + '\'' +
            ", hphone='" + hphone + '\'' +
            ", hcity='" + hcity + '\'' +
            ", hpicture='" + hpicture + '\'' +
            '}';
  }

  public Hotel(){
    super();
  }

  public Integer getHid() {
    return hid;
  }

  public void setHid(Integer hid) {
    this.hid = hid;
  }


  public String getHname() {
    return hname;
  }

  public void setHname(String hname) {
    this.hname = hname;
  }


  public String getHaddress1() {
    return haddress1;
  }

  public void setHaddress1(String haddress1) {
    this.haddress1 = haddress1;
  }

  public String getHemail() {
    return hemail;
  }

  public void setHemail(String hemail) {
    this.hemail = hemail;
  }


  public String getHphone() {
    return hphone;
  }

  public void setHphone(String hphone) {
    this.hphone = hphone;
  }


  public String getHcity() {
    return hcity;
  }

  public void setHcity(String hcity) {
    this.hcity = hcity;
  }


  public String getHpicture() {
    return hpicture;
  }

  public void setHpicture(String hpicture) {
    this.hpicture = hpicture;
  }


}
