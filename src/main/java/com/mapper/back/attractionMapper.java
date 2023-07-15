package com.mapper.back;

import com.entity.Attraction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface attractionMapper {

        int getAllCount();

        List<Attraction> getAllAttractionInfo(@Param("start")int start, @Param("pageSize")int pageSize);

        void deleteOneByAid(String aid);

        void updateOneByAttraction(Attraction attraction);

        void insertOneAttraction(Attraction attraction);

}
