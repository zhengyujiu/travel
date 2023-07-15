package com.service.front.frontImpl;

import com.entity.Suggestion;
import com.mapper.front.suggestMapper;
import com.service.front.suggestService;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class suggestServiceImpl implements suggestService {

    @Override
    public List<Suggestion> getAllInfo() {
        SqlSession session= SqlSessionFactoryUtil.getsqlSession();
        suggestMapper suggestMapper=session.getMapper(suggestMapper.class);
        return suggestMapper.getAllInfo();
    }
}
