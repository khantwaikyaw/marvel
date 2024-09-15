package com.cubebox.springboot.usecase.category.repository;

import com.cubebox.springboot.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
