package com.modulo23.webService.resources;
/*
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.modulo23.webService.entities.User;

@RestController
@RequestMapping(value =  "/users", method = RequestMethod.GET)

 */

import com.modulo23.webService.entities.User;
import com.modulo23.webService.services.ServiceUser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/users", method= RequestMethod.GET)
public class ResourceUser {


    @GetMapping
    public ResponseEntity<User> findAll() {
        User userTest = new User(1L, "Hugo Test", "hugoTEST@gmail.com", "61900001111", "0011");
        return ResponseEntity.ok().body(userTest);
    }
}





