package api.admin.configuration.jwt;

import api.admin.constants.ConstantsSecurity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class GetUsernameWithToken {
    public String getUsernameWithToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(ConstantsSecurity.JWT_FIRMA)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
