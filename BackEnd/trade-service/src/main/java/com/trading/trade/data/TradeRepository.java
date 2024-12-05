package com.trading.trade.data;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;


@Repository
public interface TradeRepository extends JpaRepository<Trade,Integer> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE trade SET t_capital = :capital, t_market= :market,  t_risk_amount = :risk, t_win_loss = :winLoss, t_buy_sell = :buySell WHERE t_name = :name AND t_userid = :uid")
    Integer updateTradeByNameUId(@Param("capital") double capital ,@Param("market") String market,@Param("risk") double risk, @Param("winLoss") String winLoss, @Param("buySell") String buySell, @Param("name") String name,@Param("uid") int uId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE FROM trade WHERE t_name = :tName AND t_userid = :uid")
    Integer deleteTradeByName(@Param("tName") String tName,@Param("uid") int uId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "INSERT INTO `trade` (`t_name`, `t_capital`, `t_market`, `t_risk_amount`, `t_win_loss`, `t_buy_sell`, `t_userid`) VALUES (:name, :capital, :market, :riskAmount, :winLoss, :buySell, :uid)")
    Integer createTrade(@Param("name") String name, @Param("capital") double capital, @Param("market") String market, @Param("riskAmount") double riskAmount, @Param("winLoss") String winLoss, @Param("buySell") String buySell, @Param("uid") int userId);

    @Query(nativeQuery = true, value = "SELECT * FROM `trade` WHERE t_userid = :id")
    List<Trade> getAllTradesByUserId(@Param("id") int id);
}
