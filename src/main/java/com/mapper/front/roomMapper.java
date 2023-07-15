package com.mapper.front;

import com.entity.Room;

import java.util.List;

public interface roomMapper {

    List<Room> getSomeInfoByRoomTypePrice(Room room);

    List<Room> getBeginSomeInfoByHid(Integer hid);

}
