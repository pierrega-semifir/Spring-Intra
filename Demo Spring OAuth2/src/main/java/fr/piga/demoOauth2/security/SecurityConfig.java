package fr.piga.demoOauth2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final OAuth2AuthenticationSuccessHandler oAuth2authenticationSuccessHandler;

    public SecurityConfig(OAuth2AuthenticationSuccessHandler oAuth2authenticationSuccessHandler) {
        this.oAuth2authenticationSuccessHandler = oAuth2authenticationSuccessHandler;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        req -> req
                                .anyRequest()
                                .authenticated()
                )
                .oauth2Login(
                        oauth2 -> oauth2
                                .successHandler(oAuth2authenticationSuccessHandler));
        return http.build();
    }
}
