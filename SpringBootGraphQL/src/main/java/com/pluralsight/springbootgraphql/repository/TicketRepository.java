package com.pluralsight.springbootgraphql.repository;

import com.pluralsight.springbootgraphql.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
