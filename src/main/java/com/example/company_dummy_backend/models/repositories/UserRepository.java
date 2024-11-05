package com.example.company_dummy_backend.models.repositories;

import com.example.company_dummy_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
