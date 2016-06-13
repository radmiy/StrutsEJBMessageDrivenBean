package by.epamlab.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.epamlab.beans.user.Role;
import by.epamlab.beans.user.User;

/**
 * Created by rdv on 04.06.2016.
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpSession httpSession = httpRequest.getSession();
        String path = httpRequest.getServletPath();
        User user = (User) httpSession.getAttribute("user");
        
        if(user != null) {
	        String textMessage = "Send Message, user=" + user.getName() + "/" + user.getRole() + " go to " + httpRequest.getRequestURL();
			SendRecvClient client = new SendRecvClient();
			try {
				client.sendRecvAsync(textMessage);
				client.stop();
			}catch(Exception err) {
				err.printStackTrace();
			}
        }

		if(path.equals("/reservation.do") || path.equals("/customer.do") || path.equals("/farefamily.do")) {
            if (user == null || user.getRole() == Role.VISITOR) {
                servletRequest.getRequestDispatcher("/index.do").forward(servletRequest, servletResponse);
                return;
            }
        }
        
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
