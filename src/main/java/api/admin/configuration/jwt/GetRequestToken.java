package api.admin.configuration.jwt;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.StringUtils;

public class GetRequestToken {
    public String obtainToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}
