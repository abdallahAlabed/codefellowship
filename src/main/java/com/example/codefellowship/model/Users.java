package com.example.codefellowship.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.List;
import java.util.Set;
@Entity
public class Users extends EntityModel {

    @Column(name = "username", length = 3000, nullable = false, unique = true)
    private String username;
    @Column(name = "password", length = 3000, nullable = false)
    private String password;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String bio;
    @Enumerated(EnumType.STRING)
    @Column(name = "userRole", length = 3000, nullable = true)
    private UserRole userRole;
    @OneToMany(mappedBy="users", cascade = CascadeType.ALL)
    private List <Posts> post;

    @ManyToMany
    @JoinTable(
            name="user_follow",
            joinColumns={@JoinColumn(name="theUser")},
            inverseJoinColumns = {@JoinColumn(name="followingUser")}
    )
    Set<Users> following;

    @ManyToMany(mappedBy="following")
    Set<Users> followers;

    public Users() {

    }


    public Users(String username, String password,UserRole userRole  , String dateOfBirth, String bio, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
        this.userRole = userRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Set<Users> getFollowing() {
        return following;
    }

    public void setFollowing(Set<Users> following) {
        this.following = following;
    }

    public Set<Users> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<Users> followers) {
        this.followers = followers;
    }

    public void addFollowing(Users followingUser) {
        following.add(followingUser);
    }
}
