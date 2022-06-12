package com.pluralsight.springbootactuator.repository;

import com.pluralsight.springbootactuator.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
