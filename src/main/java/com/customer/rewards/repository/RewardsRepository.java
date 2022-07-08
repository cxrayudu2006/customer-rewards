package com.customer.rewards.repository;

import com.customer.rewards.entity.Rewards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface RewardsRepository extends JpaRepository<Rewards, Long> {

    @Query(value = "SELECT to_char(TRANSACTION_DATE , 'YYYY-MM') as transactionMonth, sum(REWARDS_POINT ) as totalRewards, " +
            "CUSTOMER_ID as customerId FROM CUSTOMER_REWARDS WHERE CUSTOMER_ID = :customerId AND " +
            "TRANSACTION_DATE >= :fromDate AND TRANSACTION_DATE <= :toDate GROUP BY CUSTOMER_ID, " +
            "to_char(TRANSACTION_DATE, 'YYYY-MM')", nativeQuery = true)
    List<Map<String, Object>> getCustomerRewards(@Param("customerId") Long customerId, @Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

    @Query(value = "SELECT to_char(TRANSACTION_DATE , 'YYYY-MM') as transactionMonth, sum(REWARDS_POINT ) as totalRewards, CUSTOMER_ID as customerId FROM CUSTOMER_REWARDS WHERE TRANSACTION_DATE >= :fromDate AND TRANSACTION_DATE <= :toDate GROUP BY CUSTOMER_ID, to_char(TRANSACTION_DATE, 'YYYY-MM')", nativeQuery = true)
    List<Map<String, Object>> getAllCustomerRewards(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
}
