package api.admin.configuration.jwt;

import api.admin.constants.ConstantsSecurity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

import java.util.Date;

@Component
public class JwtGenerator {
    public String generateToken(String email) {
        Date currentTime = new Date();
        Date expirationToken = new Date(currentTime.getTime() + ConstantsSecurity.JWT_EXPIRATION_TOKEN);
        String token = Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(expirationToken)
                .signWith(SignatureAlgorithm.HS512, ConstantsSecurity.JWT_FIRMA)
                .compact();
        return token;
    }
}
