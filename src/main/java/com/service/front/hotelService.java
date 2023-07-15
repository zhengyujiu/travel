package com.service.front;

import com.entity.Hotel;

import java.util.List;

public interface hotelService {

    List<Hotel> getBeginSomeInfo();

    List<Hotel> getSomeByQueryCity(String QueryCity);

    List<Integer> getHotelsWithAttraction(Integer chooseAttraction,Integer ahDistance);

    List<Hotel> getHotelsByHids(List<Integer> list);

    Hotel getOneHotelByHid(Integer hid);

    Hotel getOneInfo(Integer hid);

}
