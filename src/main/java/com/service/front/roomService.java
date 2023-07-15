package com.service.front;

import com.entity.Room;

import java.util.List;

public interface roomService {

    List<Room> getSomeInfoByRoomTypePrice(Room room);

    List<Room> getBeginSomeInfoByHid(Integer hid);

}
