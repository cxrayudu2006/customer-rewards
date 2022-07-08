package com.customer.rewards.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class RewardsRequest {

    @NotNull(message = "customerId can not be null.")
    private Long customerId;
    @NotNull(message = "spentAmount can not be null.")
    private Double spentAmount;
    @NotNull(message = "transactionDate can not be null.")
    private Date transactionDate;

}
