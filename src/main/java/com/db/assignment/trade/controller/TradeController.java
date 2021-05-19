package com.db.assignment.trade.controller;

import com.db.assignment.trade.exception.NotValidTradeException;
import com.db.assignment.trade.model.Trade;
import com.db.assignment.trade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TradeController {
    
	@Autowired
    TradeService tradeService;
    
    @PostMapping("/trade")
    public ResponseEntity<String> tradeValidateStore(@RequestBody Trade trade){
       if(tradeService.isValid(trade)) {
           tradeService.persist(trade);
       }else{
          throw new NotValidTradeException(trade.getTradeId()+"Trade is not valid");
       }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/trade")
    public List<Trade> findAllTrades(){
        return tradeService.findAll();
    }
}
