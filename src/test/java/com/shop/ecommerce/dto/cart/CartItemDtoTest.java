package com.shop.ecommerce.dto.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.shop.ecommerce.model.Cart;
import com.shop.ecommerce.model.Category;
import com.shop.ecommerce.model.Product;
import com.shop.ecommerce.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class CartItemDtoTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link CartItemDto#CartItemDto()}
     *   <li>{@link CartItemDto#setId(Integer)}
     *   <li>{@link CartItemDto#setProduct(Product)}
     *   <li>{@link CartItemDto#setQuantity(Integer)}
     *   <li>{@link CartItemDto#getId()}
     *   <li>{@link CartItemDto#getProduct()}
     *   <li>{@link CartItemDto#getQuantity()}
     * </ul>
     */
    @Test
    void testConstructor() {
        CartItemDto actualCartItemDto = new CartItemDto();
        actualCartItemDto.setId(1);
        Category category = new Category();
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setId(1);
        category.setImageUrl("https://example.org/example");
        Product product = new Product();
        product.setCategory(category);
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setImageURL("https://example.org/example");
        product.setName("Name");
        product.setPrice(10.0d);
        actualCartItemDto.setProduct(product);
        actualCartItemDto.setQuantity(1);
        assertEquals(1, actualCartItemDto.getId().intValue());
        assertSame(product, actualCartItemDto.getProduct());
        assertEquals(1, actualCartItemDto.getQuantity().intValue());
    }

    /**
     * Method under test: {@link CartItemDto#CartItemDto(Cart)}
     */
    @Test
    void testConstructor2() {
        Category category = new Category();
        category.setCategoryName("Category Name");
        category.setDescription("The characteristics of someone or something");
        category.setId(1);
        category.setImageUrl("https://example.org/example");

        Product product = new Product();
        product.setCategory(category);
        product.setDescription("The characteristics of someone or something");
        product.setId(1);
        product.setImageURL("https://example.org/example");
        product.setName("Name");
        product.setPrice(10.0d);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");

        Cart cart = new Cart();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        cart.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        cart.setId(1);
        cart.setProduct(product);
        cart.setQuantity(1);
        cart.setUser(user);
        CartItemDto actualCartItemDto = new CartItemDto(cart);
        assertEquals(1, actualCartItemDto.getId().intValue());
        assertEquals(1, actualCartItemDto.getQuantity().intValue());
        assertSame(product, actualCartItemDto.getProduct());
    }
}

