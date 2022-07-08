package com.customer.rewards.service.impl;

import com.customer.rewards.entity.Customer;
import com.customer.rewards.entity.Rewards;
import com.customer.rewards.exception.CustomerNotFoundException;
import com.customer.rewards.repository.CustomerRepository;
import com.customer.rewards.repository.RewardsRepository;
import com.customer.rewards.request.RewardsRequest;
import com.customer.rewards.response.AppResponse;
import com.customer.rewards.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RewardsServiceImpl implements RewardsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RewardsRepository rewardsRepository;

    @Override
    public AppResponse createRewards(RewardsRequest request) {
        AppResponse appResponse = new AppResponse();
        double rewardPoints = 0;
        if (request.getSpentAmount() > 100) {
            rewardPoints = (((request.getSpentAmount() - 100) * 2) + (50 * 1));
        } else if (request.getSpentAmount() > 50) {
            rewardPoints = ((request.getSpentAmount() - 50) * 1);
        }
        Rewards rewards = rewardsRepository.save(converToEntity(request, rewardPoints));
        if (rewards != null) {
            appResponse.setMessage("Customer rewards created successfully.");
            appResponse.setStatus(true);
        } else {
            appResponse.setMessage("Customer rewards creation failed.");
            appResponse.setStatus(false);
        }
        return appResponse;
    }

    private Rewards converToEntity(RewardsRequest request, double rewardPoints) {
        Optional<Customer> customerOptional = customerRepository.findById(request.getCustomerId());
        if (customerOptional.isPresent()) {
            Rewards rewards = new Rewards();
            rewards.setCustomer(customerOptional.get());
            rewards.setSpentAmount(request.getSpentAmount());
            rewards.setTransactionDate(request.getTransactionDate());
            rewards.setRewardsPoint(rewardPoints);
            return rewards;
        } else {
            throw new CustomerNotFoundException("Customer not found");
        }

    }

    @Override
    public AppResponse getCustomerRewards(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            AppResponse appResponse = new AppResponse();
            Date toDate = new Date();
            List<Map<String, Object>> response = rewardsRepository.getCustomerRewards(id, fromDate(toDate), toDate);
            appResponse.setMessage("Getting rewards for customer successfully.");
            appResponse.setStatus(true);
            if (response != null) {
                appResponse.setData(response);
            }
            return appResponse;
        } else {
            throw new CustomerNotFoundException("Customer not found");
        }
    }

    @Override
    public AppResponse getAllCustomerRewards() {
        AppResponse appResponse = new AppResponse();
        Date toDate = new Date();
        List<Map<String, Object>> response = rewardsRepository.getAllCustomerRewards(fromDate(toDate), toDate);
        appResponse.setMessage("Getting rewards for all customer successfully.");
        appResponse.setStatus(true);
        if (response != null) {
            appResponse.setData(response);
        }
        return appResponse;
    }


    private Date fromDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -3);
        return c.getTime();
    }


}
