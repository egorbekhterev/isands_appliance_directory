package ru.isands.appliance.mapper;

import ru.isands.appliance.domain.Phone;
import ru.isands.appliance.domain.TV;
import ru.isands.appliance.domain.model.PhoneModel;
import ru.isands.appliance.domain.model.TvModel;
import ru.isands.appliance.dto.PhoneDTO;
import ru.isands.appliance.dto.TvDTO;
import ru.isands.appliance.dto.model.PhoneModelDTO;
import ru.isands.appliance.dto.model.TvModelDTO;

/**
 * @author: Egor Bekhterev
 * @date: 23.04.2023
 * @project: isands_appliance_directory
 */
public class TvModelDtoMapper {

    private static TvDTO toDto(TV tv) {
        TvDTO dto = new TvDTO();
        dto.setName(tv.getName());
        dto.setCountry(tv.getCountry());
        dto.setManufacturer(tv.getManufacturer());
        dto.setInstalment(tv.isInstalment());
        dto.setOnline(tv.isOnline());
        return dto;
    }

    public static TvModelDTO toModelDto(TvModel tvModel) {
        TvModelDTO dto = new TvModelDTO();
        dto.setCategory(tvModel.getCategory());
        dto.setTechnology(tvModel.getTechnology());
        dto.setName(tvModel.getName());
        dto.setSerialNumber(tvModel.getSerialNumber());
        dto.setColor(tvModel.getColor());
        dto.setSize(tvModel.getSize());
        dto.setPrice(tvModel.getPrice());
        dto.setAvailable(tvModel.isAvailable());
        dto.setAllDTO(toDto(tvModel.getTv()));
        return dto;
    }
}
