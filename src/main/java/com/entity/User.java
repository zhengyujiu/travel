package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

  private Integer uid;
  private String uname;
  private String upassword;
  private String usex;
  private Integer uage;
  private Integer utype;
  private String uphone;
  private String uemail;
  private double ufunds;


  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }


  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }


  public String getUpassword() {
    return upassword;
  }

  public void setUpassword(String upassword) {
    this.upassword = upassword;
  }


  public String getUsex() {
    return usex;
  }

  public void setUsex(String usex) {
    this.usex = usex;
  }


  public Integer getUage() {
    return uage;
  }

  public void setUage(Integer uage) {
    this.uage = uage;
  }


  public Integer getUtype() {
    return utype;
  }

  public void setUtype(Integer utype) {
    this.utype = utype;
  }


  public String getUphone() {
    return uphone;
  }

  public void setUphone(String uphone) {
    this.uphone = uphone;
  }


  public String getUemail() {
    return uemail;
  }

  public void setUemail(String uemail) {
    this.uemail = uemail;
  }


  public double getUfunds() {
    return ufunds;
  }

  public void setUfunds(double ufunds) {
    this.ufunds = ufunds;
  }

}
