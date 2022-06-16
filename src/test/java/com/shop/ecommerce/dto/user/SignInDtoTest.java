package com.shop.ecommerce.dto.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SignInDtoTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link SignInDto#SignInDto(String, String)}
     *   <li>{@link SignInDto#setEmail(String)}
     *   <li>{@link SignInDto#setPassword(String)}
     *   <li>{@link SignInDto#getEmail()}
     *   <li>{@link SignInDto#getPassword()}
     * </ul>
     */
    @Test
    void testConstructor() {
        SignInDto actualSignInDto = new SignInDto("jane.doe@example.org", "iloveyou");
        actualSignInDto.setEmail("jane.doe@example.org");
        actualSignInDto.setPassword("iloveyou");
        assertEquals("jane.doe@example.org", actualSignInDto.getEmail());
        assertEquals("iloveyou", actualSignInDto.getPassword());
    }
}

