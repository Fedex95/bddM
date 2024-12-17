package com.tienda.ordersbck.Controller;

import com.tienda.ordersbck.Entity.OrderDetail;
import com.tienda.ordersbck.Service.OrderdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderdetails")
public class OrderdetailController {
    @Autowired
    private OrderdetailService orderdetailService;

    @GetMapping("/get/all")
    public ResponseEntity<List<OrderDetail>> getAllOrderdetails() {
        List<OrderDetail> orderdetails = orderdetailService.getAllOrderdetail();
        return new ResponseEntity<>(orderdetails, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OrderDetail> getOrderdetailById(@PathVariable String id) {
        Optional<OrderDetail> orderDetails = orderdetailService.getOrderdetailById(id);
        return orderDetails.map(value-> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createOrder")
    public ResponseEntity<OrderDetail> createOrder(@RequestBody OrderDetail orderDetail) {
        OrderDetail newOrder = orderdetailService.saveOrderdetail(orderDetail);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @PutMapping("/editOrder{id}")
    public ResponseEntity<OrderDetail> editOrder(@PathVariable String id, @RequestBody OrderDetail orderDetail) {
        try{
            OrderDetail editOrder = orderdetailService.updateOrderdetail(id, orderDetail);
            return new ResponseEntity<>(editOrder, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteOrder/{id}")
    public ResponseEntity<OrderDetail> deleteOrder(@PathVariable String id) {
        try{
            orderdetailService.deleteOrderdetail(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
