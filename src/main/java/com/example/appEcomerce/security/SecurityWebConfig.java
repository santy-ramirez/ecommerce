package com.example.appEcomerce.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity(debug= true)
public class SecurityWebConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().
                httpBasic().and()
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/auth/**").permitAll()
                ).authorizeHttpRequests(auth ->
                        auth.anyRequest().hasAnyAuthority("ADMIN")
                        );
        return http.build();
    }
/*@Bean
public AuthenticationProvider daoAuthenticationProviderq(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
}
   */
@Bean
public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}


}
