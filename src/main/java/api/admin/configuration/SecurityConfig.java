package api.admin.configuration;

import api.admin.configuration.jwt.GetAuthenticationRequest;
import api.admin.configuration.jwt.GetRequestToken;
import api.admin.configuration.jwt.JwtAuthenticationFilter;
import api.admin.configuration.jwt.ValidateToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(getRequestToken(), validateToken(), getAuthenticationRequest());
    }

    @Bean
    public GetRequestToken getRequestToken() {
        return new GetRequestToken();
    }

    @Bean
    public ValidateToken validateToken() {
        return new ValidateToken();
    }

    @Bean
    public GetAuthenticationRequest getAuthenticationRequest() {
        return new GetAuthenticationRequest();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(HttpMethod.POST, "/api/v1/signin").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/v1/signup").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/v1/send/{mail}").permitAll()
                        .anyRequest().authenticated()
                );
                http.csrf(AbstractHttpConfigurer::disable)
                        .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
               ;
        return http.build();
    }
}