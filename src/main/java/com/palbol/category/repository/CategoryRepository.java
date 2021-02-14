package com.palbol.category.repository;
import com.palbol.category.domain.CategoryDomain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  CategoryRepository extends PagingAndSortingRepository<CategoryDomain, Long> {
    @Query(value = "select * from sp_getCategoryList(:search)", nativeQuery = true)
    List<CategoryDomain> findAllCategoryStoredProcedure
            (@Param("search") String search);

}