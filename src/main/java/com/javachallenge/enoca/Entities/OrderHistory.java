package com.javachallenge.enoca.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orderHistory")
public class OrderHistory extends BaseEntity{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "orderItem")
    private List<CartItem> cartItems;
    @Column(name = "totalPrice")
    private float totalPrice;

    public OrderHistory() {
    }

    public OrderHistory(Customer customer, float totalPrice, List<CartItem> cartItems) {
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.cartItems = cartItems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
