package com.carebuddy.assignment.trading.service;

import com.carebuddy.assignment.trading.entity.TradeDetail;

import java.util.List;

public interface TradeDetailService {
    public List<TradeDetail> findAll();

    void save(TradeDetail tradeDetail);

    TradeDetail findById(Long id);

    void deleteById(Long id);
}
