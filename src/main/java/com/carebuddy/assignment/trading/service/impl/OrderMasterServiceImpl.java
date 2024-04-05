package com.carebuddy.assignment.trading.service.impl;

import com.carebuddy.assignment.trading.entity.OrderMaster;
import com.carebuddy.assignment.trading.repository.OrderMasterRepository;
import com.carebuddy.assignment.trading.service.OrderMasterService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderMasterServiceImpl implements OrderMasterService {

    @Autowired
    OrderMasterRepository orderMasterRepository;
    @Override
    public List<OrderMaster> findAll() {
        return orderMasterRepository.findAll();
    }

    @Override
    public void save(OrderMaster orderMaster) {
        orderMasterRepository.save(orderMaster);
    }

    @Override
    public OrderMaster findByTradeDetailId(Long id) {
        return orderMasterRepository.findByTradeDetailId(id);
    }

    @Override
    public OrderMaster findById(Long id) {
        Optional<OrderMaster> result = orderMasterRepository.findById(id);

        OrderMaster orderMaster = null;

        if (result.isPresent()) {
            orderMaster = result.get();
        }
        else {
            // we didn't find the trade
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return orderMaster;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if(id!=null) {
            orderMasterRepository.deleteById(id);
        }
    }
}
