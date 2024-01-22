package api.admin.configuration.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final GetRequestToken getRequestToken;
    private final ValidateToken validateToken;
    private final GetAuthenticationRequest getAuthenticationRequest;

    public JwtAuthenticationFilter(GetRequestToken getRequestToken, ValidateToken validateToken, GetAuthenticationRequest getAuthenticationRequest) {
        this.getRequestToken = getRequestToken;
        this.validateToken = validateToken;
        this.getAuthenticationRequest = getAuthenticationRequest;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getRequestToken.obtainToken(request);
            if (token != null && validateToken.tokenValidate(token)) {
                UsernamePasswordAuthenticationToken auth = getAuthenticationRequest.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (Exception ex) {
            SecurityContextHolder.clearContext();
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido o caducado");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
