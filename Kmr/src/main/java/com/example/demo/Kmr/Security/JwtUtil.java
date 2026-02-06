package com.example.demo.Kmr.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Date;

@Component // class level annotation
public class JwtUtil {

    //256 BIT LENGTH KU STRING VALUE EDUTHUKANUM (256 bit key generetor)=>website

//    private static final String SECRET_KEY_STRING = "jai43G3gogrXM7vlYFwUz3CHwkAwwCHT";
//    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());

    @Value("${jwt.secret}") // ipo antha secrete key applications.property la irukum
    private String secretKeyString;

    private SecretKey SECRET_KEY;

    @PostConstruct
    public void init() {
        SECRET_KEY = Keys.hmacShaKeyFor(secretKeyString.getBytes());
    }

    public String generateToken(UserDetails request) {
        return Jwts.builder()
                .subject(request.getUsername())// ithu mukiyamaana thagaval vechi generate panrathu eg,pass or username
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 10000 * 60 * 60)) //1000=> 1sec, *60 =>1min, *60=>1hour
                .signWith(SECRET_KEY, Jwts.SIG.HS256)//HS256 ITHU ORU ALGORITHM ITHA VECHI THA SECRET KEY CREATE PANIRUKOM
                .compact(); // ithu last la return panrathu oru string

    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return extractUsername(token).equals(userDetails.getUsername());
    }

    public String extractUsername(String token){
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
