package com.customer.rewards.response;

import lombok.Data;

@Data
public class RewardsResponse {

    private String transactionMonth;
    private Long customerId;
    private Double totalRewards;

}
