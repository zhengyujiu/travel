package com.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Order {

  private Integer oid;
  private Integer aid;
  private Integer rid;
  private Integer rcid;
  private Integer uid;
  private Integer hid;
  private String ostartTime;
  @Override
  public String toString() {
    return "Order{" +
            "oid=" + oid +
            ", aid=" + aid +
            ", rid=" + rid +
            ", rcid=" + rcid +
            ", uid=" + uid +
            ", hid=" + hid +
            ", ostartTime='" + ostartTime + '\'' +
            ", oendTime='" + oendTime + '\'' +
            ", ototalPrice=" + ototalPrice +
            ", hotel=" + hotel +
            ", attraction=" + attraction +
            ", canteen=" + canteen +
            ", room=" + room +
            '}';
  }

  private String oendTime;
  private double ototalPrice;
  private Hotel hotel;
  private Attraction attraction;
  private Canteen canteen;
  private Room room;

  private User user;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Order() {
  }

  public Canteen getCanteen() {
    return canteen;
  }

  public void setCanteen(Canteen canteen) {
    this.canteen = canteen;
  }
  public Attraction getAttraction() {
    return attraction;
  }

  public void setAttraction(Attraction attraction) {
    this.attraction = attraction;
  }

  public Hotel getHotel() {
    return hotel;
  }

  public void setHotel(Hotel hotel) {
    this.hotel = hotel;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public Order(Integer oid, Integer aid, Integer rid, Integer rcid, Integer uid, Integer hid, String ostartTime, String oendTime, double ototalPrice) {
    this.oid = oid;
    this.aid = aid;
    this.rid = rid;
    this.rcid = rcid;
    this.uid = uid;
    this.hid = hid;
    this.ostartTime = ostartTime;
    this.oendTime = oendTime;
    this.ototalPrice = ototalPrice;
  }
  public Integer getOid() {
    return oid;
  }

  public void setOid(Integer oid) {
    this.oid = oid;
  }


  public Integer getAid() {
    return aid;
  }

  public void setAid(Integer aid) {
    this.aid = aid;
  }


  public Integer getRid() {
    return rid;
  }

  public void setRid(Integer rid) {
    this.rid = rid;
  }


  public Integer getRcid() {
    return rcid;
  }

  public void setRcid(Integer rcid) {
    this.rcid = rcid;
  }


  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }


  public Integer getHid() {
    return hid;
  }

  public void setHid(Integer hid) {
    this.hid = hid;
  }


  public String getOstartTime() {
    return ostartTime;
  }

  public void setOstartTime(String ostartTime) {
    this.ostartTime = ostartTime;
  }


  public String getOendTime() {
    return oendTime;
  }

  public void setOendTime(String oendTime) {
    this.oendTime = oendTime;
  }


  public double getOtotalPrice() {
    return ototalPrice;
  }

  public void setOtotalPrice(double ototalPrice) {
    this.ototalPrice = ototalPrice;
  }

}
