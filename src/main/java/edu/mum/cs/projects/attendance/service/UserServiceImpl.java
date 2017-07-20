package edu.mum.cs.projects.attendance.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.projects.attendance.domain.entity.Role;
import edu.mum.cs.projects.attendance.domain.entity.security.User;
import edu.mum.cs.projects.attendance.repository.FacultyRepository;
import edu.mum.cs.projects.attendance.repository.RoleRepository;
import edu.mum.cs.projects.attendance.repository.StudentRepository;
import edu.mum.cs.projects.attendance.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	FacultyRepository facultyRepository;

	@Autowired
	StudentRepository studentRepository;

	@Override
	public User createUser(String userName, String password, int roleId, String studentId, Long facultyId) {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setRole(roleRepository.findById(roleId));
		if (studentId.length() > 0) {
			user.setStudent(studentRepository.findByStudentId(studentId));
			user.setFaculty(null);
		}
		if (facultyId != null)
		/* if(facultyId>=0) */ {
			user.setStudent(null);
			user.setFaculty(facultyRepository.findById(facultyId));
		}

		return userRepository.save(user);

	}

	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}
	/*
	 * @Override public User getUserById(int id) { return
	 * userRepository.findByUserId(id); }
	 */

	@Override
	public int updateUser(String userName, String password, int roleId, String studentId, Long facultyId) {
		if (studentId != null) {

		}
		return userRepository.userUpdate(userName, password, roleId, studentId, facultyId);
	}

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);

	}

	@Override
	public void deleteUserByName(String userName) {
		userRepository.delete(userName);
	}

}
