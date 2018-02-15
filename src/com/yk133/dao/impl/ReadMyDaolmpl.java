package com.yk133.dao.impl;

import com.yk133.vo.User;
import com.yk133.dao.ReadMyDAO;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 10606 on 2017/6/22.
 */
public class ReadMyDaolmpl implements ReadMyDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    String results[] = new String [800];
    public ReadMyDaolmpl(Connection conn){
        this.conn = conn;
    }

    public String[] ReadMyText(User user) throws ServletException,SQLException,IOException {
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
            if(flag==false)return null;
        }

        ResultSet rs;
        flag=false;

        try{
           // System.out.println("user id is"+user.getUserid());
            String sql = "SELECT  numid,name,context,date from Textreal where userid = ?  order by date desc ";
           // System.out.println(user.getUserid()+"  "+ TextName+" "+Text);
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,user.getUserid());

            rs = this.pstmt.executeQuery();
            int i=0;
            while(rs.next()) {
                flag = true;
                results[i++]=rs.getString(1);
                results[i++]=rs.getString(2);
                //System.out.println(results[i-1]);
                results[i++]=rs.getString(3);
                results[i++]=rs.getString(4);

            }
        }catch (Exception e) {
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
        if(flag==false)return null;
        return results;
    }

    public String[][] ViewTextDiscuss(String textid) throws Exception {
            boolean flag=false;
            int g=0,f=0;
            ResultSet rs;
            String results[][]= new String [400][4];

            try{
                String sql = "SELECT  userid,discuss,ddate  from Discuss where textid = ? ORDER  by ddate desc";
                this.pstmt = this.conn.prepareStatement(sql);
                this.pstmt.setString(1,textid);
                rs = this.pstmt.executeQuery();
                int i=0;
                while(rs.next()){
                    flag = true;
                    results[i][0]=rs.getString(1);
                    results[i][1]=rs.getString(2);
                    results[i][2]=rs.getString(3);
                    System.out.println(results[0][0]);
                    System.out.println(results[0][1]);
                    System.out.println(results[0][2]);
                    i++;
                }
            }
            catch (Exception e) {throw e;
            }finally {
                if(this.pstmt != null){
                    try{
                        this.pstmt.close();
                    }catch(Exception e) {
                        throw e;
                    }
                }
            }
            if(flag==false)return null;
            return results;
        }

}
