package com.service.impl;

import com.entity.Collections;
import com.entity.Order;
import com.entity.PageBean;
import com.mapper.CollectionMapper;
import com.mapper.HotelMapper;
import com.service.CollectionService;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CollectionServiceImpl implements CollectionService {

    @Override
    public void addCollection(Collections collections) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        CollectionMapper mapper = session.getMapper(CollectionMapper.class);
        mapper.addCollection(collections);
    }

    @Override
    public List<Collections> selectCollectionsByUid(Integer uid) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        CollectionMapper mapper = session.getMapper(CollectionMapper.class);
        List<Collections> collectionsList = mapper.selectCollectionsByUid(uid);
        return collectionsList;
    }

    @Override
    public PageBean<Collections> getCollectionByPage(List<Collections> collectionsList, PageBean<Collections> pageBean) {
        pageBean.setTotalCount(collectionsList.size());
        int start=0;
//        如果要查询的数量小于订单总数的话,就让start=pageBean.getCurrentPage()-1)*pageBean.getPageSize()
        if ((pageBean.getCurrentPage()-1)*pageBean.getPageSize()<=collectionsList.size()){
            start=(pageBean.getCurrentPage()-1)*pageBean.getPageSize();
        }else {
//            查询的数量大于订单总数,则让start=最后一页刚开始的位置
            pageBean.setCurrentPage(collectionsList.size()/ pageBean.getPageSize()+1);
            start=collectionsList.size()-collectionsList.size()% pageBean.getPageSize();
        }
//        如果 查询的数量大于订单总数则end代表最后一个订单,如果不大于的话,end就是查询的最后一个
        int end=(start + pageBean.getPageSize()) <=collectionsList.size()?start + pageBean.getPageSize():collectionsList.size();
        List<Collections>  collections = collectionsList.subList(start, end);
        pageBean.setList(collections);
        return pageBean;
    }

    @Override
    public void deleteCollectionByClid(Integer clid) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        CollectionMapper mapper = session.getMapper(CollectionMapper.class);
        mapper.deleteCollectionByClid(clid);
    }
}
