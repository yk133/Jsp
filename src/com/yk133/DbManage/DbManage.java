package com.yk133.DbManage;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Caiser on 2016/11/30.
 */
public class DbManage {
    private static final String USER = "root";
    private static final String PWD = "root";
    private static final String DRIVER ="com.mysql.jdbc.Driver";
    private static final String URL ="jdbc:mysql://localhost:3306/mya";
    private Connection conn = null;

    public DbManage() throws Exception{
        try{
            Class.forName(DRIVER);
            this.conn = DriverManager.getConnection(URL,USER,PWD);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    public Connection getConnection(){
        return this.conn;
    }

    public void close() throws Exception{
        if(this.conn != null){
            try{
                this.conn.close();
            }catch(Exception e){
                throw  e;
            }
        }
    }
}
