package com.backbase.expert.security;
 
public class LoginStatus {
 
    private boolean success;
    private boolean loggedIn;
    private String username;
    private String errorMessage;
 
    /**
     * Default contructor, needed by the JSON serializer
     */
    public LoginStatus() {
    }
 
    public LoginStatus(boolean success, boolean loggedIn, String username, String errorMessage) {
        this.success = success;
        this.loggedIn = loggedIn;
        this.username = username;
        this.errorMessage = errorMessage;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
