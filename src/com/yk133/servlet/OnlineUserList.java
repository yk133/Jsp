package com.yk133.servlet;

/**
 * Created by 10606 on 2017/6/22.
 */
import java.util.* ;
import javax.servlet.* ;
import javax.servlet.http.* ;
public class OnlineUserList implements ServletContextListener,HttpSessionAttributeListener,HttpSessionListener {
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


