package me.furansa.desconstruindo.bugtracker.integration;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

// FIXME: java.lang.IllegalStateException: Failed to load ApplicationContext
@RunWith(SpringRunner.class)
@SpringBootTest //(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ReleaseControllerIntegrationTest {
    @LocalServerPort
    private final int port = 8000;

    private final String url = "http://localhost:" + port + "/api/v1/releases/";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll() throws Exception {
        ResponseEntity<List> response = 
            this.restTemplate.getForEntity(url, List.class);
        
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    // TODO: getOne()

    // TODO: create()

    // TODO: update()

    // TODO: patch()

    // TODO: delete()
}