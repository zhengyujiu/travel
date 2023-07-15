package com.service.impl;

import com.entity.Room;
import com.mapper.OrderMapper;
import com.mapper.RoomMapper;
import com.service.RoomService;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class RoomServiceImpl implements RoomService {

//通过rid查找出room
    @Override
    public Room selectRoomByRid(Integer rid) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        RoomMapper mapper = session.getMapper(RoomMapper.class);
        Room room = mapper.selectRoomByRid1(rid);
        return room;
    }
    //通过rid设置房间的状态为0,不可用状态
 @Override
    public void setRoomState(Integer rid) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        RoomMapper mapper = session.getMapper(RoomMapper.class);
        mapper.setRoomState(rid);
    }
//通过rid设置房间的状态为1,可用
    @Override
    public void setRoomState1(Integer rid) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        RoomMapper mapper = session.getMapper(RoomMapper.class);
        mapper.setRoomState1(rid);
    }
}
