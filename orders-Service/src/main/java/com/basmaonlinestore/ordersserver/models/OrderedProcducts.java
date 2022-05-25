package com.basmaonlinestore.ordersserver.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ordered_procducts")
public class OrderedProcducts {

     @ManyToOne
    @JoinColumn(name="id_order", nullable=false)
    private Orders idOrder;


    @Column(name = "id_product", nullable = false, unique = true)
    private Long idProduct;

    @Column(name = "quantity", nullable = false, unique = true)
    private Integer quantity;

    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;
}
