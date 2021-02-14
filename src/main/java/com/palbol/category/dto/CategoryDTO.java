package com.palbol.category.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class CategoryDTO {
    @JsonProperty("id")
    private Long idCategory;
    @JsonProperty("name")
    private String name;
    @JsonProperty("hasSubCategory")
    private Boolean hasSubCategory;

    @JsonProperty("parentId")
    private Long parentId;
}
