package com.lawencon.parkiran.dao.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.parkiran.dao.UsersDao;
import com.lawencon.parkiran.models.Users;

@Repository("user_repo_jpa")
public class UsersDaoImpl implements UsersDao {
	
	@Autowired
	private UserRepo usRepo;

	@Override
	public List<Users> findByUnameAndPwd(String uname, String pwd) {
		return usRepo.findByUnameAndPwd(uname, pwd);
	}	

}
