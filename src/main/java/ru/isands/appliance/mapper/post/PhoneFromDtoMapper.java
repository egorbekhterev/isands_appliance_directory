package ru.isands.appliance.mapper.post;

import ru.isands.appliance.domain.Appliance;
import ru.isands.appliance.domain.Model;
import ru.isands.appliance.dto.post.PhoneDto;
import ru.isands.appliance.dto.post.PhoneModelDto;

import java.util.stream.Collectors;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
public class PhoneFromDtoMapper {

    public static Appliance fromDto(PhoneDto phoneDto) {
        Appliance appliance = new Appliance();
        appliance.setCountry(phoneDto.getCountry());
        appliance.setManufacturer(phoneDto.getManufacturer());
        appliance.setOnline(phoneDto.isOnline());
        appliance.setInstalment(phoneDto.isInstalment());
        appliance.setModels(phoneDto.getModels()
                .stream()
                .map(PhoneFromDtoMapper::fromModelDto)
                .collect(Collectors.toList()));
        return appliance;
    }

    private static Model fromModelDto(PhoneModelDto phoneModelDto) {
        Model model = new Model();
        model.setName(phoneModelDto.getName());
        model.setSerialNumber(phoneModelDto.getSerialNumber());
        model.setColor(phoneModelDto.getColor());
        model.setSize(phoneModelDto.getSize());
        model.setPrice(phoneModelDto.getPrice());
        model.setAvailable(phoneModelDto.isAvailable());
        model.setMemory(phoneModelDto.getMemory());
        model.setCamera(phoneModelDto.getCamera());
        return model;
    }
}
