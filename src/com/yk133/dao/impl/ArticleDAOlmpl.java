package com.yk133.dao.impl;

import com.yk133.dao.ArticleDAO;
import com.yk133.vo.User;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.*;
import java.util.Date;

/**
 * Created by 10606 on 2017/6/21.
 */
public class ArticleDAOlmpl implements ArticleDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    public ArticleDAOlmpl(Connection conn){
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
            str.indexOf(" ") ;
        }
        return str;
    }

    private  int getNum() throws ServletException,SQLException,IOException
    {
        boolean flag=false;
        int ans=-1;
        try{
            String sql = "SELECT nownumid FROM now WHERE id = ?";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,"1");
            pstmt.executeQuery();
            ResultSet rs = this.pstmt.executeQuery();
            String a,b;
            if(rs.next()) {
                flag = true;
                a=rs.getString(1);
                System.out.println("asdf"+a);
                ans=Integer.valueOf(a);
            }
        }catch(Exception e ) {

        }
        finally {
            if(this.pstmt != null){
                try{
                    this.pstmt.close();
                }catch(Exception e) {
                    throw e;
                }
            }
        }

        return ans;
    }

    private  boolean InsertNum(int x) throws ServletException,SQLException,IOException
    {
        System.out.println("ssss"+x);
        boolean flag=false;
        try{
            String sql = "update now set nownumid = ? where Id = ? ";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,String.valueOf(x));
            this.pstmt.setString(2,"1");
            //pstmt.executeUpdate();
            int i = this.pstmt.executeUpdate();
            if(i>0) {
                flag = true;
            }
        }catch(Exception e ) {

        }
        finally {
            if(this.pstmt != null){
                try{
                    this.pstmt.close();
                }catch(Exception e) {
                    throw e;
                }
            }
            if(false==flag)return false;
        }
        return true;
    }

    public String getTimeNow()
    {
        Date timex= new java.sql.Date(new java.util.Date().getTime());
        Time t = new java.sql.Time(new java.util.Date().getTime());
        String xx=timex.toString();
        xx=xx+" "+t.toString();
        return xx;
    }

    public boolean InsertUserNewText(String userid,String TextName,String Text) throws ServletException,SQLException,IOException {
        boolean flag=false;
        int g=0,f=0;
        try{
            String sql = "SELECT name FROM user WHERE userid = ?";
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
            if(!flag)return false;
        }

        Text = ArticleDeal(Text);
        System.out.println(Text);

        try{
            int t=getNum();
            //System.out.println("t is:"+t);
            if(t==-1)return false;
            String sql = "INSERT INTO Textreal(Numid,userid,name,Context,date) VALUE(?,?,?,?,?)";
            //System.out.println(user.getUserid()+"  "+ TextName+" "+Text);
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, String.valueOf(t++));
            this.pstmt.setString(2,userid);
            this.pstmt.setString(3,TextName);
            this.pstmt.setString(4,Text);
            this.pstmt.setString(5,getTimeNow());

            f = this.pstmt.executeUpdate();
            InsertNum(t);
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
