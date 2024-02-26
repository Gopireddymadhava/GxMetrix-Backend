package com.gx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.gx.service.ImageService;


@CrossOrigin(origins="*")
@RestController
public class ImageController {
	@Autowired
	private ImageService imageservice;
	
	
	
	@RequestMapping("/saveimage")
	public String getimageurl(@RequestParam String url){

	 return url;
	}
	
	@PostMapping("/callclient")
	public ResponseEntity<String> fetchandstoreimage(@RequestParam String imageUrl){
		RestTemplate resttemplate =new RestTemplate();
		String imagedata=resttemplate.getForObject("http://localhost:8080/saveimage?url="+ imageUrl, String.class);
		imageservice.save(imagedata);
		return ResponseEntity.ok("Image saved successfully");
		
		
	}

	

}
