package com.nobroker.repository;

import com.nobroker.entity.OwnerPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OwnerPlanRepository extends JpaRepository<OwnerPlan, Long> {
    List<OwnerPlan> findBySubscriptionActive(boolean subscriptionActive);
    List<OwnerPlan> findBySubscriptionExpirationDateBefore(LocalDate date);
}
