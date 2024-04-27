package com.programming.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programming.dto.UserDTO;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static List<UserDTO> userList = new ArrayList<>();
	private static Long id=1L;
	static {
		userList.add(new UserDTO(id++, "Mubashar", "Shah", 676545454L, 45, "Okara"));
		userList.add(new UserDTO(id++, "Mudasar", "Shah", 676545454L, 45, "Okara"));
		userList.add(new UserDTO(id++, "Kausar", "Shah", 676545454L, 45, "Okara"));
		userList.add(new UserDTO(id++, "Meerab", "Shah", 676545454L, 45, "Okara"));
		userList.add(new UserDTO(id++, "Fazeelatr", "Shah", 676545454L, 45, "Okara"));
	}
	@GetMapping("/findAll")
	public List<UserDTO> showUser() {
		return userList;
	}
	//finding a specific user from the list based on id
	@GetMapping("/findById/{id}")
	public UserDTO findUserById(@PathVariable Long id) {
		return userList.stream().
				filter(user->user.getUserId().equals(id)).
				findFirst().get();
	}
	//creating a new user
	@PostMapping("/createUser")
	public List<UserDTO> saveUser(@RequestBody UserDTO userDto){
		userDto.setUserId(id++);
		userList.add(userDto);
		return userList;
	}
	
	
}
