package com.ust.Authentication_service.service;

import com.ust.Authentication_service.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

        private String username;
        private String password;

        public CustomUserDetails(User user) {
            this.username=user.getUsername();
            this.password=user.getPassword();
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
        }
}

