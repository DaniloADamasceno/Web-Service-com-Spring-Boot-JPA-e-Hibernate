package com.modulo23.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<User>> findAllById(@PathVariable Integer id) {
        List<User> userTest = service.findAllById(null);
        return ResponseEntity.ok().body(userTest);
    }
}
