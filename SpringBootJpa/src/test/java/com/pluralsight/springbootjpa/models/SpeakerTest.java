package com.pluralsight.springbootjpa.models;

import com.pluralsight.springbootjpa.repositories.SpeakerFirstNameProjection;
import com.pluralsight.springbootjpa.repositories.SpeakerJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SpeakerTest {
    @Autowired
    private SpeakerJpaRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testFind() throws Exception {
        Speaker speaker = repository.getById(1L);
        assertNotNull(speaker);
    }

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        Speaker s = new Speaker();
        s.setCompany("Pluralsight");
        s.setFirstName("Dan");
        s.setLastName("Bunker");
        s.setTitle("Author");
        s.setSpeakerBio("Consulting and mentoring");
        s = repository.saveAndFlush(s);

        // clear the persistence context so we don't return the previously cached location object
        // this is a test only thing and normally doesn't need to be done in prod code
        entityManager.clear();

        Speaker otherSpeaker = repository.getById(s.getSpeakerId());
        assertEquals("Dan", otherSpeaker.getFirstName());

        repository.deleteById(otherSpeaker.getSpeakerId());
    }

    @Test
    public void testJpaAnd() {
        List<Speaker> speaker = repository.findByFirstNameAndLastName("Alicia", "Peng");
        assertEquals(1, speaker.size());
    }

    @Test
    public void testJpaOr() {
        List<Speaker> speaker = repository.findByFirstNameOrLastName("James", "Perry");
        assertEquals(6, speaker.size());
    }

    @Test
    public void testJpaEquals() {
        List<Speaker> speaker = repository.findByFirstNameEquals("James");
        assertEquals(4, speaker.size());
    }

    @Test
    public void testJpaNot() {
        List<Speaker> speaker = repository.findByFirstNameNot("James");
        assertEquals(36, speaker.size());
    }

    @Test
    public void testJpaNotLike() {
        List<Speaker> speaker = repository.findByTitleNotLike("Senior%");
        assertEquals(30, speaker.size());
    }

    @Test
    public void testJpaStartingWith() {
        List<Speaker> speaker = repository.findByTitleStartingWith("Senior");
        assertEquals(10, speaker.size());
    }

    @Test
    public void testJpaIsNull() {
        List<Speaker> speaker = repository.findByCompanyIsNull();
        assertEquals(1, speaker.size());
        assertEquals("Matthew", speaker.get(0).getFirstName());
    }

    @Test
    public void testJpaIn() {
        List<Speaker> speaker = repository.findByFirstNameIn(List.of("James", "Simon", "Tonya"));
        assertEquals(6, speaker.size());
    }

    @Test
    public void testJpaIgnoreCase() {
        List<Speaker> speaker = repository.findByFirstNameContainingIgnoreCase("CH");
        assertEquals(2, speaker.size());
    }

    @Test
    public void testJpaFirstOrderByDesc() {
        Speaker speaker = repository.findFirstByFirstNameOrderByTitleDesc("James");
        assertEquals(9, speaker.getSpeakerId());
    }

    @Test
    public void testJpaTop2() {
        List<Speaker> speakers = repository.findTop2ByFirstNameOrderByTitleDesc("James");
        assertEquals(2, speakers.size());
        assertEquals(9, speakers.get(0).getSpeakerId());
    }

    @Test
    public void testJpaDistinct() {
        List<Speaker> speakers = repository.findDistinctByFirstNameOrderByTitleDesc("James");
        assertEquals(4, speakers.size());
    }

    @Test
    public void testJpaDistinctWithProjection() {
        List<SpeakerFirstNameProjection> speakers = repository.findDistinctByFirstName("James");
        assertEquals(1, speakers.size());
    }

    @Test
    public void testJpaFindAllPagingAndSorting() {
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "firstName"));
        Page<Speaker> speakersPage = repository.findAll(pageRequest);

        assertEquals(14, speakersPage.getTotalPages());
        assertEquals(40, speakersPage.getTotalElements());
        assertEquals("Tonya", speakersPage.getContent().get(0).getFirstName());
    }

    @Test
    public void testJpaFindByFirstName() {
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "title"));
        Page<Speaker> speakersPage = repository.findBySpeakerFirstName("James", pageRequest);

        assertEquals(2, speakersPage.getTotalPages());
        assertEquals(4, speakersPage.getTotalElements());
        assertEquals("Technical Lead", speakersPage.getContent().get(0).getTitle());
    }

    @Test
    public void testJpaCustomRepository() {
        List<Speaker> speakers = repository.findAllByTitle("Software Engineer");
        assertEquals(3, speakers.size());
    }
}
