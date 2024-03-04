package com.dozdugan.MovieApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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

    @OneToMany(mappedBy = "user",
               cascade = {CascadeType.ALL})
    private List<WatchList> watchLists;

    public User() {
    }

    public User(String name, String username, String mail, String password) {
        this.name = name;
        this.username = username;
        this.mail = mail;
        this.password = password;
    }

    public void add(WatchList  tempwatchList){
         if(watchLists==null){
             watchLists=new ArrayList<>();
         }

         watchLists.add(tempwatchList);
         tempwatchList.setUser(this);
    }
}
