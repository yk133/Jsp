package com.yk133.dao.proxy;

import com.yk133.DbManage.DbManage;
import com.yk133.dao.impl.ViewDAOlmpl;
import com.yk133.dao.ViewDAO;

/**
 * Created by 10606 on 2017/6/24.
 */
public class ViewDAOProxy implements ViewDAO {

    private DbManage dbc = null;
    private ViewDAO dao = null;
    public ViewDAOProxy()
    {
        try
        {
            this.dbc = new DbManage();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        this.dao = new ViewDAOlmpl(this.dbc.getConnection());
    }
    public String[] ViewAuthor(String id) throws Exception
    {
        String [] flag = null;
        try
        {
            //dbc = new DbManage();
            flag = this.dao.ViewAuthor(id);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
        return flag;
    }


    public String[] ViewText(String id) throws Exception {
        String [] flag = null;
        try
        {
            //dbc = new DbManage();
            flag = this.dao.ViewText(id);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
        return flag;
    }

    public String[][] ViewAllTextAndAuthor() throws Exception {
        String [][] flag = null;
        try
        {
            //dbc = new DbManage();
            flag = this.dao.ViewAllTextAndAuthor();
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
        return flag;
    }

    public String[][] ViewAllAuthor() throws Exception{
        String [][] flag = null;
        try
        {
            //dbc = new DbManage();
            flag = this.dao.ViewAllAuthor();
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
        return flag;
    }

    public String[][] ViewTextDiscuss(String textid) throws Exception{
        String [][] flag = null;
        try
        {
            //dbc = new DbManage();
            flag = this.dao.ViewTextDiscuss(textid);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
        return flag;

    }

    public boolean AddTextDiscuss(String Textid,String userid,String Mydis) throws Exception{
         boolean flag = false;
        try
        {
            //dbc = new DbManage();
            flag = this.dao.AddTextDiscuss(Textid,userid,Mydis);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
        return flag;
    }


    public String[][] ViewFindText(String Key) throws Exception {
        String flag[][] = null;
        try
        {
            //dbc = new DbManage();
            flag = this.dao.ViewFindText(Key);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
        return flag;
    }

}
