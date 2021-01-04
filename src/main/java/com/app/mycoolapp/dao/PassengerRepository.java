package com.app.mycoolapp.dao;

import com.app.mycoolapp.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    List<Passenger> findByStatusContainingIgnoreCase(String status);
}
