package com.basmaonlinestore.ordersserver.models;
import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_order", nullable = false)
    private Long idOrder;

   // @ManyToOne
    //@JoinColumn(name="id_user", nullable=false)
    //private User idUser;

    @Column(name = "price", nullable = false, unique = false)
    private double price;

    @Column(name = "traking_code", length=50, nullable = false, unique = true)
    private String trakingCode;

    @Column(name = "delivery_address_id", nullable = false, unique = true)
    private Long deliveryAddressId;

    @Column(name = "discount", nullable = false, unique = true)
    private double discount;

    @Column(name = "delivery_fees", nullable = false, unique = true)
    private double deliveryFees;
}
