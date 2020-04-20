package me.furansa.desconstruindo.bugtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

import me.furansa.desconstruindo.bugtracker.entities.ApplicationEntity;

// TODO: Compare against extending JpaRepository
// public interface ApplicationRepository extends CrudRepository<Application, Long> {}
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {}