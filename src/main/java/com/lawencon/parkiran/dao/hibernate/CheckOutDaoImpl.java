package com.lawencon.parkiran.dao.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.parkiran.dao.CheckOutDao;
import com.lawencon.parkiran.models.CheckIn;
import com.lawencon.parkiran.models.CheckOut;

@Repository("checkout_repo_hibernate")
public class CheckOutDaoImpl extends BaseHibernate implements CheckOutDao {

	@Override
	public void saveOut(CheckOut checkOut) {
		em.persist(checkOut);
	}

	@Override
	public CheckOut updateOut(CheckOut checkOut) {
		checkOut = em.merge(checkOut);
		return checkOut;
	}

	@Override
	public CheckOut findByIdOut(Long id) {
		Query q = em.createQuery(" from CheckOut where outId = :outId")
				.setParameter("outId", id);
		return (CheckOut) q.getResultList().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CheckOut> findAllOut() {
		Query q = em.createQuery("from CheckOut");
		return q.getResultList();
	}

	@Override
	public void deleteOut(Long id) {
		CheckOut checkOut = em.find(CheckOut.class, id);
		em.remove(checkOut);
	}
	
	@Override
	public void deleteAllOut() {
		Query q = em.createQuery("delete from CheckOut");
		q.executeUpdate();		
	}

}
