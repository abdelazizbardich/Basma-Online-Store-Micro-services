package com.basmaonlinestore.productsserver.models;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "products")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product", nullable = false)
    private Long idProduct;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private float price;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    public Product(){
    }

    public Product(String title, float price, String description, String image, Category category, Timestamp createdAt){
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
        this.createdAt = createdAt;
    }


    public Product(Long idProduct, String title, float price, String description, String image, Category category, Timestamp createdAt){
        this.idProduct = idProduct;
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
        this.createdAt = createdAt;
    }

    public Long getIdProduct() { return idProduct; }

    public void setIdProduct(Long idProduct) { this.idProduct = idProduct; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title;}

    public float getPrice() { return price; }

    public void setPrice(float price) { this.price = price; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }

    public Timestamp getCreatedAt() { return createdAt; }

    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", category=" + category +
                ", createdAt=" + createdAt +
                '}';
    }
}


