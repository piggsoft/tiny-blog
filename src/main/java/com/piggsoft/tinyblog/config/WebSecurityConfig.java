package com.piggsoft.tinyblog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // @formatter:off
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //设定哪些不需要权限即可访问
            .authorizeRequests().antMatchers("/resources/**", "/registration").permitAll()
            //剩下的全部需要权限
            .anyRequest().authenticated()
            .and()
                .formLogin().loginPage("/login").permitAll()
            .and()
                .logout()
                //使session失效
                .invalidateHttpSession(true)
                //删除cookie
                .deleteCookies("JSESSIONID")
                .permitAll();
        http
            .headers()
                .defaultsDisabled()
                .cacheControl();
    }
    // @formatter:on

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }


}