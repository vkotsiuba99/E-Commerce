package com.shop.ecommerce.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ResponseDtoTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ResponseDto#ResponseDto(String, String)}
     *   <li>{@link ResponseDto#setMessage(String)}
     *   <li>{@link ResponseDto#setStatus(String)}
     *   <li>{@link ResponseDto#getMessage()}
     *   <li>{@link ResponseDto#getStatus()}
     * </ul>
     */
    @Test
    void testConstructor() {
        ResponseDto actualResponseDto = new ResponseDto("Status", "Not all who wander are lost");
        actualResponseDto.setMessage("Not all who wander are lost");
        actualResponseDto.setStatus("Status");
        assertEquals("Not all who wander are lost", actualResponseDto.getMessage());
        assertEquals("Status", actualResponseDto.getStatus());
    }
}

