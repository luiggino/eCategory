package com.palbol.category.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@ToString
public class CategoryDomain implements Serializable {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCategory;

    @Column(name = "name")
    private String name;

    @Column(name = "has_sub_category")
    private Boolean hasSubCategory;

    @Column(name = "parent_id")
    private Long parentId;
}
