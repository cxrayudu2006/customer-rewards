package com.customer.rewards.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "customer_rewards")
public class Rewards {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Double spentAmount;

    @Column(nullable = false)
    private Double rewardsPoint;

    @Column(nullable = false)
    private Date transactionDate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}
