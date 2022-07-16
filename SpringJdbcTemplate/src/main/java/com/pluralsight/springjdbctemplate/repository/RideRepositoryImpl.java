package com.pluralsight.springjdbctemplate.repository;

import com.pluralsight.springjdbctemplate.model.Ride;
import com.pluralsight.springjdbctemplate.repository.util.RideRowMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class RideRepositoryImpl implements RideRepository {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Ride> getRides() {
        List<Ride> rides = jdbcTemplate.query("select * from ride", new RideRowMapper());
        return rides;
    }

    @Override
    public Ride createRide(Ride ride) {
//        jdbcTemplate.update("insert into ride(name, duration) values(?, ?)",
//                ride.getName(), ride.getDuration());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con
                        .prepareStatement("insert into ride(name, duration) values(?, ?)", new String[]{"id"});
                preparedStatement.setString(1, ride.getName());
                preparedStatement.setInt(2, ride.getDuration());
                return preparedStatement;
            }
        }, keyHolder);
        Number number = keyHolder.getKey();

//        simpleJdbcInsert.setTableName("ride");
//        simpleJdbcInsert.setColumnNames(List.of("name", "duration"));
//        simpleJdbcInsert.setGeneratedKeyName("id");
//
//        Map<String, Object> data = Map.of("name", ride.getName(), "duration", ride.getDuration());
//        Number number = simpleJdbcInsert.executeAndReturnKey(data);
//        logger.info(number);

        return getRide(number.intValue());
    }

    @Override
    public Ride getRide(int id) {
        return jdbcTemplate.queryForObject("select * from ride where id = ?",
                new RideRowMapper(), id);
    }

    @Override
    public Ride updateRide(Ride ride) {
        jdbcTemplate.update("update ride set name = ?, duration = ? where id = ?",
                ride.getName(), ride.getDuration(), ride.getId());
        return ride;
    }

    @Override
    public void batchUpdateRides(List<Object[]> elements) {
        jdbcTemplate.batchUpdate("update ride set name = ?, duration = ? where id = ?", elements);
    }

    @Override
    public void deleteRide(Integer id) {
//        jdbcTemplate.update("delete from ride where id = ?", id);
        namedParameterJdbcTemplate.update("delete from ride where id = :id", Map.of("id", id));
    }
}