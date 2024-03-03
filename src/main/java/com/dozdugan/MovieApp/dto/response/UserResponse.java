package com.dozdugan.MovieApp.dto.response;

import com.dozdugan.MovieApp.model.WatchList;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponse {

    private String name;
    private String username;
    private String mail;

    private List<WatchList> watchLists;
}
