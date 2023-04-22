package ru.isands.appliance.mapper;

import ru.isands.appliance.dto.AllDTO;
import ru.isands.appliance.dto.model.AllModelDTO;
import java.util.stream.Collectors;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
public class AllDtoMapper {

    private static <T extends AllModelDTO> AllModelDTO toModelDto(T object) {
        AllModelDTO dto = new AllModelDTO();
        dto.setName(object.getName());
        dto.setSerialNumber(object.getSerialNumber());
        dto.setColor(object.getColor());
        dto.setSize(object.getSize());
        dto.setPrice(object.getPrice());
        dto.setAvailable(object.isAvailable());
        dto.setCategory(object.getCategory());
        dto.setTechnology(object.getTechnology());
        dto.setMemory(object.getMemory());
        dto.setCamera(object.getCamera());
        return dto;
    }

    public static <T extends AllDTO> AllDTO toDto(T object) {
        AllDTO dto = new AllDTO();
        dto.setName(object.getName());
        dto.setCountry(object.getCountry());
        dto.setManufacturer(object.getManufacturer());
        dto.setOnline(object.isOnline());
        dto.setInstalment(object.isInstalment());
        dto.setModels(object.getModels()
                .stream()
                .map(AllDtoMapper::toModelDto)
                .collect(Collectors.toList()));
        return dto;
    }
}
