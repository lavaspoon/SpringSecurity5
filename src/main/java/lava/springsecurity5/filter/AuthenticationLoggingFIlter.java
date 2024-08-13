package lava.springsecurity5.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationLoggingFIlter implements Filter {

    private final Logger logger = Logger.getLogger(AuthenticationLoggingFIlter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        var httpRequest = (HttpServletRequest) request;

        var requestId = httpRequest.getHeader("Request-ID");

        logger.config("Successfullt authenticated request with id " + requestId);

        filterChain.doFilter(request, response);
    }
}
