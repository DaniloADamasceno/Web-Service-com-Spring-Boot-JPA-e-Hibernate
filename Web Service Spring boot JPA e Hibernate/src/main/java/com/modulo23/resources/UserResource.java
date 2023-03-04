package com.modulo23.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modulo23.services.UserService;
import com.modulo23.entities.User;

@RestController
@RequestMapping({"/users"}) //, method = RequestMethod.GET)
public class UserResource {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> userTest = service.findAll();
        return ResponseEntity.badRequest().body(userTest);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllById() {
        List<User> userTest = service.findAllById(null);
        return ResponseEntity.ok().body(userTest);
    }
}
