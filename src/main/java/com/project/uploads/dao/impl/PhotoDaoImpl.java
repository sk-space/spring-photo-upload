package com.project.uploads.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.uploads.dao.PhotoDao;
import com.project.uploads.model.Image;

@Repository
public class PhotoDaoImpl implements PhotoDao {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	
	@Override
	@Transactional
	public void addPhoto(Image i) {
		session = sessionFactory.getCurrentSession();
		session.save(i);
	}

	@Override
	@Transactional
	public List<String> getAll() {
		session = sessionFactory.getCurrentSession();
		List<String> pList = session.createQuery("FROM Image").list();
		return pList;
	}

}
