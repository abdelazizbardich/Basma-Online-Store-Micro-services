package com.basmaonlinestore.ordersserver.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.basmaonlinestore.ordersserver.models.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {

}
