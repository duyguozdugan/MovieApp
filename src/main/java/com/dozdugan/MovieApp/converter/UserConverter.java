package com.dozdugan.MovieApp.converter;

import com.dozdugan.MovieApp.dto.request.UserRequest;
import com.dozdugan.MovieApp.dto.response.UserResponse;
import com.dozdugan.MovieApp.model.User;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class UserConverter{

    public static User convertToUser(UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.getName());
        user.setMail(userRequest.getMail());
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        return user;
    }

    public static UserResponse convertToUserResponse(User user){
        UserResponse userResponse= new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setUsername(user.getUsername());
        userResponse.setMail(user.getMail());
        userResponse.setWatchLists(user.getWatchLists());
        return userResponse;
    }

    public static List<UserResponse> convertListUserResponse(List<User> users) {

        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            UserResponse userResponse = new UserResponse();
            userResponse.setName(user.getName());
            userResponse.setUsername(user.getUsername());
            userResponse.setMail(user.getMail());
            userResponse.setWatchLists(user.getWatchLists());
            userResponses.add(userResponse);
        }

        return userResponses;
    }
}
