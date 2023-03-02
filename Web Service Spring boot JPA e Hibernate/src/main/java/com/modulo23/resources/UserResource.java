package com.modulo23.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modulo23.services.UserService;
import com.modulo23.entities.User;

@RestController
@RequestMapping(value = "/users" ) //, method = RequestMethod.GET)
public class UserResource {

    //@Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> userTest = service.findAll();
        return ResponseEntity.ok().body(userTest);
    }
}
