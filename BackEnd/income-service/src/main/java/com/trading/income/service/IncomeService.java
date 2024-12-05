package com.trading.income.service;

import com.trading.income.data.Income;
import com.trading.income.data.IncomeRepository;
import com.trading.income.model.UserResponse;
import com.trading.income.model.planResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Service
public class IncomeService {
    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    RestTemplate restTemplate;

    //Get All the Income Details From the Database to view
    public List<Income> getAllIncomes(int totalTrades, String planName, String email) {
        // getUserIdByEmail -> Rest Template rest call (USER-SERVICE)
        UserResponse userResponse = restTemplate.getForObject("http://localhost:8081/trading-app/usersx?email={email}",UserResponse.class , email);
        int userId = userResponse.getId();


        // get plan information based on the user id AND plan name -> Rest Template call to (PLAN SERVICE)
        planResponse plan = restTemplate.getForObject("http://localhost:8083/trading-app/plansx?id={userId}&plan={planName}", planResponse.class,userId,planName);
            int planId = plan.getId();
            double AccStart = plan.getAccStart();
            int typicalRisk = plan.getRisk();
            double RiskReward = plan.getRiskReward();
            int win_loss = plan.getWinLoss();

        //Run Logic and Update Income table in a LOOP -> To Calculate Profit Or Loss
            double balance = 0.0;
            double profit = 0;
            double newBalance = 0;

            int x = (win_loss / 100) * totalTrades;
            int y = totalTrades - x;
            int even_count = 0;
            int odd_count = 0;

            Random random = new Random();
            for (int i = 0; i < totalTrades; i++)
            {
                int randomNumber = random.nextInt(3) + 1;
                if (even_count == x) {randomNumber++;}
                if (odd_count == y) {randomNumber++;}

                if (randomNumber % 2 == 0) {
                    if (i == 0) {
                        balance = AccStart;
                    } else {
                        balance = newBalance;
                    }
                    profit = ((balance * typicalRisk) / 100) * RiskReward;
                    newBalance = balance + profit;
                    even_count += 1;
                }

                else {
                    if (i == 0) {
                        balance = AccStart;
                    } else {
                        balance = newBalance;
                    }
                    profit = ((balance * typicalRisk) / 100);
                    newBalance = balance - profit;
                    odd_count += 1;
                }
            incomeRepository.saveDetail (balance, (int) profit, (int) newBalance,userId,planId);
            }

        //Return table to view
        return incomeRepository.getAllIncomes(userId);
    }


    //Delete All Incomes
    public void deleteAllIncomes()
    {
        incomeRepository.deleteAll();
    }
}
