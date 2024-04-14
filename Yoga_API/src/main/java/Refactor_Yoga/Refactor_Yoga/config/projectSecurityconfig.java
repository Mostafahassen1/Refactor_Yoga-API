package Refactor_Yoga.Refactor_Yoga.config;

import jakarta.servlet.DispatcherType;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import java.util.Collections;

@Configuration
public class projectSecurityconfig {


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> {

                    requests.requestMatchers("/api/v1/clients/**" ).hasAnyRole("USER" , "INSTRUCTOR") ;

                   requests.requestMatchers(HttpMethod.POST ,"/api/v1/**").hasRole("INSTRUCTOR");
                    requests.requestMatchers(HttpMethod.DELETE,"/api/v1/**").hasRole("INSTRUCTOR");

                   requests.requestMatchers(HttpMethod.GET ,"/api/v1/instructors/**").hasAnyRole("USER" , "INSTRUCTOR" );
                    requests.requestMatchers(HttpMethod.GET ,"/api/v1/payments/**").hasRole( "INSTRUCTOR" );
                   requests.requestMatchers(HttpMethod.GET ,"/api/v1/sessions/**").hasAnyRole("USER" , "INSTRUCTOR" );


                    requests.requestMatchers("/api/v2/**"  ).permitAll();  // Allow access to "/log" without authentication
                    requests.requestMatchers( HttpMethod.GET , "/api/v1/packages/").permitAll();

                    requests.anyRequest().authenticated();    // Require authentication for all other paths
                })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
        ;
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}