package com.trading.income.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "income")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "i_id")
    private int id;

    @Column(name = "i_balance")
    private double balance;

    @Column(name = "i_profit_loss")
    private int profitLoss;

    @Column(name = "i_new_balance")
    private int newBalance;

    @Column(name = "i_userid")
    private int userId;

    @Column(name = "i_pid")
    private int pId;

}
