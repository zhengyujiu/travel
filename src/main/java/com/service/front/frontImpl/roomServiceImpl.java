package com.service.front.frontImpl;

import com.entity.Room;
import com.mapper.front.roomMapper;
import com.service.front.roomService;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class roomServiceImpl implements roomService {

    @Override
    public List<Room> getSomeInfoByRoomTypePrice(Room room) {
        SqlSession session= SqlSessionFactoryUtil.getsqlSession();
        roomMapper roomMapper =session.getMapper(roomMapper.class);
        return roomMapper.getSomeInfoByRoomTypePrice(room);
    }

    @Override
    public List<Room> getBeginSomeInfoByHid(Integer hid) {
        SqlSession session= SqlSessionFactoryUtil.getsqlSession();
        roomMapper roomMapper =session.getMapper(roomMapper.class);
        return roomMapper.getBeginSomeInfoByHid(hid);
    }
}
