package com.carebuddy.assignment.trading.repository;

import com.carebuddy.assignment.trading.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster,Long> {

    OrderMaster findByTradeDetailId(Long id);
}
