package com.project.uploads.dao;

import java.util.List;

import com.project.uploads.model.Image;

public interface PhotoDao {
	
	public List<String> getAll();

	public void addPhoto(Image i);
	
}
