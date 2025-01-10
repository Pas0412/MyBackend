package com.example.mybackend.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<com.example.mybackend.Entity.Friend, Integer> {
}
