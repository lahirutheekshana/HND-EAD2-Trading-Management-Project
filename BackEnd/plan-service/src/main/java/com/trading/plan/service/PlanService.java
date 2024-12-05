package com.trading.plan.service;

import com.trading.plan.data.Plan;
import com.trading.plan.data.PlanRepository;
import com.trading.plan.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Plan> getAllPlansByUserId (int id) {
        return planRepository.getAllPlansByUserId(id);
    }

    public Integer createPlan(String name,double accStart,int risk,int riskReward,int winLoss,String email) {
        UserResponse userResponse = restTemplate.getForObject("http://localhost:8081/trading-app/usersx?email={email}",UserResponse.class , email);
        int userId = userResponse.getId();
        return planRepository.createPlan(name,accStart,risk,riskReward,winLoss,userId);
    }

    public Integer updatePlanByName(Plan plan) {
        return planRepository.updatePlanByName(plan.getName(),plan.getDate(), plan.getAccStart(),plan.getRisk(),plan.getRiskReward(),plan.getWinLoss());
    }

    public Integer deletePlanByName(String name) {
        return planRepository.deletePlanByName(name);
    }

    public Optional<Plan> getPlanByIdAndPlanName(int id, String planName) {
        return planRepository.getPlanByIdAndPlanName(id,planName);
    }
}

