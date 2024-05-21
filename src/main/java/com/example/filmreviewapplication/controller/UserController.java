package com.example.filmreviewapplication.controller;

import com.example.filmreviewapplication.model.entity.UserProfile;
import com.example.filmreviewapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/userProfiles")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserController {

    UserService userService;

    @PostMapping

    public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
        UserProfile newUserProfile = userService.createUser(userProfile);
        return ResponseEntity.ok().body(newUserProfile);
    }

    @GetMapping

    public ResponseEntity<UserProfile> getUserProfile(@RequestParam Long id){

        UserProfile userProfile = userService.getUserProfile(id);
        return ResponseEntity.ok().body(userProfile);
    }
}