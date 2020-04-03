package com.lawencon.parkiran.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lawencon.parkiran.models.CheckIn;

@Service
public interface CheckInService {
	abstract void saveIn(CheckIn checkIn, String uname, String pwd) throws Exception;
	abstract CheckIn updateIn(CheckIn checkIn, String uname, String pwd) throws Exception;
	abstract CheckIn findByIdIn(Long id, String uname, String pwd) throws Exception;
	abstract List<CheckIn> findAllIn(String uname, String pwd) throws Exception;
	abstract void deleteAllIn(String uname, String pwd) throws Exception;
	abstract void deleteIn(Long id, String uname, String pwd) throws Exception;
	
	abstract String codeGenerate(CheckIn checkIn) throws Exception;
}
