package com.palbol.category.services;


import com.palbol.category.domain.CategoryDomain;
import com.palbol.category.dto.CategoryDTO;
import com.palbol.category.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    public CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<CategoryDTO> listAll(String search) {
        log.info("listAll");

        Set<CategoryDTO> response = new HashSet<>();
        try {
            List<CategoryDomain> listCategory = this.categoryRepository
                    .findAllCategoryStoredProcedure(search);

            ModelMapper modelMapper = new ModelMapper();
            return listCategory
                    .stream()
                    .map(entity -> modelMapper.map(entity, CategoryDTO.class))
                    .collect(Collectors.toSet());

        } catch (Exception err) {
            log.error(err.getMessage(), err);
        }

        return response;
    }
}
