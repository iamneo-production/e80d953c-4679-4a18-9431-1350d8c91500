package com.examly.springapp.model.entitymodels;

import javax.persistence.*;

@Entity
public class AppAdmin {
    @Id
    @SequenceGenerator(
            name = "appadmin_sequence",
            sequenceName = "appadmin_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "appadmin_sequence"
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
    private UserRole userRole= UserRole.ADMIN;
    @Column(
            nullable = false
    )
    private String sellerName;
    @Column(
            nullable = false
    )
    private String companyName;
    @Column(
            nullable = false
    )
    private String companyImageUrl;
    @Column(
            nullable = false
    )
    private String companyAddress;

    public AppAdmin() {
    }

    public AppAdmin(Long id, String email, String password, String mobileNumber, UserRole userRole, String sellerName, String companyName, String companyImageUrl, String companyAddress) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.userRole = userRole;
        this.sellerName = sellerName;
        this.companyName = companyName;
        this.companyImageUrl = companyImageUrl;
        this.companyAddress = companyAddress;
    }

    public AppAdmin(String email, String password, String mobileNumber, String sellerName, String companyName, String companyImageUrl, String companyAddress) {
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.sellerName = sellerName;
        this.companyName = companyName;
        this.companyImageUrl = companyImageUrl;
        this.companyAddress = companyAddress;
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

    public void setMobileNumber(String mobileNUmber) {
        this.mobileNumber = mobileNUmber;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyImageUrl() {
        return companyImageUrl;
    }

    public void setCompanyImageUrl(String companyImageUrl) {
        this.companyImageUrl = companyImageUrl;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
}
