package com.springcloud.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//配置类
@Configuration
@EnableWebSecurity    //开启websecurity功能
@EnableGlobalMethodSecurity(prePostEnabled = true)  //开启方法级别的保护
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //WebSecurityConfigurerAdapter配置如何验证用户信息
    //注入AuthenticationManagerBuilder,并通过AuthenticationManagerBuilder创建一个admin的用户,密码,角色
    //使得每个请求都需要认证,会生成一个登陆表单和成功页面,还继承HttpServletHttp等API方法
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        //在内存中加载一个lr用户,密码需要加密
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("lr").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
//                .withUser("lr").password("123456").roles("USER");
//        auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    //定义验证的规则,哪些需要验证,满足的条件
    @Override
    protected void configure(HttpSecurity http)throws Exception{

        http.
                authorizeRequests()
                .antMatchers("/css/**","/index").permitAll()   //以css和index开头的不需要验证
                .antMatchers("/user/**").hasRole("USER")   //user和blogs开头的需要验证,并且角色必须是USER
                .antMatchers("/blog/**").hasRole("USER")
                .and()
                //请求验证时会重定向到login页面
                .formLogin().loginPage("/login")
                //交给security处理登录的url是/doLogin
                .loginProcessingUrl("/doLogin")
                .failureUrl("/login-error")//失败地址是login-error
                .and()
                .exceptionHandling().accessDeniedPage("/401");  //异常定向到401
        http.logout().logoutSuccessUrl("/");  //注销成功,返回首页


    }

    //创建用户信息,验证用户信息
   /* @Override
    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
        //在内存中存放用户信息
        manager.createUser(User.withUsername("lr").password("123456").roles("USER").build());
        manager.createUser(User.withUsername("admin").password("123456").roles("ADMIN").build());
        return manager;
    }*/
}
