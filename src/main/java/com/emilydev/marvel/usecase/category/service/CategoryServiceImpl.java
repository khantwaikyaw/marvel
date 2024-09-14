package com.emilydev.marvel.usecase.category.service;

import com.emilydev.marvel.domain.category.entity.Category;
import com.emilydev.marvel.domain.category.service.CategoryService;
import com.emilydev.marvel.usecase.category.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repo;

    @Override
    public Category create(Category category) {
        return repo.save(category);
    }

    @Override
    public Collection<Category> findAll() {
        return List.copyOf(repo.findAll());
    }

    @Override
    public Optional<Category> findOne(UUID id) {
        return Optional.ofNullable(repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Category not found")));
    }

    @Override
    public Category update(Category category) {
        return repo.save(category);
    }
}
