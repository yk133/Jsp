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
 * Created by 10606 on 2017/6/23.
 */

public class EditMyTextServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
       req.setCharacterEncoding("UTF-8");
        //resp.setCharacterEncoding("UTF-8");

        String path = "failure.jsp";
        String TextId = req.getParameter("TextId");
        String Text = req.getParameter("Text");
        String Title = req.getParameter("Title");

        List<String> info = new ArrayList<String>();
        if(TextId == null || TextId.equals("")){
            info.add("TextID coudld not be empty!");
        }
        if(Text == null || Text.equals("")){
            info.add("Text coudld not be empty!");
        }
        if(Title == null || Title.equals("")){
            info.add("Titlername coudld not be empty!");
        }

        if(info.size() == 0)
        {
            User user=LoginServlet.user;
            try {
                if(DAOFactory.getEditMyTextDaoInstance().ReEditMyText(user,TextId,Title,Text)){
                   info.add("Change Successfully!!<br>");
                    path = "ReadMyText.jsp";
                }
                else{
                    info.add("Please try again later!");
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
