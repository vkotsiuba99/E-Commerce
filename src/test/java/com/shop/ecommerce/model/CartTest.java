package com.shop.ecommerce.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class CartTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Cart}
     *   <li>{@link Cart#setCreatedDate(Date)}
     *   <li>{@link Cart#setId(Integer)}
     *   <li>{@link Cart#setProduct(Product)}
     *   <li>{@link Cart#setQuantity(int)}
     *   <li>{@link Cart#setUser(User)}
     *   <li>{@link Cart#getCreatedDate()}
     *   <li>{@link Cart#getId()}
     *   <li>{@link Cart#getProduct()}
     *   <li>{@link Cart#getQuantity()}
     *   <li>{@link Cart#getUser()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Cart actualCart = new Cart();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualCart.setCreatedDate(fromResult);
        actualCart.setId(1);
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
        actualCart.setProduct(product);
        actualCart.setQuantity(1);
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        actualCart.setUser(user);
        assertSame(fromResult, actualCart.getCreatedDate());
        assertEquals(1, actualCart.getId().intValue());
        assertSame(product, actualCart.getProduct());
        assertEquals(1, actualCart.getQuantity());
        assertSame(user, actualCart.getUser());
    }
}

