package me.furansa.desconstruindo.bugtracker.unit.controllers;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import me.furansa.desconstruindo.bugtracker.controllers.ApplicationController;
import me.furansa.desconstruindo.bugtracker.repositories.ApplicationRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationController.class)
public class ApplicationControllerUnitTest {
    private final String url = "/api/v1/applications/";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ApplicationRepository applicationRepository;

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get(url))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(content().json("[]"));

        // Verify the output against the repository
        verify(applicationRepository, times(2)).findAll();
    }

    @Test
    public void getOne() throws Exception {
        final long id = 1;

        mockMvc.perform(get(url + id))
               .andExpect(status().isOk());
               //.andExpect(content().contentType(MediaType.APPLICATION_JSON));
               //.andExpect(content().json("[]"));

        // Verify the output against the repository
        verify(applicationRepository, times(1)).getOne(id);
    }

    // TODO: create()

    // TODO: update()

    // TODO: patch()

    // TODO: delete()
}