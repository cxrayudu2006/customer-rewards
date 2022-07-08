package com.customer.rewards.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class AppResponse {

    private Integer statusCode;
    private String message;
    private Object data;
    private Boolean status;
}
