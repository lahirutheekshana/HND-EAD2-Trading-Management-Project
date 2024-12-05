package com.trading.income.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class createIncomeModel {
    private int totalTrades;
    private String planName;
    private String email;
}
