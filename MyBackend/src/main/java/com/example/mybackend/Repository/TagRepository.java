package com.example.mybackend.Repository;
import com.example.mybackend.Entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<com.example.mybackend.Entity.Tag, Integer> {
}
