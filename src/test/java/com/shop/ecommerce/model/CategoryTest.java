package com.shop.ecommerce.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CategoryTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Category}
     *   <li>{@link Category#setCategoryName(String)}
     *   <li>{@link Category#setDescription(String)}
     *   <li>{@link Category#setId(Integer)}
     *   <li>{@link Category#setImageUrl(String)}
     *   <li>{@link Category#getCategoryName()}
     *   <li>{@link Category#getDescription()}
     *   <li>{@link Category#getId()}
     *   <li>{@link Category#getImageUrl()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Category actualCategory = new Category();
        actualCategory.setCategoryName("Category Name");
        actualCategory.setDescription("The characteristics of someone or something");
        actualCategory.setId(1);
        actualCategory.setImageUrl("https://example.org/example");
        assertEquals("Category Name", actualCategory.getCategoryName());
        assertEquals("The characteristics of someone or something", actualCategory.getDescription());
        assertEquals(1, actualCategory.getId().intValue());
        assertEquals("https://example.org/example", actualCategory.getImageUrl());
    }
}

