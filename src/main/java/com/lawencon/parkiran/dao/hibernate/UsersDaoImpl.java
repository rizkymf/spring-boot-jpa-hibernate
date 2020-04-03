package com.lawencon.parkiran.dao.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.parkiran.dao.UsersDao;
import com.lawencon.parkiran.models.Users;

@Repository("user_repo_hibernate")
public class UsersDaoImpl extends BaseHibernate implements UsersDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> findByUnameAndPwd(String uname, String pwd) {
		Query q = em.createQuery("from Users where uname = :uname and pwd = :pwd").setParameter("uname", uname).setParameter("pwd", pwd);
		return q.getResultList();
	}
	
}
