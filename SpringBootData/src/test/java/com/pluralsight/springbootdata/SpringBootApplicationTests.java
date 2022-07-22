package com.pluralsight.springbootdata;

import com.pluralsight.springbootdata.entity.Flight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SpringBootApplicationTests {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void verifyFlightCanBeSaved() {
        Flight flight = new Flight();
        flight.setOrigin("London");
        flight.setDestination("Sofia");
        flight.setScheduledAt(LocalDateTime.now().plusDays(10));
        entityManager.persist(flight);

        List<Flight> flights = entityManager
                .createQuery("SELECT f FROM Flight f", Flight.class)
                .getResultList();

        assertThat(flights)
            .hasSize(1)
            .first()
            .isEqualTo(flight);
    }
}
