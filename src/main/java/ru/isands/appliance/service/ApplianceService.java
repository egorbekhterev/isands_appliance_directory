package ru.isands.appliance.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.isands.appliance.dto.ApplianceDto;
import ru.isands.appliance.dto.ModelDto;
import ru.isands.appliance.mapper.ApplianceToDtoMapper;
import ru.isands.appliance.mapper.ModelToDtoMapper;
import ru.isands.appliance.repository.ApplianceRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Service
@AllArgsConstructor
public class ApplianceService {

    private ApplianceRepository applianceRepository;
    private Pageable pageable;

    public List<ApplianceDto> findAll() {
        return applianceRepository.findAll(pageable)
                .stream()
                .map(ApplianceToDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findByColor(String color) {
        return applianceRepository.findByColor(color)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllSortByPriceAsc() {
        return applianceRepository.findAllSortByPriceAsc(pageable)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllSortByPriceDesc() {
        return applianceRepository.findAllSortByPriceDesc(pageable)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllSortByNameAsc() {
        return applianceRepository.findAllSortByNameAsc(pageable)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllSortByNameDesc() {
        return applianceRepository.findAllSortByNameDesc(pageable)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }
}
