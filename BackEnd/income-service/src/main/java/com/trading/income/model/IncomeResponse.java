package com.trading.income.model;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IncomeResponse {
    private int id;

    private double balance;

    private int profitLoss;

    private int newBalance;

    private int userId;

    private int pId;
}
