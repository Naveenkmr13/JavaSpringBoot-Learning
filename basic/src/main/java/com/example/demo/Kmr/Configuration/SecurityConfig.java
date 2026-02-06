package com.example.demo.Kmr.Configuration;

import com.example.demo.Kmr.CustomUserDetailService.CustomUserDetailService;
import com.example.demo.Kmr.Security.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity    //customize the security for owr wish.
public class SecurityConfig {
    @Autowired
    private JwtFilter jwtFilter;


    @Bean //method ku podara annotation class ku no
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz ->
                                authz.requestMatchers("/home","/login").permitAll()
//                                        .requestMatchers("/**").authenticated()
                                        .requestMatchers("/alldatas").authenticated()
                                        .requestMatchers("/add").authenticated()
                                        .requestMatchers("/update/**").authenticated()
                                        .requestMatchers("/delete/**").authenticated()

                )

//                .httpBasic(Customizer.withDefaults()) // this is seen in postman also in browser(pop up message)
//                .formLogin(form ->form.permitAll().defaultSuccessUrl("/home"))// this is spring boot's default html,css form used in brower can't see in post man
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//              👉 UsernamePasswordAuthenticationFilter = LOGIN time username/password check pannum
//              👉 JwtFilter = LOGIN kapram ellaa request la token check pannum
//

        return http.build();
    }

//    @Bean // inmemory user login ku create panirukom.
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
//        UserDetails user = User.withUsername("naveen")
//                .password(passwordEncoder.encode("kmr"))
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("kumar")
//                .password(passwordEncoder.encode("kmr"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user,admin);
//    }

    /// /
    /// /
//    @Bean // mela commend paniruka inmemory logic ku password encoding ku ithu
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetailsService dta = new CustomUserDetailService(); //interface reference
        return dta;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(){
        return new ProviderManager(List.of(authenticationProvider()));
    }
}
//kila ithu theve ila epd password encoding work aaguthu and athoda interface ena epd implements nu pathu tharichikoo?

//    public interface PasswordEncoder {  ------->eg. interface dog
//        String encode(CharSequence rawPassword);
//        boolean matches(CharSequence rawPassword, String encodedPassword);
//    }
//
//    public class BCryptPasswordEncoder implements PasswordEncoder { ----->eg. class cat implements dog ==> so cat ku new cat nu obj podanum which imples dog so
//    dog d = new cat() this is interface

// for clarify :

//interface Animal {
//    void sound();
//}
//
//class Dog implements Animal {
//
//    @Override
//    public void sound() {
//        System.out.println("Bark");
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//
//        Animal a = new Dog();  // interface reference
//        a.sound();             // method call
//    }
//}
