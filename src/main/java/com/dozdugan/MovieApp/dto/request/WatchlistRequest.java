package com.dozdugan.MovieApp.dto.request;

import com.dozdugan.MovieApp.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WatchlistRequest {
    @JsonIgnore
    private User user;
    private String title;
}
