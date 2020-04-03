package com.lawencon.parkiran.dao.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.parkiran.dao.CheckInDao;
import com.lawencon.parkiran.models.CheckIn;

@Repository("checkin_repo_hibernate")
public class CheckInDaoImpl extends BaseHibernate implements CheckInDao {
	
	public String codeGenerate(CheckIn checkIn) {
		String typeCode = em.createQuery("select typeCode from VehicleType where typeId = :typeId")
				.setParameter("typeId", checkIn.getTypeId().getTypeId()).getResultList().get(0).toString();
		return typeCode;
	}

	@Override
	public void saveIn(CheckIn checkIn) {
		em.persist(checkIn);
	}

	@Override
	public CheckIn updateIn(CheckIn checkIn) {
		checkIn = em.merge(checkIn);
		return checkIn;
	}

	@Override
	public CheckIn findByIdIn(Long id) {
		Query q = em.createQuery(" from CheckIn where inId = :inId")
				.setParameter("inId", id);
		return (CheckIn) q.getResultList().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CheckIn> findAllIn() {
		Query q = em.createQuery(" from CheckIn");
		return q.getResultList();
	}

	@Override
	public void deleteIn(Long id) {
		CheckIn checkIn = em.find(CheckIn.class, id);
		em.remove(checkIn);
	}
	
	@Override
	public void deleteAllIn() {
		Query q = em.createQuery("delete from CheckIn");
		q.executeUpdate();		
	}
}
