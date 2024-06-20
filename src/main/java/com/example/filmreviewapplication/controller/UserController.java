package com.example.filmreviewapplication.controller;

import com.example.filmreviewapplication.dto.UserProfileDTO;
import com.example.filmreviewapplication.model.entity.UserProfile;
import com.example.filmreviewapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/userProfiles")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

    UserService userService;

    @PostMapping

    public ResponseEntity<UserProfileDTO> createUserProfile(@RequestBody UserProfileDTO userProfileDto) {

        UserProfileDTO createdUserProfile = userService.createUser(userProfileDto);
        return ResponseEntity.ok().body(createdUserProfile);
    }

    @GetMapping("/byId")

    public ResponseEntity<UserProfileDTO> getUserProfileById(@RequestParam Long id){

        UserProfileDTO userProfileDto = userService.getUserProfileById(id);
        return ResponseEntity.ok().body(userProfileDto);
    }

    @GetMapping("/byUsername")

    public ResponseEntity<UserProfileDTO> getUserProfileByUsername(@RequestParam String username){

        UserProfileDTO userProfileDTO = userService.getUserProfileByUsername(username);
        return ResponseEntity.ok().body(userProfileDTO);
    }

    @GetMapping("/byPhoneNumber")

    public ResponseEntity<UserProfileDTO> getUserProfileByPhoneNumber(@RequestParam String phoneNumber){

        UserProfileDTO userProfileDTO = userService.getUserProfileByPhoneNumber(phoneNumber);
        return ResponseEntity.ok().body(userProfileDTO);
    }

    @DeleteMapping("/byId")

    public ResponseEntity<Void> deleteUserProfileById(@RequestParam Long id){

        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUserProfile(@RequestBody UserProfileDTO userProfileDto){

        userService.updateUser(userProfileDto.getId(), userProfileDto);
        return ResponseEntity.noContent().build();
    }
}