package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Repository
public interface UserDetailRepo extends JpaRepository<UserDetail, Long> {

	UserDetail findUserByemailid(String emailid);

	UserDetail findUsersByuserid(Long userid);
	List<UserDetail> findUsersByusername(String username);
	List<UserDetail> findUsersBysurname(String surname);
	List<UserDetail> findUsersBypincode(String pincode);
	List<UserDetail> findUserByuserid(Long userid);

	@Query("SELECT u FROM UserDetail u WHERE CONCAT(u.username, u.surname,  u.pincode) LIKE %?1%")
	List<UserDetail> search(String keyword);
	//serch we 3 api 
	@Query("select u  from UserDetail u order by joiningdate,dateofbirth")
	List<UserDetail> searchDate(Date joiningdate, Date dateofbirth);
	List<UserDetail> findUsersBydateofbirth(Date dateofbirth);
	List<UserDetail> findUsersByjoiningdate(Date joiningdate);
//two dif api 
	
	Page<UserDetail> findUsersBydateofbirth (Date dateofbirth, Pageable pageable);
	
	// List<UserDetail> searchDateBetweenjoiningdateAnddateofbirth(Date date);

}
