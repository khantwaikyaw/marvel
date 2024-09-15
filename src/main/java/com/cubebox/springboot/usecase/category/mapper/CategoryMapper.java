package com.cubebox.springboot.usecase.category.mapper;

import com.cubebox.springboot.domain.category.entity.Category;
import com.cubebox.springboot.domain.category.entity.dto.CategoryRequestDto;
import com.cubebox.springboot.domain.category.entity.dto.CategoryResponseDto;

public class CategoryMapper {
    
    public static CategoryResponseDto toResponseDto(Category category) {
        return CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

    public static Category toEntity(CategoryRequestDto requestDto) {
        return Category.builder()
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .build();
    }
}
