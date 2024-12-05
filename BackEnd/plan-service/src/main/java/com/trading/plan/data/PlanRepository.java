package com.trading.plan.data;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanRepository extends JpaRepository<Plan,Integer> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value ="UPDATE `plan` SET `p_date`=:newDate,`p_accstart`=:newAccStart,`p_typicalrisk`=:newTypicalRisk,`p_riskreward`=:newRiskReward,`p_winloss`=:newWinLoss WHERE `p_name`=:name")
    Integer updatePlanByName(@Param("name") String name, @Param("newDate") String newDate,@Param("newAccStart") double newAccStart, @Param("newTypicalRisk") int newTypicalRisk, @Param("newRiskReward") int newRiskReward, @Param("newWinLoss") int newWinLoss);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM `plan` WHERE p_name = :name")
    Integer deletePlanByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "INSERT INTO `plan` (`p_name`, `p_accstart`, `p_typicalrisk`, `p_riskreward`, `p_winloss`, `p_userid`) VALUES (:name, :accStart, :risk, :riskReward, :winLoss, :uid)")
    Integer createPlan(@Param("name") String name, @Param("accStart") double accStart, @Param("risk") int risk, @Param("riskReward") int riskReward, @Param("winLoss") int winLoss, @Param("uid") int userId);

    @Query(nativeQuery = true, value = "SELECT * FROM `plan` WHERE p_userid = :uid AND p_name = :name")
    Optional<Plan> getPlanByIdAndPlanName(@Param("uid") int id, @Param("name") String planName);

    @Query(nativeQuery = true, value = "SELECT * FROM `plan` WHERE p_userid = :uid")
    List<Plan> getAllPlansByUserId(@Param("uid") int id);
}
