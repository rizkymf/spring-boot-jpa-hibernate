package com.lawencon.parkiran.dao;

import java.util.List;

import com.lawencon.parkiran.models.Users;

public interface UsersDao {

	abstract List<Users> findByUnameAndPwd(String uname, String pwd);
	
//	abstract boolean checkUser(String uname, String pwd) throws Exception;
	
}
