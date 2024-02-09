package com.nobroker.repository;

import com.nobroker.entity.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Long> {
    List<SubscriptionPlan> findBySubscriptionActive(boolean subscriptionActive);
    List<SubscriptionPlan> findBySubscriptionExpirationDateBefore(LocalDate date);
}
