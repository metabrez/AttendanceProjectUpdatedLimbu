package edu.mum.cs.projects.attendance.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import edu.mum.cs.projects.attendance.domain.entity.Role;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.domain.entity.security.User;
import edu.mum.cs.projects.attendance.repository.RoleRepository;
import edu.mum.cs.projects.attendance.repository.StudentRepository;
import edu.mum.cs.projects.attendance.repository.UserRepository;
import edu.mum.cs.projects.attendance.service.UserService;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class CreateUserTest {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserService us;
	
	@Autowired
	TestEntityManager em;
	
	@Test
	public void test() {
		
		String userName = "aaaaa";
		
//		Role role = roleRepository.findById(1);
		
		Role role = new Role();
		role.setId(1);

//		Student student = studentRepository.findByStudentId("000-98-0010");
		
		Student student = new Student();
		student.setStudentId("000-98-0010");
		
		System.out.println(student.getFirstName());
		
		User expectedUser = new User();
		expectedUser.setUserName("aaaaa");
		expectedUser.setPassword("aa");
		expectedUser.setFaculty(null);
		expectedUser.setRole(role);
		expectedUser.setStudent(student);
//		assertTrue("Test failed!!!", actualUser.equals(expectedUser));
		
		em.persist(expectedUser);
		
		User actualUser = us.findByUserName(userName);
		assertThat(actualUser.getUserName()).isEqualTo("aaaaa");
		
//		assertEquals(expectedUser, actualUser);
	}

}
