package com.entity;



import java.util.List;




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
  private List<Order> userOrders;

  public List<Order> getUserOrders() {
    return userOrders;
  }

  public void setUserOrders(List<Order> userOrders) {
    this.userOrders = userOrders;
  }

  public User() {
  }

  @Override
  public String toString() {
    return "User{" +
            "uid=" + uid +
            ", uname='" + uname + '\'' +
            ", upassword='" + upassword + '\'' +
            ", usex='" + usex + '\'' +
            ", uage=" + uage +
            ", utype=" + utype +
            ", uphone='" + uphone + '\'' +
            ", uemail='" + uemail + '\'' +
            ", ufunds=" + ufunds +
            ", userOrders=" + userOrders +
            '}';
  }

  public User(Integer uid, String uname, String upassword, String usex, Integer uage, Integer utype, String uphone, String uemail, double ufunds) {
    this.uid = uid;
    this.uname = uname;
    this.upassword = upassword;
    this.usex = usex;
    this.uage = uage;
    this.utype = utype;
    this.uphone = uphone;
    this.uemail = uemail;
    this.ufunds = ufunds;
  }


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
