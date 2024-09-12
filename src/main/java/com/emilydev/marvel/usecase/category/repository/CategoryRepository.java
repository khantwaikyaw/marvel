package com.emilydev.marvel.usecase.category.repository;

import com.emilydev.marvel.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
