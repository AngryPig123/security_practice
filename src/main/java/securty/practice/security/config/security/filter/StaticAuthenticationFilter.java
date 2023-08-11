package securty.practice.security.config.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class StaticAuthenticationFilter implements Filter {

    @Value("${authorization.key}")
    private String authorization;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String reqAuthorization = httpServletRequest.getHeader("Authorization");

        if (authorization.equals(reqAuthorization)) {
            chain.doFilter(request, response);
        } else {

            log.info("no authorization!!");
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

    }

}
