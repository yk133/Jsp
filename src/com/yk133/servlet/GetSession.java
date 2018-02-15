package com.yk133.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 10606 on 2017/6/22.
 */
public class GetSession  implements ServletContextListener,HttpSessionAttributeListener,HttpSessionListener{
    private ServletContext app = null ;
    public void contextInitialized(ServletContextEvent sce){
        this.app = sce.getServletContext() ;
        this.app.setAttribute("online",new TreeSet()) ;	// 准备集合
    }
    public void contextDestroyed(ServletContextEvent sce){
    }

    public void attributeAdded(HttpSessionBindingEvent se){
        Set all = (Set) this.app.getAttribute("online") ;
        all.add(se.getValue()) ;
        this.app.setAttribute("online",all) ;
    }
    public void attributeRemoved(HttpSessionBindingEvent se){
        Set all = (Set) this.app.getAttribute("online") ;
        all.remove(se.getSession().getAttribute("userid")) ;
        this.app.setAttribute("online",all);
    }

    public void attributeReplaced(HttpSessionBindingEvent se){}
    public void sessionCreated(HttpSessionEvent se){}
    public void sessionDestroyed(HttpSessionEvent se){
        Set all = (Set) this.app.getAttribute("online") ;
        all.remove(se.getSession().getAttribute("userid")) ;
        this.app.setAttribute("online",all) ;
    }

}
