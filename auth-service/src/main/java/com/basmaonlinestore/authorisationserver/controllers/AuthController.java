package com.basmaonlinestore.authorisationserver.controllers;

import com.basmaonlinestore.authorisationserver.models.User;
import com.basmaonlinestore.authorisationserver.services.RoleService;
import com.basmaonlinestore.authorisationserver.services.UDService;
import com.basmaonlinestore.authorisationserver.security.AuthRequest;
import com.basmaonlinestore.authorisationserver.services.UserService;
import com.basmaonlinestore.authorisationserver.utils.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.rmi.NotBoundException;
import java.util.Map;

@Controller
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private UDService userDetailsService;
    private UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> authenticate(@RequestBody AuthRequest authRequest) {
        String login = authRequest.getLogin();
            String password = authRequest.getPassword();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password));
            final UserDetails userDetails = userDetailsService.loadUserByUsername(login);
            return ResponseEntity.ok().body(Map.of("token", jwtUtil.generateToken(userDetails)));
        }catch (Exception e){
            System.err.println("Error: "+e.getMessage());
            System.err.println("Cause: "+e.getCause());
            e.getStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error","Unexpected internal server error!"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@RequestBody User user) {
        String login = user.getLogin();
        String password = user.getPassword();
        try {
            System.err.println("password: "+user.getPassword());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole(roleService.getByName("ROLE_USER"));
            userService.add(user);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password));
            final UserDetails userDetails = userDetailsService.loadUserByUsername(login);
            return ResponseEntity.ok().body(Map.of("token", jwtUtil.generateToken(userDetails)));
        }catch (UsernameNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error",e.getMessage()));
        }
//        catch (Exception e){
//            System.err.println("Error: "+e.getMessage());
//            System.err.println("Cause: "+e.getCause());
//            e.getStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error","Unexpected internal server error!"));
//        }
    }
}
