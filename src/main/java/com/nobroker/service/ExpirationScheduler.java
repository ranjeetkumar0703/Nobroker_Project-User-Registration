package com.nobroker.service;
import com.nobroker.entity.OwnerPlan;
import com.nobroker.repository.OwnerPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpirationScheduler {




    @Autowired
    private OwnerPlanRepository ownerPlanRepository;

    // ... (other methods)

    @Scheduled(cron = "0 0 0 * * ?") // Execute daily at midnight
    public void handleSubscriptionExpirations() {
        List<OwnerPlan> expiringSubscriptions = ownerPlanRepository.findBySubscriptionExpirationDateBefore(LocalDate.now());

        for (OwnerPlan expiredSubscription : expiringSubscriptions) {
            // Perform expiration logic, e.g., update subscriptionActive to false
            expiredSubscription.setSubscriptionActive(false);

            // Save the updated entity back to the database
            ownerPlanRepository.save(expiredSubscription);
        }
    }
}
