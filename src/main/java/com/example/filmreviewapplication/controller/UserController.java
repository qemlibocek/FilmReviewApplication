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

    @GetMapping("/byId")

    public ResponseEntity<UserProfile> getUserProfileById(@RequestParam Long id){

        UserProfile userProfile = userService.getUserProfileById(id);
        return ResponseEntity.ok().body(userProfile);
    }

    @GetMapping("/byUsername")

    public ResponseEntity<UserProfile> getUserProfileByUsername(@RequestParam String username){

        UserProfile userProfile = userService.getUserProfileByUsername(username);
        return ResponseEntity.ok().body(userProfile);
    }

    @GetMapping("/byPhoneNumber")

    public ResponseEntity<UserProfile> getUserProfileByPhoneNumber(@RequestParam String phoneNumber){

        UserProfile userProfile = userService.getUserProfileByPhoneNumber(phoneNumber);
        return ResponseEntity.ok().body(userProfile);
    }

    @DeleteMapping("/byId")

    public ResponseEntity<Void> deleteUserProfileById(@RequestParam Long id){

        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}