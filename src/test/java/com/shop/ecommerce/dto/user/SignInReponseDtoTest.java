package com.shop.ecommerce.dto.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SignInReponseDtoTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link SignInReponseDto#SignInReponseDto(String, String)}
     *   <li>{@link SignInReponseDto#setStatus(String)}
     *   <li>{@link SignInReponseDto#setToken(String)}
     *   <li>{@link SignInReponseDto#getStatus()}
     *   <li>{@link SignInReponseDto#getToken()}
     * </ul>
     */
    @Test
    void testConstructor() {
        SignInReponseDto actualSignInReponseDto = new SignInReponseDto("Status", "ABC123");
        actualSignInReponseDto.setStatus("Status");
        actualSignInReponseDto.setToken("ABC123");
        assertEquals("Status", actualSignInReponseDto.getStatus());
        assertEquals("ABC123", actualSignInReponseDto.getToken());
    }
}

