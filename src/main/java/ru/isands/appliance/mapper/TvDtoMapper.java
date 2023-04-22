package ru.isands.appliance.mapper;

import ru.isands.appliance.domain.TV;
import ru.isands.appliance.domain.model.TvModel;
import ru.isands.appliance.dto.TvDTO;
import ru.isands.appliance.dto.model.AllModelDTO;

import java.util.stream.Collectors;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
public class TvDtoMapper {

    private static AllModelDTO toModelDto(TvModel tvModel) {
        AllModelDTO dto = new AllModelDTO();
        dto.setName(tvModel.getName());
        dto.setSerialNumber(tvModel.getSerialNumber());
        dto.setColor(tvModel.getColor());
        dto.setSize(tvModel.getSize());
        dto.setPrice(tvModel.getPrice());
        dto.setAvailable(tvModel.isAvailable());
        dto.setCategory(tvModel.getCategory());
        dto.setTechnology(tvModel.getTechnology());
        return dto;
    }

    public static TvDTO toDto(TV tv) {
        TvDTO dto = new TvDTO();
        dto.setName(tv.getName());
        dto.setCountry(tv.getCountry());
        dto.setManufacturer(tv.getManufacturer());
        dto.setOnline(tv.isOnline());
        dto.setInstalment(tv.isInstalment());
        dto.setModels(tv.getModels()
                .stream()
                .map(TvDtoMapper::toModelDto)
                .collect(Collectors.toList()));
        return dto;
    }
}
