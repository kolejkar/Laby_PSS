package com.project.Laboratorium1.configuration;

import org.springframework.context.annotation.Configuration;



//@Configuration
public class SecurityConfig
    //extends WebSecurityConfigurerAdapter
{

   /* @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("test")
                .password("test1")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {



        http
                .authorizeRequests()

                .antMatchers("/*").permitAll()
                .anyRequest().hasRole("USER")
                .and()
                .formLogin()
                //.loginPage("http://localhost:3000/login")
               // .successForwardUrl("http://localhost:3000/logged")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .and()
                .oauth2Login();


    }*/


}
