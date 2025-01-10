package com.example.mybackend.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.mybackend.Entity.Collection;
import com.example.mybackend.Entity.Tag;
import com.example.mybackend.Entity.Category;

import java.util.List;

public interface CollectionRepository extends JpaRepository<com.example.mybackend.Entity.Collection, Integer> {
}
