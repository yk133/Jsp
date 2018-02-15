package com.yk133.dao.proxy;

import com.yk133.DbManage.DbManage;
import com.yk133.dao.*;
import com.yk133.dao.impl.*;
import com.yk133.vo.User;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 10606 on 2017/6/22.
 */
public class ReadMyDAOProxy implements ReadMyDAO {
    private DbManage dbc = null;
    private ReadMyDAO dao = null;
    public ReadMyDAOProxy()
    {
        try
        {
            this.dbc = new DbManage();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        this.dao = new ReadMyDaolmpl(this.dbc.getConnection());
    }

    public String[] ReadMyText(User user)throws Exception
    {
        String[] flag = null;
        try
        {
            flag = this.dao.ReadMyText(user);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
        return flag;
    }


    public String[][] ViewTextDiscuss(String textid) throws Exception {
        String[][] flag = null;
        try
        {
            flag = this.dao.ViewTextDiscuss(textid);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
        return flag;
    }


}
