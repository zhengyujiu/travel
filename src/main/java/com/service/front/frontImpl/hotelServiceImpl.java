package com.service.front.frontImpl;

import com.entity.Hotel;
import com.mapper.front.hotelMapper;
import com.service.front.hotelService;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class hotelServiceImpl implements hotelService {

    @Override
    public List<Hotel> getBeginSomeInfo() {
        SqlSession session= SqlSessionFactoryUtil.getsqlSession();
        hotelMapper hotelMapper =session.getMapper(hotelMapper.class);
        return hotelMapper.getBeginSomeInfo();
    }

    @Override
    public List<Hotel> getSomeByQueryCity(String QueryCity) {
        SqlSession session= SqlSessionFactoryUtil.getsqlSession();
        hotelMapper hotelMapper =session.getMapper(hotelMapper.class);
        return hotelMapper.getSomeByQueryCity(QueryCity);
    }

    @Override
    public List<Integer> getHotelsWithAttraction(Integer chooseAttraction, Integer ahDistance) {
        SqlSession session= SqlSessionFactoryUtil.getsqlSession();
        hotelMapper hotelMapper =session.getMapper(hotelMapper.class);
        return hotelMapper.getHotelsWithAttraction(chooseAttraction,ahDistance);
    }

    @Override
    public List<Hotel> getHotelsByHids(List<Integer> list) {
        SqlSession session= SqlSessionFactoryUtil.getsqlSession();
        hotelMapper hotelMapper =session.getMapper(hotelMapper.class);
        return hotelMapper.getHotelsByHids(list);
    }

    @Override
    public Hotel getOneHotelByHid(Integer hid) {
        SqlSession session= SqlSessionFactoryUtil.getsqlSession();
        hotelMapper hotelMapper =session.getMapper(hotelMapper.class);
        return hotelMapper.getOneHotelByHid(hid);
    }

    @Override
    public Hotel getOneInfo(Integer hid) {
        SqlSession session= SqlSessionFactoryUtil.getsqlSession();
        hotelMapper hotelMapper =session.getMapper(hotelMapper.class);
        return hotelMapper.getOneInfo(hid);
    }

}
