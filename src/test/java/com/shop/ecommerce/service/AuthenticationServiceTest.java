package com.shop.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.shop.ecommerce.exceptions.AuthenticationFailException;
import com.shop.ecommerce.model.AuthenticationToken;
import com.shop.ecommerce.model.User;
import com.shop.ecommerce.repository.TokenRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuthenticationService.class})
@ExtendWith(SpringExtension.class)
class AuthenticationServiceTest {
    @Autowired
    private AuthenticationService authenticationService;

    @MockBean
    private TokenRepository tokenRepository;

    /**
     * Method under test: {@link AuthenticationService#saveConfirmationToken(AuthenticationToken)}
     */
    @Test
    void testSaveConfirmationToken() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");

        AuthenticationToken authenticationToken = new AuthenticationToken();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        authenticationToken.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        authenticationToken.setId(1);
        authenticationToken.setToken("ABC123");
        authenticationToken.setUser(user);
        when(this.tokenRepository.save((AuthenticationToken) any())).thenReturn(authenticationToken);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1);
        user1.setLastName("Doe");
        user1.setPasswoprd("Passwoprd");

        AuthenticationToken authenticationToken1 = new AuthenticationToken();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        authenticationToken1.setCreatedDate(fromResult);
        authenticationToken1.setId(1);
        authenticationToken1.setToken("ABC123");
        authenticationToken1.setUser(user1);
        this.authenticationService.saveConfirmationToken(authenticationToken1);
        verify(this.tokenRepository).save((AuthenticationToken) any());
        assertSame(fromResult, authenticationToken1.getCreatedDate());
        assertSame(user1, authenticationToken1.getUser());
        assertEquals("ABC123", authenticationToken1.getToken());
        assertEquals(1, authenticationToken1.getId().intValue());
    }

    /**
     * Method under test: {@link AuthenticationService#saveConfirmationToken(AuthenticationToken)}
     */
    @Test
    void testSaveConfirmationToken2() {
        when(this.tokenRepository.save((AuthenticationToken) any())).thenThrow(new AuthenticationFailException("Msg"));

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");

        AuthenticationToken authenticationToken = new AuthenticationToken();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        authenticationToken.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        authenticationToken.setId(1);
        authenticationToken.setToken("ABC123");
        authenticationToken.setUser(user);
        assertThrows(AuthenticationFailException.class,
                () -> this.authenticationService.saveConfirmationToken(authenticationToken));
        verify(this.tokenRepository).save((AuthenticationToken) any());
    }

    /**
     * Method under test: {@link AuthenticationService#getToken(User)}
     */
    @Test
    void testGetToken() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");

        AuthenticationToken authenticationToken = new AuthenticationToken();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        authenticationToken.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        authenticationToken.setId(1);
        authenticationToken.setToken("ABC123");
        authenticationToken.setUser(user);
        when(this.tokenRepository.findByUser((User) any())).thenReturn(authenticationToken);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(1);
        user1.setLastName("Doe");
        user1.setPasswoprd("Passwoprd");
        assertSame(authenticationToken, this.authenticationService.getToken(user1));
        verify(this.tokenRepository).findByUser((User) any());
    }

    /**
     * Method under test: {@link AuthenticationService#getToken(User)}
     */
    @Test
    void testGetToken2() {
        when(this.tokenRepository.findByUser((User) any())).thenThrow(new AuthenticationFailException("Msg"));

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        assertThrows(AuthenticationFailException.class, () -> this.authenticationService.getToken(user));
        verify(this.tokenRepository).findByUser((User) any());
    }

    /**
     * Method under test: {@link AuthenticationService#getUser(String)}
     */
    @Test
    void testGetUser() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");

        AuthenticationToken authenticationToken = new AuthenticationToken();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        authenticationToken.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        authenticationToken.setId(1);
        authenticationToken.setToken("ABC123");
        authenticationToken.setUser(user);
        when(this.tokenRepository.findByToken((String) any())).thenReturn(authenticationToken);
        assertSame(user, this.authenticationService.getUser("ABC123"));
        verify(this.tokenRepository).findByToken((String) any());
    }

    /**
     * Method under test: {@link AuthenticationService#getUser(String)}
     */
    @Test
    void testGetUser2() {
        when(this.tokenRepository.findByToken((String) any())).thenThrow(new AuthenticationFailException("Msg"));
        assertThrows(AuthenticationFailException.class, () -> this.authenticationService.getUser("ABC123"));
        verify(this.tokenRepository).findByToken((String) any());
    }

    /**
     * Method under test: {@link AuthenticationService#authenticate(String)}
     */
    @Test
    void testAuthenticate() throws AuthenticationFailException {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");

        AuthenticationToken authenticationToken = new AuthenticationToken();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        authenticationToken.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        authenticationToken.setId(1);
        authenticationToken.setToken("ABC123");
        authenticationToken.setUser(user);
        when(this.tokenRepository.findByToken((String) any())).thenReturn(authenticationToken);
        this.authenticationService.authenticate("ABC123");
        verify(this.tokenRepository).findByToken((String) any());
    }
}

