package com.pluralsight.springbootjpa.repositories;

import com.pluralsight.springbootjpa.models.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface TicketPriceJpaRepository extends JpaRepository<TicketPrice, Long> {

    List<TicketPrice> findByBasePriceGreaterThanEqual(BigDecimal price);

    @Query("SELECT tp FROM TicketPrice tp WHERE tp.ticketType.ticketTypeName = ?1")
    List<TicketPrice> getTicketsByTicketType(String ticketType);

    @Query("SELECT tp FROM TicketPrice tp WHERE tp.ticketType.ticketTypeName = :ticketType")
    List<TicketPrice> getTicketsByTicketTypeParams(@Param("ticketType") String ticketType);

    @Modifying
    @Transactional
    @Query("UPDATE TicketPrice tp " +
            "SET tp.basePrice = tp.basePrice + :basePrice " +
            "WHERE tp.ticketType.ticketTypeCode = :ticketCode")
    int increaseBasePrice(@Param("basePrice") BigDecimal basePrice, @Param("ticketCode") String ticketCode);

    List<TicketPrice> namedParamsFindTicketsByPricingCategoryName(@Param("name") String name);
    @Query(name = "findTicketsByPricingCategoryName")
    List<TicketPrice> namedIndexFindTicketsByPricingCategoryName(String name);

    List<TicketPrice> nativeParamsFindTicketsByCategoryWithWorkshop(@Param("name") String name);

    @Query(name = "findTicketsByCategoryWithWorkshop")
    List<TicketPrice> nativeIndexFindTicketsByCategoryWithWorkshop(String name);
}
