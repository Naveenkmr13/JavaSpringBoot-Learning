package com.example.demo.Kmr.CustomUserDetailService;

import com.example.demo.Kmr.Repository.EmployeeRepo;
import com.example.demo.Kmr.Require.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;

// this page is for access the datas from db for to login using datas in db
@Component
public class CustomUserDetailService implements UserDetailsService {
    // spring boot DAO intha method ha call panum also
    // UserDetailsService kura interface ku intha method podanum
    // apo spring boot default ha itha call panrapa namba ula podara code vele seium

    @Autowired //Autowired members must be defined in valid Spring bean(@Component | @Service | ...)
    private EmployeeRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //fetch users name and pass and role from db

        Employees user = repo.findByusername(username).orElseThrow(() -> new UsernameNotFoundException("User not found Bro!.."));
        return new User(user.getUsername(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("USER")));
    }
}
//DAO → DB-la irundhu data edukum →
//UserDetailsService ku kudukum →
//UserDetailsService Spring Security ku kudukum →
//Spring Security password analyze pannum →
//Result (SUCCESS / FAIL) tharum
//
//✔ YES. Ithu thaan nadakuthu.
//
//🔁 SAME FLOW – STEP BY STEP (1 line each)
//
//1️⃣ DAO (EmployeeRepo)
//👉 DB-la irundhu user record edukkum
//
//2️⃣ UserDetailsService (CustomUserDetailService)
//👉 DAO-va use panni user eduthu
//👉 Spring Security ku puriya UserDetails format-la maathum
//
//3️⃣ Spring Security (DaoAuthenticationProvider)
//👉 Username correct-aa nu paakum
//👉 PasswordEncoder use panni password check pannum
//
//4️⃣ Result
//✔ Correct → Login SUCCESS
//❌ Wrong → Login FAIL
