package me.furansa.desconstruindo.bugtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import me.furansa.desconstruindo.bugtracker.entities.ReleaseEntity;

// TODO: Compare against extending JpaRepository
// public interface ReleaseRepository extends CrudRepository<Release, Long> {}
public interface ReleaseRepository extends JpaRepository<ReleaseEntity, Long> {}