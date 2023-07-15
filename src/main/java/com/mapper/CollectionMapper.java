package com.mapper;

import com.entity.Collections;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionMapper {
    void addCollection(Collections collections);

    List<Collections> selectCollectionsByUid(@Param("uid") Integer uid);

    void deleteCollectionByClid(@Param("clid") Integer clid);
}
