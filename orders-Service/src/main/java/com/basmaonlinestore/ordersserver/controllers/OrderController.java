package com.basmaonlinestore.ordersserver.controllers;
import com.basmaonlinestore.ordersserver.models.Orders;
import com.basmaonlinestore.ordersserver.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public  OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @GetMapping("")
    public ResponseEntity<List<Orders>> getAllOrders(){
        return ResponseEntity.status(200).body(orderService.getAllOrders());
    }

    @GetMapping("/{idOrder}")
    public ResponseEntity<Orders> getOneOrder(@PathVariable(name = "idOrder") Long id){
        return ResponseEntity.status(200).body(orderService.getOneOrder(id));
    }

    @PostMapping("")
    public  ResponseEntity<Orders> addOrder(@RequestBody Orders orders){
        return ResponseEntity.status(200).body(orderService.AddOrder(orders));
    }

    @PutMapping("")
    public  ResponseEntity<Orders> updateOrder(@RequestBody Orders orders){
        return ResponseEntity.status(200).body(orderService.updateOrder(orders));
    }

    @DeleteMapping("")
    public ResponseEntity deleteOrder(@RequestBody Long id){
        return ResponseEntity.status(200).body(orderService.deleteOrder(id));
    }
}
