package com.lawencon.parkiran.dao.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.parkiran.models.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {

	abstract List<Users> findByUnameAndPwd(String uname, String pwd);
}
