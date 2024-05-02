package Refactor_Yoga.Refactor_Yoga.config;

import Refactor_Yoga.Refactor_Yoga.Filter.JwtAuthenticationFilter;
import Refactor_Yoga.Refactor_Yoga.util.ClientDetailes;
import jakarta.servlet.DispatcherType;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import java.util.Collections;

@Configuration
@EnableWebSecurity

public class projectSecurityconfig {

private  final ClientInstructorLogConfig clientInstructorLogConfig ;
private  final JwtAuthenticationFilter jwtAuthenticationFilter ;

    public projectSecurityconfig(
            ClientInstructorLogConfig clientInstructorLogConfig,
            JwtAuthenticationFilter jwtAuthenticationFilter) {

        this.clientInstructorLogConfig = clientInstructorLogConfig;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> {

                    requests.requestMatchers("/api/v1/clients/**" ).hasAnyRole("USER" , "INSTRUCTOR") ;

                   requests.requestMatchers(HttpMethod.POST ,"/api/v1/**").hasRole("INSTRUCTOR");
                    requests.requestMatchers(HttpMethod.DELETE,"/api/v1/**").hasRole("INSTRUCTOR");


                    requests.requestMatchers(HttpMethod.GET ,"/api/v1/payments/**").hasRole( "INSTRUCTOR" );
                   requests.requestMatchers(HttpMethod.GET ,"/api/v1/sessions/**").hasAnyRole("USER" , "INSTRUCTOR" );


                    requests.requestMatchers("/api/v2/**"  ).permitAll();  // Allow access to "/log" without authentication
                    requests.requestMatchers( HttpMethod.GET , "/api/v1/packages/").permitAll();

                    requests.anyRequest().authenticated();    // Require authentication for all other paths
                })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        ;
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }


}