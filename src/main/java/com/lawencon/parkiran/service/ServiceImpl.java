package com.lawencon.parkiran.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.parkiran.dao.CheckInDao;
import com.lawencon.parkiran.dao.CheckOutDao;
import com.lawencon.parkiran.dao.UsersDao;
import com.lawencon.parkiran.dao.hibernate.BaseHibernate;
import com.lawencon.parkiran.models.CheckIn;
import com.lawencon.parkiran.models.CheckOut;
import com.lawencon.parkiran.models.Users;
import com.lawencon.parkiran.service.CheckInService;
import com.lawencon.parkiran.service.CheckOutService;

@Transactional
@Service
public class ServiceImpl extends BaseHibernate implements CheckInService, CheckOutService, UserService {

//	to use hibernate, simply rename jpa inside qualifier to hibernate and vice versa.
	@Autowired
	@Qualifier("checkin_repo_jpa")
	private CheckInDao inDao;

	@Autowired
	@Qualifier("checkout_repo_jpa")
	private CheckOutDao outDao;
	
	@Autowired
	@Qualifier("user_repo_jpa")
	private UsersDao usDao;
	
	@Override
	public List<Users> findByUnameAndPwd(String uname, String pwd) {
		return usDao.findByUnameAndPwd(uname, pwd);
	}
	
	@Override
	public boolean checkUser(String uname, String pwd) throws Exception {
		if(findByUnameAndPwd(uname, pwd).isEmpty()) {
			throw new Exception();
		} else return true;
	}

	@Override
	public void saveOut(CheckOut checkOut, String uname, String pwd) throws Exception {
		checkUser(uname, pwd);
		outDao.saveOut(checkOut);
	}

	@Override
	public CheckOut updateOut(CheckOut checkOut, String uname, String pwd) throws Exception {
		checkUser(uname, pwd);
		checkOut = outDao.updateOut(checkOut);
		return checkOut;
	}

	@Override
	public CheckOut findByIdOut(Long id, String uname, String pwd) throws Exception {
		checkUser(uname, pwd);
		return outDao.findByIdOut(id);
	}

	@Override
	public List<CheckOut> findAllOut(String uname, String pwd) throws Exception {
		checkUser(uname, pwd);
		return outDao.findAllOut();
	}

	@Override
	public void deleteOut(Long id, String uname, String pwd) throws Exception {
		checkUser(uname, pwd);
		outDao.deleteOut(id);
	}
	
	@Override
	public void deleteAllOut(String uname, String pwd) throws Exception {
		checkUser(uname, pwd);
		outDao.deleteAllOut();
	}

	@Override
	public void saveIn(CheckIn checkIn, String uname, String pwd) throws Exception {
		checkUser(uname, pwd);
		inDao.saveIn(checkIn);;
	}

	@Override
	public CheckIn updateIn(CheckIn checkIn, String uname, String pwd) throws Exception {
		checkUser(uname, pwd);
		checkIn = inDao.updateIn(checkIn);
		return checkIn;
	}

	@Override
	public CheckIn findByIdIn(Long id, String uname, String pwd) throws Exception {
		checkUser(uname, pwd);
		return inDao.findByIdIn(id);
	}

	@Override
	public List<CheckIn> findAllIn(String uname, String pwd) throws Exception {
		checkUser(uname, pwd);
		return inDao.findAllIn();
	}

	@Override
	public void deleteIn(Long id, String uname, String pwd) throws Exception {
		checkUser(uname, pwd);
		inDao.deleteIn(id);
	}
	
	@Override
	public void deleteAllIn(String uname, String pwd) throws Exception {
		checkUser(uname, pwd);
		inDao.deleteAllIn();
	}
	
	@Override
	public String codeGenerate(CheckIn checkIn) {
		String code = inDao.codeGenerate(checkIn) + checkIn.getPlate().replaceAll(" ", "")
				+ checkIn.getDateIn().format(DateTimeFormatter.ofPattern("ddMMyy"));
		return code;
	}

}
