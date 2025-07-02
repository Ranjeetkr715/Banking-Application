package com.banking.app.repository;


import com.banking.app.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomUserDetailsRepository extends JpaRepository<Users,Integer> {

    public Optional<Users> findByUserName(String username);
}
