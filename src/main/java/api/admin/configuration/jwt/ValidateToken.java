package api.admin.configuration.jwt;

import api.admin.constants.ConstantsSecurity;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;

public class ValidateToken {
    public Boolean tokenValidate(String token) {
        try {
            Jwts.parser().setSigningKey(ConstantsSecurity.JWT_FIRMA).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new AuthenticationCredentialsNotFoundException("expired or incorrect Token");
        }
    }
}
