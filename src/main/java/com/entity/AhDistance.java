package com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AhDistance {

  private Integer hid;
  private Integer aid;
  private String cityName;
  private Integer distance;

  public Integer getHid() {
    return hid;
  }
  public void setHid(Integer hid) {
    this.hid = hid;
  }
  public Integer getAid() {
    return aid;
  }
  public void setAid(Integer aid) {
    this.aid = aid;
  }
  public String getcityName() {
    return cityName;
  }
  public void setcityName(String cityName) {
    this.cityName = cityName;
  }


  public Integer getDistance() {
    return distance;
  }

  public void setDistance(Integer distance) {
    this.distance = distance;
  }

}
