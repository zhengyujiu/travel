package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FilenameFilter;
import java.io.IOException;

/*非法访问拦截:
//    拦截的资源::
            拦截所有资源
      需要放行的资源:
            1.放行指定页面,即无需登录便可以访问的页面(登录,注册,主页)
            2.静态资源
*/
@WebFilter("/*")
public class LogingAccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        基于http请求
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
//          获取请求的路径
        String url= String.valueOf(request.getRequestURL());
        System.out.println(request.getRequestURL());
        //判断是不是指定页面,指定页面的话就放行
        if (url.contains("login.jsp")||url.contains("register.jsp")||url.contains("homeServlet")||url.contains("index.jsp")){
            System.out.println(2);
            filterChain.doFilter(request,response);
            return;
        }
        //放行静态资源
        if (url.contains("statics")){
            filterChain.doFilter(request,response);
            return;
        }
//        放行指定操作
        if (url.contains("loginServlet")||url.contains("registerServlet") ||url.contains("arriveServlet")
                ||url.contains("orderHotelServlet")||url.contains("orderCanteenServlet")||url.contains("suggestServlet")
                ||url.contains("produceOrderServlet")||url.contains("cancelChooseOrderServlet")){
            filterChain.doFilter(request,response);
            return;
        }
        else {
            //判断是否用户登录
            if (request.getSession().getAttribute("user")!=null){
                filterChain.doFilter(request,response);
                return;
            }
            else {
                request.getSession().setAttribute("filterMsg","请先登录");
                response.sendRedirect("login.jsp");
                System.out.println("不放行");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
