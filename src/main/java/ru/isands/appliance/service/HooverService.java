package ru.isands.appliance.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.appliance.domain.Appliance;
import ru.isands.appliance.dto.ApplianceDto;
import ru.isands.appliance.dto.ModelDto;
import ru.isands.appliance.dto.post.HooverDto;
import ru.isands.appliance.mapper.ApplianceToDtoMapper;
import ru.isands.appliance.mapper.ModelToDtoMapper;
import ru.isands.appliance.mapper.post.HooverFromDtoMapper;
import ru.isands.appliance.repository.HooverRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
@Service
@AllArgsConstructor
public class HooverService implements ApplianceModelService<ModelDto> {

    private HooverRepository hooverRepository;

    public List<ApplianceDto> findAll() {
        return hooverRepository.findAll()
                .stream()
                .map(ApplianceToDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public HooverDto save(HooverDto hooverDto) {
        Appliance rsl = HooverFromDtoMapper.fromDto(hooverDto);
        rsl.setName("Пылесос");
        hooverRepository.save(rsl);
        return hooverDto;
    }

    @Override
    public List<ModelDto> findAllBySerialNumberIgnoreCase(String serialNumber) {
        return hooverRepository.findAllBySerialNumberIgnoreCase(serialNumber)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllByNameIgnoreCase(String name) {
        return hooverRepository.findAllByNameIgnoreCase(name)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllByColorIgnoreCase(String color) {
        return hooverRepository.findAllByColorIgnoreCase(color)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllBySizeIgnoreCase(BigDecimal size) {
        return hooverRepository.findAllBySizeIgnoreCase(size)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllByPriceIgnoreCase(BigDecimal price) {
        return hooverRepository.findAllByPriceIgnoreCase(price)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllByAvailable() {
        return hooverRepository.findAllByAvailable()
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllByVolume(BigDecimal volume) {
        return hooverRepository.findAllByVolume(volume)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllByMode(int mode) {
        return hooverRepository.findAllByMode(mode)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }
}
