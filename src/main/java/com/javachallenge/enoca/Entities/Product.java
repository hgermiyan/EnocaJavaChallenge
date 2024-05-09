package com.javachallenge.enoca.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product extends BaseEntity{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "stock")
    private int stock;

    @Column(name = "price")
    private float price;

    @Column(name = "model")
    private String name;

    public Product(int stock, float price, String name) {
        this.stock = stock;
        this.price = price;
        this.name = name;
    }

    public Product() {}
    public long getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}