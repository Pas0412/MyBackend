package com.example.mybackend.Repository;

import com.example.mybackend.Entity.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ViewRepository  extends JpaRepository<View, Integer> {
    @Query("SELECT SUM(v.views) FROM View v")
    int sumViews();

    @Modifying
    @Query("UPDATE View v SET v.views = v.views + 1 WHERE v.name = :name")
    void incrementViewsByName(@Param("name")String name);
}