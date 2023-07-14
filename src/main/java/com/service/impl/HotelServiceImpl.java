package com.service.impl;

import com.mapper.HotelMapper;
import com.service.HotelService;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class HotelServiceImpl implements HotelService {
    @Override
    public Integer selectHidByHname(String hname) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        HotelMapper mapper = session.getMapper(HotelMapper.class);
        return mapper.selectHidByHname(hname);

    }
}
