package ru.isands.appliance.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.isands.appliance.dto.PhoneDTO;
import ru.isands.appliance.dto.model.PhoneModelDTO;
import ru.isands.appliance.mapper.PhoneDtoMapper;
import ru.isands.appliance.mapper.PhoneModelDtoMapper;
import ru.isands.appliance.repository.PhoneRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Service
@AllArgsConstructor
public class PhoneService {

    private PhoneRepository phoneRepository;

    public List<PhoneDTO> findAll() {
        return phoneRepository.findAll()
                .stream()
                .map(PhoneDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<PhoneDTO> findByColor(String color) {
        return phoneRepository.findByColor(color)
              .stream()
              .map(PhoneDtoMapper::toDto)
              .collect(Collectors.toList());
    }

    public List<PhoneModelDTO> findAllSortPriceAsc() {
        return phoneRepository.findAllSortByPriceAsc()
                .stream()
                .map(PhoneModelDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }
}
