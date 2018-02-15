package com.yk133.dao;

import com.yk133.vo.User;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 10606 on 2017/6/23.
 */
public interface EditMyTextDAO {
    public boolean DeleteMyText(User user, String id)throws Exception ;
    public boolean ReEditMyText(User user, String id,String Title,String NewText)throws Exception ;
    public boolean DeleteMyAllText(String userid) throws ServletException,SQLException,IOException, Exception;
}
