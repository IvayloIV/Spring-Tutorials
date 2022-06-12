package com.pluralsight.springboottesting.controller;

import com.pluralsight.springboottesting.entity.Application;
import com.pluralsight.springboottesting.repository.ApplicationRepository;
import com.pluralsight.springboottesting.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class) // included by default in @WebMvcTest
@WebMvcTest(ApplicationRestController.class)
class ApplicationRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApplicationService applicationService;

    @MockBean //Only for CommandLineRunner
    private ApplicationRepository applicationRepository;

    @Test
    @DisplayName("Retrieving application by id test")
    void retrieveApplication() throws Exception {
        Application application = new Application();
        application.setId(1L);
        application.setName("Cleaning");
        application.setDescription("Desc");
        application.setOwner("Teodor");

        Mockito.when(applicationService.getApplication(application.getId()))
                .thenReturn(application);

        mockMvc.perform(get("/api/v1/application/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.name").value(application.getName()));
    }
}