package com.trading.income.controller;

import com.trading.income.data.Income;
import com.trading.income.model.createIncomeModel;
import com.trading.income.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    //Get All the Income Details From the Database to view
    @PostMapping("incomes")
    public ResponseEntity<List<Income>> getAllIncomes (@RequestBody createIncomeModel i) {
        List<Income> income = incomeService.getAllIncomes(i.getTotalTrades(),i.getPlanName(),i.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(income);
    }


    //Delete All Incomes
    @DeleteMapping("incomes")
    public ResponseEntity<String> deleteAllIncomes () {
        incomeService.deleteAllIncomes();
        return ResponseEntity.status(HttpStatus.OK).body("All INCOMES DELETED");
    }


}
