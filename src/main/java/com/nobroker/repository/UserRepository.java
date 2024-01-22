package com.nobroker.repository;

import com.nobroker.entity.User;


import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("unused")
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}

