package com.modulo23.resources;

import com.modulo23.entities.Category;
import com.modulo23.services.ServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = {"/categorias"}, method = RequestMethod.GET) //, method = RequestMethod.GET)
public class ResourceCategory {

    @Autowired
    private ServiceCategory serviceCategory;

    @PostMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categoryTest = serviceCategory.findAll();
        return ResponseEntity.badRequest().body(categoryTest);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<Category>> findAllById(@PathVariable Integer id) {
        List<Category> categoryTest;
        categoryTest = serviceCategory.findAllById(null);
        return ResponseEntity.ok().body(categoryTest);
    }
}
