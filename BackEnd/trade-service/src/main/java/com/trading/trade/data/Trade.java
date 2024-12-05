package com.trading.trade.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name = "trade")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "t_id")
    private int id;

    @Column(name = "t_name")
    private String name;

    @Column(name = "t_date")
    private String date;

    @Column(name = "t_capital")
    private double capital;

    @Column(name = "t_market")
    private String market;

    @Column(name = "t_risk_amount")
    private double riskAmount;

    @Column(name = "t_win_loss")
    private String winLoss;

    @Column(name = "t_buy_sell")
    private String buySell;

    @Column(name = "t_userid")
    private int tUserId;
}
