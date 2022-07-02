package com.example.demo.repositories;

import com.example.demo.models.AdminModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<AdminModels, Integer> {

    @Query("FROM AdminModels")
    public AdminModels getAdmin();
}