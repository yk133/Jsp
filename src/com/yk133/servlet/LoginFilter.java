package com.yk133.servlet;

/**
 * Created by 10606 on 2017/6/22.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter {
    public static final String login_page = "/login.jsp";
    public static final String logout_page = "/registered.jsp";
    public void destroy(){

    }
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)throws ServletException, IOException {
        // servletRequest.setCharacterEncoding("UTF-8");2
        //servletResponse.setCharacterEncoding("UTF-8");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String currentURL = request.getRequestURI();
        String ctxPath = request.getContextPath();
        //������Ŀ����ʱ����ҳ�浱ǰ·��
        String targetURL = currentURL.substring(ctxPath.length());
        System.out.println(targetURL);
        List<String>info = new ArrayList<String>();

        HttpSession session = request.getSession(false);
        //�Ե�ǰҳ������жϣ������ǰҳ�治Ϊ��¼ҳ��
        if(!(("/login.jsp".equals(targetURL)) || ("/failure.jsp".equals(targetURL)) || ("/UnMainPage.jsp".equals(targetURL))||("/file.jsp".equals(targetURL)) ||("/registered.jsp".equals(targetURL)))){
            //System.out.println("1"+targetURL+"ctxPath:"+ctxPath+"currentURL:"+currentURL);
            //�ڲ�Ϊ��½ҳ��ʱ���ٽ����жϣ�������ǵ�½ҳ��Ҳû��session����ת����¼ҳ�棬
            if(session == null || session.getAttribute("admin") == null){
                info.add("You are not logged in!");
                request.setAttribute("info",info);
                request.getRequestDispatcher(login_page).forward(request,response);
                return;
            }else{
                //�����ʾ��ȷ����ȥѰ����һ��������������ڣ������������ҳ����ת
                filterChain.doFilter(request, response);
                return;
            }
        }else{
            //�����ʾ�����ǰҳ���ǵ�½ҳ�棬��ת����½ҳ��
            try{
                filterChain.doFilter(request, response);
            }catch (Exception e){
                throw e;
            }

            return;
        }

    }
    public void init(FilterConfig filterConfig)throws ServletException{

    }
}