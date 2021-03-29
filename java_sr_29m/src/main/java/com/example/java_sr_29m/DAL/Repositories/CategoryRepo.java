package com.example.java_sr_29m.DAL.Repositories;

import com.example.java_sr_29m.DAL.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
