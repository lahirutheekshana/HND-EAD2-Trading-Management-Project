package com.trading.trade.controller;

import com.trading.trade.data.Trade;
import com.trading.trade.model.CreateTradeModel;
import com.trading.trade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TradeController {
    @Autowired
    TradeService tradeService;

    //Get all the trades in database to view
    @GetMapping("trades")
    public List<Trade> getAllTradesByUserId (@RequestParam("id") int id) {
        return tradeService.getAllTradesByUserId(id);
    }

    //Get all the trades in database to view
    @PostMapping("trades")
    public ResponseEntity<String> createTrade (@RequestBody CreateTradeModel t) {
        Integer i = tradeService.createTrade (t.getName(),t.getCapital(),t.getMarket(),t.getRiskAmount(),t.getWinLoss(),t.getBuySell(),t.getEmail());
        if (i > 0) {
            return ResponseEntity.status(HttpStatus.OK).body("TRADE PLACED");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("TRADE PLACING UNSUCCESSFUL");
        }
    }

    //Update a Specific Trade in the database
    @PutMapping("trades")
    public ResponseEntity<String> updateTradeByNameUId (@RequestBody CreateTradeModel trade) {
        Integer i = tradeService.updateTradeByNameUId(trade);
        if (i > 0) {
            return ResponseEntity.status(HttpStatus.OK).body("TRADE UPDATED");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("TRADE UPDATE UNSUCCESSFUL");
        }
    }

    //Delete a Specific Trade in the database
    @DeleteMapping("trades")
    public ResponseEntity<String> deleteTradeByName (@RequestParam("tName") String tName,@RequestParam("email") String email) {
        Integer i = tradeService.deleteTradeByName(tName,email);
        if(i > 0) {
            return ResponseEntity.status(HttpStatus.OK).body("TRADE HAS BEEN DELETED.");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("TRADE DELETE UNSUCCESSFUL.");
        }
    }
}
