package edu.mum.cs.projects.attendance.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.projects.attendance.domain.entity.security.User;
import edu.mum.cs.projects.attendance.service.UserService;

@Controller
public class AdminController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createUser(Model model,@PathParam("userName")String userName, @PathParam("password")String password, @PathParam("roleId")int roleId, @PathParam("studentId")String studentId, @PathParam("facultyId")Long facultyId) {
		
		System.out.println("facultyID" +facultyId);
		System.out.println("studentId" +studentId+"test");
		if (userService.createUser(userName, password, roleId, studentId, facultyId) != null) {
			return "redirect:/userInfo";
		} else {
			model.addAttribute("msg", "This user couldn't be created.");
			return "error";
		}
	}

	@GetMapping("/userInfo")
	public String userInfo(Model model) {
		List<User> userList = userService.findAllUser();
		System.out.println("....................Hello  ......");
		System.out.println(userList.size());
		model.addAttribute("userList", userList);
		return "userInfo";
	}

	@GetMapping("/userInfo/edit/{userName}")
	public String getUserInfoEdit(Model model, @PathVariable("userName") String userName) {
		User user = userService.findByUserName(userName);

		System.out.println(user.getUserName());

		model.addAttribute("user", user);
		return "updateUser";

	}

	@PostMapping("/updateUser")
	public String updateUser(@PathParam("userName")String userName, @PathParam("password")String password, @PathParam("roleId")int roleId, @PathParam("studentId")String studentId, @PathParam("facultyId")Long facultyId, Model model) {
		try {
			System.out.println("user is Editing:   ....");
			
			userService.updateUser(userName, password, roleId, studentId, facultyId);

		} catch (Exception e) {
			model.addAttribute("msg", "This user couldn't be updated.");
			return "error";

		}

		return "redirect:/userInfo";
	}
	/*
	@GetMapping(value = "/search")
	public String searchByName(Model model, @RequestParam("userName") String userName) {
		System.out.println("searcing: " + userName);
		User user = userService.findByUserName(userName);
		if (user == null) {
			model.addAttribute("msg", "This user couldn't be searched.");
			return "error";
		}
		System.out.println("-------------Searching user------------");
		System.out.println(user.getUserName());
		model.addAttribute("user", user);

		return "searchView";

	}
*/
	@GetMapping("/userInfo/delete/{userName}")
	public String Delete(@PathVariable("userName") String userName, Model model) {
		try {
			userService.deleteUserByName(userName);
		} catch (Exception e) {
			model.addAttribute("msg", "This user couldn't be deleted.");
			return "error";
		}
		return "redirect:/userInfo";
	}

}
	