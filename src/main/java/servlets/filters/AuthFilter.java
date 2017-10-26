package servlets.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String isAuth = (String) ((HttpServletRequest)request).getSession().getAttribute("isAuth");
        if(isAuth == null){
            chain.doFilter(request,response);
        } else {
            if("customer".equals(isAuth)) {
                ((HttpServletResponse) response).sendRedirect("/webtravel/user");
            } else {
                ((HttpServletResponse) response).sendRedirect("/webtravel/admin");
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
