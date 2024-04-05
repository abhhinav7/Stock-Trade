package com.carebuddy.assignment.trading.facade;

import com.carebuddy.assignment.trading.entity.OrderMaster;
import com.carebuddy.assignment.trading.entity.TradeDetail;
import com.carebuddy.assignment.trading.service.OrderMasterService;
import com.carebuddy.assignment.trading.service.TradeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Component
public class MarketOrderFacadeImpl implements MarketOrderFacade{

    @Autowired
    TradeDetailService tradeDetailService;

    @Autowired
    OrderMasterService orderMasterService;

    @Override
    public void saveSell(OrderMaster orderMaster) {
        OrderMaster tempOrderMaster = orderMasterService.findById(orderMaster.getId());
        TradeDetail tradeDetail = tradeDetailService.findById(tempOrderMaster.getTradeDetailId());
        int updateQuantity = tempOrderMaster.getQuantity() - orderMaster.getQuantity();
        if(updateQuantity<=0){
            if(updateQuantity==0){
                orderMasterService.deleteById(tempOrderMaster.getId());
                tradeDetail.setQuantity(tradeDetail.getQuantity()+orderMaster.getQuantity());
                tradeDetailService.save(tradeDetail);
            }
            else {
            throw new RuntimeException("you don't have this much stock");
            }
        }
        if(updateQuantity>0) {
            tempOrderMaster.setQuantity(updateQuantity);
            tradeDetail.setQuantity(tradeDetail.getQuantity()+orderMaster.getQuantity());
            tradeDetailService.save(tradeDetail);
            orderMasterService.save(tempOrderMaster);
        }
    }

    @Override
    public void saveBuy(TradeDetail tradeDetail) {
        TradeDetail tempTradeDetail = tradeDetailService.findById(tradeDetail.getId());

        int updateQuantity = tempTradeDetail.getQuantity() - tradeDetail.getQuantity();

        if (updateQuantity < 0) {
            throw new RuntimeException("Quantity that you entered is not available. Please enter a lower quantity.");
        }

        OrderMaster orderMaster = orderMasterService.findByTradeDetailId(tradeDetail.getId());

        if (orderMaster == null) {
            orderMaster = new OrderMaster();
            orderMaster.setTradeDetailId(tempTradeDetail.getId());
            orderMaster.setPricePerUnit(tempTradeDetail.getPricePerUnit());
            orderMaster.setStockName(tempTradeDetail.getStockName());
            orderMaster.setStatus("Created");
            orderMaster.setTradeDateTime(LocalDateTime.now());
        }

        orderMaster.setQuantity(orderMaster.getQuantity() + tradeDetail.getQuantity());

        orderMasterService.save(orderMaster);

        tempTradeDetail.setQuantity(updateQuantity);
        tradeDetailService.save(tempTradeDetail);
    }




    @Override
    public List<OrderMaster> findAll() {
        return orderMasterService.findAll();
    }

    @Override
    public OrderMaster findById(Long id) {
        return orderMasterService.findById(id);
    }
}
