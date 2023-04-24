package ru.isands.appliance.service;

import lombok.AllArgsConstructor;
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

    public List<ApplianceDto> findAll() {
        return applianceRepository.findAll()
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
        return applianceRepository.findAllSortByPriceAsc()
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }
}
