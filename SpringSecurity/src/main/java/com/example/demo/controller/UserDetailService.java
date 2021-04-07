package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface UserDetailService {
	void saveUserDetail(UserDetail userDetail);

	void editUserDetail(UserDetail userdetail);
	List<UserDetail> search(String keyword);
	List<UserDetail> getUserDetailByUserId(Long userid);
	List<UserDetail> searchByDate(Date joiningdate, Date dateofbirth );
	void deleteUserById(Long id);
	List<UserDetail> findUsersByjdateofbirth(Date dateofbirth);
	List<UserDetail> findUsersByjoiningdate(Date joiningdate);
	List<UserDetail> findUsersByusername(String username);
	List<UserDetail> findUsersBysurname(String surname);
	List<UserDetail> findUsersBypincode(String pincode);
//	List<UserDetail> findPaginated(int pageNo, int pageSize);
	Page<UserDetail> findUsersBydateofbirth (Date dateofbirth, Pageable pageable);
	List<UserDetail> getAllUserDetail(Integer pageNo, Integer pageSize, String sortBy);

}
