package com.lawencon.parkiran.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.parkiran.models.CheckOut;

@Repository
public interface CheckOutRepo extends JpaRepository<CheckOut, Long> {

}

