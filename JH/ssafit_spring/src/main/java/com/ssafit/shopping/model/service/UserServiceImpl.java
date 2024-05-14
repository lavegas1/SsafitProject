package com.ssafit.shopping.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.shopping.model.dao.UserDao;
import com.ssafit.shopping.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public void signup(User user) {
		userDao.insertUser(user);
	}

	@Override
	public User login(String id, String password) {
		Map<String, String> info = new HashMap<>();
		info.put("id", id);
		info.put("password", password);
		return userDao.selectOne(info);
	}

}
