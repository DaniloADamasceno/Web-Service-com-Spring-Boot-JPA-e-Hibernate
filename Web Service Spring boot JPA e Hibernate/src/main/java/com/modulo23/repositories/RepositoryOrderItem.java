package com.modulo23.repositories;

import com.modulo23.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //  Anotação que indica que a classe é um repositório
public interface RepositoryOrderItem extends JpaRepository<OrderItem, Integer> {
}
