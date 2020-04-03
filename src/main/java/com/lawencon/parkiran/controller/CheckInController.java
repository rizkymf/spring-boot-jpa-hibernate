package com.lawencon.parkiran.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.parkiran.models.CheckIn;
import com.lawencon.parkiran.service.CheckInService;
import com.lawencon.parkiran.service.UserService;

@RestController
public class CheckInController extends BaseController {
	
	@Autowired
	private CheckInService checkInServ;

	@Autowired
	UserService userServ;

	@PostMapping("/checkin")
	public ResponseEntity<String> insert(@RequestBody String content, @RequestHeader("Authorization") String auth) {
		try {
			List<CheckIn> inputan = Arrays.asList(new ObjectMapper().readValue(content, CheckIn[].class));
			for (CheckIn val : inputan ) {
				val.setInCode(checkInServ.codeGenerate(val));
				checkInServ.saveIn(val, authorize(auth)[0], authorize(auth)[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Terjadi kesalahan!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Sukses!", HttpStatus.OK);
	}

	@GetMapping("/checkin")
	public ResponseEntity<?> showAll(@RequestHeader("Authorization") String auth) {
		List<CheckIn> inList = new ArrayList<>();
		try {
			inList = checkInServ.findAllIn(authorize(auth)[0], authorize(auth)[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("username atau password salah!",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(inList, HttpStatus.OK);
	}

	@GetMapping("/checkin/{id}")
	public ResponseEntity<CheckIn> showById(@PathVariable("id") Long id, @RequestHeader("Authorization") String auth) {
		CheckIn findIn;
		try {
			findIn = checkInServ.findByIdIn(id, authorize(auth)[0], authorize(auth)[1]);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(findIn, HttpStatus.OK);
	}

	@DeleteMapping("/checkin/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id, @RequestHeader("Authorization") String auth) {
		try {
			checkInServ.deleteIn(id, authorize(auth)[0], authorize(auth)[1]);
		} catch (Exception e) {
			return new ResponseEntity<String>("Gagal hapus. . .", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>("Terhapus!", HttpStatus.OK);
	}
	
	@DeleteMapping("/checkin/all")
	public ResponseEntity<String> deleteAll(@RequestHeader("Authorization") String auth) {
		try {
			checkInServ.deleteAllIn(authorize(auth)[0], authorize(auth)[1]);
		} catch (Exception e) {
			return new ResponseEntity<String>("Gagal hapus. . .", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>("Terhapus!", HttpStatus.OK);
	}
	
	@PatchMapping("/checkin")
	public ResponseEntity<String> update(@RequestBody String content, @RequestHeader("Authorization") String auth) {
		try {
			userServ.checkUser(authorize(auth)[0], authorize(auth)[1]);
			List<CheckIn> body = Arrays.asList(new ObjectMapper().readValue(content, CheckIn[].class));
			for(CheckIn val : body) {
				checkInServ.updateIn(val, authorize(auth)[0], authorize(auth)[1]);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>("Gagal update. . .", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>("Berhasil update!", HttpStatus.OK);
	}
}
