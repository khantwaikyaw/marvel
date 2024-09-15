package com.cubebox.springboot.usecase.category;

import com.cubebox.springboot.core.exception.BadRequestException;
import com.cubebox.springboot.core.exception.NotFoundException;
import com.cubebox.springboot.domain.category.entity.Category;
import com.cubebox.springboot.domain.category.entity.dto.CategoryRequestDto;
import com.cubebox.springboot.domain.category.entity.dto.CategoryResponseDto;
import com.cubebox.springboot.usecase.category.mapper.CategoryMapper;
import com.cubebox.springboot.usecase.category.service.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class CategoryUseCase {

    private final CategoryServiceImpl serviceImpl;

    public CategoryResponseDto create(CategoryRequestDto requestDto) throws BadRequestException {
        Category category = CategoryMapper.toEntity(requestDto);
        return CategoryMapper.toResponseDto(serviceImpl.create(category));
    }

    public Collection<CategoryResponseDto> findAll() {
        Collection<Category> categories = serviceImpl.findAll();
        return categories.stream().map(CategoryMapper::toResponseDto).toList();
    }

    public Optional<CategoryResponseDto> findOne(UUID id) {
        Optional<Category> category = serviceImpl.findOne(id);
        return category.map(CategoryMapper::toResponseDto);
    }

    public CategoryResponseDto update(UUID id, Category req) throws BadRequestException {
        Optional<Category> existingCategory = Optional.ofNullable(
                serviceImpl.findOne(id).orElseThrow(
                        () -> new NotFoundException("Category not found")
                ));

        if (existingCategory.isPresent()) {
            Category category = existingCategory.get();
            category.setName(req.getName());
            category.setDescription(req.getDescription());
            return CategoryMapper.toResponseDto(serviceImpl.update(category));
        }
        throw new BadRequestException("Category not found");
    }

    public void delete(UUID id) {
        Boolean exists = serviceImpl.isExist(id);
        if (!exists) {
            throw new NotFoundException("Category not found");
        }
        serviceImpl.delete(id);
    }
}
