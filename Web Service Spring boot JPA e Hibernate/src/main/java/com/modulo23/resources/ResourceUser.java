package com.modulo23.resources;

import com.modulo23.entities.User;
import com.modulo23.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/usuarios") //, method = RequestMethod.GET)
public class ResourceUser {

    @Autowired
    private ServiceUser serviceUser;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> userList = serviceUser.findAll();
        return ResponseEntity.ok().body(userList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findAllById(@PathVariable Integer id) {
        User userTestId = serviceUser.findAllById(id);
        return ResponseEntity.ok().body(userTestId);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User userInsert) { //RequestBody para receber o JSON do body
        userInsert = serviceUser.insert(userInsert);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(userInsert.getId()).toUri();
        return ResponseEntity.created(uri).body(userInsert);
        //return ResponseEntity.ok().body(userTest);
    }

    @DeleteMapping(value = "/{id}") // DeleteMapping para deletar um usuário
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        serviceUser.delete(id);
        return ResponseEntity.noContent().build();
    }
}
