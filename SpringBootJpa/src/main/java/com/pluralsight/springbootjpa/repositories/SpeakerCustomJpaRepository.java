package com.pluralsight.springbootjpa.repositories;

import com.pluralsight.springbootjpa.models.Speaker;

import java.util.List;

public interface SpeakerCustomJpaRepository {

    List<Speaker> findAllByTitle(String title);
}
