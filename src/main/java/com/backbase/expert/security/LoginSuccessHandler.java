package com.backbase.expert.security;
 
import com.backbase.portal.foundation.commons.security.CustomAuthenticationSuccessHandler;
import com.backbase.portal.foundation.domain.conceptual.UserPropertyDefinition;
import com.backbase.portal.foundation.domain.model.User;
import org.apache.commons.collections.MapUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
 
public class LoginSuccessHandler extends CustomAuthenticationSuccessHandler {
 
    private static final Logger log = LoggerFactory.getLogger(LoginSuccessHandler.class);
 
    public static final String SPRING_SECURITY_SAVED_REQUEST = "SPRING_SECURITY_SAVED_REQUEST";
 
    private static final String ACCEPT = "Accept";
    private static final String ACCEPT_JSON = "application/json";
 
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
 
        log.info("onAuthenticationSuccess() name={}, isAuthenticated={}", authentication.getName(), authentication.isAuthenticated());
        SecurityContextHolderAwareRequestWrapper securityContext = new SecurityContextHolderAwareRequestWrapper(request, "role_");
        log.info("UserPrincipal name=" + securityContext.getUserPrincipal().getName());
 
        SavedRequest savedRequest = (SavedRequest)request.getSession().getAttribute(SPRING_SECURITY_SAVED_REQUEST);
        if (savedRequest != null ) {
            log.info("SavedRequest redirectUrl=" + savedRequest.getRedirectUrl());
        }
 
        String accept = request.getHeader(ACCEPT);
        if (accept.contains(ACCEPT_JSON)) {
            response.setContentType(ACCEPT_JSON);
            ObjectMapper mapper = new ObjectMapper();
            LoginStatus status = new LoginStatus(true, authentication.isAuthenticated(), authentication.getName(), null);
            OutputStream out = response.getOutputStream();
            mapper.writeValue(out, status);
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
