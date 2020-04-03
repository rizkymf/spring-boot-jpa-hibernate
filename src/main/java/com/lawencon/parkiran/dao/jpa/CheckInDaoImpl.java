package com.lawencon.parkiran.dao.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.parkiran.dao.CheckInDao;
import com.lawencon.parkiran.dao.hibernate.BaseHibernate;
import com.lawencon.parkiran.models.CheckIn;

@Repository("checkin_repo_jpa")
public class CheckInDaoImpl extends BaseHibernate implements CheckInDao {

	@Autowired
	private CheckInRepo inRepo;

	@Override
	public void saveIn(CheckIn checkIn) {
		inRepo.save(checkIn);
	}

	@Override
	public CheckIn updateIn(CheckIn checkIn) {
		checkIn = inRepo.save(checkIn);
		return checkIn;
	}

	@Override
	public CheckIn findByIdIn(Long id) {
		return inRepo.findById(id).orElse(null);
	}

	@Override
	public List<CheckIn> findAllIn() {
		return inRepo.findAll();
	}

	@Override
	public void deleteIn(Long id) {
		inRepo.deleteById(id);
		;
	}

	@Override
	public void deleteAllIn() {
		inRepo.deleteAll();
	}

	@Override
	public String codeGenerate(CheckIn checkIn) {
		String typeCode = inRepo.codeGenerate(checkIn.getTypeId().getTypeId());
		return typeCode;
	}

}
