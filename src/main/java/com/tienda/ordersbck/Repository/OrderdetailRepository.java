package com.tienda.ordersbck.Repository;

import com.tienda.ordersbck.Entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderdetailRepository extends JpaRepository<OrderDetail, String> {
}
