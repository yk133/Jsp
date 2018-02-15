package com.yk133.dao.proxy;

import com.yk133.DbManage.DbManage;
import com.yk133.dao.ArticleDAO;
import com.yk133.dao.impl.ArticleDAOlmpl;
import com.yk133.vo.User;

/**
 * Created by 10606 on 2017/6/21.
 */
public class ArticleDAOProxy implements ArticleDAO {
    private DbManage dbc = null;
    private ArticleDAO dao = null;
    public ArticleDAOProxy()
    {
        try
        {
            this.dbc = new DbManage();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        this.dao = new ArticleDAOlmpl(this.dbc.getConnection());
    }

    public boolean InsertUserNewText(String userid, String name, String TextName)throws Exception
    {
        boolean flag = false;
        try
        {
            //dbc = new DbManage();
            flag = this.dao.InsertUserNewText(userid,name,TextName);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
        return flag;
    }

}
