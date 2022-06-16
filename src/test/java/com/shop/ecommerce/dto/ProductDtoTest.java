package com.shop.ecommerce.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProductDtoTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link ProductDto}
     *   <li>{@link ProductDto#setCategoryId(Integer)}
     *   <li>{@link ProductDto#setDescription(String)}
     *   <li>{@link ProductDto#setId(Integer)}
     *   <li>{@link ProductDto#setImageURL(String)}
     *   <li>{@link ProductDto#setName(String)}
     *   <li>{@link ProductDto#setPrice(double)}
     *   <li>{@link ProductDto#getCategoryId()}
     *   <li>{@link ProductDto#getDescription()}
     *   <li>{@link ProductDto#getId()}
     *   <li>{@link ProductDto#getImageURL()}
     *   <li>{@link ProductDto#getName()}
     *   <li>{@link ProductDto#getPrice()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ProductDto actualProductDto = new ProductDto();
        actualProductDto.setCategoryId(123);
        actualProductDto.setDescription("The characteristics of someone or something");
        actualProductDto.setId(1);
        actualProductDto.setImageURL("https://example.org/example");
        actualProductDto.setName("Name");
        actualProductDto.setPrice(10.0d);
        assertEquals(123, actualProductDto.getCategoryId().intValue());
        assertEquals("The characteristics of someone or something", actualProductDto.getDescription());
        assertEquals(1, actualProductDto.getId().intValue());
        assertEquals("https://example.org/example", actualProductDto.getImageURL());
        assertEquals("Name", actualProductDto.getName());
        assertEquals(10.0d, actualProductDto.getPrice());
    }
}

