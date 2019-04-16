package upcnews.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "LoginFilter",urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取请求资源，截取
        String uri = request.getRequestURI();
        // 截取 【login.jsp或login】
        String requestPath = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
        // 判断： 先放行一些资源：
        if (uri.contains("static")) {
            filterChain.doFilter(request, response);
        }else if(uri.contains("visitorLogin")) {
            filterChain.doFilter(request, response);
        } else if ("login".equals(requestPath) || "login.jsp".equals(requestPath) || "index".equals(requestPath) || "index".equals(requestPath) || "zhuce.jsp".equals(requestPath) || "zhuce".equals(requestPath)) {

            filterChain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession(false);
            if (session != null) {

                Object obj = session.getAttribute("user");

                //如果获取的内容不为空
                if (obj != null) {
                    filterChain.doFilter(request, response);
                    return;
                } else {
                    //如果获取的内容为空，说明没有登陆； 跳转到登陆
                    uri = "/index.jsp";
                }

            }
            request.getRequestDispatcher(uri).forward(request, response);
        }
    }

    public void destroy() {

    }
}
