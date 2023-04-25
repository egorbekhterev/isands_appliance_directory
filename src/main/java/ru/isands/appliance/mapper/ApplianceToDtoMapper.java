package ru.isands.appliance.mapper;

import ru.isands.appliance.domain.Appliance;
import ru.isands.appliance.domain.Model;
import ru.isands.appliance.dto.ApplianceDto;
import ru.isands.appliance.dto.ModelDto;

import java.util.stream.Collectors;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
public class ApplianceToDtoMapper {

    private static ModelDto toModelDto(Model model) {
        ModelDto dto = new ModelDto();
        dto.setName(model.getName());
        dto.setSerialNumber(model.getSerialNumber());
        dto.setColor(model.getColor());
        dto.setSize(model.getSize());
        dto.setPrice(model.getPrice());
        dto.setAvailable(model.isAvailable());
        dto.setCategory(model.getCategory());
        dto.setTechnology(model.getTechnology());
        dto.setMemory(model.getMemory());
        dto.setCamera(model.getCamera());
        dto.setVolume(model.getVolume());
        dto.setMode(model.getMode());
        return dto;
    }

    public static ApplianceDto toDto(Appliance appliance) {
        ApplianceDto dto = new ApplianceDto();
        dto.setName(appliance.getName());
        dto.setCountry(appliance.getCountry());
        dto.setManufacturer(appliance.getManufacturer());
        dto.setOnline(appliance.isOnline());
        dto.setInstalment(appliance.isInstalment());
        dto.setModels(appliance.getModels()
                .stream()
                .map(ApplianceToDtoMapper::toModelDto)
                .collect(Collectors.toList()));
        return dto;
    }
}
