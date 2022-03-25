package com.examly.springapp.model.entitymodels;

import javax.persistence.*;

@Entity
public class Booking {
    @Id
    @SequenceGenerator(
            name = "booking_sequence",
            sequenceName = "booking_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "booking_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;
    @Column(
            nullable = false
    )
    private Long userid;
    @Column(
            nullable = false
    )
    private Long adminid;
    @Column(
            nullable = false
    )
    private String carModel;
    @Column(
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private BuyCategory buyCategory = BuyCategory.RENT;
    @Column(
            nullable = false
    )
    private Integer days;
    @Column(
            nullable = false
    )
    private Long total_price;

    public Booking() {
    }
    public Booking(Long id, Long userid, Long adminid, String carModel, BuyCategory buyCategory, Integer days, Long total_price) {
        this.id = id;
        this.userid = userid;
        this.adminid = adminid;
        this.carModel = carModel;
        this.buyCategory = buyCategory;
        this.days = days;
        this.total_price = total_price;
    }
    public Booking(Long userid, Long adminid, String carModel, BuyCategory buyCategory, Integer days, Long total_price) {
        this.userid = userid;
        this.adminid = adminid;
        this.carModel = carModel;
        this.buyCategory = buyCategory;
        this.days = days;
        this.total_price = total_price;
    }
    public Booking(Long userid, Long adminid, String carModel, Integer days, Long total_price) {
        this.userid = userid;
        this.adminid = adminid;
        this.carModel = carModel;
        this.days = days;
        this.total_price = total_price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long user_id) {
        this.userid = user_id;
    }

    public Long getAdminid() {
        return adminid;
    }

    public void setAdminid(Long admin_id) {
        this.adminid = admin_id;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public BuyCategory getBuyCategory() {
        return buyCategory;
    }

    public void setBuyCategory(BuyCategory buyCategory) {
        this.buyCategory = buyCategory;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Long total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", userid=" + userid +
                ", adminid=" + adminid +
                ", carModel='" + carModel + '\'' +
                ", buyCategory=" + buyCategory +
                ", days=" + days +
                ", total_price=" + total_price +
                '}';
    }
}
