package com.carebuddy.assignment.trading.service;

import com.carebuddy.assignment.trading.entity.OrderMaster;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderMasterService {
    List<OrderMaster> findAll();

    void save(OrderMaster orderMaster);

    OrderMaster findByTradeDetailId(Long id);

    OrderMaster findById(Long id);

    void deleteById(Long id);
}
