package com.modulo23.resources;

import com.modulo23.entities.User;
import com.modulo23.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@EnableAutoConfiguration
@RequestMapping(value = {"/users"}, method = RequestMethod.GET) //, method = RequestMethod.GET)
public class UserResource {

    @Autowired
    private UserService service;

//    @PostMapping
//    public ResponseEntity<List<User>> findAll() {
//        List<User> userTest = service.findAll();
//        return ResponseEntity.badRequest().body(userTest);
//    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<User>> findAllById(@PathVariable Integer id) {
        List<User> userTest;
        userTest = service.findAllById(null);
        return ResponseEntity.ok().body(userTest);
    }
}
