package com.examly.springapp.model.entitymodels;


import javax.persistence.*;

@Entity
public class AppCar {
    @Id
    @SequenceGenerator(
            name = "appcar_sequence",
            sequenceName = "appcar_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "appcar_sequence"
    )
    @Column(
            updatable = false
    )
    private Long carId;
    @Column(
            nullable = false
    )
    private String carModel;
    @Column(
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private CarStatus status = CarStatus.AVAILABLE;
    @Column(
            nullable = false
    )
    private String price;
    @Column(
            nullable = false
    )
    private String type;
    @Column(
            nullable = false
    )
    private Long adminId;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public AppCar() {
    }

    public AppCar(Long carId, String carModel, CarStatus status, String price, String type, Long adminId) {
        this.carId = carId;
        this.carModel = carModel;
        this.status = status;
        this.price = price;
        this.type = type;
        this.adminId = adminId;
    }

    public AppCar(String carModel, CarStatus status, String price, String type, Long adminId) {
        this.carModel = carModel;
        this.status = status;
        this.price = price;
        this.type = type;
        this.adminId = adminId;
    }

    public AppCar(String carModel, String price, String type, Long adminId) {
        this.carModel = carModel;
        this.price = price;
        this.type = type;
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "AppCar{" +
                "carId=" + carId +
                ", carModel='" + carModel + '\'' +
                ", status=" + status +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                ", adminId=" + adminId +
                '}';
    }
}