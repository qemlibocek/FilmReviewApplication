package com.example.filmreviewapplication.security.secservice;

import com.example.filmreviewapplication.dto.UserProfileDTO;
import com.example.filmreviewapplication.mapper.UserProfileMapper;
import com.example.filmreviewapplication.model.entity.UserProfile;
import com.example.filmreviewapplication.model.entity.UserType;
import com.example.filmreviewapplication.repository.UserTypeRepository;
import com.example.filmreviewapplication.security.SecurityUser;
import com.example.filmreviewapplication.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserProfile userProfile = userService.getUserProfileByUsername(username);

        return new SecurityUser(userProfile);
    }
}
