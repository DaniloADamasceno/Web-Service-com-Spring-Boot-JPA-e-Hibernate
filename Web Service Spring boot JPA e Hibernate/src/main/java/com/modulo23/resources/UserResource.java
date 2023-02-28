package com.modulo23.resources;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modulo23.entities.User;

@RestController
@RequestMapping(value = "/users") // Path
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User userTest = new User(1L, "Snow", "snow@gmail.com", "61900001111", "1111");
        return ResponseEntity.ok().body(userTest);
    }
}
