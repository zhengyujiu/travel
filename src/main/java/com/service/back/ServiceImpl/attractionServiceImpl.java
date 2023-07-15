package com.service.back.ServiceImpl;

import com.entity.Attraction;
import com.entity.PageBean;
import com.mapper.back.attractionMapper;
import com.service.back.attractionService;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;
public class attractionServiceImpl implements attractionService {
    @Override
    public int getAllCount() {
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        attractionMapper attractionMapper = session.getMapper(attractionMapper.class);
        int count=attractionMapper.getAllCount();
        return count;
    }
    @Override
    public PageBean getAllAttractionInfo(PageBean<Attraction> pageBean) {
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        attractionMapper attractionMapper = session.getMapper(attractionMapper.class);
        int count=attractionMapper.getAllCount();
        pageBean.setTotalCount(count);
        int start=(pageBean.getCurrentPage()-1)* pageBean.getPageSize();
        List<Attraction> attractionList=attractionMapper.getAllAttractionInfo(start,pageBean.getPageSize());
        pageBean.setList(attractionList);
        return pageBean;
    }

    @Override
    public void deleteOneByAid(String aid) {
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        attractionMapper attractionMapper = session.getMapper(attractionMapper.class);
        attractionMapper.deleteOneByAid(aid);
    }

    @Override
    public void updateOneByAttraction(Attraction attraction) {
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        attractionMapper attractionMapper = session.getMapper(attractionMapper.class);
        attractionMapper.updateOneByAttraction(attraction);
    }

    @Override
    public void insertOneAttraction(Attraction attraction) {
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        attractionMapper attractionMapper = session.getMapper(attractionMapper.class);
        attractionMapper.insertOneAttraction(attraction);
    }
}
