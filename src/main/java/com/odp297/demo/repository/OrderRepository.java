package com.odp297.demo.repository;

import com.odp297.demo.model.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderList, Long> {
    // You can define custom queries here if needed
}
