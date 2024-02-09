package com.nobroker.service;


import com.nobroker.entity.SubscriptionPlan;

import com.nobroker.repository.SubscriptionPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class SubscriptionPlanService {

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    public SubscriptionPlan subscribeOwnerPlan(long userId, int duration) {
        // Assuming you want to start the subscription immediately (current date)
        LocalDate subscriptionActiveDate = LocalDate.now();

        // Calculate the expiration date based on the provided duration
        LocalDate subscriptionExpirationDate = subscriptionActiveDate.plusDays(duration);

        // Create a new OwnerPlan
        SubscriptionPlan newSubscription = new SubscriptionPlan();
        newSubscription.setUserId(userId);
        newSubscription.setSubscriptionActive(true);
        newSubscription.setSubscriptionActiveDate(subscriptionActiveDate);
        newSubscription.setSubscriptionExpirationDate(subscriptionExpirationDate);
        newSubscription.setNumberOfDays(duration);

        // Save the new owner plan to the repository
        return subscriptionPlanRepository.save(newSubscription);
    }

    public SubscriptionPlan getOwnerPlan(long ownerPlanId) {
        Optional<SubscriptionPlan> optionalOwnerPlan = subscriptionPlanRepository.findById(ownerPlanId);

        // Return the owner plan if found, otherwise return null
        return optionalOwnerPlan.orElse(null);
    }
}
