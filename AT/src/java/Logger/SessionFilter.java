
package Logger;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(filterName = "SessionFilter", urlPatterns = {"/*"})
public class SessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req1=(HttpServletRequest)request;
        HttpServletResponse res1=(HttpServletResponse)response;
        
        String sessionUser=(String)req1.getSession().getAttribute("username");
        String sessionRole = (String)req1.getSession().getAttribute("role");
        String currentPath=req1.getRequestURL().toString();
        
        if(sessionUser !=null && sessionRole.equals("1")){
            if(currentPath.contains("AlbaniaTravel/login.jsf")){
                res1.sendRedirect(req1.getContextPath()+"/admin/admin.jsf");
            }else if(currentPath.contains("user")){
                res1.sendRedirect(req1.getContextPath()+"/admin/admin.jsf");
            }else{
                chain.doFilter(request, response);
            }
        }
        else if(sessionUser !=null && sessionRole.equals("2")){
            if(currentPath.contains("AlbaniaTravel/index.jsf")){
                res1.sendRedirect(req1.getContextPath()+"/index.jsf");
            }else if(currentPath.contains("admin")){
                res1.sendRedirect(req1.getContextPath()+"/admin/admin.jsf");
            }
            else{
                chain.doFilter(request, response);
            }
        }else{
            if(currentPath.contains("admin")){
                res1.sendRedirect(req1.getContextPath()+"/admin.jsf");
            }else{
                chain.doFilter(request, response);
            }
        }
        
       
    }

    @Override
    public void destroy() {
        
    }
    
   
    
}