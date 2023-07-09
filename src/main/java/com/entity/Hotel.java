package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {

  private Integer hid;
  private String hname;
  private String haddress;
  private String hemail;
  private String hphone;
  private String hcity;
  private String hpicture;


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


  public String getHaddress() {
    return haddress;
  }

  public void setHaddress(String haddress) {
    this.haddress = haddress;
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
