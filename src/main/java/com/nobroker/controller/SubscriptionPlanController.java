package com.nobroker.controller;


import com.nobroker.entity.SubscriptionPlan;
import com.nobroker.service.SubscriptionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owner-plans")
public class SubscriptionPlanController {

    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    // ... (other methods)

    @PostMapping("/subscribe/{userId}/{duration}")
    public SubscriptionPlan subscribeOwnerPlan(@PathVariable long userId, @PathVariable int duration) {
        // Assuming you want to start the subscription immediately (current date)
        return subscriptionPlanService.subscribeOwnerPlan(userId, duration);
    }

    @GetMapping("/{ownerPlanId}")
    public SubscriptionPlan getOwnerPlan(@PathVariable long ownerPlanId) {
        return subscriptionPlanService.getOwnerPlan(ownerPlanId);
    }
}
