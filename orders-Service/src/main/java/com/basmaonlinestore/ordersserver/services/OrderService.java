package com.basmaonlinestore.ordersserver.services;

import com.basmaonlinestore.ordersserver.models.Orders;
import com.basmaonlinestore.ordersserver.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrdersRepository ordersRepository;

    @Autowired
    public OrderService(OrdersRepository ordersRepository){
        this.ordersRepository=ordersRepository;
    }

    public List<Orders> getAllOrders(){
        try {
        return ordersRepository.findAll();
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Orders getOneOrder(Long id){
        try {
            return ordersRepository.findById(id).get();
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Orders AddOrder( Orders orders){
            try {
                return ordersRepository.save(orders);
            }catch (Exception e){
                System.err.println(e);
                return null;
            }
    }

    public Orders updateOrder(Orders orders){
        try {
            return ordersRepository.save(orders);
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

    public Boolean deleteOrder(Long id){
        try {
            ordersRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.err.println(e);
            return null;
        }
    }

}
