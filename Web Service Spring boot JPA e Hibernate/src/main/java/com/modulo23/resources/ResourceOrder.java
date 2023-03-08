package com.modulo23.resources;

import com.modulo23.entities.Order;
import com.modulo23.services.ServiceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = {"/pedidos"}, method = RequestMethod.GET) //, method = RequestMethod.GET)
public class ResourceOrder {

    @Autowired
    private ServiceOrder serviceOrder;

    @PostMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> OrderTest = serviceOrder.findAll();
        return ResponseEntity.badRequest().body(OrderTest);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<Order>> findAllById(@PathVariable Integer id) {
        List<Order> OrderTest;
        OrderTest = serviceOrder.findAllById(null);
        return ResponseEntity.ok().body(OrderTest);
    }
}
