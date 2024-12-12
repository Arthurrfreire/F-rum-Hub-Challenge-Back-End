package com.alura.forumhub.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfiguration {

    @Value("${forum.jwt.secret}")
    private String secret;

    public String getSecret() {
        return secret;
    }
}