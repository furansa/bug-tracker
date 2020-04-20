package me.furansa.desconstruindo.bugtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import me.furansa.desconstruindo.bugtracker.entities.TicketEntity;

// TODO: Compare against extending JpaRepository
// public interface TicketRepository extends CrudRepository<Ticket, Long> {}
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {}