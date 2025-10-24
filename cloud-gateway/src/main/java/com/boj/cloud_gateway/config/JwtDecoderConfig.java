package com.boj.cloud_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;

import javax.crypto.spec.SecretKeySpec;

@Configuration
public class JwtDecoderConfig {

    private static final String SECRET = "your-256-bit-secret"; // Must match the key used to sign tokens

    @Bean
    public ReactiveJwtDecoder jwtDecoder() {
        return NimbusReactiveJwtDecoder
                .withSecretKey(new SecretKeySpec(SECRET.getBytes(), "HmacSHA256"))
                .build();
    }
}
