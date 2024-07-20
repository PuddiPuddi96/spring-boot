package it.davide.course.mainproject.conf.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    private static final String EMPLOYEE = "EMPLOYEE";
    private static final String MANAGER = "MANAGER";
    private static final String ADMIN = "ADMIN";

    private static final String BASE_URL = "/magic-api/employees";

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT user_id, pw, active FROM members WHERE user_id=?"
        );

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT user_id, role FROM roles where user_id=?"
        );

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(configurer ->
//                configurer
//                        .requestMatchers(HttpMethod.GET, BASE_URL).hasRole(EMPLOYEE)
//                        .requestMatchers(HttpMethod.GET, BASE_URL + "/**").hasRole(EMPLOYEE)
//                        .requestMatchers(HttpMethod.POST, BASE_URL).hasRole(MANAGER)
//                        .requestMatchers(HttpMethod.PUT, BASE_URL + "/**").hasRole(MANAGER)
//                        .requestMatchers(HttpMethod.DELETE, BASE_URL + "/**").hasRole(ADMIN)
//        );
//
//        //Basic authentication
//        http.httpBasic(Customizer.withDefaults());
//
//        //Disable CSRF
//        http.csrf(AbstractHttpConfigurer::disable);
//
//        return http.build();

        http.authorizeHttpRequests(configurer ->
                configurer
                        .anyRequest()
                        .authenticated()
        ).formLogin(form ->
                form
                        .loginPage("/login")
                        .loginProcessingUrl("/authenticate")
                        .permitAll()
        ).logout(LogoutConfigurer::permitAll
        );

        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//
//        UserDetails davide = User.builder()
//                .username("Puddi")
//                .password("{noop}test123")
//                .roles(EMPLOYEE)
//                .build();
//
//        UserDetails luca = User.builder()
//                .username("GigaPuddi")
//                .password("{noop}test123")
//                .roles(EMPLOYEE, MANAGER)
//                .build();
//
//        UserDetails nicola = User.builder()
//                .username("Puddolo")
//                .password("{noop}test123")
//                .roles(EMPLOYEE, MANAGER, ADMIN)
//                .build();
//
//        return new InMemoryUserDetailsManager(davide, luca, nicola);
//    }

//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }
}
