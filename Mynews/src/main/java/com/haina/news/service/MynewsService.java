package com.haina.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haina.news.dao.MynewsDao;
import com.haina.news.domin.Mynews;


@Service
public class MynewsService {
	@Autowired
	private MynewsDao mynewsDao;
	public List<Mynews> findAll() {
		List<Mynews> list = mynewsDao.findAll();
		return list;
	}
	public void add(Mynews mynews) {
		mynewsDao.add(mynews);
		
	}
	public Mynews findbyid(int id) {
		
		return mynewsDao.findbyid(id);
	}
	public Mynews staticfun() {
		// TODO Auto-generated method stub
		return mynewsDao.staticfun();
	}
	public void updatemn(Mynews mn) {
		mynewsDao.updatemn(mn);
		
	}
	

}
