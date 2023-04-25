package ru.isands.appliance.mapper.post;

import ru.isands.appliance.domain.Appliance;
import ru.isands.appliance.domain.Model;
import ru.isands.appliance.dto.post.FridgeDto;
import ru.isands.appliance.dto.post.FridgeModelDto;

import java.util.stream.Collectors;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
public class FridgeFromDtoMapper {

    public static Appliance fromDto(FridgeDto fridgeDto) {
        Appliance appliance = new Appliance();
        appliance.setCountry(fridgeDto.getCountry());
        appliance.setManufacturer(fridgeDto.getManufacturer());
        appliance.setOnline(fridgeDto.isOnline());
        appliance.setInstalment(fridgeDto.isInstalment());
        appliance.setModels(fridgeDto.getModels()
                .stream()
                .map(FridgeFromDtoMapper::fromModelDto)
                .collect(Collectors.toList()));
        return appliance;
    }

    private static Model fromModelDto(FridgeModelDto fridgeModelDto) {
        Model model = new Model();
        model.setName(fridgeModelDto.getName());
        model.setSerialNumber(fridgeModelDto.getSerialNumber());
        model.setColor(fridgeModelDto.getColor());
        model.setSize(fridgeModelDto.getSize());
        model.setPrice(fridgeModelDto.getPrice());
        model.setAvailable(fridgeModelDto.isAvailable());
        model.setDoor(fridgeModelDto.getDoor());
        model.setCompressor(fridgeModelDto.getCompressor());
        return model;
    }
}
