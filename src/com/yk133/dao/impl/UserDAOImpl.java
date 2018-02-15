package com.yk133.dao.impl;

import java.io.IOException;
import java.sql.*;
import com.yk133.vo.User;
import com.yk133.dao.IUserDAO;

import javax.servlet.ServletException;

/**
 * Created by 10606 on 2017/6/22.
 */
public class UserDAOImpl implements IUserDAO{
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    public UserDAOImpl(Connection conn){
        this.conn = conn;
    }

    public boolean InsertUser(User user) throws ServletException,SQLException,IOException{
        boolean flag = false;
        int f = 0;

        try{
            String sql = "SELECT name FROM user WHERE userid = ?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,user.getUserid());
            pstmt.executeQuery();
            ResultSet rs = this.pstmt.executeQuery();
            if(rs.next()) {
                flag = true;
            }
        }catch (Exception e){
            throw e;
        }finally {
            if(this.pstmt != null){
                try{
                    this.pstmt.close();
                }catch(Exception e) {
                    throw e;
                }
            }
            if(flag)return false;
        }

        try{
            String sql = "INSERT INTO user(userid,password,name) VALUE(?,?,?)";
            //System.out.println(sql);
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,user.getUserid());
            this.pstmt.setString(2,user.getPwd());
            this.pstmt.setString(3,user.getName());
            System.out.println(pstmt);
            f = this.pstmt.executeUpdate();
        }catch (Exception e) {
            throw e;
        }finally {
            if(f == 1){
                try{
                    this.pstmt.close();
                }catch(Exception e) {
                    throw e;
                }
            }
        }
        if(f == 1)flag = true;
        return flag;
    }

    public boolean findLogin(User user)throws Exception{
        boolean flag = false;
        try{
            String sql = "SELECT name FROM user WHERE userid = ? AND password = ?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,user.getUserid());
            this.pstmt.setString(2,user.getPwd());
            ResultSet rs = this.pstmt.executeQuery();
            if(rs.next()) {
                user.setName(rs.getString(1));
                flag = true;
            }
        }catch (Exception e){
            throw e;
        }finally {
            if(this.pstmt != null){
                try{
                    this.pstmt.close();
                }catch(Exception e) {
                    throw e;
                }
            }
        }
        return flag;
    }

    public boolean DeleteUser(String userid)throws Exception{
        int f=0;
        boolean flag=false;

        try{
            String sql = "delete FROM user where userid = ?";
            //System.out.println(sql);
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,userid);

            System.out.println(pstmt);
             f = this.pstmt.executeUpdate();
        }catch (Exception e) {
            throw e;
        }finally {
            if(f == 1){
                try{
                    this.pstmt.close();
                }catch(Exception e) {
                    throw e;
                }
            }
        }
        if(f == 1)flag = true;
        return flag;
    }


}
/*
<%
  request.setCharacterEncoding("GBK");
%>
<%
  SmartUpload smart = new SmartUpload();
  smart.initialize(pageContext);
  smart.upload();
  String name = smart.getRequest().getParameter("uname");
  IpTimeStamp its = new IpTimeStamp(request.getRemoteAddr());
  String ext = smart.getFiles().getFile(0).getFileExt();
  String fileName = its.getIpTimeRand() + "." + ext;
  smart.getFiles().getFile(0).saveAs(this.getServletContext().getRealPath("/") + "upload" + File.separator + fileName);
%>
 */