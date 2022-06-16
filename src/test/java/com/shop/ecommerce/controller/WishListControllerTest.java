package com.shop.ecommerce.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.shop.ecommerce.model.Category;
import com.shop.ecommerce.model.Product;
import com.shop.ecommerce.model.User;
import com.shop.ecommerce.service.AuthenticationService;
import com.shop.ecommerce.service.WishListService;

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

@ContextConfiguration(classes = {WishListController.class})
@ExtendWith(SpringExtension.class)
class WishListControllerTest {
    @MockBean
    private AuthenticationService authenticationService;

    @Autowired
    private WishListController wishListController;

    @MockBean
    private WishListService wishListService;

    /**
     * Method under test: {@link WishListController#getWishList(String)}
     */
    @Test
    void testGetWishList() throws Exception {
        when(this.wishListService.getWishListForUser((User) any())).thenReturn(new ArrayList<>());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        when(this.authenticationService.getUser((String) any())).thenReturn(user);
        doNothing().when(this.authenticationService).authenticate((String) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/wishlist/{token}", "ABC123");
        MockMvcBuilders.standaloneSetup(this.wishListController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link WishListController#getWishList(String)}
     */
    @Test
    void testGetWishList2() throws Exception {
        when(this.wishListService.getWishListForUser((User) any())).thenReturn(new ArrayList<>());

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        when(this.authenticationService.getUser((String) any())).thenReturn(user);
        doNothing().when(this.authenticationService).authenticate((String) any());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/wishlist/{token}", "ABC123");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.wishListController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

