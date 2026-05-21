package com.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth

                        // CSS, JS, images allowed without login
                        .requestMatchers(
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/webjars/**",
                                "/login"
                        ).permitAll()

                        // Student pages
                        .requestMatchers("/student/**").hasRole("STUDENT")

                        // Admin and Librarian pages
                        .requestMatchers(
                                "/dashboard",
                                "/books/**",
                                "/students/**",
                                "/issues/**",
                                "/book-issues/**",
                                "/fines/**",
                                "/reports/**"
                        ).hasAnyRole("ADMIN", "LIBRARIAN")

                        // Only Admin pages
                        .requestMatchers("/settings/**").hasRole("ADMIN")

                        // Any other page needs login
                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login")

                        .successHandler((request, response, authentication) -> {

                            boolean isStudent = authentication.getAuthorities().stream()
                                    .anyMatch(auth -> auth.getAuthority().equals("ROLE_STUDENT"));

                            boolean isAdminOrLibrarian = authentication.getAuthorities().stream()
                                    .anyMatch(auth ->
                                            auth.getAuthority().equals("ROLE_ADMIN") ||
                                            auth.getAuthority().equals("ROLE_LIBRARIAN")
                                    );

                            if (isStudent) {
                                response.sendRedirect("/student/dashboard");
                            } else if (isAdminOrLibrarian) {
                                response.sendRedirect("/dashboard");
                            } else {
                                response.sendRedirect("/login?error");
                            }
                        })

                        .permitAll()
                )

                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )

                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/403")
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails admin = User.withUsername("admin")
                .password("admin123")
                .roles("ADMIN")
                .build();

        UserDetails librarian = User.withUsername("librarian")
                .password("lib123")
                .roles("LIBRARIAN")
                .build();

        UserDetails student = User.withUsername("spoorthireddyy26@gmail.com")
                .password("student123")
                .roles("STUDENT")
                .build();
        UserDetails student1 = User.withUsername("john@gmail.com")
                .password("student123")
                .roles("STUDENT")
                .build();

        UserDetails student2 = User.withUsername("emily@gmail.com")
                .password("student123")
                .roles("STUDENT")
                .build();

        UserDetails student3 = User.withUsername("rahul@gmail.com")
                .password("student123")
                .roles("STUDENT")
                .build();

        return new InMemoryUserDetailsManager(admin, librarian, student);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}