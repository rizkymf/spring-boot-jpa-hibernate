package com.lawencon.parkiran.service;

import java.util.List;

import com.lawencon.parkiran.models.Users;

public interface UserService {

	abstract List<Users> findByUnameAndPwd(String uname, String pwd);
	
	abstract boolean checkUser(String uname, String pwd) throws Exception;
}
