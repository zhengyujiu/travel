package com.mapper;

import com.entity.Room;
import org.apache.ibatis.annotations.Param;

public interface RoomMapper {
    Room selectRoomByRid1(@Param("rid") Integer rid);


    void setRoomState(@Param("rid") Integer rid);

    void setRoomState1(@Param("rid") Integer rid);
}
