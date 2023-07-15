package com.service.impl;

import com.mapper.CanteenMapper;
import com.service.CanteenService;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class CanteenServiceImpl implements CanteenService {
//    根据餐厅名称查找餐厅id
    @Override
    public Integer selectRcidByRcname(String rcname) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        CanteenMapper mapper = session.getMapper(CanteenMapper.class);
        return mapper.selectRcidByRcname(rcname);

    }
}
