package com.customer.rewards.exception;

/**
 * This class is used the Handle UserNotFound exception, if user is not found
 * at runtime
 *
 * @author tkushwaha
 *
 */
public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
