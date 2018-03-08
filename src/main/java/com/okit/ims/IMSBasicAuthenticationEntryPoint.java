package com.okit.ims;

import java.io.IOException;
import java.io.PrintWriter;

//import org.springframework.security.core.AuthenticationException; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Diederick Verweij
 *
 */
@Component
public class IMSBasicAuthenticationEntryPoint /* extends BasicAuthenticationEntryPoint */ {	
 
//	@Override
//	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        PrintWriter writer = response.getWriter();
//        writer.println("HTTP Status 401 - " + authException.getMessage());
//    }
// 
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        setRealmName("okit");
//        super.afterPropertiesSet();
//    }  

}

	