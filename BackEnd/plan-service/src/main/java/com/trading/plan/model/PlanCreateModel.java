package com.trading.plan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanCreateModel {
    private String name;
    private double accStart;
    private int risk;
    private int riskReward;
    private int winLoss;
    private String email;
}
