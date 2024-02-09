package com.nobroker.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="subscription_plan-1")
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Owner_Plan_Id")
    private long ownerPlanId;

    @Column(name = "user_Id", unique = true)
    private long userId;

    @Column(name = "subscription_active")
    private boolean subscriptionActive;

    @Column(name = "subscription_active_date")
    private LocalDate subscriptionActiveDate;

    @Column(name = "subscription_expiration_date")
    private LocalDate subscriptionExpirationDate;

    @Column(name = "number_of_days")
    private int numberOfDays;


}