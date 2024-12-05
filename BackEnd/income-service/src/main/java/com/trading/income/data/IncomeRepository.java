package com.trading.income.data;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer> {


    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "INSERT INTO `income` (`i_balance`, `i_profit_loss`, `i_new_balance`, `i_userid`, `i_pid`) VALUES (:balance, :profit, :newBalance, :uid, :planId)")
    void saveDetail(@Param("balance") double balance, @Param("profit") int profit,@Param("newBalance") int newBalance,@Param("uid") int userId,@Param("planId") int planId);

    @Query(nativeQuery = true, value = "SELECT * FROM `income` WHERE `i_userid` = :uid")
    List<Income> getAllIncomes(@Param("uid") int userId);
}
