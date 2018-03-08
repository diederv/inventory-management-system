package com.okit.ims;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * @author Diederick Verweij
 *
 */
//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig /* extends WebSecurityConfigurerAdapter */ {
	
	@Autowired
	private IMSBasicAuthenticationEntryPoint authenticationEntryPoint;

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//          .withUser("user").password("password")
//          .authorities("USER", "ADMIN");
//    }
	
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//// I had to disable the security because the web-part (home.html) is challenged by the server-response, 
//// to use Basic-Authentication, while the server expects Digest Authentication. Unfortunately I don't have
//// enough time to solve this problem for now :-/
//// The plan was to let the jquery POST queries to pass the JSESSIONID cookie after authentication    	
//    	
//        http.csrf().disable()
//            .authorizeRequests()
//                .antMatchers("/", "/home", "/items", "/categories").permitAll()
//                .anyRequest().authenticated()
//                .and()                
//                .httpBasic()                
//                .authenticationEntryPoint(authenticationEntryPoint);        
//    }
	
}
