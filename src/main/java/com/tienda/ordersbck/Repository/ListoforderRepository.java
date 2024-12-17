package com.tienda.ordersbck.Repository;

import com.tienda.ordersbck.Entity.ListofOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListoforderRepository extends JpaRepository<ListofOrder, String> {
}
