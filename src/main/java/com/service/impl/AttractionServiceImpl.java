package com.service.impl;

import com.mapper.AttractionMapper;
import com.service.AttractionService;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class AttractionServiceImpl implements AttractionService {
    //根据景点名称查找景点id
    @Override
    public Integer selectAidByAname(String aname) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        AttractionMapper mapper = session.getMapper(AttractionMapper.class);
        return  mapper.selectAidByAname(aname);
    }
//根据景点名称查找景点价格
    @Override
    public double selectApriceByAname(String aname) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        AttractionMapper mapper = session.getMapper(AttractionMapper.class);
        double v = mapper.selectApriceByAname(aname);
        return v;

    }
}
