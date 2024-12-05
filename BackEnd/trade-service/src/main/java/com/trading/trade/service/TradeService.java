package com.trading.trade.service;

import com.trading.trade.data.Trade;
import com.trading.trade.data.TradeRepository;
import com.trading.trade.model.CreateTradeModel;
import com.trading.trade.model.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class TradeService {
    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    RestTemplate restTemplate;

    //Get all the trades in database to view
    public List<Trade> getAllTradesByUserId (int id) {
        return tradeRepository.getAllTradesByUserId(id);
    }

    //Get all the trades in database to view
    public Integer createTrade(String name,double capital,String market,double riskAmount,String winLoss,String buySell,String email) {
        //Get the User id Based On the Email (REST Templete -> To user table)
        UserResponse userResponse = restTemplate.getForObject("http://localhost:8081/trading-app/usersx?email={email}",UserResponse.class , email);
        int userId = userResponse.getId();
        return tradeRepository.createTrade(name,capital,market,riskAmount,winLoss,buySell,userId);
    }

    //Update a Specific Trade in the database
    public Integer updateTradeByNameUId(CreateTradeModel trade) {
        // getUserIdByEmail -> Rest Template rest call (USER-SERVICE)
        UserResponse userResponse = restTemplate.getForObject("http://localhost:8081/trading-app/usersx?email={email}",UserResponse.class , trade.getEmail());
        int userId = userResponse.getId();

        return tradeRepository.updateTradeByNameUId(trade.getCapital(),trade.getMarket(),trade.getRiskAmount(),trade.getWinLoss(),trade.getBuySell(),trade.getName(),userId);
    }


    //Delete a Specific Trade in the database
    public Integer deleteTradeByName(String tName,String email) {
        // getUserIdByEmail -> Rest Template rest call (USER-SERVICE)
        UserResponse userResponse = restTemplate.getForObject("http://localhost:8081/trading-app/usersx?email={email}",UserResponse.class , email);
        int userId = userResponse.getId();

        return tradeRepository.deleteTradeByName(tName,userId);
    }
}

