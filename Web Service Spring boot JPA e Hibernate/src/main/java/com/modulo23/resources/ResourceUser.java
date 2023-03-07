package com.modulo23.resources;

import com.modulo23.entities.User;
import com.modulo23.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = {"/users"}, method = RequestMethod.GET) //, method = RequestMethod.GET)
public class ResourceUser {

    @Autowired
    private ServiceUser service;

    @PostMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> userTest = service.findAll();
        return ResponseEntity.badRequest().body(userTest);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<User>> findAllById(@PathVariable Integer id) {
        List<User> userTest;
        userTest = service.findAllById(null);
        return ResponseEntity.ok().body(userTest);
    }
}
