package servlets.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String isAuth = (String) ((HttpServletRequest)request).getSession().getAttribute("isAuth");
        if("customer".equals(isAuth)){
            chain.doFilter(request,response);
        } else{
            ((HttpServletResponse) response).sendRedirect("/webtravel/auth");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
