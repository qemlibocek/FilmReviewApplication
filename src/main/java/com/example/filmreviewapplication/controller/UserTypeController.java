package com.example.filmreviewapplication.controller;

import com.example.filmreviewapplication.model.entity.UserType;
import com.example.filmreviewapplication.service.UserTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("v1/user-types")
public class UserTypeController {

    UserTypeService userTypeService;

    @PostMapping
    public ResponseEntity<UserType> createUserType(@RequestBody UserType userType) {

        var newUserType = userTypeService.createUserType(userType);
        return ResponseEntity.ok().body(newUserType);
    }

    @GetMapping({"/id"})
    public ResponseEntity<UserType> getUserTypeById(@RequestParam Long id) {

        var userType = userTypeService.getUserTypeById(id);
        return ResponseEntity.ok().body(userType);
    }

    @GetMapping
    public ResponseEntity<List<UserType>> getAllUserTypes() {

        var userTypesList = userTypeService.getAllUserTypes();
        return ResponseEntity.ok().body(userTypesList);
    }

    @DeleteMapping
    public ResponseEntity<UserType> deleteUserTypeById(@RequestParam Long id) {

        userTypeService.deleteUserTypeById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<UserType> updateUserType(@RequestBody UserType userType) {

       var newUserType = userTypeService.updateUserType(userType.getUser_types_id(), userType);
       return ResponseEntity.ok().body(newUserType);
    }
}
