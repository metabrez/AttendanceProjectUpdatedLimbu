package edu.mum.cs.projects.attendance.service;

import java.util.List;

import edu.mum.cs.projects.attendance.domain.entity.security.User;

public interface UserService {
	
	public User createUser(String userName, String password, int roleId, String studentId, Long facultyId);
	
	public List<User> findAllUser();

//	public User getUserById(int id);
	
	public int updateUser(String userName, String password, int roleId, String studentId, Long facultyId);

	public User findByUserName(String userName);
	
	public void deleteUserByName(String userName);
}
