package com.vimacodes.re;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TicketShopTest {

    // unit under test
    private TicketShop ticketShop;

    @BeforeEach
    void setUp() {
        ticketShop = new TicketShop();
    }

    @ParameterizedTest
    @MethodSource
    void  verifyMinTickets(int[] A, int k, int D, int expected) {
        // given - the parameters

        // when
        int result = ticketShop.minTickets(A, k, D);

        // then
        assertEquals(expected, result);
    }

    private static Stream<Arguments> verifyMinTickets() {
        int[] tickets = {2, 4, 2, 3, 1, 3, 3, 4, 3};

        return Stream.of(
                // positive cases
                arguments(tickets, 0, 20, 6),
                arguments(tickets, 1, 20, 5),
                arguments(tickets, 2, 20, 4),
                arguments(tickets, 3, 20, 3)
        );
    }
}
