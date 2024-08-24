package com.nikhil.blogapp.services.impl;

import com.nikhil.blogapp.entities.User;
import com.nikhil.blogapp.exceptions.ResourceNotFoundException;
import com.nikhil.blogapp.payloads.UserDto;
import com.nikhil.blogapp.repositories.UserRepo;
import com.nikhil.blogapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userDtoToUser(userDto);
        User savedUser = userRepo.save(user);
        return userToUserDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = userRepo.findById(userId).orElseThrow((()-> new ResourceNotFoundException("User", "Id", userId)));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User savedUser = userRepo.save(user);
        return userToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = userRepo.findById((userId)).orElseThrow((()-> new ResourceNotFoundException("User", "Id", userId)));
        return userToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream().map(this::userToUserDto).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow((()-> new ResourceNotFoundException("User", "Id", userId)));
        userRepo.delete(user);
    }

    private User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return user;
    }

    private UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;
    }
}
