package com.yk133.dao.proxy;
import com.yk133.DbManage.DbManage;
import com.yk133.dao.EditMyTextDAO;
import com.yk133.dao.impl.EditMyTextDAOlmpl;
import com.yk133.vo.User;

/**
 * Created by 10606 on 2017/6/23.
 */
public class EditMyTextDAOProxy implements EditMyTextDAO {
    private DbManage dbc = null;
    private EditMyTextDAO dao = null;
    public EditMyTextDAOProxy()
    {
        try
        {
            this.dbc = new DbManage();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        this.dao = new EditMyTextDAOlmpl(this.dbc.getConnection());
    }

    public boolean DeleteMyText(User user, String id)throws Exception
    {
        boolean flag = false;
        try
        {
            //dbc = new DbManage();
            flag = this.dao.DeleteMyText(user,id);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
        return flag;
    }

    public boolean DeleteMyAllText(String user)throws Exception
    {
        boolean flag = false;
        try
        {
            flag = this.dao.DeleteMyAllText(user);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
        return flag;
    }

    public boolean ReEditMyText(User user, String id,String Title,String NewText)throws Exception {
        boolean flag = false;
        try
        {
            //dbc = new DbManage();
            flag = this.dao.ReEditMyText(user,id,Title,NewText);
        }catch (Exception e){
            throw e;
        }finally{
            this.dbc.close();
        }
        return flag;
    }

}
