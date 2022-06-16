package com.shop.ecommerce.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class AuthenticationTokenTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AuthenticationToken#AuthenticationToken()}
     *   <li>{@link AuthenticationToken#setCreatedDate(Date)}
     *   <li>{@link AuthenticationToken#setId(Integer)}
     *   <li>{@link AuthenticationToken#setToken(String)}
     *   <li>{@link AuthenticationToken#setUser(User)}
     *   <li>{@link AuthenticationToken#getCreatedDate()}
     *   <li>{@link AuthenticationToken#getId()}
     *   <li>{@link AuthenticationToken#getToken()}
     *   <li>{@link AuthenticationToken#getUser()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AuthenticationToken actualAuthenticationToken = new AuthenticationToken();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualAuthenticationToken.setCreatedDate(fromResult);
        actualAuthenticationToken.setId(1);
        actualAuthenticationToken.setToken("ABC123");
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        actualAuthenticationToken.setUser(user);
        assertSame(fromResult, actualAuthenticationToken.getCreatedDate());
        assertEquals(1, actualAuthenticationToken.getId().intValue());
        assertEquals("ABC123", actualAuthenticationToken.getToken());
        assertSame(user, actualAuthenticationToken.getUser());
    }

    /**
     * Method under test: {@link AuthenticationToken#AuthenticationToken(User)}
     */
    @Test
    void testConstructor2() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(1);
        user.setLastName("Doe");
        user.setPasswoprd("Passwoprd");
        assertSame(user, (new AuthenticationToken(user)).getUser());
    }
}

