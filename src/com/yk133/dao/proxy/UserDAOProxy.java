package com.yk133.dao.proxy;

import com.yk133.DbManage.DbManage;
import com.yk133.dao.IUserDAO;
import com.yk133.dao.impl.UserDAOImpl;
import com.yk133.vo.User;

/**
 * Created by 10606 on 2017/6/22.
 */
public class UserDAOProxy implements IUserDAO{
    private DbManage dbc = null;
    private IUserDAO dao = null;
    public UserDAOProxy(){
        try{
            this.dbc = new DbManage();
        }catch(Exception e){
            e.printStackTrace();
        }
        this.dao = new UserDAOImpl(this.dbc.getConnection());
    }

    public boolean findLogin(User user)throws Exception{
        boolean flag = false;
        try {
            flag = this.dao.findLogin(user);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
        return flag;
    }


    public boolean InsertUser(User user)throws Exception{
        boolean flag = false;
        try{
            flag = this.dao.InsertUser(user);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return flag;
    }

    public boolean DeleteUser(String userid)throws Exception {
        boolean flag = false;
        try{
            flag = this.dao.DeleteUser(userid);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
        return flag;
    }
}
