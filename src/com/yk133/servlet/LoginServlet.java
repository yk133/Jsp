package com.yk133.servlet;

import com.yk133.factory.DAOFactory;
import com.yk133.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10606 on 2017/6/22.
 */

public class LoginServlet extends HttpServlet{
    public static User user;
    public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        //resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        HttpSession ss=req.getSession(true);
        String path = "success.jsp";
        String userid = req.getParameter("userid");
        String name = "";

        boolean flag=false;
        String pwd = req.getParameter("pwd");
        List<String> info = new ArrayList<String>();
        if(userid == null || userid.equals("")){
            info.add("UserID coudld not be empty!");
        }
        if(pwd == null || pwd.equals("")){
            info.add("Userpassword coudld not be empty!");
        }

        if(info.size() == 0){
            //info.add("hello");
            user = new User();
            user.setUserid(userid);
            user.setPwd(pwd);
            try{
                if(DAOFactory.getIUserDAOInstance().findLogin(user)){
                    info.add("HI " + user.getName() + "!");
                    name = user.getName();
                    flag=true;
                }
                else {
                    info.add("Wrong UserID or wrong User password!");
                    path = "failure.jsp";
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        req.setAttribute("info",info);
        req.setAttribute("nowuserid",userid);
        req.setAttribute("nowname",name);

        /*
        if(userid.equals("yk133") && flag==true ) {

            req.getRequestDispatcher("AdminPage.jsp").forward(req, resp);
        }
        else
        */
        req.getSession().setAttribute("userid",userid);
        req.getRequestDispatcher(path).forward(req,resp);
    }
    public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        this.doGet(req,resp);
    }
}
