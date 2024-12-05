package com.trading.plan.controller;

import com.trading.plan.data.Plan;
import com.trading.plan.model.PlanCreateModel;
import com.trading.plan.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class PlanController {
    @Autowired
    private PlanService planService;

    // Rest End Point For View All Plans
    @GetMapping("plans")
    public ResponseEntity<List<Plan>> getAllPlansByUserId (@RequestParam("id") int id) {
        List<Plan> plan = planService.getAllPlansByUserId (id);
        return ResponseEntity.status(HttpStatus.OK).body(plan);
    }

    // Rest End Point For Create a Plan
    @PostMapping("plans")
    //public ResponseEntity<String> createPlan (@RequestParam("pName") String name, @RequestParam("pDate") String date, @RequestParam("accStart") double accStart,@RequestParam("typicalRisk") int risk,@RequestParam("riskReward") int riskReward, @RequestParam("winLoss") int winLoss,@RequestParam("email") String email) {
    public ResponseEntity<String> createPlan (@RequestBody PlanCreateModel p) {
        Integer i = planService.createPlan(p.getName(),p.getAccStart(),p.getRisk(),p.getRiskReward(),p.getWinLoss(),p.getEmail());
        if(i > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("CREATED SUCCESSFULLY");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FAILED");
        }
    }

    // Rest End Point For Update a Plan
    @PutMapping("plans")
    public ResponseEntity<String> updatePlanByName (@RequestBody Plan plan) {
        Integer i = planService.updatePlanByName(plan);
        if(i > 0) {
            return ResponseEntity.status(HttpStatus.OK).body("UPDATE SUCCESSFULLY");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("FAILED");
        }
    }

    // Rest End Point For Delete a Plan by a Specific Name
    @DeleteMapping("plans")
    public ResponseEntity<String> deletePlanByName (@RequestParam("name") String name) {
        Integer i = planService.deletePlanByName(name);
        if (i > 0) {
            return ResponseEntity.status(HttpStatus.OK).body("DELETED SUCCESSFULLY");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("DELETED FAILED");
        }
    }

    //Help get Plan id for the INCOME SERVICE
    @GetMapping("plansx")
    public ResponseEntity<Optional<Plan>> getPlanByIdAndPlanName (@RequestParam("id") int id, @RequestParam("plan") String planName) {
        Optional<Plan> plan = planService.getPlanByIdAndPlanName(id,planName);
        return ResponseEntity.status(HttpStatus.OK).body(plan);
    }

}
