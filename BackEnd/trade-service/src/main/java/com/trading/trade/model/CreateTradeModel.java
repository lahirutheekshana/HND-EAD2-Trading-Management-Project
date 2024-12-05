package com.trading.trade.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTradeModel {
    private String name;
    private double capital;
    private String market;
    private double riskAmount;
    private String winLoss;
    private String buySell;
    private String email;
}
