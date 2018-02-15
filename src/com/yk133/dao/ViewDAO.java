package com.yk133.dao;

/**
 * Created by 10606 on 2017/6/24.
 */
public interface ViewDAO {
    public String [] ViewAuthor(String id) throws Exception ;

    public String[] ViewText(String id)throws Exception ;

    public String[][] ViewAllTextAndAuthor()throws Exception ;

    public String[][] ViewAllAuthor() throws Exception;

    public String[][] ViewTextDiscuss(String textid) throws Exception;

    public boolean AddTextDiscuss(String Textid,String userid,String Mydis) throws Exception;

    public String[][] ViewFindText(String Key) throws Exception;
}
