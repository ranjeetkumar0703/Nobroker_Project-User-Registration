package com.nobroker.service.Impl;

import com.nobroker.entity.OwnerPlan;
import com.nobroker.payLoad_Dto.OwnerPlanDto;
import com.nobroker.repository.OwnerPlanRepository;
import com.nobroker.service.OwnerPlanService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OwnerPlanServiceImpl  implements OwnerPlanService {

    private OwnerPlanRepository ownerPlanRepository;

    private ModelMapper modelMapper;

    public OwnerPlanServiceImpl(OwnerPlanRepository ownerPlanRepository, ModelMapper modelMapper) {
        this.ownerPlanRepository = ownerPlanRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OwnerPlanDto createOwnerPlans(OwnerPlanDto ownerPlanDto) {
        OwnerPlan ownerPlan = mapToEntity(ownerPlanDto);
        OwnerPlan savedOwnerPlan = ownerPlanRepository.save(ownerPlan);
       return mapToDto(savedOwnerPlan);
    }

    OwnerPlan mapToEntity(OwnerPlanDto ownerPlanDto){
        OwnerPlan ownerPlan = modelMapper.map(ownerPlanDto, OwnerPlan.class);
        return ownerPlan;


    }

    OwnerPlanDto mapToDto(OwnerPlan OwnerPlan){
        OwnerPlanDto ownerPlanDto = modelMapper.map(OwnerPlan, OwnerPlanDto.class);
        return ownerPlanDto;


    }
}

