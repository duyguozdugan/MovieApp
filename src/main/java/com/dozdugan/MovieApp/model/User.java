package com.dozdugan.MovieApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String username;
    private String mail;
    private String password;
    //bir user'ın birden fazla izleme listesi olabilir. bir izleme listesinin bir user'ı olabilir.
    // yani user department gibi düşünülebilir, watchlist'te employee.

    @OneToMany(mappedBy = "user")
    private List<WatchList> watchLists;

}
