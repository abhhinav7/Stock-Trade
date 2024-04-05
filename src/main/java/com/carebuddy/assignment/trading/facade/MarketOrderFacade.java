package com.carebuddy.assignment.trading.facade;


import com.carebuddy.assignment.trading.entity.OrderMaster;
import com.carebuddy.assignment.trading.entity.TradeDetail;

import java.util.List;

public interface MarketOrderFacade {
    void saveSell(OrderMaster orderMaster);

    void saveBuy(TradeDetail tradeDetail);

    List<OrderMaster> findAll();

    OrderMaster findById(Long id);
}
