package com.cubebox.springboot.controller.category;

import com.cubebox.springboot.domain.category.entity.Category;
import com.cubebox.springboot.domain.category.entity.dto.CategoryRequestDto;
import com.cubebox.springboot.domain.category.entity.dto.CategoryResponseDto;
import com.cubebox.springboot.usecase.category.CategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryUseCase useCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private ResponseEntity<CategoryResponseDto> create(@RequestBody CategoryRequestDto requestDTO) {
        CategoryResponseDto categoryDto = useCase.create(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Collection<CategoryResponseDto>> findAll() {
        Collection<CategoryResponseDto> categories = useCase.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<Optional<CategoryResponseDto>> findOne(@PathVariable("id") UUID id) {
        Optional<CategoryResponseDto> category = useCase.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity<CategoryResponseDto> update(@RequestBody Category req, @PathVariable("id") UUID id) {
        CategoryResponseDto categoryDto = useCase.update(id, req);
        return ResponseEntity.status(HttpStatus.OK).body(categoryDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void delete(@PathVariable("id") UUID id) {
        useCase.delete(id);
    }

}
