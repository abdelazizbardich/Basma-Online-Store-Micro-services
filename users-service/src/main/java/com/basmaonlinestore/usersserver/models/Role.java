package com.basmaonlinestore.usersserver.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_role", nullable = false)
    private Long idRole;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "authorities", nullable = false)
    private String authorities;

    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    public Role() {
    }

    public Role(String name, String authorities, Timestamp createdAt) {
        this.name = name;
        this.authorities = authorities;
        this.createdAt = createdAt;
    }

    public Role(Long idRole, String name, String authorities, Timestamp createdAt) {
        this.idRole = idRole;
        this.name = name;
        this.authorities = authorities;
        this.createdAt = createdAt;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", name='" + name + '\'' +
                ", authorities='" + authorities + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
