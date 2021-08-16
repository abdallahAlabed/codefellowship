package com.example.codefellowship.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Column(name = "username", length = 3000, nullable = false, unique = true)
    private String username;


    private boolean disabled;
    protected Date createTime;
    protected Date lastModifiedTime;
    @Column(name = "password", length = 3000, nullable = false)
    private String password;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String bio;
    @Enumerated(EnumType.STRING)
    @Column(name = "userRole", length = 3000, nullable = true)
    private UserRole userRole;

    @OneToMany(mappedBy="users", cascade = CascadeType.ALL)
    private List <Post> post;

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    public Users() {

    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
        this.createTime = new Date();
        this.lastModifiedTime = new Date();
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time", nullable = false)
    @CreatedDate
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified_time", nullable = false)
    @LastModifiedDate
    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    @PrePersist
    protected void prePersist() {
        if (this.createTime == null) createTime = new Date();
        if (this.lastModifiedTime == null) lastModifiedTime = new Date();
    }

    @PreUpdate
    protected void preUpdate() {
        this.lastModifiedTime = new Date();
    }

    @PreRemove
    protected void preRemove() {
        this.lastModifiedTime = new Date();
    }



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
