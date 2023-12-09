package com.belrose.stockservice.repository;


import com.belrose.stockservice.model.OrderEventModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEventRepository extends JpaRepository<OrderEventModel,Long> {
}
