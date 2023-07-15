package com.service;

import com.entity.Collections;
import com.entity.Order;
import com.entity.PageBean;

import java.util.List;

public interface CollectionService {
    public  void addCollection(Collections collections);

    List<Collections> selectCollectionsByUid(Integer uid);

    PageBean<Collections> getCollectionByPage(List<Collections> collectionsList, PageBean<Collections> pageBean);

    void deleteCollectionByClid(Integer clid);
}
