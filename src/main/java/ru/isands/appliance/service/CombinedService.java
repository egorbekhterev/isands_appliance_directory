package ru.isands.appliance.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.isands.appliance.dto.AllDTO;
import ru.isands.appliance.dto.PhoneDTO;
import ru.isands.appliance.dto.TvDTO;
import ru.isands.appliance.mapper.AllDtoMapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Service
@AllArgsConstructor
public class CombinedService {

    private PhoneService phoneService;

    private TvService tvService;

    public List<AllDTO> findAll() {
        List<PhoneDTO> phones = phoneService.findAll();
        List<TvDTO> tvs = tvService.findAll();

        return Stream
                .concat(phones.stream(), tvs.stream())
                .map(AllDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<AllDTO> findByColor(String color) {
        List<PhoneDTO> phones = phoneService.findByColor(color);
        List<TvDTO> tvs = tvService.findByColor(color);

        return Stream
                .concat(phones.stream(), tvs.stream())
                .map(AllDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
