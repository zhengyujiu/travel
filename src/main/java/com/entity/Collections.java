package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
public class Collections {

  private Integer clid;
  private Integer aid;



  private Integer uid;
  private Integer rcid;
  private Integer hid;
  private String cltime;
  private Hotel hotel;
  private Canteen canteen;

  public Hotel getHotel() {
    return hotel;
  }

  public Collections(Integer clid, Integer aid, Integer uid, Integer rcid, Integer hid, String cltime, Hotel hotel, Canteen canteen, Attraction attraction) {
    this.clid = clid;
    this.aid = aid;
    this.uid = uid;
    this.rcid = rcid;
    this.hid = hid;
    this.cltime = cltime;
    this.hotel = hotel;
    this.canteen = canteen;
    this.attraction = attraction;
  }

  public void setHotel(Hotel hotel) {
    this.hotel = hotel;
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

  private Attraction attraction;

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


  public String getCltime() {
    return cltime;
  }

  public void setCltime(String cltime) {
    this.cltime = cltime;
  }

  public Collections(Integer clid, Integer aid, Integer uid, Integer rcid, Integer hid, String cltime) {
    this.clid = clid;
    this.aid = aid;
    this.uid = uid;
    this.rcid = rcid;
    this.hid = hid;
    this.cltime = cltime;
  }

  public Collections() {
  }
}
