package com.shop.ecommerce.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.shop.ecommerce.dto.cart.AddToCartDto;
import com.shop.ecommerce.dto.cart.CartDto;
import com.shop.ecommerce.dto.cart.CartItemDto;
import com.shop.ecommerce.model.User;
import com.shop.ecommerce.service.AuthenticationService;
import com.shop.ecommerce.service.CartService;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CartController.class})
@ExtendWith(SpringExtension.class)
class CartControllerTest {
    @MockBean
    private AuthenticationService authenticationService;

    @Autowired
    private CartController cartController;

    @MockBean
    private CartService cartService;

    /**
     * Method under test: {@link CartController#getCartItems(String)}
     */
    @Test
    void testGetCartItems() throws Exception {
        CartDto cartDto = new CartDto();
        cartDto.setCartItems(new ArrayList<>());
        cartDto.setTotalCost(10.0d);
        when(this.cartService.listCartItems((User) any())).thenReturn(cartDto);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        when(this.authenticationService.getUser((String) any())).thenReturn(user);
        doNothing().when(this.authenticationService).authenticate((String) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart/").param("token", "foo");
        MockMvcBuilders.standaloneSetup(this.cartController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"cartItems\":[],\"totalCost\":10.0}"));
    }

    /**
     * Method under test: {@link CartController#getCartItems(String)}
     */
    @Test
    void testGetCartItems2() throws Exception {
        ArrayList<CartItemDto> cartItemDtoList = new ArrayList<>();
        cartItemDtoList.add(new CartItemDto());

        CartDto cartDto = new CartDto();
        cartDto.setCartItems(cartItemDtoList);
        cartDto.setTotalCost(10.0d);
        when(this.cartService.listCartItems((User) any())).thenReturn(cartDto);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        when(this.authenticationService.getUser((String) any())).thenReturn(user);
        doNothing().when(this.authenticationService).authenticate((String) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart/").param("token", "foo");
        MockMvcBuilders.standaloneSetup(this.cartController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"cartItems\":[{\"id\":null,\"quantity\":null,\"product\":null}],\"totalCost\":10.0}"));
    }

    /**
     * Method under test: {@link CartController#getCartItems(String)}
     */
    @Test
    void testGetCartItems3() throws Exception {
        CartDto cartDto = new CartDto();
        cartDto.setCartItems(new ArrayList<>());
        cartDto.setTotalCost(10.0d);
        when(this.cartService.listCartItems((User) any())).thenReturn(cartDto);

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        when(this.authenticationService.getUser((String) any())).thenReturn(user);
        doNothing().when(this.authenticationService).authenticate((String) any());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/cart/");
        getResult.contentType("https://example.org/example");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("token", "foo");
        MockMvcBuilders.standaloneSetup(this.cartController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"cartItems\":[],\"totalCost\":10.0}"));
    }
}

