package ru.isands.appliance.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.isands.appliance.dto.ApplianceDto;
import ru.isands.appliance.dto.ModelDto;
import ru.isands.appliance.mapper.ApplianceToDtoMapper;
import ru.isands.appliance.mapper.ModelToDtoMapper;
import ru.isands.appliance.repository.ApplianceRepository;

import java.math.BigDecimal;
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

    public List<ApplianceDto> findAll() {
        return applianceRepository.findAll()
                .stream()
                .map(ApplianceToDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findByColorIgnoreCase(String color) {
        return applianceRepository.findByColorIgnoreCase(color)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllSortByPriceAsc() {
        return applianceRepository.findAllSortByPriceAsc()
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllSortByPriceDesc() {
        return applianceRepository.findAllSortByPriceDesc()
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllSortByNameAsc() {
        return applianceRepository.findAllSortByNameAsc()
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllSortByNameDesc() {
        return applianceRepository.findAllSortByNameDesc()
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllByNameIgnoreCase(String name) {
        return applianceRepository.findAllByNameIgnoreCase(name)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllByPriceBetween(BigDecimal min, BigDecimal max) {
        return applianceRepository.findAllByPriceBetween(min, max)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }
}
