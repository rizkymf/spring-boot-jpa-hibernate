package com.lawencon.parkiran.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.parkiran.models.CheckOut;
import com.lawencon.parkiran.service.CheckOutService;
import com.lawencon.parkiran.service.UserService;

@SuppressWarnings("unused")
@RestController
public class CheckOutController extends BaseController {

	@Autowired
	private CheckOutService checkOutServ;
	
	@Autowired
	UserService userServ;
	
	@PostMapping("/checkout")
	public ResponseEntity<String> insert(@RequestBody String content, @RequestHeader("Authorization") String auth){
		try {
			List<CheckOut> inputan = Arrays.asList(new ObjectMapper().readValue(content, CheckOut[].class));
			for(CheckOut val : inputan) {
				checkOutServ.saveOut(val, authorize(auth)[0], authorize(auth)[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Terjadi kesalahan!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Sukses!", HttpStatus.OK);
	}
	
	@GetMapping("/checkout")
	public ResponseEntity<List<CheckOut>> showAll(@RequestHeader("Authorization") String auth){
		List<CheckOut> inList = new ArrayList<>();
		try {
			inList = checkOutServ.findAllOut(authorize(auth)[0], authorize(auth)[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(inList, HttpStatus.OK);
	}
	
	@GetMapping("/checkout/{id}")
	public ResponseEntity<Optional<CheckOut>> showById(@RequestParam("id") Long id, @RequestHeader("Authorization") String auth){
		try {
			CheckOut in = checkOutServ.findByIdOut(id, authorize(auth)[0], authorize(auth)[1]);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
