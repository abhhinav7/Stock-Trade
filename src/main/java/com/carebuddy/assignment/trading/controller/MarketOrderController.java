package com.carebuddy.assignment.trading.controller;

import com.carebuddy.assignment.trading.entity.OrderMaster;
import com.carebuddy.assignment.trading.entity.TradeDetail;
import com.carebuddy.assignment.trading.facade.MarketOrderFacade;
import com.carebuddy.assignment.trading.service.TradeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/market")
public class MarketOrderController {

    @Autowired
    TradeDetailService tradeDetailService;

    @Autowired
    MarketOrderFacade marketOrderFacade;

    @GetMapping("/portfolio")
    public String getYourPortfolio(Model model){
        List<OrderMaster> orderMasterList = marketOrderFacade.findAll();
        model.addAttribute("orderMasterList", orderMasterList);
        return "show-portfolio";
    }

    @GetMapping("")
    public String showStockListing(Model model){
        List<TradeDetail> tradeDetailList = tradeDetailService.findAll();
        model.addAttribute("tradeDetailList",tradeDetailList);
        return "show-market-list";
    }

    @GetMapping("/buy")
    public String showBuyForm(@RequestParam("tradeId") Long id,Model model){
        TradeDetail tradeDetail = tradeDetailService.findById(id);
        model.addAttribute("tradeDetail",tradeDetail);
        return "show-form-buy";
    }

    @PostMapping("/saveBuy")
    public String saveBuy(@ModelAttribute("tradeDetail") TradeDetail tradeDetail){
        marketOrderFacade.saveBuy(tradeDetail);
        return "redirect:/market/portfolio";
    }

    @GetMapping("/sell")
    public String showFormSell(@RequestParam("orderId") Long id,Model model){
        OrderMaster orderMaster = marketOrderFacade.findById(id);
        model.addAttribute("orderMaster",orderMaster);
        return "show-form-sell";
    }

    @PostMapping("/saveSell")
    public String saveSell(@ModelAttribute("orderMaster") OrderMaster orderMaster){
        marketOrderFacade.saveSell(orderMaster);
        return "redirect:/market/portfolio";
    }


}
