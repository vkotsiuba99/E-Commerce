package com.shop.ecommerce.dto.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StripeResponseTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link StripeResponse#StripeResponse(String)}
     *   <li>{@link StripeResponse#setSessionId(String)}
     *   <li>{@link StripeResponse#getSessionId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        StripeResponse actualStripeResponse = new StripeResponse("42");
        actualStripeResponse.setSessionId("42");
        assertEquals("42", actualStripeResponse.getSessionId());
    }
}

