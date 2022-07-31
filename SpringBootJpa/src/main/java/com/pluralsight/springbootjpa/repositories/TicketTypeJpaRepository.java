package com.pluralsight.springbootjpa.repositories;

import com.pluralsight.springbootjpa.models.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketTypeJpaRepository extends JpaRepository<TicketType, String> {

    List<TicketType> findByIncludesWorkshopFalse();
}
