package com.example.manytoonedemo.Repository;

import com.example.manytoonedemo.Model.ManyToOneDemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManyToOneRepository extends JpaRepository<ManyToOneDemo,Integer> {
}
