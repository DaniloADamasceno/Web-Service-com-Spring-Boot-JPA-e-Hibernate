package com.modulo23.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modulo23.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
