package com.shop.ecommerce.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class ProductTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Product}
     *   <li>{@link Product#setCategory(Category)}
     *   <li>{@link Product#setDescription(String)}
     *   <li>{@link Product#setId(Integer)}
     *   <li>{@link Product#setImageURL(String)}
     *   <li>{@link Product#setName(String)}
     *   <li>{@link Product#setPrice(double)}
     *   <li>{@link Product#getCategory()}
     *   <li>{@link Product#getDescription()}
     *   <li>{@link Product#getId()}
     *   <li>{@link Product#getImageURL()}
     *   <li>{@link Product#getName()}
     *   <li>{@link Product#getPrice()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Product actualProduct = new Product();
        Category category = new Category();
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setId(1);
        category.setImageUrl("https://example.org/example");
        actualProduct.setCategory(category);
        actualProduct.setDescription("The characteristics of someone or something");
        actualProduct.setId(1);
        actualProduct.setImageURL("https://example.org/example");
        actualProduct.setName("Name");
        actualProduct.setPrice(10.0d);
        assertSame(category, actualProduct.getCategory());
        assertEquals("The characteristics of someone or something", actualProduct.getDescription());
        assertEquals(1, actualProduct.getId().intValue());
        assertEquals("https://example.org/example", actualProduct.getImageURL());
        assertEquals("Name", actualProduct.getName());
        assertEquals(10.0d, actualProduct.getPrice());
    }
}

