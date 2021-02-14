package com.palbol.category.controllers;

import com.palbol.category.dto.CategoryDTO;
import com.palbol.category.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@Slf4j
public class CategoryControllers {
    private CategoryService categoryService;

    public CategoryControllers(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/findall")
    public ResponseEntity<Set<CategoryDTO>> findAll(@RequestBody String search) {
        try {
            Set<CategoryDTO> response = this.categoryService.listAll(search);

            log.debug(response.toString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
