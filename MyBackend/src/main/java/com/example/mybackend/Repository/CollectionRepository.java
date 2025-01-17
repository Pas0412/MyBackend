package com.example.mybackend.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionRepository extends JpaRepository<com.example.mybackend.Entity.Collection, Integer> {
}
