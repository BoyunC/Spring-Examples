package com.example.jpa.springexamples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//            http.csrf().disable();
//            http.headers().frameOptions().sameOrigin();
//            http.authorizeRequests().anyRequest().permitAll();


            http
                    .csrf((csrfConfig) ->
                            csrfConfig.disable()
                    )
                    .headers((headerConfig) ->
                            headerConfig.frameOptions(frameOptionsConfig ->
                                    frameOptionsConfig.sameOrigin()
                            )
                    )
                    .authorizeHttpRequests((authorizeRequests) ->
                            authorizeRequests
                                    .anyRequest().permitAll()
                    );

            return http.build();
        }

}
