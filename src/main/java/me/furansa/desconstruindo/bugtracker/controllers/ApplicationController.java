package me.furansa.desconstruindo.bugtracker.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.furansa.desconstruindo.bugtracker.entities.ApplicationEntity;
import me.furansa.desconstruindo.bugtracker.repositories.ApplicationRepository;

@RestController
@RequestMapping("/api/v1/applications")
public class ApplicationController {
    @Autowired
    private ApplicationRepository applicationRepository;

    // Get all
    @GetMapping
    public List<ApplicationEntity> getAll() {
        return applicationRepository.findAll();
    }

    // Get one
    @GetMapping
    @RequestMapping("{id}")
    public ApplicationEntity getOne(@PathVariable final Long id) {
        return applicationRepository.getOne(id);
    }

    // Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApplicationEntity create(@RequestBody final ApplicationEntity applicationEntity) {  // Marshall the Request into Application object
        return applicationRepository.saveAndFlush(applicationEntity);
    }

    // Update
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ApplicationEntity update(@PathVariable final Long id,
                              @RequestBody final ApplicationEntity applicationEntity) {
        ApplicationEntity existingApplication = applicationRepository.getOne(id);

        // Copy received object into existing one retrieved from database,
        // except the id from database to preserve the existing value
        BeanUtils.copyProperties(applicationEntity, existingApplication, "id");

        return applicationRepository.saveAndFlush(existingApplication);
    }

    // Patch
    // TODO: Implement PATCH verb to perform partial update
    // @RequestMapping(value = "{id}", method = RequestMethod.PATCH)

    // Delete
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable final Long id) {
        // TODO: Check for children record before delete?
        applicationRepository.deleteById(id);
    }
}