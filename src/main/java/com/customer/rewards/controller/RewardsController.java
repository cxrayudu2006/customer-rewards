package com.customer.rewards.controller;

import com.customer.rewards.request.RewardsRequest;
import com.customer.rewards.response.AppResponse;
import com.customer.rewards.service.RewardsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/rewards")
@Api(tags = "customer-rewards")
public class RewardsController {

    @Autowired
    private RewardsService service;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(value = "Create Customer Rewards", nickname = "Create Rewards", httpMethod = "POST", consumes = MediaType.APPLICATION_JSON_VALUE, response = AppResponse.class)
    ResponseEntity<AppResponse> createRewards(@Valid @RequestBody RewardsRequest request) {
        AppResponse response = service.createRewards(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get Customer Rewards", nickname = "Get Rewards", httpMethod = "GET", consumes = MediaType.APPLICATION_JSON_VALUE, response = AppResponse.class)
    public ResponseEntity<AppResponse> getCustomerRewards(@PathVariable("id") Long id) {
        AppResponse response = service.getCustomerRewards(id);
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get All Customer Rewards", nickname = "Get All Rewards", httpMethod = "GET", consumes = MediaType.APPLICATION_JSON_VALUE, response = AppResponse.class)
    public ResponseEntity<AppResponse> getCustomerRewards() {
        AppResponse response = service.getAllCustomerRewards();
        return ResponseEntity.ok().body(response);
    }


}
