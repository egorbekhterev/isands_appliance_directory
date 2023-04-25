package ru.isands.appliance.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.appliance.domain.Appliance;
import ru.isands.appliance.dto.ApplianceDto;
import ru.isands.appliance.dto.ModelDto;
import ru.isands.appliance.dto.post.FridgeDto;
import ru.isands.appliance.mapper.ApplianceToDtoMapper;
import ru.isands.appliance.mapper.ModelToDtoMapper;
import ru.isands.appliance.mapper.post.FridgeFromDtoMapper;
import ru.isands.appliance.repository.FridgeRepository;

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
public class FridgeService implements ApplianceModelService<ModelDto> {

    private FridgeRepository fridgeRepository;

    public List<ApplianceDto> findAll() {
        return fridgeRepository.findAll()
                .stream()
                .map(ApplianceToDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public FridgeDto save(FridgeDto fridgeDto) {
        Appliance rsl = FridgeFromDtoMapper.fromDto(fridgeDto);
        rsl.setName("Холодильник");
        fridgeRepository.save(rsl);
        return fridgeDto;
    }

    @Override
    public List<ModelDto> findAllBySerialNumberIgnoreCase(String serialNumber) {
        return fridgeRepository.findAllBySerialNumberIgnoreCase(serialNumber)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllByNameIgnoreCase(String name) {
        return fridgeRepository.findAllByNameIgnoreCase(name)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllByColorIgnoreCase(String color) {
        return fridgeRepository.findAllByColorIgnoreCase(color)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllBySizeIgnoreCase(BigDecimal size) {
        return fridgeRepository.findAllBySizeIgnoreCase(size)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllByPriceIgnoreCase(BigDecimal price) {
        return fridgeRepository.findAllByPriceIgnoreCase(price)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllByAvailable() {
        return fridgeRepository.findAllByAvailable()
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllByDoor(int door) {
        return fridgeRepository.findAllByDoor(door)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllByCompressorIgnoreCase(String compressor) {
        return fridgeRepository.findAllByCompressorIgnoreCase(compressor)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }
}
