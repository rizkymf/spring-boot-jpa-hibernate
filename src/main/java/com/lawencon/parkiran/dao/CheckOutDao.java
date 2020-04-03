package com.lawencon.parkiran.dao;

import java.util.List;

import com.lawencon.parkiran.models.CheckOut;

public interface CheckOutDao {

	abstract void saveOut(CheckOut checkOut);
	abstract CheckOut updateOut(CheckOut checkOut);
	abstract CheckOut findByIdOut(Long id);
	abstract List<CheckOut> findAllOut();
	abstract void deleteAllOut();
	abstract void deleteOut(Long id);
	
}
