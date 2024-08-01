package com.example.filmreviewapplication.controller;

import com.example.filmreviewapplication.dto.UserTypeDTO;
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
    public ResponseEntity<?> createUserType(@RequestBody UserTypeDTO userTypeDto) {

        var newUserType = userTypeService.createUserType(userTypeDto);
        return ResponseEntity.ok().body(newUserType);
    }

    @GetMapping({"/byId/id"})
    public ResponseEntity<?> getUserTypeById(@RequestParam Long id) {

        var userType = userTypeService.getUserTypeDTOById(id);
        return ResponseEntity.ok().body(userType);
    }

    @GetMapping
    public ResponseEntity<List<?>> getAllUserTypes() {

        var userTypesList = userTypeService.getAllUserTypes();
        return ResponseEntity.ok().body(userTypesList);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserTypeById(@RequestParam Long id) {

        userTypeService.deleteUserTypeById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> updateUserType(@RequestBody UserTypeDTO userTypeDto) {

       var newUserType = userTypeService.updateUserType(userTypeDto.getUser_types_id(), userTypeDto);
       return ResponseEntity.ok().body(newUserType);
    }
}
