//package com.nobroker.service.Impl;
//
//import com.nobroker.entity.OwnerPlan;
//import com.nobroker.payLoad_Dto.OwnerPlanDto;
//import com.nobroker.repository.OwnerPlanRepository;
//import com.nobroker.service.OwnerPlanService;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class OwnerPlanServiceImpl extends OwnerPlanService {
//
//    private OwnerPlanRepository ownerPlanRepository;
//
//    private ModelMapper modelMapper;
//
//    public OwnerPlanServiceImpl(OwnerPlanRepository ownerPlanRepository, ModelMapper modelMapper) {
//        this.ownerPlanRepository = ownerPlanRepository;
//        this.modelMapper = modelMapper;
//    }
//
//
//    public OwnerPlanDto createOwnerPlans(OwnerPlanDto ownerPlanDto) {
//        OwnerPlan ownerPlan = mapToEntity(ownerPlanDto);
//        OwnerPlan savedOwnerPlan = ownerPlanRepository.save(ownerPlan);
//       return mapToDto(savedOwnerPlan);
//    }
//
//
//    public List<OwnerPlanDto> getAllOwnerPlans() {
//        List<OwnerPlan> ownerPlans = ownerPlanRepository.findAll();
//        List<OwnerPlanDto> ownerPlanDtos = ownerPlans.stream().map(plan -> mapToDto(plan)).collect(Collectors.toList());
//
//        return ownerPlanDtos;
//
//    }
//
//    OwnerPlan mapToEntity(OwnerPlanDto ownerPlanDto){
//        OwnerPlan ownerPlan = modelMapper.map(ownerPlanDto, OwnerPlan.class);
//        return ownerPlan;
//
//
//    }
//
//    OwnerPlanDto mapToDto(OwnerPlan OwnerPlan){
//        OwnerPlanDto ownerPlanDto = modelMapper.map(OwnerPlan, OwnerPlanDto.class);
//        return ownerPlanDto;
//
//
//    }
//}
//
