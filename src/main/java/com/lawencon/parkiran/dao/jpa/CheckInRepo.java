package com.lawencon.parkiran.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.parkiran.models.CheckIn;

@Repository
public interface CheckInRepo extends JpaRepository<CheckIn, Long> {
	
	@Query("select typeCode from VehicleType where typeId = ?1")
	abstract String codeGenerate(int typeId);
}
