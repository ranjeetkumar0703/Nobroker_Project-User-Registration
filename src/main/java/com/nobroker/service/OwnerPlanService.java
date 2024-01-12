
package com.nobroker.service;


import com.nobroker.payLoad_Dto.OwnerPlanDto;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface OwnerPlanService {
    public OwnerPlanDto createOwnerPlans(OwnerPlanDto ownerPlanDto);

    List<OwnerPlanDto>getAllOwnerPlans();
}
