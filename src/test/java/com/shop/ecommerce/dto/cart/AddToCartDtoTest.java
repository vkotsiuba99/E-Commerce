package com.shop.ecommerce.dto.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AddToCartDtoTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link AddToCartDto}
     *   <li>{@link AddToCartDto#setId(Integer)}
     *   <li>{@link AddToCartDto#setProductId(Integer)}
     *   <li>{@link AddToCartDto#setQuantity(Integer)}
     *   <li>{@link AddToCartDto#getId()}
     *   <li>{@link AddToCartDto#getProductId()}
     *   <li>{@link AddToCartDto#getQuantity()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AddToCartDto actualAddToCartDto = new AddToCartDto();
        actualAddToCartDto.setId(1);
        actualAddToCartDto.setProductId(123);
        actualAddToCartDto.setQuantity(1);
        assertEquals(1, actualAddToCartDto.getId().intValue());
        assertEquals(123, actualAddToCartDto.getProductId().intValue());
        assertEquals(1, actualAddToCartDto.getQuantity().intValue());
    }
}

