package com.examly.springapp.model.entitymodels;

import org.apache.catalina.User;

import javax.persistence.*;

@Entity
public class AppUser {
    @Id
    @SequenceGenerator(
            name = "appuser_sequence",
            sequenceName = "appuser_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "appuser_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;
    @Column(
            nullable = false,
            unique = true
    )
    private String email;
    @Column(
            nullable = false
    )
    private String password;
    @Column(
            nullable = false,
            unique = true
    )
    private String mobileNumber;
    @Column(
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private UserRole userRole = UserRole.USER;

    @Column(
            nullable = false,
            unique = true
    )
    private String userName;
    @Column(
            nullable = false
    )
    private Integer userAge;

    public AppUser(Long id, String email, String password, String mobileNumber, UserRole userRole, String userName, Integer userAge) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.userRole = userRole;
        this.userName = userName;
        this.userAge = userAge;
    }

    public AppUser(String email, String password, String mobileNumber, String userName, Integer userAge) {
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.userName = userName;
        this.userAge = userAge;
    }

    public AppUser(String email, String password, String mobileNumber, UserRole userRole, String userName, Integer userAge) {
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.userRole = userRole;
        this.userName = userName;
        this.userAge = userAge;
    }

    public AppUser() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}

