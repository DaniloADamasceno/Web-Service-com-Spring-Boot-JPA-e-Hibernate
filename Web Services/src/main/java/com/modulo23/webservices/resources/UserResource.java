package com.modulo23.webservices.resources;


import com.modulo23.webservices.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User userTest = new User(1L, "Snow", "snow@gmail.com", "61991225544", "11111");
        return ResponseEntity.ok().body(userTest);
    }
}
