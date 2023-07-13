package com.service;

import com.entity.User;

import javax.jws.soap.SOAPBinding;

public interface UserService {
    public User queryUserByUname(String uname);

    public User queryUserByUphone(String uphone);
    public User queryUserByUemail(String uemail);

    public int insertUser(User user);


}
