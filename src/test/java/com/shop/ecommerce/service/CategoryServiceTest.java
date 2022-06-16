package com.shop.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.shop.ecommerce.model.Category;
import com.shop.ecommerce.repository.CategoryRepo;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CategoryService.class})
@ExtendWith(SpringExtension.class)
class CategoryServiceTest {
    @MockBean
    private CategoryRepo categoryRepo;

    @Autowired
    private CategoryService categoryService;

    /**
     * Method under test: {@link CategoryService#createCategory(Category)}
     */
    @Test
    void testCreateCategory() {
        Category category = new Category();
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setId(1);
        category.setImageUrl("https://example.org/example");
        when(this.categoryRepo.save((Category) any())).thenReturn(category);

        Category category1 = new Category();
        category1.setCategoryName("Category Name");
        category1.setDescription("The characteristics of someone or something");
        category1.setId(1);
        category1.setImageUrl("https://example.org/example");
        this.categoryService.createCategory(category1);
        verify(this.categoryRepo).save((Category) any());
        assertEquals("Category Name", category1.getCategoryName());
        assertEquals("https://example.org/example", category1.getImageUrl());
        assertEquals(1, category1.getId().intValue());
        assertEquals("The characteristics of someone or something", category1.getDescription());
    }

    /**
     * Method under test: {@link CategoryService#listCategory()}
     */
    @Test
    void testListCategory() {
        ArrayList<Category> categoryList = new ArrayList<>();
        when(this.categoryRepo.findAll()).thenReturn(categoryList);
        List<Category> actualListCategoryResult = this.categoryService.listCategory();
        assertSame(categoryList, actualListCategoryResult);
        assertTrue(actualListCategoryResult.isEmpty());
        verify(this.categoryRepo).findAll();
    }

    /**
     * Method under test: {@link CategoryService#editCategory(int, Category)}
     */
    @Test
    void testEditCategory() {
        Category category = new Category();
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setId(1);
        category.setImageUrl("https://example.org/example");

        Category category1 = new Category();
        category1.setCategoryName("Category Name");
        category1.setDescription("The characteristics of someone or something");
        category1.setId(1);
        category1.setImageUrl("https://example.org/example");
        when(this.categoryRepo.save((Category) any())).thenReturn(category1);
        when(this.categoryRepo.getById((Integer) any())).thenReturn(category);

        Category category2 = new Category();
        category2.setCategoryName("Category Name");
        category2.setDescription("The characteristics of someone or something");
        category2.setId(1);
        category2.setImageUrl("https://example.org/example");
        this.categoryService.editCategory(123, category2);
        verify(this.categoryRepo).getById((Integer) any());
        verify(this.categoryRepo).save((Category) any());
    }

    /**
     * Method under test: {@link CategoryService#findById(int)}
     */
    @Test
    void testFindById() {
        Category category = new Category();
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setId(1);
        category.setImageUrl("https://example.org/example");
        Optional<Category> ofResult = Optional.of(category);
        when(this.categoryRepo.findById((Integer) any())).thenReturn(ofResult);
        assertTrue(this.categoryService.findById(123));
        verify(this.categoryRepo).findById((Integer) any());
    }

    /**
     * Method under test: {@link CategoryService#findById(int)}
     */
    @Test
    void testFindById2() {
        when(this.categoryRepo.findById((Integer) any())).thenReturn(Optional.empty());
        assertFalse(this.categoryService.findById(123));
        verify(this.categoryRepo).findById((Integer) any());
    }
}

