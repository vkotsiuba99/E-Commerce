package com.shop.ecommerce.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.ecommerce.dto.ResponseDto;
import com.shop.ecommerce.dto.user.SignInDto;
import com.shop.ecommerce.dto.user.SignupDto;
import com.shop.ecommerce.service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {
    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link UserController#signup(SignupDto)}
     */
    @Test
    void testSignup() throws Exception {
        when(this.userService.signUp((SignupDto) any()))
                .thenReturn(new ResponseDto("Status", "Not all who wander are lost"));

        SignupDto signupDto = new SignupDto();
        signupDto.setEmail("jane.doe@example.org");
        signupDto.setFirstName("Jane");
        signupDto.setLastName("Doe");
        signupDto.setPassword("iloveyou");
        String content = (new ObjectMapper()).writeValueAsString(signupDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"status\":\"Status\",\"message\":\"Not all who wander are lost\"}"));
    }
}

