package com.shop.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.shop.ecommerce.dto.cart.AddToCartDto;
import com.shop.ecommerce.dto.cart.CartDto;
import com.shop.ecommerce.dto.cart.CartItemDto;
import com.shop.ecommerce.exceptions.CustomException;
import com.shop.ecommerce.exceptions.ProductNotExistsException;
import com.shop.ecommerce.model.Cart;
import com.shop.ecommerce.model.Category;
import com.shop.ecommerce.model.Product;
import com.shop.ecommerce.model.User;
import com.shop.ecommerce.repository.CartRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CartService.class})
@ExtendWith(SpringExtension.class)
class CartServiceTest {
    @MockBean
    private CartRepository cartRepository;

    @Autowired
    private CartService cartService;

    @MockBean
    private ProductService productService;

    /**
     * Method under test: {@link CartService#addToCart(AddToCartDto, User)}
     */
    @Test
    void testAddToCart() throws ProductNotExistsException {
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
        when(this.productService.findById((Integer) any())).thenReturn(product);

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
        cart.setProduct(product1);
        cart.setQuantity(1);
        cart.setUser(user);
        when(this.cartRepository.save((Cart) any())).thenReturn(cart);

        AddToCartDto addToCartDto = new AddToCartDto();
        addToCartDto.setId(1);
        addToCartDto.setProductId(123);
        addToCartDto.setQuantity(1);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1);
        user1.setLastName("Doe");
        user1.setPasswoprd("Passwoprd");
        this.cartService.addToCart(addToCartDto, user1);
        verify(this.productService).findById((Integer) any());
        verify(this.cartRepository).save((Cart) any());
    }

    /**
     * Method under test: {@link CartService#addToCart(AddToCartDto, User)}
     */
    @Test
    void testAddToCart2() throws ProductNotExistsException {
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
        when(this.productService.findById((Integer) any())).thenReturn(product);
        when(this.cartRepository.save((Cart) any())).thenThrow(new CustomException("Msg"));

        AddToCartDto addToCartDto = new AddToCartDto();
        addToCartDto.setId(1);
        addToCartDto.setProductId(123);
        addToCartDto.setQuantity(1);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        assertThrows(CustomException.class, () -> this.cartService.addToCart(addToCartDto, user));
        verify(this.productService).findById((Integer) any());
        verify(this.cartRepository).save((Cart) any());
    }

    /**
     * Method under test: {@link CartService#listCartItems(User)}
     */
    @Test
    void testListCartItems() {
        ArrayList<Cart> cartList = new ArrayList<>();
        when(this.cartRepository.findAllByUserOrderByCreatedDateDesc((User) any())).thenReturn(cartList);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        CartDto actualListCartItemsResult = this.cartService.listCartItems(user);
        assertEquals(cartList, actualListCartItemsResult.getCartItems());
        assertEquals(0.0d, actualListCartItemsResult.getTotalCost());
        verify(this.cartRepository).findAllByUserOrderByCreatedDateDesc((User) any());
    }

    /**
     * Method under test: {@link CartService#listCartItems(User)}
     */
    @Test
    void testListCartItems2() {
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

        ArrayList<Cart> cartList = new ArrayList<>();
        cartList.add(cart);
        when(this.cartRepository.findAllByUserOrderByCreatedDateDesc((User) any())).thenReturn(cartList);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1);
        user1.setLastName("Doe");
        user1.setPasswoprd("Passwoprd");
        CartDto actualListCartItemsResult = this.cartService.listCartItems(user1);
        List<CartItemDto> cartItems = actualListCartItemsResult.getCartItems();
        assertEquals(1, cartItems.size());
        assertEquals(10.0d, actualListCartItemsResult.getTotalCost());
        CartItemDto getResult = cartItems.get(0);
        assertEquals(1, getResult.getId().intValue());
        assertEquals(1, getResult.getQuantity().intValue());
        assertSame(product, getResult.getProduct());
        verify(this.cartRepository).findAllByUserOrderByCreatedDateDesc((User) any());
    }

    /**
     * Method under test: {@link CartService#listCartItems(User)}
     */
    @Test
    void testListCartItems3() {
        when(this.cartRepository.findAllByUserOrderByCreatedDateDesc((User) any())).thenThrow(new CustomException("Msg"));

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        assertThrows(CustomException.class, () -> this.cartService.listCartItems(user));
        verify(this.cartRepository).findAllByUserOrderByCreatedDateDesc((User) any());
    }

    /**
     * Method under test: {@link CartService#deleteCartItem(Integer, User)}
     */
    @Test
    void testDeleteCartItem() {
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
        Optional<Cart> ofResult = Optional.of(cart);
        when(this.cartRepository.findById((Integer) any())).thenReturn(ofResult);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1);
        user1.setLastName("Doe");
        user1.setPasswoprd("Passwoprd");
        assertThrows(CustomException.class, () -> this.cartService.deleteCartItem(123, user1));
        verify(this.cartRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link CartService#deleteCartItem(Integer, User)}
     */
    @Test
    void testDeleteCartItem2() {
        when(this.cartRepository.findById((Integer) any())).thenReturn(Optional.empty());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        assertThrows(CustomException.class, () -> this.cartService.deleteCartItem(123, user));
        verify(this.cartRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link CartService#deleteCartItem(Integer, User)}
     */
    @Test
    void testDeleteCartItem3() {
        when(this.cartRepository.findById((Integer) any())).thenThrow(new CustomException("Msg"));

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        assertThrows(CustomException.class, () -> this.cartService.deleteCartItem(123, user));
        verify(this.cartRepository).findById((Integer) any());
    }
}

