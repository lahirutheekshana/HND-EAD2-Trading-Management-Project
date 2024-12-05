package com.trading.trade.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TradeResponse {

    private int id;

    private String date;

    private double capital;

    private double market;

    private double riskAmount;

    private double winLoss;

    private double buySell;

    private double tUserId;
}
