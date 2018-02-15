package com.yk133.dao;

import com.yk133.vo.User;

/**
 * Created by Caiser on 2016/11/30.
 */
public interface IUserDAO {
    public boolean findLogin(User user)throws Exception;
    public boolean InsertUser(User user)throws Exception;
    public boolean DeleteUser(String userid)throws Exception;
}
