package com.lawencon.parkiran.dao.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.parkiran.dao.CheckOutDao;
import com.lawencon.parkiran.models.CheckOut;

@Repository("checkout_repo_jpa")
public class CheckOutDaoImpl implements CheckOutDao {
	
	@Autowired
	private CheckOutRepo outRepo;

	@Override
	public void saveOut(CheckOut checkOut) {
		outRepo.save(checkOut);		
	}

	@Override
	public CheckOut updateOut(CheckOut checkOut) {
		checkOut = outRepo.save(checkOut);
		return checkOut;
	}

	@Override
	public CheckOut findByIdOut(Long id) {
		return outRepo.findById(id).orElse(null);
	}

	@Override
	public List<CheckOut> findAllOut() {
		return outRepo.findAll();
	}

	@Override
	public void deleteOut(Long id) {
		outRepo.deleteById(id);
	}
	
	@Override
	public void deleteAllOut() {
		outRepo.deleteAll();		
	}

	
}
