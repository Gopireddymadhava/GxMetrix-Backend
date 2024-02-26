package com.gx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gx.entites.Image;
import com.gx.repositories.ImageRepo;

@Service
public class ImageService {
	
	@Autowired
	private ImageRepo imagerepo;
	
	public void save(String  image) {
		Image image1=new Image();
		image1.setUrl(image);
		 imagerepo.save(image1);
	}

}
