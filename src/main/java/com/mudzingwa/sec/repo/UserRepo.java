package com.mudzingwa.sec.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mudzingwa.sec.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
