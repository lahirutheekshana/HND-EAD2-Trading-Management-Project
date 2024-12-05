package com.trading.plan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanResponse {
    private int id;

    private String name;

    private String date;

    private double accStart;

    private int risk;

    private int riskReward;

    private int winLoss;

    private  int userId;
}
