package com.yk133.servlet;

import com.yk133.factory.DAOFactory;
import com.yk133.vo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10606 on 2017/6/22.
 */
public class UpdateTextServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        String path = "user.jsp";
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        //HttpSession session = req.getSession(true);
        String userid=(String)req.getSession().getAttribute("userid");

        String NewText = req.getParameter("NewText");
        String TextName = req.getParameter("TextName");
        String username = req.getParameter("user");
        username="2";
        List<String> info = new ArrayList<String>();
        if(NewText == null || NewText.equals("")){
            info.add("Your Text coudld not be empty!");
        }
        if(TextName == null || TextName.equals("")){
            info.add("Text title coudld not be empty!");
        }
        if(username == null || username.equals("")){
            info.add("Username coudld not be empty!");
        }
        //info.add(NewText);
        //info.add(TextName);
        System.out.println(info);
      // System.out.println("A+***** "+userid);
       //System.out.println("B+"+TextName);

        if(info.size() == 0)
        {
            LoginServlet.user.setName(userid);
            User user =  new User();
            user.setUserid(userid);

            try {
                System.out.println(userid +"has write "+TextName);
                if(DAOFactory.getArticleDAOInstance().InsertUserNewText(userid,TextName,NewText)){
                    info.add("Save successfully " + user.getName() + "!");
                    System.out.println("!@#!@#+++++");
                    path = "user.jsp";
                }
                else{
                    info.add("Please try again later!");
                    System.out.println("AAAA!@#!@#+++++");
                }
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        req.setAttribute("info",info);
        //req.getRequestDispatcher(path).forward(req,resp);
        resp.sendRedirect(path);
    }
    public void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        this.doGet(req,resp);
    }
}
