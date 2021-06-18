package taxi.web.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {
    private static final String DRIVER_ID = "driver_id";
    private Set<String> allowedUrls;

    @Override
    public void init(FilterConfig filterConfig)
            throws ServletException {
        allowedUrls = new HashSet<>();
        allowedUrls.add("/login");
        allowedUrls.add("/drivers/add");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpRequest.getSession();

        Long driverId = (Long) session.getAttribute(DRIVER_ID);
        if (allowedUrls.contains(httpRequest.getServletPath())) {
            filterChain.doFilter(httpRequest, httpResponse);
            return;
        }
        if (driverId == null) {
            httpResponse.sendRedirect("/login");
            return;
        }
        filterChain.doFilter(httpRequest, httpResponse);
    }
}
