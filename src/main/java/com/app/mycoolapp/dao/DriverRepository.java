package com.app.mycoolapp.dao;

import com.app.mycoolapp.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    List<Driver> findFirst1ByStatusContainingIgnoreCase(String status);

    List<Driver> findByStatusContainingIgnoreCase(String status);
}
