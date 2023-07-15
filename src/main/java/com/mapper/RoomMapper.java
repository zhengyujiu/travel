package com.mapper;

import com.entity.Room;
import org.apache.ibatis.annotations.Param;

public interface RoomMapper {
//    通过rid查找房间
    Room selectRoomByRid1(@Param("rid") Integer rid);
//通过rid设置房间的状态为0,不可用状态
    void setRoomState(@Param("rid") Integer rid);
//通过rid设置房间的状态为1,可用状态
    void setRoomState1(@Param("rid") Integer rid);
}
