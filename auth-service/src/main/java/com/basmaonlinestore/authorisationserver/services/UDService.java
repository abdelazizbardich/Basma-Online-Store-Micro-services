package com.basmaonlinestore.authorisationserver.services;

import com.basmaonlinestore.authorisationserver.repositories.UserRepository;
import com.basmaonlinestore.authorisationserver.models.User;
import com.basmaonlinestore.authorisationserver.security.UserSecurity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UDService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new UserSecurity(user);
    }
}
