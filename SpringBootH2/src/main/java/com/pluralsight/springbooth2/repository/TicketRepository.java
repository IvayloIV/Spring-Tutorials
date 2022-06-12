package com.pluralsight.springbooth2.repository;

import com.pluralsight.springbooth2.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
