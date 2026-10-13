//First step for security package
// security key , token generation , username extraction

//Link
// https://docs.google.com/document/d/1vybEWwKkvT9vlM42TYITTGrgEOsFaW28ybb85BGC47Y/edit?usp=sharing documentation


package com.deepanshu.clinicbooking.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET = "YourSuperSecretKeyForClinicBookingAppJwtTokenGenerationAndValidationMustBeLongEnough123456";

    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    private final long ExpirationMS = 86400000;

    // method to generate token


    public String generateToken(String userName){
        return Jwts.builder().
                subject(userName)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + ExpirationMS))
                .signWith(key)
                .compact();
    }

    // function to extract username from token
    //This method does all the work to get all the details in the token
    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }

    //this method uses upper helper method to just get the username
    public String extractUsername(String token){
        return extractAllClaims(token).getSubject();
    }

    //Method to check token expiry


    private boolean isTokenExpired(String token){
        return extractAllClaims(token).getExpiration().before(new Date());
    }


    // Method to validate the username this username is coming from DB to cross check

    public boolean validateToken( String token,String userName){
        final String extractedUser = extractUsername(token);
        return (extractedUser.equals(userName) && !isTokenExpired(token));

    }


}
