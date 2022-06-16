package com.shop.ecommerce.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class WishListTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link WishList#WishList()}
     *   <li>{@link WishList#setCreatedDate(Date)}
     *   <li>{@link WishList#setId(Integer)}
     *   <li>{@link WishList#setProduct(Product)}
     *   <li>{@link WishList#setUser(User)}
     *   <li>{@link WishList#getCreatedDate()}
     *   <li>{@link WishList#getId()}
     *   <li>{@link WishList#getProduct()}
     *   <li>{@link WishList#getUser()}
     * </ul>
     */
    @Test
    void testConstructor() {
        WishList actualWishList = new WishList();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualWishList.setCreatedDate(fromResult);
        actualWishList.setId(1);
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
        actualWishList.setProduct(product);
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        actualWishList.setUser(user);
        assertSame(fromResult, actualWishList.getCreatedDate());
        assertEquals(1, actualWishList.getId().intValue());
        assertSame(product, actualWishList.getProduct());
        assertSame(user, actualWishList.getUser());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link WishList#WishList(User, Product)}
     *   <li>{@link WishList#setCreatedDate(Date)}
     *   <li>{@link WishList#setId(Integer)}
     *   <li>{@link WishList#setProduct(Product)}
     *   <li>{@link WishList#setUser(User)}
     *   <li>{@link WishList#getCreatedDate()}
     *   <li>{@link WishList#getId()}
     *   <li>{@link WishList#getProduct()}
     *   <li>{@link WishList#getUser()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");

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
        WishList actualWishList = new WishList(user, product);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualWishList.setCreatedDate(fromResult);
        actualWishList.setId(1);
        Category category1 = new Category();
        category1.setCategoryName("Category Name");
        category1.setDescription("The characteristics of someone or something");
        category1.setId(1);
        category1.setImageUrl("https://example.org/example");
        Product product1 = new Product();
        product1.setCategory(category1);
        product1.setDescription("The characteristics of someone or something");
        product1.setId(1);
        product1.setImageURL("https://example.org/example");
        product1.setName("Name");
        product1.setPrice(10.0d);
        actualWishList.setProduct(product1);
        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1);
        user1.setLastName("Doe");
        user1.setPasswoprd("Passwoprd");
        actualWishList.setUser(user1);
        assertSame(fromResult, actualWishList.getCreatedDate());
        assertEquals(1, actualWishList.getId().intValue());
        assertSame(product1, actualWishList.getProduct());
        assertSame(user1, actualWishList.getUser());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link WishList#WishList(Integer, User, Date, Product)}
     *   <li>{@link WishList#setCreatedDate(Date)}
     *   <li>{@link WishList#setId(Integer)}
     *   <li>{@link WishList#setProduct(Product)}
     *   <li>{@link WishList#setUser(User)}
     *   <li>{@link WishList#getCreatedDate()}
     *   <li>{@link WishList#getId()}
     *   <li>{@link WishList#getProduct()}
     *   <li>{@link WishList#getUser()}
     * </ul>
     */
    @Test
    void testConstructor3() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date createdDate = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());

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
        WishList actualWishList = new WishList(1, user, createdDate, product);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        actualWishList.setCreatedDate(fromResult);
        actualWishList.setId(1);
        Category category1 = new Category();
        category1.setCategoryName("Category Name");
        category1.setDescription("The characteristics of someone or something");
        category1.setId(1);
        category1.setImageUrl("https://example.org/example");
        Product product1 = new Product();
        product1.setCategory(category1);
        product1.setDescription("The characteristics of someone or something");
        product1.setId(1);
        product1.setImageURL("https://example.org/example");
        product1.setName("Name");
        product1.setPrice(10.0d);
        actualWishList.setProduct(product1);
        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1);
        user1.setLastName("Doe");
        user1.setPasswoprd("Passwoprd");
        actualWishList.setUser(user1);
        assertSame(fromResult, actualWishList.getCreatedDate());
        assertEquals(1, actualWishList.getId().intValue());
        assertSame(product1, actualWishList.getProduct());
        assertSame(user1, actualWishList.getUser());
    }
}

