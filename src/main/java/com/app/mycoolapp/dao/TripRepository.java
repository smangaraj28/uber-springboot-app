package com.app.mycoolapp.dao;

import com.app.mycoolapp.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
