package lava.springsecurity5.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestValidationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        /* HttpServletRequest, httpServletResponse 는 HTTP에 특화된 메서들을 추가로 제공하기 때문에 다운 캐스팅 한다. */

        var httpRequest = (HttpServletRequest) request;
        var httpResponse = (HttpServletResponse) response;

        String requestId = httpRequest.getHeader("Request-ID");

        if (requestId == null || requestId.isBlank()) {
            httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        /* 헤더가 있으면 request 와 response를 필터 체인의 다음 필터로 전달한다. */
        filterChain.doFilter(request, response);
    }
}
