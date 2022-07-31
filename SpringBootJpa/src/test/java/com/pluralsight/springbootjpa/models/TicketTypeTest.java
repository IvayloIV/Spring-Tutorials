package com.pluralsight.springbootjpa.models;

import com.pluralsight.springbootjpa.repositories.TicketTypeJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TicketTypeTest {
    @Autowired
    private TicketTypeJpaRepository repository;

    @Test
    public void testJpaGreaterThan() {
        List<TicketType> ticketTypes = repository.findByIncludesWorkshopFalse();
        assertEquals(2, ticketTypes.size());
    }

}
