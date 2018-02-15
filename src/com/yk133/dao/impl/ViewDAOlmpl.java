package com.yk133.dao.impl;

import com.yk133.dao.ViewDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.Date;

/**
 * Created by 10606 on 2017/6/24.
 */
public class ViewDAOlmpl implements ViewDAO {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    public ViewDAOlmpl(Connection conn){
        this.conn = conn;
    }

    public String getTimeNow()
    {
        Date timex= new java.sql.Date(new java.util.Date().getTime());
        Time t = new java.sql.Time(new java.util.Date().getTime());
        String xx=timex.toString();
        xx=xx+" "+t.toString();
        return xx;
    }

    @Override
    public String[] ViewAuthor(String id) throws Exception {
        boolean flag=false;
        int g=0,f=0;
        ResultSet rs;
        String results[]= new String [300];

        try{
            String sql = "SELECT  userid  from Textreal where numid = ? ";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,id);
            rs = this.pstmt.executeQuery();
            int i=0;
            while(rs.next()) {
                flag = true;
                results[i++]=rs.getString(1);
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

    public String[] ViewText(String id) throws Exception {
        boolean flag=false;
        int g=0,f=0;
        ResultSet rs;
        String results[]= new String [300];

        try{
            String sql = "SELECT  name,context  from Textreal where numid = ? ";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,id);
            rs = this.pstmt.executeQuery();
            int i=0;
            while(rs.next()) {
                flag = true;
                results[i++]=rs.getString(1);
                results[i++]=rs.getString(2);
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

    public String[][] ViewFindText(String Key) throws Exception{
        boolean flag=false;
        int g=0,f=0;
        ResultSet rs;
        String results[][]= new String [300][5];
        try{
            String sql = "SELECT  numid,name  from textreal where name like  ?  or Context like ? ";
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,"%"+Key+"%");
            this.pstmt.setString(2,"%"+Key+"%");
            rs = this.pstmt.executeQuery();
            int i=0;
            while(rs.next()) {
                flag = true;
                results[i][0]=rs.getString(1);
                results[i][1]=rs.getString(2);
                //results[i++][1]=rs.getString(2);
                i++;
            }
        }
        catch (Exception e) {
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




    public String[][] ViewAllTextAndAuthor() throws Exception {
        boolean flag=false;
        int g=0,f=0;
        ResultSet rs;
        String results[][]= new String [300][5];

        try{
            String sql = "SELECT numid,userid,name,context  from Textreal order by date desc";
            this.pstmt = this.conn.prepareStatement(sql);
           // this.pstmt.setString(1,id);
            rs = this.pstmt.executeQuery();
            int i=0;
            while(rs.next()) {
                flag = true;
                results[i][0]=rs.getString(1);
                results[i][1]=rs.getString(2);
                results[i][2]=rs.getString(3);
                results[i++][3]=rs.getString(4);
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


    public String[][] ViewAllAuthor() throws Exception {
        boolean flag=false;
        int g=0,f=0;
        ResultSet rs;
        String results[][]= new String [300][3];

        try{
            String sql = "SELECT  userid  from user  ";
            this.pstmt = this.conn.prepareStatement(sql);

            rs = this.pstmt.executeQuery();
            int i=0;
            while(rs.next()) {
                flag = true;
                results[i][0]=rs.getString(1);
                //results[i++][1]=rs.getString(2);
                i++;
            }
        }
        catch (Exception e) {
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
        String results[][]= new String [400][5];

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

    public boolean AddTextDiscuss(String Textid,String userid,String Mydis) throws Exception{
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


        try{
            String sql = "INSERT INTO Discuss(userid,ddate,discuss,textid) VALUE(?,?,?,?)";
            //System.out.println(user.getUserid()+"  "+ TextName+" "+Text);
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, userid);
            this.pstmt.setString(2,getTimeNow());
            this.pstmt.setString(3,Mydis);
            this.pstmt.setString(4,Textid);

            //Integer a=new I
            //System.out.println("TTTTTTT:"+t);

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
