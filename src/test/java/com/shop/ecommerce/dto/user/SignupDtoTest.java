package com.shop.ecommerce.dto.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SignupDtoTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link SignupDto}
     *   <li>{@link SignupDto#setEmail(String)}
     *   <li>{@link SignupDto#setFirstName(String)}
     *   <li>{@link SignupDto#setLastName(String)}
     *   <li>{@link SignupDto#setPassword(String)}
     *   <li>{@link SignupDto#getEmail()}
     *   <li>{@link SignupDto#getFirstName()}
     *   <li>{@link SignupDto#getLastName()}
     *   <li>{@link SignupDto#getPassword()}
     * </ul>
     */
    @Test
    void testConstructor() {
        SignupDto actualSignupDto = new SignupDto();
        actualSignupDto.setEmail("jane.doe@example.org");
        actualSignupDto.setFirstName("Jane");
        actualSignupDto.setLastName("Doe");
        actualSignupDto.setPassword("iloveyou");
        assertEquals("jane.doe@example.org", actualSignupDto.getEmail());
        assertEquals("Jane", actualSignupDto.getFirstName());
        assertEquals("Doe", actualSignupDto.getLastName());
        assertEquals("iloveyou", actualSignupDto.getPassword());
    }
}

