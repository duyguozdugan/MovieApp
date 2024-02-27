package com.dozdugan.MovieApp.service;

import com.dozdugan.MovieApp.converter.UserConverter;
import com.dozdugan.MovieApp.dto.request.UserRequest;
import com.dozdugan.MovieApp.dto.response.UserResponse;
import com.dozdugan.MovieApp.exception.UserNotFoundException;
import com.dozdugan.MovieApp.exception.UsernameAlreadyExistsException;
import com.dozdugan.MovieApp.model.User;
import com.dozdugan.MovieApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserResponse createUser(UserRequest userRequest) {
        Optional<User> userByName= userRepository.findByUsername(userRequest.getUsername());
        if(userByName.isPresent()){
            throw new UsernameAlreadyExistsException("This username is already exists: "+userRequest.getUsername());
        }
       return UserConverter.convertToUserResponse(userRepository.save(UserConverter.convertToUser(userRequest)));
    }

    public List<UserResponse> getUsers() {
        return UserConverter.convertListUserResponse(userRepository.findAll()) ;
    }

    public UserResponse getUserById(Long id) {
        Optional<User> userOptional=userRepository.findById(id);
        if(userOptional.isPresent()){
            return UserConverter.convertToUserResponse(userOptional.get());
        }
        else{
            throw new UserNotFoundException("User not found with id: "+id);
        }


    }

    public String updateUser(Long id, UserRequest userRequest) {
        Optional<User> userId= userRepository.findById(id);
        if(userId.isPresent()){
            User oldUser = userId.get();
            oldUser.setName(userRequest.getName());
            oldUser.setMail(userRequest.getMail());
            oldUser.setUsername(userRequest.getUsername());
            oldUser.setPassword(userRequest.getPassword());
            userRepository.save(oldUser);
            return "Update successful.";
        }
        return "Update failed.";
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
