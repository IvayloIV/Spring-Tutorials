package com.pluralsight.springaopwithdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PassengerDaoImpl implements PassengerDao {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    private Map<Long, Passenger> passengers = new HashMap<>();

    @Autowired
    public PassengerDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void createDb() {
        this.jdbcTemplate.update("CREATE TABLE passenger (" +
            "   id BIGINT AUTO_INCREMENT, " +
            "   name VARCHAR(127)" +
            ") ");
    }

    public void insertRecord(String name) {
        this.jdbcTemplate.update("insert into passenger (name) values (?)", name);
    }

    public Passenger getById(Long id) {
        if (passengers.containsKey(id)) {
            Passenger passenger = passengers.get(id);
            System.out.println("Returned from the cache: " + passenger);
            return passenger;
        }

        Passenger passenger = this.jdbcTemplate.queryForObject(
                "select * from passenger where id = ?", getPassengerRowMapper(), id);
        System.out.println(passenger);
        return passenger;
    }

    private RowMapper<Passenger> getPassengerRowMapper() {
        return (rs, rowNum) ->
                new Passenger(rs.getLong("id"), rs.getString("name"));
    }

    public Map<Long, Passenger> getPassengers() {
        return passengers;
    }
}
