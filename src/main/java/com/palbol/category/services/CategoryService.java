package com.palbol.category.services;

import com.palbol.category.dto.CategoryDTO;

import java.util.Set;

public interface CategoryService {
    Set<CategoryDTO> listAll(String search);
}
