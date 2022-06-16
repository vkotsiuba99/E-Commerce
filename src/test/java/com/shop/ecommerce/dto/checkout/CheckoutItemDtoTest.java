package com.shop.ecommerce.dto.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CheckoutItemDtoTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link CheckoutItemDto}
     *   <li>{@link CheckoutItemDto#setPrice(double)}
     *   <li>{@link CheckoutItemDto#setProductId(long)}
     *   <li>{@link CheckoutItemDto#setProductName(String)}
     *   <li>{@link CheckoutItemDto#setQuantity(int)}
     *   <li>{@link CheckoutItemDto#setUserId(int)}
     *   <li>{@link CheckoutItemDto#getPrice()}
     *   <li>{@link CheckoutItemDto#getProductId()}
     *   <li>{@link CheckoutItemDto#getProductName()}
     *   <li>{@link CheckoutItemDto#getQuantity()}
     *   <li>{@link CheckoutItemDto#getUserId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        CheckoutItemDto actualCheckoutItemDto = new CheckoutItemDto();
        actualCheckoutItemDto.setPrice(10.0d);
        actualCheckoutItemDto.setProductId(123L);
        actualCheckoutItemDto.setProductName("Product Name");
        actualCheckoutItemDto.setQuantity(1);
        actualCheckoutItemDto.setUserId(123);
        assertEquals(10.0d, actualCheckoutItemDto.getPrice());
        assertEquals(123L, actualCheckoutItemDto.getProductId());
        assertEquals("Product Name", actualCheckoutItemDto.getProductName());
        assertEquals(1, actualCheckoutItemDto.getQuantity());
        assertEquals(123, actualCheckoutItemDto.getUserId());
    }
}

