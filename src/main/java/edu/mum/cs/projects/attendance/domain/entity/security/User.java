package edu.mum.cs.projects.attendance.domain.entity.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import edu.mum.cs.projects.attendance.domain.Identifiable;
import edu.mum.cs.projects.attendance.domain.entity.Faculty;
import edu.mum.cs.projects.attendance.domain.entity.Role;
import edu.mum.cs.projects.attendance.domain.entity.Student;

@Entity
@Immutable
@Table(name = "user")
public class User implements Identifiable<String> {
	@Id
	@Column(name = "username", columnDefinition = "nvarchar(25)")
	private String userName;

	@Column(name = "password", columnDefinition = "nvarchar(25)")
	private String password;

	@OneToOne
	@JoinColumn(name = "studentId", columnDefinition = "nvarchar(50)")
	private Student student;

	@OneToOne
	@JoinColumn(name = "facultyId", columnDefinition = "int")
	private Faculty faculty;

	@OneToOne
	@JoinColumn(name = "roleId", columnDefinition = "int")
	private Role role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	/*@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<>();
		// role.forEach(ur -> authorities.add(new
		// Authority(ur.getRole().getName())));
		authorities.add(new Authority(role.getName()));
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;*/
	/*}
*/
	@Override
	public String getId() {
		return "";
	}
}
