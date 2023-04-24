package ru.isands.appliance.mapper.post;

import ru.isands.appliance.domain.Appliance;
import ru.isands.appliance.domain.Model;
import ru.isands.appliance.dto.post.TvDto;
import ru.isands.appliance.dto.post.TvModelDto;

import java.util.stream.Collectors;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
public class TvFromDtoMapper {

    public static Appliance fromDto(TvDto tvDto) {
        Appliance appliance = new Appliance();
        appliance.setCountry(tvDto.getCountry());
        appliance.setManufacturer(tvDto.getManufacturer());
        appliance.setOnline(tvDto.isOnline());
        appliance.setInstalment(tvDto.isInstalment());
        appliance.setModels(tvDto.getModels()
                .stream()
                .map(TvFromDtoMapper::fromModelDto)
                .collect(Collectors.toList()));
        return appliance;
    }

    private static Model fromModelDto(TvModelDto tvModelDto) {
        Model model = new Model();
        model.setName(tvModelDto.getName());
        model.setSerialNumber(tvModelDto.getSerialNumber());
        model.setColor(tvModelDto.getColor());
        model.setSize(tvModelDto.getSize());
        model.setPrice(tvModelDto.getPrice());
        model.setAvailable(tvModelDto.isAvailable());
        model.setCategory(tvModelDto.getCategory());
        model.setTechnology(tvModelDto.getTechnology());
        return model;
    }
}
