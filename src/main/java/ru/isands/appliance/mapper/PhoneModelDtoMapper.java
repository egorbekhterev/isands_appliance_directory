package ru.isands.appliance.mapper;

import ru.isands.appliance.domain.Phone;
import ru.isands.appliance.domain.model.PhoneModel;
import ru.isands.appliance.dto.PhoneDTO;
import ru.isands.appliance.dto.model.PhoneModelDTO;

/**
 * @author: Egor Bekhterev
 * @date: 23.04.2023
 * @project: isands_appliance_directory
 */
public class PhoneModelDtoMapper {

    private static PhoneDTO toDto(Phone phone) {
        PhoneDTO dto = new PhoneDTO();
        dto.setName(phone.getName());
        dto.setCountry(phone.getCountry());
        dto.setManufacturer(phone.getManufacturer());
        dto.setInstalment(phone.isInstalment());
        dto.setOnline(phone.isOnline());
        return dto;
    }

    public static PhoneModelDTO toModelDto(PhoneModel phoneModel) {
        PhoneModelDTO dto = new PhoneModelDTO();
        dto.setCamera(phoneModel.getCamera());
        dto.setMemory(phoneModel.getMemory());
        dto.setName(phoneModel.getName());
        dto.setSerialNumber(phoneModel.getSerialNumber());
        dto.setColor(phoneModel.getColor());
        dto.setSize(phoneModel.getSize());
        dto.setPrice(phoneModel.getPrice());
        dto.setAvailable(phoneModel.isAvailable());
        dto.setAllDTO(toDto(phoneModel.getPhone()));
        return dto;
    }
}
