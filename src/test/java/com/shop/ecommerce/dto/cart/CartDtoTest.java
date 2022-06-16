package com.shop.ecommerce.dto.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CartDtoTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link CartDto}
     *   <li>{@link CartDto#setCartItems(List)}
     *   <li>{@link CartDto#setTotalCost(double)}
     *   <li>{@link CartDto#getCartItems()}
     *   <li>{@link CartDto#getTotalCost()}
     * </ul>
     */
    @Test
    void testConstructor() {
        CartDto actualCartDto = new CartDto();
        ArrayList<CartItemDto> cartItemDtoList = new ArrayList<>();
        actualCartDto.setCartItems(cartItemDtoList);
        actualCartDto.setTotalCost(10.0d);
        assertSame(cartItemDtoList, actualCartDto.getCartItems());
        assertEquals(10.0d, actualCartDto.getTotalCost());
    }
}

