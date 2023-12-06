/*package com.fatma.fruits.sercurity;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .cors().configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest
                                                                          request) {
                        CorsConfiguration config = new CorsConfiguration();

                        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setExposedHeaders(Arrays.asList("Authorization"));
                        config.setMaxAge(3600L);
                        return config;
                    }
                }).and()

                .authorizeHttpRequests().anyRequest().permitAll();
              
        return http.build();

    }


}*/
package com.mohamed.chiens.sercurity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import
org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.http.HttpServletRequest;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
@Bean
 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
{
http.csrf().disable()
 .sessionManagement()
 .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
 .cors()
 .configurationSource(new CorsConfigurationSource() {
     @Override
     public CorsConfiguration getCorsConfiguration(@NonNull HttpServletRequest request) {
         CorsConfiguration configuration = new CorsConfiguration();
         configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
         configuration.setAllowedMethods(Collections.singletonList("*"));
         configuration.setAllowCredentials(true);
         configuration.setAllowedHeaders(Collections.singletonList("*"));
         configuration.setExposedHeaders(List.of("Authorization"));
         configuration.setMaxAge(3600L);
         return configuration;
     }
 })

	 .and()
 
 .authorizeHttpRequests()
 .requestMatchers(HttpMethod.GET, "/api/all").hasAnyAuthority("ADMIN", "USER")
//consulter tous les Chiens
 //.requestMatchers("/api/all/**").hasAnyAuthority("ADMIN","USER")
//consulter un Chien par son id
.requestMatchers(HttpMethod.GET,"/api/getbyid/**").hasAnyAuthority("ADMIN","USER")
//ajouter un nouveau Chien
.requestMatchers(HttpMethod.POST,"/api/addprod/**").hasAnyAuthority("ADMIN")
//modifier un Chien
.requestMatchers(HttpMethod.PUT,"/api/updateprod/**").hasAuthority("ADMIN")
//supprimer un Chien
.requestMatchers(HttpMethod.DELETE,"/api/delprod/**").hasAuthority("ADMIN")
.requestMatchers("/Rc/**").hasAnyAuthority("ADMIN","USER")

.anyRequest().authenticated().and()
.addFilterBefore(new JWTAuthorizationFilter(),BasicAuthenticationFilter.class);
return http.build();

}
}