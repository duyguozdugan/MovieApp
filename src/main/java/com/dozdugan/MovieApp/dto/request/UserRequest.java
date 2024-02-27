package com.dozdugan.MovieApp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String name;
    private String username;
    private String mail;
    private String password;
}
