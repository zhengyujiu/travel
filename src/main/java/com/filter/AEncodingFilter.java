package com.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebFilter("/*")
public class AEncodingFilter implements Filter {
    private ServletContext servletContext;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        基于http
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        //处理post的乱码请求
        request.setCharacterEncoding("UTF-8");

        //处理get请求且服务器范本在tomcat8以下的
        String method =request.getMethod();
        //如果是get请求
        if("get".equalsIgnoreCase(method)){
            //服务器版本在tomcat8以下的

            String serverInfo = servletContext.getServerInfo();
            String versionStr=serverInfo.substring(serverInfo.indexOf("/")+1,serverInfo.indexOf("."));
            if (Integer.parseInt(versionStr)<8){
                HttpServletRequest myRequest=new MyWapper(request);
                filterChain.doFilter( myRequest, response);
                return;
            }
        }
        filterChain.doFilter( request, response);
    }

    @Override
    public void destroy() {

    }
    class  MyWapper extends HttpServletRequestWrapper{
        private HttpServletRequest request;
        public MyWapper(HttpServletRequest request){
            super(request);
            this.request=request;
        }
//        重写getParamet方法

        @Override
        public String getParameter(String name) {
           String value =request.getParameter(name);
           if (value!=null&&!"".equals(value.trim())){
               try {
//                   将默认iso-8859-1编码 的字符转换成utf8
                   value=new String(value.getBytes("ISO-8859-1"),"UTF-8");
               } catch (UnsupportedEncodingException e) {
                   e.printStackTrace();
               }
           }
           return value;
        }
    }
}
