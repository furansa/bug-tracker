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

import me.furansa.desconstruindo.bugtracker.entities.TicketEntity;
import me.furansa.desconstruindo.bugtracker.repositories.TicketRepository;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;

    // Get all
    @GetMapping
    public List<TicketEntity> getAll() {
        return ticketRepository.findAll();
    }

    // Get one
    @GetMapping
    @RequestMapping("{id}")
    public TicketEntity getOne(@PathVariable final Long id) {
        return ticketRepository.getOne(id);
    }

    // Create
    // FIXME: Cannot construct instance of 'me.furansa.desconstruindo.bugtracker.models.Application'
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TicketEntity create(@RequestBody final TicketEntity ticketEntity) {  // Marshall the Request into Ticket object
        return ticketRepository.saveAndFlush(ticketEntity);
    }

    // Update
    // FIXME: Cannot construct instance of 'me.furansa.desconstruindo.bugtracker.models.Application'
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public TicketEntity update(@PathVariable final Long id,
                         @RequestBody final TicketEntity ticketEntity) {
        TicketEntity existingTicket = ticketRepository.getOne(id);

        // Copy received object into existing one retrieved from database,
        // except the id from database to preserve the existing value
        BeanUtils.copyProperties(ticketEntity, existingTicket, "id");

        return ticketRepository.saveAndFlush(existingTicket);
    }

    // Patch
    // TODO: Implement PATCH verb to perform partial update
    // @RequestMapping(value = "{id}", method = RequestMethod.PATCH)

    // Delete
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable final Long id) {
        // TODO: Check for children record before delete?
        ticketRepository.deleteById(id);
    }
}