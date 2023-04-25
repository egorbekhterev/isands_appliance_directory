package ru.isands.appliance.mapper.post;

import ru.isands.appliance.domain.Appliance;
import ru.isands.appliance.domain.Model;
import ru.isands.appliance.dto.post.HooverDto;
import ru.isands.appliance.dto.post.HooverModelDto;

import java.util.stream.Collectors;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
public class HooverFromDtoMapper {

    public static Appliance fromDto(HooverDto hooverDto) {
        Appliance appliance = new Appliance();
        appliance.setCountry(hooverDto.getCountry());
        appliance.setManufacturer(hooverDto.getManufacturer());
        appliance.setOnline(hooverDto.isOnline());
        appliance.setInstalment(hooverDto.isInstalment());
        appliance.setModels(hooverDto.getModels()
                .stream()
                .map(HooverFromDtoMapper::fromModelDto)
                .collect(Collectors.toList()));
        return appliance;
    }

    private static Model fromModelDto(HooverModelDto hooverModelDto) {
        Model model = new Model();
        model.setName(hooverModelDto.getName());
        model.setSerialNumber(hooverModelDto.getSerialNumber());
        model.setColor(hooverModelDto.getColor());
        model.setSize(hooverModelDto.getSize());
        model.setPrice(hooverModelDto.getPrice());
        model.setAvailable(hooverModelDto.isAvailable());
        model.setVolume(hooverModelDto.getVolume());
        model.setMode(hooverModelDto.getMode());
        return model;
    }
}
