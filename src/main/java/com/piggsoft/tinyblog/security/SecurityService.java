package com.piggsoft.tinyblog.security;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
