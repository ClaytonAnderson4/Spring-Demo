package com.example.userapp.repostitory;

import com.example.userapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface UserRepository extends JpaRepository<User, BigInteger> {
    List<User> findByuserid(BigInteger id);
    List<User> findBycourseid(BigInteger id);
}
