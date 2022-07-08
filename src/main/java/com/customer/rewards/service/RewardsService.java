package com.customer.rewards.service;

import com.customer.rewards.request.RewardsRequest;
import com.customer.rewards.response.AppResponse;

public interface RewardsService {
    
    AppResponse createRewards(RewardsRequest request);

    AppResponse getCustomerRewards(Long id);

    AppResponse getAllCustomerRewards();
}
