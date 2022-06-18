package com.basmaonlinestore.productsserver.models;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category", nullable = false)
    private Long idCategory;
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    public Category(){
    }

    public Category(String name, String image, Timestamp createdAt) {
        this.name = name;
        this.image = image;
        this.createdAt = createdAt;
    }

    public Category(Long idCategory, String name, String image, Timestamp createdAt) {
        this.idCategory = idCategory;
        this.name = name;
        this.image = image;
        this.createdAt = createdAt;
    }

    public Long getIdCategory() { return idCategory; }

    public void setIdCategory(Long idCategory) { this.idCategory = idCategory; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public Timestamp getCreatedAt() { return createdAt; }

    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }


    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }



}