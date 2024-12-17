package com.tienda.ordersbck.Service;

import com.tienda.ordersbck.Entity.OrderDetail;
import com.tienda.ordersbck.Repository.OrderdetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderdetailService {
    @Autowired
    private OrderdetailRepository orderdetailRepository;

    public List<OrderDetail> getAllOrderdetail() {
        return orderdetailRepository.findAll();
    }

    public Optional<OrderDetail> getOrderdetailById(String id){
        return orderdetailRepository.findById(id);
    }

    public OrderDetail saveOrderdetail(OrderDetail orderdetail) {
        try {
            return orderdetailRepository.save(orderdetail);
        }catch (Exception e){
            throw new RuntimeException("ERROR");
        }
    }

    public void deleteOrderdetail(String id) {
        Optional<OrderDetail> orderdetail = orderdetailRepository.findById(id);
        if(orderdetail.isPresent()){
            orderdetailRepository.deleteById(id);
        }else{
            throw new RuntimeException("ERROR");
        }
    }

    public OrderDetail updateOrderdetail(String id ,OrderDetail orderdetail) {
        Optional<OrderDetail> exist = orderdetailRepository.findById(id);
        if(exist.isPresent()){
            OrderDetail updatedOrderdetail = exist.get();

            updatedOrderdetail.setAmount(orderdetail.getAmount());
            updatedOrderdetail.setCategory(orderdetail.getCategory());
            updatedOrderdetail.setProfit(orderdetail.getProfit());
            updatedOrderdetail.setQuantity(orderdetail.getQuantity());
            updatedOrderdetail.setSubCategory(orderdetail.getSubCategory());

            return orderdetailRepository.save(updatedOrderdetail);
        }else{
            throw new RuntimeException("ERROR");
        }
    }
}
