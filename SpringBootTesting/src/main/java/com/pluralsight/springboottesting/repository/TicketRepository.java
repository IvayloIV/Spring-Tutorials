package com.pluralsight.springboottesting.repository;

import com.pluralsight.springboottesting.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
