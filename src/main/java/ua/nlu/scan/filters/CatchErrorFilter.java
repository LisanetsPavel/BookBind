package ua.nlu.scan.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pc8 on 11.12.15.
 */
public class CatchErrorFilter implements Filter {
    private static final Logger logger = Logger.getLogger(CatchErrorFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Throwable ex) {
            ex.printStackTrace();
            logger.error("Some exception catched by CatchErrorFilter", ex);
            resp.sendRedirect("/error");
        }
    }

    @Override
    public void destroy() {

    }
}
