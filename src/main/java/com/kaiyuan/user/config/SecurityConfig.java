package com.kaiyuan.user.config;

import com.kaiyuan.user.service.MyFilterSecurityInterceptor;
import com.kaiyuan.user.service.MyUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MyUserDetailsService myUserDetailsService;  //注入我们自己的AuthenticationProvider

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;
    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        //super.configure(http);
        http
                .authorizeRequests()
                .antMatchers("/css/**","/fonts/**","/img/**","/js/**").permitAll()//,"/login"
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/","/common/**","/member/**","/index","/milestone","/addGysUserOne","/addGysUserTwo","/updatePassword","/usermanagement/resetpassword","/member/zchcompany/{username}","/member/tymcompany/{username}").permitAll()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/admin/login").permitAll()
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login/form")
                .successHandler(myAuthenticationSuccessHandler)
               // .successForwardUrl("/")
                //.defaultSuccessUrl("/home")
                .failureUrl("/login?error")
                .permitAll() //登录页面用户任意访问
                .and()
                .logout().permitAll() //注销行为任意访问
//                .formLogin().loginPage("/login").loginProcessingUrl("/login/form").permitAll()  //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
//                .and()
//                .logout().permitAll() //注销行为任意访问
//                .and()
//                .authorizeRequests().anyRequest().authenticated() //任何请求,登录后可以访问
//                .and()
                .and()
                .csrf().disable();
        logger.info("myFilterSecurityInterceptor-f");
        http
                .addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
        logger.info("myFilterSecurityInterceptor-e");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        logger.info("myUserDetailsService");
        auth.userDetailsService(myUserDetailsService); //user Details Service验证

//        auth
//        .inMemoryAuthentication()
//            .withUser("admin").password("123456").roles("USER")
//            .and()
//            .withUser("test").password("test123").roles("ADMIN");
    }


//    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        return new MD5PasswordEncoder()    ;
//    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
