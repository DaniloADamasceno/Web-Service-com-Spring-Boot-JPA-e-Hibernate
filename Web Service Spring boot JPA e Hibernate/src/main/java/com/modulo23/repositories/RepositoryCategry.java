package com.modulo23.repositories;

import com.modulo23.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCategry extends JpaRepository<Category, Integer> {
}