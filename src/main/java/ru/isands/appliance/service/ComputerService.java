package ru.isands.appliance.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.appliance.domain.Appliance;
import ru.isands.appliance.dto.ApplianceDto;
import ru.isands.appliance.dto.ModelDto;
import ru.isands.appliance.dto.post.ComputerDto;
import ru.isands.appliance.mapper.ApplianceToDtoMapper;
import ru.isands.appliance.mapper.ModelToDtoMapper;
import ru.isands.appliance.mapper.post.ComputerFromDtoMapper;
import ru.isands.appliance.repository.ComputerRepository;

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
public class ComputerService implements ApplianceModelService<ModelDto> {

    private ComputerRepository computerRepository;

    public List<ApplianceDto> findAll() {
        return computerRepository.findAll()
                .stream()
                .map(ApplianceToDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ComputerDto save(ComputerDto computerDto) {
        Appliance rsl = ComputerFromDtoMapper.fromDto(computerDto);
        rsl.setName("ПК");
        computerRepository.save(rsl);
        return computerDto;
    }

    @Override
    public List<ModelDto> findAllBySerialNumberIgnoreCase(String serialNumber) {
        return computerRepository.findAllBySerialNumberIgnoreCase(serialNumber)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllByNameIgnoreCase(String name) {
        return computerRepository.findAllByNameIgnoreCase(name)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllByColorIgnoreCase(String color) {
        return computerRepository.findAllByColorIgnoreCase(color)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllBySizeIgnoreCase(BigDecimal size) {
        return computerRepository.findAllBySizeIgnoreCase(size)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllByPriceIgnoreCase(BigDecimal price) {
        return computerRepository.findAllByPriceIgnoreCase(price)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllByAvailable() {
        return computerRepository.findAllByAvailable()
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllByCategoryIgnoreCase(String category) {
        return computerRepository.findAllByCategoryIgnoreCase(category)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllByProcessorIgnoreCase(String processor) {
        return computerRepository.findAllByProcessorIgnoreCase(processor)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }
}
