package com.service.front;

import com.entity.Canteen;

import java.util.List;

public interface canteenService {

    List<Canteen> getBeginSomeInfo();

    List<Canteen> getSomeByQueryCity(String QueryCity);

    List<Integer> getCanteensWithAttraction(Integer chooseAttraction,Integer ahDistance);

    List<Canteen> getCanteensByHids(List<Integer> list);

    Canteen getOneCanteenlByRcid(Integer rcid);

    Canteen getOneInfo(Integer rcid);
}
