package com.modulo23.repositories;

import com.modulo23.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProduct extends JpaRepository<Product, Integer> {
}