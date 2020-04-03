package com.lawencon.parkiran.dao;

import java.util.List;

import com.lawencon.parkiran.models.CheckIn;

public interface CheckInDao {
	abstract void saveIn(CheckIn checkIn);
	abstract CheckIn updateIn(CheckIn checkIn);
	abstract CheckIn findByIdIn(Long id);
	abstract List<CheckIn> findAllIn();
	abstract void deleteAllIn();
	abstract void deleteIn(Long id);
	
	abstract String codeGenerate(CheckIn checkIn);

}
