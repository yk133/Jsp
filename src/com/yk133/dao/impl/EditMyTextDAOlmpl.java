package com.yk133.dao.impl;

/**
 * Created by 10606 on 2017/6/23.
 */

import com.yk133.dao.EditMyTextDAO;
import com.yk133.vo.User;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditMyTextDAOlmpl implements EditMyTextDAO{
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    public EditMyTextDAOlmpl(Connection conn){
        this.conn = conn;
    }
    private String ArticleDeal(String str)
    {
        str=str.replaceAll("<","&lt;");
        str=str.replaceAll("<=","&le;");
        str=str.replaceAll(">","&gt;");
        str=str.replaceAll(">=","&ge;");


        while (str.indexOf("\n") != -1) {
            str = str.substring(0, str.indexOf("\n")) + "<br>"
                    + str.substring(str.indexOf("\n") + 1);
        }
        while (str.indexOf(" ") != -1) {
            str = str.substring(0, str.indexOf(" ")) + "&nbsp;"
                    + str.substring(str.indexOf(" ") + 1);
            str.indexOf(" ");
        }
        return str;
    }

    public boolean DeleteMyText(User user,String id) throws ServletException,SQLException,IOException {
        //System.out.println("AAAAAAAA$$$$$$$$");
        boolean flag=false;
        int g=0,f=0;
        try{
            String sql = "SELECT name FROM user WHERE userid = ? ";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,user.getUserid());
            pstmt.executeQuery();
            ResultSet rs = this.pstmt.executeQuery();
            if(rs.next()) {
                flag = true;
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            if(this.pstmt != null){
                try{
                    this.pstmt.close();
                }catch(Exception e) {
                    throw e;
                }
            }
            //System.out.println("AAAAAAAA$$$$$$$$");
            if(flag==false)return false;
        }
        //System.out.println("AAAAAAAA$$$$$$$$");

        try{
            String sql ="delete from Textreal where NumId = ? ";
           // System.out.println(user.getUserid()+"  "+ TextName+" "+Text);
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,id);
            //this.pstmt.setString(2,TextName);
            //Integer a=new I
            //this.pstmt.setString(3,Text);
            f = this.pstmt.executeUpdate();
        }catch (Exception e) {
            throw e;
        }finally {
            if(f>0){
                try{
                    this.pstmt.close();
                }catch(Exception e) {
                    throw e;
                }
            }
        }
        if(flag==false)return flag;
        else flag=false;

        try{
            String sql ="delete from Discuss where TextId = ? ";
            // System.out.println(user.getUserid()+"  "+ TextName+" "+Text);
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,id);

            f = this.pstmt.executeUpdate();
        }catch (Exception e) {
            throw e;
        }finally {
            if(f>0){
                try{
                    this.pstmt.close();
                }catch(Exception e) {
                    throw e;
                }
            }
        }
        if(f>0)flag=true;
        return flag;
    }

    public boolean ReEditMyText(User user,String id,String Title,String NewText) throws ServletException,SQLException,IOException {
        boolean flag=false;
        int g=0,f=0;
        try{
            String sql = "SELECT name FROM user WHERE userid = ?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,user.getUserid());
            pstmt.executeQuery();
            ResultSet rs = this.pstmt.executeQuery();
            if(rs.next()) {
                flag = true;
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            if(this.pstmt != null){
                try{
                    this.pstmt.close();
                }catch(Exception e) {
                    throw e;
                }
            }
            if(!flag)return false;
        }

        NewText = ArticleDeal(NewText);

        try{

            String sql ="update Textreal set Context = ? ,name = ? where NumId = ?  ";
            // System.out.println(user.getUserid()+"  "+ TextName+" "+Text);
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,NewText);
            this.pstmt.setString(2,Title);
            this.pstmt.setString(3,id);
            f = this.pstmt.executeUpdate();
        }catch (Exception e) {
            throw e;
        }finally {
            if(f >0){
                try{
                    this.pstmt.close();
                }catch(Exception e) {
                    throw e;
                }
            }
        }
        if(f >0)flag = true;
        return flag;
    }

    public boolean DeleteMyAllText(String userid) throws ServletException,SQLException,IOException {
        //System.out.println("AAAAAAAA$$$$$$$$");
        boolean flag=false;
        int g=0,f=0;
        try{
            String sql = "SELECT name FROM user WHERE userid = ? ";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,userid);
            pstmt.executeQuery();
            ResultSet rs = this.pstmt.executeQuery();
            if(rs.next()) {
                flag = true;
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            if(this.pstmt != null){
                try{
                    this.pstmt.close();
                }catch(Exception e) {
                    throw e;
                }
            }
            if(flag==false)return false;
        }

        //System.out.println("AAAAAAAA$$$$$$$$");
        flag=false;
         g=0;int i=0;
        f=0;
        String textid[] = new String [500];
        try{
            String sql = "SELECT textid FROM textreal WHERE userid = ? ";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,userid);
            pstmt.executeQuery();
            ResultSet rs = this.pstmt.executeQuery();

            while(rs.next()) {
                flag = true;
                textid[i++]=rs.getString(1);
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            if(this.pstmt != null){
                try{
                    this.pstmt.close();
                }catch(Exception e) {
                    throw e;
                }
            }
            if(flag==false)return false;
        }

        for(int x=0;x<i;x++)
        {
            try{
                String sql ="delete from discuss where textId = ? ";
                // System.out.println(user.getUserid()+"  "+ TextName+" "+Text);
                this.pstmt = this.conn.prepareStatement(sql);
                this.pstmt.setString(1,textid[x]);
                f = this.pstmt.executeUpdate();
            }catch (Exception e) {
                throw e;
            }finally {
                if(f>0){
                    try{
                        this.pstmt.close();
                    }catch(Exception e) {
                        throw e;
                    }
                }
            }
        }
        if(f ==0)return false;

        try{
            String sql ="delete from Textreal where userId = ? ";
            // System.out.println(user.getUserid()+"  "+ TextName+" "+Text);
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,userid);
            //this.pstmt.setString(2,TextName);
            //Integer a=new I
            //this.pstmt.setString(3,Text);
            f = this.pstmt.executeUpdate();
        }catch (Exception e) {
            throw e;
        }finally {
            if(f>0){
                try{
                    this.pstmt.close();
                }catch(Exception e) {
                    throw e;
                }
            }
        }
        if(f >0)flag = true;
        return flag;
    }

}
