package com.backbase.expert.security;
 
import com.backbase.portal.foundation.business.process.LinkBusinessProcess;
import com.backbase.portal.foundation.business.service.LinkBusinessService;
import com.backbase.portal.foundation.business.service.PortalBusinessService;
import com.backbase.portal.foundation.business.service.SecurityHelper;
import com.backbase.portal.foundation.commons.security.CustomSpecialPageHandler;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
 
public class LoginFailureHandler extends CustomSpecialPageHandler {
 
    private static final Logger log = LoggerFactory.getLogger(LoginFailureHandler.class);
    private static final String ACCEPT = "Accept";
    private static final String ACCEPT_JSON = "application/json";

 
    @Autowired
    public LoginFailureHandler(PortalBusinessService pPortalBusinessService, SecurityHelper securityHelper, LinkBusinessService pLinkBusinessService,LinkBusinessProcess pLinkBusinessProcess) {
        super(pPortalBusinessService, securityHelper, pLinkBusinessService, pLinkBusinessProcess);
    }
    

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException auth) throws IOException, ServletException {
        log.debug("onAuthenticationFailure() msg={}", auth.getMessage());
        String accept = request.getHeader(ACCEPT); 
        log.debug("Accept={}", accept);
 
        if (accept != null && accept.contains(ACCEPT_JSON)) {
            // Reponse message
            response.setContentType(ACCEPT_JSON);
            ObjectMapper mapper = new ObjectMapper();
            LoginStatus status = new LoginStatus(false, false, null, "The username or password you entered is incorrect. Please try again Sachin.");
            OutputStream out = response.getOutputStream();          
            mapper.writeValue(out, status);
        } else {
            super.onAuthenticationFailure(request, response, auth);
        }
    }
}
