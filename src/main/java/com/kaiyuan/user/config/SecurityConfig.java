package com.kaiyuan.user.config;

import com.kaiyuan.user.service.MyFilterSecurityInterceptor;
import com.kaiyuan.user.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MyUserDetailsService myUserDetailsService;  //注入我们自己的AuthenticationProvider

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;
    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/favicon.ico","/css/**","/fonts/**","/img/**","/js/**").permitAll()//,"/login"
                .antMatchers("/","/registerUserName","/common/**","/member/**","/index","/milestone","/addGysUserOne","/addGysUserTwo","/deliverinform","/updatePassword","/usermanagement/resetpassword","/member/zchcompany/{username}","/member/tymcompany/{username}").permitAll()
                .antMatchers("/administrator/approval").hasRole("SPGLY")
                .antMatchers("/administrator/procurement").hasRole("CGGLY")
                .antMatchers("/administrator/medicalsupplies").hasRole("YYPGLY")
                .antMatchers("/administrator/**").hasRole("ADMIN")
                .antMatchers("/usermanagement/**").hasRole("USER")
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/member/login")
                .loginProcessingUrl("/login/form")
                .successHandler(myAuthenticationSuccessHandler)
                .failureUrl("/login?error")
                .permitAll() //登录页面用户任意访问
                .and()
                .logout().permitAll() //注销行为任意访问
                .and()
                .csrf().disable();
        http
                .addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService); //user Details Service验证

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
