package com.example.codefellowship.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Date;


@Entity
@Table(name = "users")
public class User extends EntityModel implements UserDetails {
    @Column(name = "username", length = 3000, nullable = false, unique = true)
    private String username;
    @Column(name = "password", length = 3000, nullable = false)
    private String password;
    @Column(name = "firstName", length = 3000, nullable = false)
    private String firstName;
    @Column(name = "lastName", length = 3000, nullable = false)
    private String lastName;
    @Column(name = "dateOfBirth", length = 3000, nullable = false)
    private Date dateOfBirth;
    @Column(name = "bio", length = 3000, nullable = true)
    private String bio;
    @Column(name = "userRole", length = 3000, nullable = false)
    private UserRole userRole;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public User(String username, String password, String firstName, String lastName, Date dateOfBirth, String bio, UserRole userRole) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
        this.userRole=userRole;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    ///////////////////////////////////////////////////////////////////

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



}
