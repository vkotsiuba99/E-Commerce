package com.shop.ecommerce.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setFirstName(String)}
     *   <li>{@link User#setId(Integer)}
     *   <li>{@link User#setLastName(String)}
     *   <li>{@link User#setPasswoprd(String)}
     *   <li>{@link User#getEmail()}
     *   <li>{@link User#getFirstName()}
     *   <li>{@link User#getId()}
     *   <li>{@link User#getLastName()}
     *   <li>{@link User#getPasswoprd()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setFirstName("Jane");
        actualUser.setId(1);
        actualUser.setLastName("Doe");
        actualUser.setPasswoprd("Passwoprd");
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals(1, actualUser.getId().intValue());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals("Passwoprd", actualUser.getPasswoprd());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User(String, String, String, String)}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setFirstName(String)}
     *   <li>{@link User#setId(Integer)}
     *   <li>{@link User#setLastName(String)}
     *   <li>{@link User#setPasswoprd(String)}
     *   <li>{@link User#getEmail()}
     *   <li>{@link User#getFirstName()}
     *   <li>{@link User#getId()}
     *   <li>{@link User#getLastName()}
     *   <li>{@link User#getPasswoprd()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        User actualUser = new User("Jane", "Doe", "jane.doe@example.org", "iloveyou");
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setFirstName("Jane");
        actualUser.setId(1);
        actualUser.setLastName("Doe");
        actualUser.setPasswoprd("Passwoprd");
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("Jane", actualUser.getFirstName());
        assertEquals(1, actualUser.getId().intValue());
        assertEquals("Doe", actualUser.getLastName());
        assertEquals("Passwoprd", actualUser.getPasswoprd());
    }
}

