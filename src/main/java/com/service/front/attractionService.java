package com.service.front;

import com.entity.Attraction;

import java.util.List;

//通过该接口处理在前端有关景点的所有数据
public interface attractionService {

    //该方法用于查询景点的前10条数据，用于在前端页面中展示出来，人为规定只查询10条数据
    List<Attraction> getBeginSomeInfo();
    List<String> getAllTypesInfo();
    List<Attraction> getAllInfoByType(String atype);
    List<Attraction> getSomeByQueryCity(String acity);
    Attraction getOneInfo(Integer aid);
}
