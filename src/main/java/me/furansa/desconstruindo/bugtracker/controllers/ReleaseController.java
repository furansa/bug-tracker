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

import me.furansa.desconstruindo.bugtracker.entities.ReleaseEntity;
import me.furansa.desconstruindo.bugtracker.repositories.ReleaseRepository;

@RestController
@RequestMapping("/api/v1/releases")
public class ReleaseController {
    @Autowired
    private ReleaseRepository releaseRepository;

    // Get all
    @GetMapping
    public List<ReleaseEntity> getAll() {
        return releaseRepository.findAll();
    }

    // Get one
    @GetMapping
    @RequestMapping("{id}")
    public ReleaseEntity getOne(@PathVariable final Long id) {
        return releaseRepository.getOne(id);
    }

    // Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReleaseEntity create(@RequestBody final ReleaseEntity releaseEntity) { // Marshall the Request into Release object
        return releaseRepository.saveAndFlush(releaseEntity);
    }

    // Update
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ReleaseEntity update(@PathVariable final Long id,
                          @RequestBody final ReleaseEntity releaseEntity) {
        ReleaseEntity existingRelease = releaseRepository.getOne(id);

        // Copy received object into existing one retrieved from database,
        // except the id from database to preserve the existing value
        BeanUtils.copyProperties(releaseEntity, existingRelease, "id");

        return releaseRepository.saveAndFlush(existingRelease);
    }

    // Patch
    // TODO: Implement PATCH verb to perform partial update
    // @RequestMapping(value = "{id}", method = RequestMethod.PATCH)

    // Delete
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable final Long id) {
        // TODO: Check for children record before delete?
        releaseRepository.deleteById(id);
    }
}