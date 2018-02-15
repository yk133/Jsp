package com.yk133.servlet;

import com.yk133.factory.DAOFactory;
import com.yk133.vo.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10606 on 2017/6/22.
 */
public class InsertServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        req.setCharacterEncoding("UTF-8");

        String path = "failure.jsp";
        String userid = req.getParameter("userid");
        String pwd = req.getParameter("pwd");
        String name = req.getParameter("name");

        List<String> info = new ArrayList<String>();
        if(userid == null || userid.equals("")){
            info.add("UserID coudld not be empty!");
        }
        if(pwd == null || pwd.equals("")){
            info.add("Userpassword coudld not be empty!");
        }
        if(name == null || name.equals("")){
            info.add("Username coudld not be empty!");
        }

        if(info.size() == 0)
        {
            User user = new User();
            user.setUserid(userid);
            user.setPwd(pwd);
            user.setName(name);
            try {
                if(DAOFactory.getIUserDAOInstance().InsertUser(user)){
                    info.add("Welcome to join us " + user.getName() + "!");
                    path = "login.jsp";
                }
                else{
                    info.add("Please try again later! or the userid has existed");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        req.setAttribute("info",info);
        req.getRequestDispatcher(path).forward(req,resp);
    }
    public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        this.doGet(req,resp);
    }
}
