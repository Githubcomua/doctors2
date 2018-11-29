package reestr.docs.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
//@EnableResourceServer

public class Security extends WebSecurityConfigurerAdapter {

     @Override
         protected void configure(AuthenticationManagerBuilder auth) throws Exception {
             auth.inMemoryAuthentication().withUser("user").password("{noop}pass").roles("ADMIN");
         }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.requiresChannel().antMatchers();
//    }

//         @Override
//         protected void configure(HttpSecurity http) throws Exception {
//             http
//                     .authorizeRequests()
//                     .antMatchers("/", "/home").permitAll()
//                     .anyRequest().authenticated()
//                     .antMatchers("/admin/**").hasRole("ADMIN")
//                     .and()
//                     .formLogin()
//                     .loginPage("/login")
//                     .successForwardUrl("/successURL")//handle with post mapping in controller
//                     .failureUrl("/login?error").permitAll()
//                     .permitAll()
//                     .and()
//                     .logout()
//                     .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                     .logoutSuccessUrl("/login")
//                     .permitAll();
//         }

}
