package com.shop.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.shop.ecommerce.dto.user.SignInDto;
import com.shop.ecommerce.dto.user.SignupDto;
import com.shop.ecommerce.exceptions.AuthenticationFailException;
import com.shop.ecommerce.exceptions.CustomException;
import com.shop.ecommerce.model.User;
import com.shop.ecommerce.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserService.class})
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @MockBean
    private AuthenticationService authenticationService;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * Method under test: {@link UserService#signUp(SignupDto)}
     */
    @Test
    void testSignUp() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1);
        user1.setLastName("Doe");
        user1.setPasswoprd("Passwoprd");
        when(this.userRepository.findByEmail((String) any())).thenReturn(user);
        when(this.userRepository.save((User) any())).thenReturn(user1);

        SignupDto signupDto = new SignupDto();
        signupDto.setEmail("jane.doe@example.org");
        signupDto.setFirstName("Jane");
        signupDto.setLastName("Doe");
        signupDto.setPassword("iloveyou");
        assertThrows(CustomException.class, () -> this.userService.signUp(signupDto));
        verify(this.userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#signUp(SignupDto)}
     */
    @Test
    void testSignUp2() {
        when(this.userRepository.findByEmail((String) any())).thenThrow(new AuthenticationFailException("MD5"));
        when(this.userRepository.save((User) any())).thenThrow(new AuthenticationFailException("MD5"));

        SignupDto signupDto = new SignupDto();
        signupDto.setEmail("jane.doe@example.org");
        signupDto.setFirstName("Jane");
        signupDto.setLastName("Doe");
        signupDto.setPassword("iloveyou");
        assertThrows(AuthenticationFailException.class, () -> this.userService.signUp(signupDto));
        verify(this.userRepository).findByEmail((String) any());
    }

    /**
     * Method under test: {@link UserService#signIn(SignInDto)}
     */
    @Test
    void testSignIn() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        when(this.userRepository.findByEmail((String) any())).thenReturn(user);
        assertThrows(AuthenticationFailException.class,
                () -> this.userService.signIn(new SignInDto("jane.doe@example.org", "iloveyou")));
        verify(this.userRepository).findByEmail((String) any());
    }
}

