package trinh.vo.van.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final String ERROR_MESSAGE_UNAUTHORIZED = "Responding with unauthorized error. Message -{}";

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.error(ERROR_MESSAGE_UNAUTHORIZED,authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED ,authException.getMessage());
    }
}
