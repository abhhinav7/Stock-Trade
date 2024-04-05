package com.carebuddy.assignment.trading.controller;

import com.carebuddy.assignment.trading.entity.TradeDetail;
import com.carebuddy.assignment.trading.service.TradeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trade")
public class TradeDetailsController {

    @Autowired
    TradeDetailService tradeDetailService;

    @GetMapping("")
    public String tradeList(Model model){
        List<TradeDetail> tradeDetailList = tradeDetailService.findAll();
        model.addAttribute("tradeDetailList",tradeDetailList);
        return "enter-details";
    }

    @GetMapping("/showFormToAddDetails")
    public String showFormToAddDetails(Model model){
        model.addAttribute("tradeDetail",new TradeDetail());
        return "show-form-add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("tradeDetail") TradeDetail tradeDetail){
        tradeDetailService.save(tradeDetail);
        return "redirect:/trade";
    }

    @GetMapping("/update")
    public String update(@RequestParam("tradeId") Long id, Model theModel){
        TradeDetail tradeDetail = tradeDetailService.findById(id);
        theModel.addAttribute("tradeDetail",tradeDetail);
        return "show-form-add";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("tradeId") Long id){
        tradeDetailService.deleteById(id);
        return "redirect:/trade";
    }

}
