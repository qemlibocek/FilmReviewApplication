package com.example.filmreviewapplication.controller;

import com.example.filmreviewapplication.dto.UserProfileDTO;
import com.example.filmreviewapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/userProfiles")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

    UserService userService;

    @PostMapping("/public/reg")

    public ResponseEntity<?> createUserProfile(@RequestBody UserProfileDTO userProfileDto) {

        var createdUserProfile = userService.createUser(userProfileDto);
        return ResponseEntity.ok().body(createdUserProfile);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<?> getUserProfileById(@PathVariable Long id){

        return ResponseEntity.ok().body(userService.getUserProfileById(id));
    }

    @GetMapping("/byUsername/{username}")
    public ResponseEntity<?> getUserProfileByUsername(@PathVariable String username) {

        return ResponseEntity.ok().body(userService.getUserProfileByUsername(username));
    }

    @GetMapping("/byPhoneNumber/{phoneNumber}")

    public ResponseEntity<?> getUserProfileByPhoneNumber(@PathVariable String phoneNumber){

        return ResponseEntity.ok().body(userService.getUserProfileByPhoneNumber(phoneNumber));
    }

    @DeleteMapping("/byId/{id}")

    public ResponseEntity<Void> deleteUserProfileById(@PathVariable Long id){

        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateUserProfile(@RequestBody UserProfileDTO userProfileDto){

        userService.updateUser(userProfileDto.getId(), userProfileDto);
        return ResponseEntity.noContent().build();
    }
}