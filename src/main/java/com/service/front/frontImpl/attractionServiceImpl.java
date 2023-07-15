package com.service.front.frontImpl;

import com.entity.Attraction;
import com.mapper.front.attractionMapper;
import com.service.front.attractionService;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

//在服务层中通过mapper映射得到对应dao层的接口方法，从而直接执行
public class attractionServiceImpl implements attractionService {

    @Override
    public List<Attraction> getBeginSomeInfo() {
        SqlSession session= SqlSessionFactoryUtil.getsqlSession();
        //加载dao层front包下的处理景点事务的类文件
        attractionMapper attractionMapper =session.getMapper(attractionMapper.class);
        List<Attraction> attractionList= attractionMapper.getBeginSomeInfo();
        return attractionList;
    }

    @Override
    public List<String> getAllTypesInfo() {
        SqlSession session= SqlSessionFactoryUtil.getsqlSession();
        //加载dao层front包下的处理景点事务的类文件
        attractionMapper attractionMapper =session.getMapper(attractionMapper.class);
        return attractionMapper.getAllTypesInfo();
    }

    @Override
    public List<Attraction> getAllInfoByType(String atype) {
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        //加载dao层front包下的处理景点事务的类文件
        attractionMapper attractionMapper = session.getMapper(attractionMapper.class);
        return attractionMapper.getAllInfoByType(atype);
    }

    @Override
    public List<Attraction> getSomeByQueryCity(String acity) {
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        attractionMapper attractionMapper = session.getMapper(attractionMapper.class);
        return attractionMapper.getSomeByQueryCity(acity);
    }

    @Override
    public Attraction getOneInfo(Integer aid) {
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        attractionMapper attractionMapper = session.getMapper(attractionMapper.class);
        return attractionMapper.getOneInfo(aid);
    }

}
