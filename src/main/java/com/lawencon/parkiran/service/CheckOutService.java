package com.lawencon.parkiran.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lawencon.parkiran.models.CheckOut;

@Service
public interface CheckOutService {
	
	abstract void saveOut(CheckOut checkOut, String uname, String pwd) throws Exception ;
	abstract CheckOut updateOut(CheckOut checkOut, String uname, String pwd) throws Exception;
	abstract CheckOut findByIdOut(Long id, String uname, String pwd) throws Exception;
	abstract List<CheckOut> findAllOut(String uname, String pwd) throws Exception;
	abstract void deleteAllOut(String uname, String pwd) throws Exception;
	abstract void deleteOut(Long id, String uname, String pwd) throws Exception;

}
