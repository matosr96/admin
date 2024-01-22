package api.admin.configuration.jwt;

import api.admin.constants.ConstantsSecurity;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class GetAuthenticationRequest {
    public UsernamePasswordAuthenticationToken getAuthentication(String token) {
        String username = Jwts.parser().setSigningKey(ConstantsSecurity.JWT_FIRMA).parseClaimsJws(token).getBody().getSubject();
        return new UsernamePasswordAuthenticationToken(username, null, null);
    }
}
