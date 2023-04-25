package ru.isands.appliance.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.appliance.domain.Appliance;
import ru.isands.appliance.dto.ApplianceDto;
import ru.isands.appliance.dto.ModelDto;
import ru.isands.appliance.dto.post.PhoneDto;
import ru.isands.appliance.mapper.ApplianceToDtoMapper;
import ru.isands.appliance.mapper.ModelToDtoMapper;
import ru.isands.appliance.mapper.post.PhoneFromDtoMapper;
import ru.isands.appliance.repository.PhoneRepository;

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
public class PhoneService {

    private PhoneRepository phoneRepository;

    public List<ApplianceDto> findAll() {
        return phoneRepository.findAll()
                .stream()
                .map(ApplianceToDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public PhoneDto save(PhoneDto phoneDto) {
        Appliance rsl = PhoneFromDtoMapper.fromDto(phoneDto);
        rsl.setName("Смартфон");
        phoneRepository.save(rsl);
        return phoneDto;
    }

    public List<ModelDto> findAllBySerialNumberIgnoreCase(String serialNumber) {
        return phoneRepository.findAllBySerialNumberIgnoreCase(serialNumber)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllByNameIgnoreCase(String name) {
        return phoneRepository.findAllByNameIgnoreCase(name)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllByColorIgnoreCase(String color) {
        return phoneRepository.findAllByColorIgnoreCase(color)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllBySizeIgnoreCase(BigDecimal size) {
        return phoneRepository.findAllBySizeIgnoreCase(size)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllByPriceIgnoreCase(BigDecimal price) {
        return phoneRepository.findAllByPriceIgnoreCase(price)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllByAvailable() {
        return phoneRepository.findAllByAvailable()
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllByMemory(int memory) {
        return phoneRepository.findAllByMemory(memory)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllByCamera(int camera) {
        return phoneRepository.findAllByCamera(camera)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }
}
