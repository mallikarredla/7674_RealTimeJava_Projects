package com.javaexpress.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.dto.UserDto;
import com.javaexpress.helper.UserMappingHelper;
import com.javaexpress.model.User;
import com.javaexpress.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto save(UserDto userDto) {

		User user = UserMappingHelper.map(userDto);
		User dbUser = userRepository.save(user);
		UserDto result = UserMappingHelper.map(dbUser);

		return result;
	}

	@Override
	public UserDto findById(Integer UserId) {

		return userRepository.findById(UserId).map(UserMappingHelper::map)
				.orElseThrow(() -> new RuntimeException("User not found in Database"));
	}

	@Override
	public List<UserDto> findAll() {
		return userRepository.findAll().stream().sorted(Comparator.comparing(User::getUserId))
				.map(UserMappingHelper::map).collect(Collectors.toList());
	}

	@Override
	public UserDto update(Integer userId, UserDto userDto) {
		return null;
	}

	@Override
	public void deleteById(Integer userId) {
		
		userRepository.deleteById(userId);
		

	}

	@Override
	public UserDto findByUserUserName(String userName) {
		return null;
	}

}
