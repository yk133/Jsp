package com.yk133.factory;

import com.yk133.dao.*;
import com.yk133.dao.proxy.ArticleDAOProxy;
import com.yk133.dao.proxy.ReadMyDAOProxy;
import com.yk133.dao.proxy.UserDAOProxy;
import com.yk133.dao.proxy.*;

/**
 * Created by 10606 on 2017/6/22.
 */
public class DAOFactory {
    public static IUserDAO getIUserDAOInstance(){
        return new UserDAOProxy();
    }

    public static ArticleDAO getArticleDAOInstance(){
        return new ArticleDAOProxy();
    }

    public static ReadMyDAO getReadMyDaoInstance() {
        return new ReadMyDAOProxy();
    }

    public static EditMyTextDAO getEditMyTextDaoInstance(){
        return new EditMyTextDAOProxy();
    }

    public static ViewDAO getViewDaoInstance(){
        return new ViewDAOProxy();
    }

}
