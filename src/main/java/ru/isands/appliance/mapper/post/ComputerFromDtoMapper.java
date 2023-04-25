package ru.isands.appliance.mapper.post;

import ru.isands.appliance.domain.Appliance;
import ru.isands.appliance.domain.Model;
import ru.isands.appliance.dto.post.ComputerDto;
import ru.isands.appliance.dto.post.ComputerModelDto;

import java.util.stream.Collectors;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
public class ComputerFromDtoMapper {

    public static Appliance fromDto(ComputerDto computerDto) {
        Appliance appliance = new Appliance();
        appliance.setCountry(computerDto.getCountry());
        appliance.setManufacturer(computerDto.getManufacturer());
        appliance.setOnline(computerDto.isOnline());
        appliance.setInstalment(computerDto.isInstalment());
        appliance.setModels(computerDto.getModels()
                .stream()
                .map(ComputerFromDtoMapper::fromModelDto)
                .collect(Collectors.toList()));
        return appliance;
    }

    private static Model fromModelDto(ComputerModelDto computerModelDto) {
        Model model = new Model();
        model.setName(computerModelDto.getName());
        model.setSerialNumber(computerModelDto.getSerialNumber());
        model.setColor(computerModelDto.getColor());
        model.setSize(computerModelDto.getSize());
        model.setPrice(computerModelDto.getPrice());
        model.setAvailable(computerModelDto.isAvailable());
        model.setCategory(computerModelDto.getCategory());
        model.setProcessor(computerModelDto.getProcessor());
        return model;
    }
}
