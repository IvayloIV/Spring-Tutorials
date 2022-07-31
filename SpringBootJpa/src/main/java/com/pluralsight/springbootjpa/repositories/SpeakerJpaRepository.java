package com.pluralsight.springbootjpa.repositories;

import com.pluralsight.springbootjpa.models.Speaker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpeakerJpaRepository extends JpaRepository<Speaker, Long>, SpeakerCustomJpaRepository {

    List<Speaker> findByFirstNameAndLastName(String firstName, String lastName);

    List<Speaker> findByFirstNameOrLastName(String firstName, String lastName);

    List<Speaker> findByFirstNameEquals(String firstName);

    List<Speaker> findByFirstNameNot(String firstName);

    List<Speaker> findByTitleNotLike(String title);

    List<Speaker> findByTitleStartingWith(String title);

    List<Speaker> findByCompanyIsNull();

    List<Speaker> findByFirstNameIn(List<String> firstNames);

    List<Speaker> findByFirstNameContainingIgnoreCase(String firstName);

    Speaker findFirstByFirstNameOrderByTitleDesc(String firstName);

    List<Speaker> findTop2ByFirstNameOrderByTitleDesc(String firstName);

    List<Speaker> findDistinctByFirstNameOrderByTitleDesc(String firstName);

    List<SpeakerFirstNameProjection> findDistinctByFirstName(String firstName);

    @Query("SELECT s FROM Speaker s WHERE s.firstName = :firstName")
    Page<Speaker> findBySpeakerFirstName(@Param("firstName") String firstName, Pageable pageable);
}
