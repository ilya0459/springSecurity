package ru.netology.dz_Dao_Hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
//@EnableWebSecurity
public class SecurityFileChainConfiguration {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                (authz) -> {
                    authz
                            .requestMatchers(HttpMethod.GET, "/persons/by-name-surname/**").hasRole("USER")
                            .requestMatchers(HttpMethod.GET, "/persons/by-name-surname/**", "/persons/by-city/**").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.GET, "/persons/by-age/**").permitAll()
                            .anyRequest().authenticated();
                }
        ).formLogin(withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsManager userDetailsService() {
        UserDetails user1 = User.builder()  //withDefaultPasswordEncoder()
                .username("Dmitrii")
                .password(encoder().encode("12345"))
                .roles("USER")
                .build();
        UserDetails user2 = User.builder()  //withDefaultPasswordEncoder()
                .username("Nikolay")
                .password(encoder().encode("qwert12345"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

}
