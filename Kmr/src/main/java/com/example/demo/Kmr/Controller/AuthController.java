package com.example.demo.Kmr.Controller;

import com.example.demo.Kmr.Require.Employees;
import com.example.demo.Kmr.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody Employees user){
//        Authenticate the user uname pass correct a irutha(db la  irutha) intha authentication obj kedaikuk ilati exception error
        try {


//            AuthticationManager Spring Security oda login checker
//            Username + Password correct ah nu DB poi verify pannrathu
//            Authentication kula set panum
            Authentication authentication = authManager.
                    authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

//            UserDetails = Spring Security oda interface
//            Represents logged-in user oda information
//            Username, password, roles, status (enabled/locked) ellam hold pannum

//            authentication.getPrincipal() returns Object type (generic)
//            But namakku thaan UserDetails type ah venum
//            So we “cast” Object → UserDetails using (UserDetails)

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(Map.of("token",token));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error","Invalid Username or Password correct panuga bro.."));
        }

    }
}
//chaat anna
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
//    @Autowired
//    private AuthenticationManager authManager;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    @PostMapping("/login")
//    public ResponseEntity<Map<String, String>> login(@RequestBody Employees user) {
//
//        try {
//            // 1️⃣ Wrap username/password in token
//            UsernamePasswordAuthenticationToken authToken =
//                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
//
//            // 2️⃣ Authenticate against DB via AuthenticationManager
//            Authentication authentication = authManager.authenticate(authToken);
//
//            // 3️⃣ Extract Principal = Logged-in user details
//            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//            // 4️⃣ Generate JWT token using username
//            String token = jwtUtil.generateToken(userDetails);
//
//            // 5️⃣ Return token to frontend
//            return ResponseEntity.ok(Map.of("token", token));
//
//        } catch (Exception e) {
//            // 6️⃣ Handle invalid username/password
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body(Map.of("error", "Invalid Username or Password. Correct panunga bro.."));
//        }
//    }
//}


