package com.example.mybackend.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<com.example.mybackend.Entity.Category, Integer> {
}

