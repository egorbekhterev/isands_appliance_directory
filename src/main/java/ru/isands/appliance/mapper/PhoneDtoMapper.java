package ru.isands.appliance.mapper;

import ru.isands.appliance.domain.Phone;
import ru.isands.appliance.domain.model.PhoneModel;
import ru.isands.appliance.dto.PhoneDTO;
import ru.isands.appliance.dto.model.AllModelDTO;

import java.util.stream.Collectors;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
public class PhoneDtoMapper {

    private static AllModelDTO toModelDto(PhoneModel phoneModel) {
        AllModelDTO dto = new AllModelDTO();
        dto.setName(phoneModel.getName());
        dto.setSerialNumber(phoneModel.getSerialNumber());
        dto.setColor(phoneModel.getColor());
        dto.setSize(phoneModel.getSize());
        dto.setPrice(phoneModel.getPrice());
        dto.setAvailable(phoneModel.isAvailable());
        dto.setMemory(phoneModel.getMemory());
        dto.setCamera(phoneModel.getCamera());
        return dto;
    }

    public static PhoneDTO toDto(Phone phone) {
        PhoneDTO dto = new PhoneDTO();
        dto.setName(phone.getName());
        dto.setCountry(phone.getCountry());
        dto.setManufacturer(phone.getManufacturer());
        dto.setOnline(phone.isOnline());
        dto.setInstalment(phone.isInstalment());
        dto.setModels(phone.getModels()
                .stream()
                .map(PhoneDtoMapper::toModelDto)
                .collect(Collectors.toList()));
//        List<AllModelDTO> rsl = phone.getModels().stream()
//                .map(PhoneDtoMapper::toModelDto)
//                .collect(Collectors.toList());
//        rsl.forEach(allModelDTO -> {
//            PhoneDTO dto = new PhoneDTO();
//            dto.setName(phone.getName());
//            dto.setCountry(phone.getCountry());
//            dto.setManufacturer(phone.getManufacturer());
//            dto.setOnline(phone.isOnline());
//            dto.setInstalment(phone.isInstalment());
//            dto.setModel(allModelDTO);
//            dtos.add(dto);
//        });
        return dto;
    }
}
