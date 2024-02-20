package com.gx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gx.dto.LoginDto;
import com.gx.dto.UserDto;
import com.gx.entites.LoginResponse;
import com.gx.entites.User;
import com.gx.exceptions.UserNotFoundException;
import com.gx.service.EmailService1;
import com.gx.service.UserService;

import jakarta.validation.Valid;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userservice;
	
	   @Autowired
	    private EmailService1 emailService;

	//Save a new user (signup)
	@PostMapping("/signup")
	public ResponseEntity<User> saveuser(@RequestBody @Valid UserDto dto){
	 // Call userservice to save a new user and return the created user
	 return new ResponseEntity<>(userservice.saveUser(dto), HttpStatus.CREATED);
	}

	//Get all users
	@GetMapping("/alluser")
	public ResponseEntity<List<User>> getallUsers(){
	 // Retrieve and return all users
	 return ResponseEntity.ok(userservice.getAllUser1());
	}

	//Get user by ID
	@GetMapping("/all/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id) throws UserNotFoundException{
	 // Retrieve and return user by ID
	 return ResponseEntity.ok(userservice.getUser1(id));
	}

	//Login user
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> loginEmployee(@RequestBody LoginDto loginDTO)
	{
	 // Call userservice to authenticate and login the user
	 LoginResponse loginResponse = userservice.loginEmployee(loginDTO);
	 
	
	 return ResponseEntity.ok(loginResponse);
	}
	
	 // Endpoint for deleting user by ID
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userservice.deleteUserById(userId);
        return ResponseEntity.ok("User with ID " + userId + " deleted successfully.");
    }

    // Endpoint for updating user details
    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody UserDto dto) {
        User updatedUser = userservice.updateUser(userId, dto);
        return ResponseEntity.ok(updatedUser);
    }
	
 
    @GetMapping("/{username}")
    public ResponseEntity<?> getUserEmail(@PathVariable String username) {
        String email = userservice.getemailbyusername(username);
        System.out.println(email);
       return ResponseEntity.ok(email);
     
    }

    @PostMapping("/send-email/{email}")
    public ResponseEntity<String> sendEmail(@PathVariable String email) {
        try {
            emailService.sendLoginEmail(email);
            return ResponseEntity.ok("Email sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Failed to send email: " + e.getMessage());
        }
    }
	
	
}
