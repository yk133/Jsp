package com.yk133.dao;

import com.yk133.vo.User;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 10606 on 2017/6/22.
 */
public interface ReadMyDAO {
    public String[] ReadMyText(User user) throws Exception ;
    public String[][] ViewTextDiscuss(String textid) throws Exception;
}
