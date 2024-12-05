package com.trading.plan.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "p_id")
    private int id;

    @Column(name = "p_name")
    private String name;

    @Column(name = "p_date")
    private String date;

    @Column(name = "p_accstart")
    private double accStart;

    @Column(name = "p_typicalrisk")
    private int risk;

    @Column(name = "p_riskreward")
    private int riskReward;

    @Column(name = "p_winloss")
    private int winLoss;

    @Column(name = "p_userid")
    private  int userId;
}
