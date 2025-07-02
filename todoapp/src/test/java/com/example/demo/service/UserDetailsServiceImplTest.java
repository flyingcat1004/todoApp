package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.model.SiteUser;
import com.example.demo.repository.SiteUserRepository;
import com.example.demo.util.Role;

@SpringBootTest
@Transactional
class UserDetailsServiceImplTest {

    @Autowired
    SiteUserRepository siteUserRepository;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Test
    void loadUserByUsername_returnsUserDetails() {
        // arrange
        SiteUser user = new SiteUser();
        user.setUsername("sample");
        user.setPassword(passwordEncoder.encode("password"));
        user.setEmail("sample@example.com");
        user.setRole(Role.USER.name());
        siteUserRepository.save(user);

        // act
        UserDetails details = userDetailsService.loadUserByUsername("sample");

        // assert
        assertEquals("sample", details.getUsername());
        assertTrue(passwordEncoder.matches("password", details.getPassword()));
        assertTrue(details.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_" + user.getRole())));
    }

}
