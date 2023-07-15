package com.service.front.frontImpl;

import com.entity.Canteen;
import com.mapper.front.canteenMapper;
import com.service.front.canteenService;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class canteenServiceImpl implements canteenService {

    @Override
    public List<Canteen> getBeginSomeInfo() {
        SqlSession session= SqlSessionFactoryUtil.getsqlSession();
        canteenMapper canteenMapper =session.getMapper(canteenMapper.class);
        return canteenMapper.getBeginSomeInfo();
    }

    @Override
    public List<Canteen> getSomeByQueryCity(String QueryCity) {
        SqlSession session= SqlSessionFactoryUtil.getsqlSession();
        canteenMapper canteenMapper =session.getMapper(canteenMapper.class);
        return canteenMapper.getSomeByQueryCity(QueryCity);
    }

    @Override
    public List<Integer> getCanteensWithAttraction(Integer chooseAttraction, Integer ahDistance) {
        SqlSession session= SqlSessionFactoryUtil.getsqlSession();
        canteenMapper canteenMapper =session.getMapper(canteenMapper.class);
        return canteenMapper.getCanteensWithAttraction(chooseAttraction,ahDistance);
    }

    @Override
    public List<Canteen> getCanteensByHids(List<Integer> list) {
        SqlSession session= SqlSessionFactoryUtil.getsqlSession();
        canteenMapper canteenMapper =session.getMapper(canteenMapper.class);
        return canteenMapper.getCanteensByHids(list);
    }

    @Override
    public Canteen getOneCanteenlByRcid(Integer rcid) {
        SqlSession session= SqlSessionFactoryUtil.getsqlSession();
        canteenMapper canteenMapper =session.getMapper(canteenMapper.class);
        return canteenMapper.getOneCanteenByRcid(rcid);
    }

    @Override
    public Canteen getOneInfo(Integer rcid) {
        SqlSession session= SqlSessionFactoryUtil.getsqlSession();
        canteenMapper canteenMapper =session.getMapper(canteenMapper.class);
        return canteenMapper.getOneInfo(rcid);
    }

}
