package com.tienda.ordersbck.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "OrderDetails")
public class OrderDetail {
    @Id
    @Column(name = "OrderDetailsID", nullable = false, length = 50)
    private String orderDetailsID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`Order ID`")
    @JsonProperty("order")
    private ListofOrder orderID;

    @Column(name = "Amount")
    private Double amount;

    @Column(name = "Profit")
    private Double profit;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Category", length = 50)
    private String category;

    @Column(name = "`Sub-Category`", length = 50)
    private String subCategory;

    public String getOrderDetailsID() {
        return orderDetailsID;
    }

    public void setOrderDetailsID(String orderDetailsID) {
        this.orderDetailsID = orderDetailsID;
    }

    public ListofOrder getOrderID() {
        return orderID;
    }

    public void setOrderID(ListofOrder orderID) {
        this.orderID = orderID;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

}