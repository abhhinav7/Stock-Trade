package com.carebuddy.assignment.trading.service.impl;

import com.carebuddy.assignment.trading.entity.TradeDetail;
import com.carebuddy.assignment.trading.repository.TradeDetailRepository;
import com.carebuddy.assignment.trading.service.TradeDetailService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeDetailServiceImpl implements TradeDetailService {

    @Autowired
    TradeDetailRepository tradeDetailRepository;

    @Override
    public List<TradeDetail> findAll() {
        return tradeDetailRepository.findAll();
    }

    @Override
    @Transactional
    public void save(TradeDetail tradeDetail) {
        tradeDetailRepository.save(tradeDetail);
    }

    @Override
    public TradeDetail findById(Long id) {
        Optional<TradeDetail> result = tradeDetailRepository.findById(id);

        TradeDetail tradeDetail = null;

        if (result.isPresent()) {
            tradeDetail = result.get();
        }
        else {
            // we didn't find the trade
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return tradeDetail;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        tradeDetailRepository.deleteById(id);
    }
}
