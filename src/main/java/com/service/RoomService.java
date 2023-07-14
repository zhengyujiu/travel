package com.service;

import com.entity.Room;

public interface RoomService {
    Room selectRoomByRid(Integer rid);

    void setRoomState(Integer rid);

    void setRoomState1(Integer oid);
}
