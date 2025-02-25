package com.example.Truper.Segurity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    //TODO: Hacer en properties e inportar con values, evitar subir al repo
    private String secret = "eb3478367b15a4927106180318c2d4852a8e367908cc970723cb14dd8a5c0770";
    private Long expiration = 86400000L;

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject("user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
                .compact();

    }
}
