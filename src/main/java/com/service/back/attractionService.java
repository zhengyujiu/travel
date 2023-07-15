package com.service.back;

import com.entity.Attraction;
import com.entity.PageBean;

public interface attractionService {

    int getAllCount();
    PageBean getAllAttractionInfo(PageBean<Attraction> pageBean);

    void deleteOneByAid(String Aid);

    void updateOneByAttraction(Attraction attraction);

    void insertOneAttraction(Attraction attraction);

}
