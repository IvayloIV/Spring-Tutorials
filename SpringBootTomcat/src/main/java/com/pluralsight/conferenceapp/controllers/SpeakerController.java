package com.pluralsight.conferenceapp.controllers;

import com.pluralsight.conferenceapp.models.Speaker;
import com.pluralsight.conferenceapp.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/speaker")
public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> getSpeakers() {
        return speakerRepository.findAll();
    }

    @GetMapping("{id}")
    public Speaker getSpeaker(@PathVariable Long id) {
        return speakerRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker create(@RequestBody Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }

    @PutMapping("{id}")
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
        Speaker oldSpeaker = speakerRepository.getById(id);
        BeanUtils.copyProperties(speaker, oldSpeaker, "id");
        return speakerRepository.saveAndFlush(oldSpeaker);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        speakerRepository.deleteById(id);
    }
}
