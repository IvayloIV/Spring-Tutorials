package com.pluralsight.springbootjpa.models;

import com.pluralsight.springbootjpa.repositories.PricingCategoryRepository;
import com.pluralsight.springbootjpa.repositories.TicketPriceJpaRepository;
import com.pluralsight.springbootjpa.repositories.TicketPriceRepository;
import com.pluralsight.springbootjpa.repositories.TicketTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TicketPriceTest {
    @Autowired
    private TicketPriceJpaRepository repository;

    @Autowired
    private PricingCategoryRepository pcRepository;

    @Autowired
    private TicketTypeRepository ttRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testFind() throws Exception {
        TicketPrice ticket = repository.getById(1L);
        assertNotNull(ticket);
    }

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        TicketPrice tp = new TicketPrice();
        tp.setBasePrice(BigDecimal.valueOf(200, 2));

        tp.setPricingCategory(pcRepository.find("E"));

        tp.setTicketType(ttRepository.find("C"));

        tp = repository.saveAndFlush(tp);

        // clear the persistence context so we don't return the previously cached location object
        // this is a test only thing and normally doesn't need to be done in prod code
        entityManager.clear();

        TicketPrice otherTp = repository.getById(tp.getTicketPriceId());
        assertEquals(BigDecimal.valueOf(200, 2), otherTp.getBasePrice());

        repository.deleteById(  otherTp.getTicketPriceId());
    }

    @Test
    public void testJpaGreaterThan() {
        List<TicketPrice> ticketPrices = repository.findByBasePriceGreaterThanEqual(BigDecimal.valueOf(800));
        assertEquals(4, ticketPrices.size());
    }

    @Test
    public void testJpaIndexedQuery() {
        List<TicketPrice> ticketPrices = repository.getTicketsByTicketType("Standard");
        assertEquals(3, ticketPrices.size());
    }

    @Test
    public void testJpaParamsQuery() {
        List<TicketPrice> ticketPrices = repository.getTicketsByTicketTypeParams("Standard");
        assertEquals(3, ticketPrices.size());
    }

    @Test
    public void testJpaUpdateBasePrice() {
        int updatedRows = repository.increaseBasePrice(BigDecimal.valueOf(10), "S");
        assertEquals(3, updatedRows);
    }

    @Test
    public void testJpaNamedParamsQuery() {
        List<TicketPrice> ticketPrices = repository.namedParamsFindTicketsByPricingCategoryName("Last Minute");
        assertEquals(3, ticketPrices.size());
    }

    @Test
    public void testJpaNamedIndexQuery() {
        List<TicketPrice> ticketPrices = repository.namedIndexFindTicketsByPricingCategoryName("Last Minute");
        assertEquals(3, ticketPrices.size());
    }

    @Test
    public void testJpaNativeParamsQuery() {
        List<TicketPrice> ticketPrices = repository.nativeParamsFindTicketsByCategoryWithWorkshop("Early Bird");
        assertEquals(1, ticketPrices.size());
        assertEquals(1, ticketPrices.get(0).getTicketPriceId());
    }

    @Test
    public void testJpaNativeIndexQuery() {
        List<TicketPrice> ticketPrices = repository.nativeIndexFindTicketsByCategoryWithWorkshop("Early Bird");
        assertEquals(1, ticketPrices.size());
        assertEquals(1, ticketPrices.get(0).getTicketPriceId());
    }

}
