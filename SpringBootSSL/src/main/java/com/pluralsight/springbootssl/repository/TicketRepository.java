package com.pluralsight.springbootssl.repository;

import com.pluralsight.springbootssl.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
