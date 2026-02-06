package com.example.demo.Kmr.Security;

import com.example.demo.Kmr.CustomUserDetailService.CustomUserDetailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//@Component
//public class JwtFilter extends OncePerRequestFilter {
//    @Autowired
//    private JwtUtil jwtUtil;
//    @Autowired
//    private CustomUserDetailService customUserDetailService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//       String authHeader = request.getHeader("Authorization");
//       if (authHeader == null || !authHeader.startsWith("Bearer ")){
//           filterChain.doFilter(request,response);
//           return;
//       }else{
//           String token = authHeader.substring(7);
//           try{
//               String username = jwtUtil.extractUsername(token);
//               if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
//                   UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
//                   if (jwtUtil.validateToken(token,userDetails)){
//                       UsernamePasswordAuthenticationToken authenticationToken =
//                               new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
//                       authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                       SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                   }
//               }
//           }catch (Exception e) {
//               Map<String, String> responseMap = new HashMap<>();
//               responseMap.put("error", "Invalid token bro..");
//
//               ObjectMapper objectMapper = new ObjectMapper();
//               String jsonString = objectMapper.writeValueAsString(responseMap);
//
//               response.getWriter().write(jsonString);
//               response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//               return;
//           }
//       }
//        filterChain.doFilter(request,response);
//    }
//}
//GPT EASY
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil; // JWT token extract & validate panna

    @Autowired
    private CustomUserDetailService customUserDetailService; // DB la irundhu user load panna

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // Request header la Authorization token eduka
        String authHeader = request.getHeader("Authorization");

        // Header illa OR Bearer token illa na -> next filter ku move aagum
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // "Bearer " remove pannitu actual token eduka
        String token = authHeader.substring(7);

        try {
            // Token la irundhu username extract panna
            String username = jwtUtil.extractUsername(token);

            // Username irundha AND already authenticated illa na
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                // DB la irundhu full user details load panna
                UserDetails userDetails = customUserDetailService.loadUserByUsername(username);

                // Token valid ah nu check panna
                if (jwtUtil.validateToken(token, userDetails)) {

//                    “Intha request user authenticated” nu register panna porom
                    // Spring Security authentication object create panna
                    UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails, // logged in user
                                    null,        // password not needed (already verified)
                                    userDetails.getAuthorities() // roles/permissions
                            );

                    // Security context la authenticated user set panna
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }

        } catch (Exception e) {
            // Token invalid na -> 401 Unauthorized return pannum
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid Token");
            return;
        }

        // Next filter / controller ku request forward pannum
        filterChain.doFilter(request, response);
    }
}

