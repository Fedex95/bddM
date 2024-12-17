package com.tienda.ordersbck.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ListofOrders")
public class ListofOrder {
    @Id
    @Column(name = "`Order ID`", nullable = false, length = 50)
    private String orderID;

    @Column(name = "`Order Date`", length = 50)
    private String orderDate;

    @Column(name = "CustomerName", length = 50)
    private String customerName;

    @Column(name = "State", length = 50)
    private String state;

    @Column(name = "City", length = 50)
    private String city;

    @JsonIgnore
    @OneToMany(mappedBy = "orderID")
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

}