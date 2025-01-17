package com.example.mybackend.Repository;

import com.example.mybackend.Entity.WebLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebLogRepository extends JpaRepository<WebLog, Integer> {
}
