package com.deepanshu.clinicbooking.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;


import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter {

    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doInternalFilter(HttpServletRequest request , HttpServletResponse response , FilterChain filterChain)
    throws ServletException , IOException
    {
        final String authHeader = request.getHeader("Authorization");
        String jwt = null;
        String userName = null;

        //Check if header has a bearer token or not

        if(authHeader != null && authHeader.startsWith("Bearer")){
            jwt = authHeader.substring(7);
            try {
                userName = jwtUtil.extractUsername(jwt);
        }catch (Exception e){
                System.out.println("error in username extraction" + e.getMessage());
            }
    }
}
