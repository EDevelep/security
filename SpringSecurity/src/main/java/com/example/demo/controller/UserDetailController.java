package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Api(value = "UserDetailController", tags = { "UserDetail Controller" })
@CrossOrigin(origins = "*")
@RestController
public class UserDetailController {

	@Autowired
	private UserDetailService userDetailService;

	@Autowired
	private MyUserDetailService userDetailsService;

	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private UserDetailRepo userDetailRepo;

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/auth")
	public ResponseEntity<?> cerateAuth(@RequestBody AuthnatationReq authnatationReq) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authnatationReq.getUsername(),
					authnatationReq.getPassword()));
		} catch (Exception e) {
			throw new Exception("user name and password fail");
		}
		UserDetails userDetails = userDetailsService.loadUserByUsername(authnatationReq.getUsername());

		String token = jwtutil.generateToken(userDetails);

		return ResponseEntity.ok(new AuTResponcs(token));
	}

	@GetMapping(value = "/employees")
	public ResponseEntity<Response<List<UserDetail>>> findAllUser() {
		try {
			List<UserDetail> userdetail = userDetailRepo.findAll();
			return new ResponseEntity<>(new Response<>(userdetail, StatusEnum.SUCCESS, null), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(new Response<>(null, StatusEnum.FAILURE, e.getMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			throw new UserDetailServerException(e.getMessage(), e);
		}
	}

	@PostMapping(value = "/employees")
	public ResponseEntity<?> saveUserDetail(@RequestBody UserDetail userDetail) {
		try {
			userDetailService.saveUserDetail(userDetail);
			return new ResponseEntity<>(("UserDetail data saved successfully"), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(new Response<>(null, StatusEnum.FAILURE, e.getMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			throw new UserDetailServerException(e.getMessage(), e);
		}

	}

	@PutMapping(value = "/employees/{id}")
	public ResponseEntity<?> updateUserDetails(@PathVariable(value = "id") Long employeeId,
			@RequestBody UserDetail userDetail) {
		try {

			userDetail.setUserid(employeeId);
			userDetailService.editUserDetail(userDetail);
			return new ResponseEntity<>(("UserDetail data updated successfully"), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(new Response<>(null, StatusEnum.FAILURE, e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}
		// writting custom exception
		catch (Exception e) {
			throw new UserDetailServerException(e.getMessage(), e);
		}
	}

	@GetMapping(value = "/employees/{id}")
	public ResponseEntity<Response<List<UserDetail>>> getUserDetailByUserId(@PathVariable("id") Long id) {
		try {
			List<UserDetail> userdetail = userDetailService.getUserDetailByUserId(id);
			return new ResponseEntity<>(new Response<>(userdetail, StatusEnum.SUCCESS, null), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(new Response<>(null, StatusEnum.FAILURE, e.getMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			throw new UserDetailServerException(e.getMessage(), e);
		}
	}

	@GetMapping(value = "/user/pincode}")
	public ResponseEntity<Response<List<UserDetail>>> findUsersBypincode(@PathVariable String pincode) {
		try {
			List<UserDetail> userdetail = userDetailService.findUsersBypincode(pincode);
			return new ResponseEntity<>(new Response<>(userdetail, StatusEnum.SUCCESS, null), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(new Response<>(null, StatusEnum.FAILURE, e.getMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			throw new UserDetailServerException(e.getMessage(), e);
		}
	}

	@GetMapping(value = "/user/get/{surname}")
	public ResponseEntity<Response<List<UserDetail>>> findUsersBysurname(@PathVariable String surname) {
		try {
			List<UserDetail> userdetail = userDetailService.findUsersBysurname(surname);
			return new ResponseEntity<>(new Response<>(userdetail, StatusEnum.SUCCESS, null), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(new Response<>(null, StatusEnum.FAILURE, e.getMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			throw new UserDetailServerException(e.getMessage(), e);
		}
	}

	@GetMapping(value = "/user/get/{username}")
	public ResponseEntity<Response<List<UserDetail>>> findUsersByusername(@PathVariable String username) {
		try {
			List<UserDetail> userdetail = userDetailService.findUsersByusername(username);
			return new ResponseEntity<>(new Response<>(userdetail, StatusEnum.SUCCESS, null), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(new Response<>(null, StatusEnum.FAILURE, e.getMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			throw new UserDetailServerException(e.getMessage(), e);
		}
	}

	@PostMapping(value = "/user/get/{joiningdate}")
	public ResponseEntity<Response<List<UserDetail>>> findUsersByjoiningdate(
			@PathVariable("joiningdate") Date joiningdate) {
		try {
			List<UserDetail> userdetail = userDetailService.findUsersByjoiningdate(joiningdate);
			return new ResponseEntity<>(new Response<>(userdetail, StatusEnum.SUCCESS, null), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(new Response<>(null, StatusEnum.FAILURE, e.getMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			throw new UserDetailServerException(e.getMessage(), e);
		}
	}

	@PostMapping(value = "/get/{dateofbirth}")
	public ResponseEntity<Response<List<UserDetail>>> findUsersBydateofbirth(
			@PathVariable("dateofbirth") Date dateofbirth) {
		try {
			List<UserDetail> userdetail = userDetailService.findUsersByjdateofbirth(dateofbirth);
			return new ResponseEntity<>(new Response<>(userdetail, StatusEnum.SUCCESS, null), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(new Response<>(null, StatusEnum.FAILURE, e.getMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			throw new UserDetailServerException(e.getMessage(), e);
		}
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Response<String>> deleteUser(@PathVariable("id") Long id) {
		try {
			userDetailService.deleteUserById(id);
			return new ResponseEntity<>(new Response<>(null, StatusEnum.SUCCESS, null), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(new Response<>(null, StatusEnum.FAILURE, e.getMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			throw new UserDetailServerException(e.getMessage(), e);
		}

	}

	@PostMapping("/search/{value}")
	public ResponseEntity<Response<List<UserDetail>>> serchUser(@PathVariable String value) {
		try {

			// we can pass the dto also
			List<UserDetail> userdetail = userDetailService.search(value);
			return new ResponseEntity<>(new Response<>(userdetail, StatusEnum.SUCCESS, null), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(new Response<>(null, StatusEnum.FAILURE, e.getMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			throw new UserDetailServerException(e.getMessage(), e);
		}

	}

	@GetMapping("/getuser")
	public ResponseEntity<Response<List<UserDetail>>> getPaginatedCountries(
			@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy) {
		try {
			List<UserDetail> userdetail = userDetailService.getAllUserDetail(pageNo, pageSize, sortBy);
			return new ResponseEntity<>(new Response<>(userdetail, StatusEnum.SUCCESS, null), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(new Response<>(null, StatusEnum.FAILURE, e.getMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			throw new UserDetailServerException(e.getMessage(), e);
		}

	}

	@PostMapping("/seasearchbydaterchdate/{joiningdate}/{dateofbirth}")
	public ResponseEntity<Response<List<UserDetail>>> searchByDate(@PathVariable Date joiningdate,
			@PathVariable Date dateofbirth) {
		try {
			List<UserDetail> userdetail = userDetailService.searchByDate(joiningdate, dateofbirth);
			return new ResponseEntity<>(new Response<>(userdetail, StatusEnum.SUCCESS, null), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(new Response<>(null, StatusEnum.FAILURE, e.getMessage()),
					HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			throw new UserDetailServerException(e.getMessage(), e);
		}

	}

}
