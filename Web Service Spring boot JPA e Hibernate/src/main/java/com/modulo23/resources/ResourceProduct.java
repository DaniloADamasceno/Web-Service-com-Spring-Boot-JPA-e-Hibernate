package com.modulo23.resources;

import com.modulo23.entities.Product;
import com.modulo23.services.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = {"/produtos"}, method = RequestMethod.GET) //, method = RequestMethod.GET)
public class ResourceProduct {

    @Autowired
    private ServiceProduct serviceProduct;

    @PostMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> ProductTest = serviceProduct.findAll();
        return ResponseEntity.badRequest().body(ProductTest);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<Product>> findAllById(@PathVariable Integer id) {
        List<Product> ProductTest;
        ProductTest = serviceProduct.findAllById(null);
        return ResponseEntity.ok().body(ProductTest);
    }
}
