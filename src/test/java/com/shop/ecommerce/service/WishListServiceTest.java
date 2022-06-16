package com.shop.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.shop.ecommerce.dto.ProductDto;
import com.shop.ecommerce.model.Category;
import com.shop.ecommerce.model.Product;
import com.shop.ecommerce.model.User;
import com.shop.ecommerce.model.WishList;
import com.shop.ecommerce.repository.WishListRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {WishListService.class})
@ExtendWith(SpringExtension.class)
class WishListServiceTest {
    @MockBean
    private ProductService productService;

    @MockBean
    private WishListRepository wishListRepository;

    @Autowired
    private WishListService wishListService;

    /**
     * Method under test: {@link WishListService#createWishlist(WishList)}
     */
    @Test
    void testCreateWishlist() {
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

        WishList wishList = new WishList();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        wishList.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        wishList.setId(1);
        wishList.setProduct(product);
        wishList.setUser(user);
        when(this.wishListRepository.save((WishList) any())).thenReturn(wishList);

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

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1);
        user1.setLastName("Doe");
        user1.setPasswoprd("Passwoprd");

        WishList wishList1 = new WishList();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        wishList1.setCreatedDate(fromResult);
        wishList1.setId(1);
        wishList1.setProduct(product1);
        wishList1.setUser(user1);
        this.wishListService.createWishlist(wishList1);
        verify(this.wishListRepository).save((WishList) any());
        assertSame(fromResult, wishList1.getCreatedDate());
        assertSame(user1, wishList1.getUser());
        assertSame(product1, wishList1.getProduct());
        assertEquals(1, wishList1.getId().intValue());
    }

    /**
     * Method under test: {@link WishListService#getWishListForUser(User)}
     */
    @Test
    void testGetWishListForUser() {
        when(this.wishListRepository.findAllByUserOrderByCreatedDateDesc((User) any())).thenReturn(new ArrayList<>());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        assertTrue(this.wishListService.getWishListForUser(user).isEmpty());
        verify(this.wishListRepository).findAllByUserOrderByCreatedDateDesc((User) any());
    }

    /**
     * Method under test: {@link WishListService#getWishListForUser(User)}
     */
    @Test
    void testGetWishListForUser2() {
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

        WishList wishList = new WishList();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        wishList.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        wishList.setId(1);
        wishList.setProduct(product);
        wishList.setUser(user);

        ArrayList<WishList> wishListList = new ArrayList<>();
        wishListList.add(wishList);
        when(this.wishListRepository.findAllByUserOrderByCreatedDateDesc((User) any())).thenReturn(wishListList);

        ProductDto productDto = new ProductDto();
        productDto.setCategoryId(123);
        productDto.setDescription("The characteristics of someone or something");
        productDto.setId(1);
        productDto.setImageURL("https://example.org/example");
        productDto.setName("Name");
        productDto.setPrice(10.0d);
        when(this.productService.getProductDto((Product) any())).thenReturn(productDto);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1);
        user1.setLastName("Doe");
        user1.setPasswoprd("Passwoprd");
        assertEquals(1, this.wishListService.getWishListForUser(user1).size());
        verify(this.wishListRepository).findAllByUserOrderByCreatedDateDesc((User) any());
        verify(this.productService).getProductDto((Product) any());
    }
}

