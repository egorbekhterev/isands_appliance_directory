package ru.isands.appliance.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.isands.appliance.dto.TvDTO;
import ru.isands.appliance.mapper.TvDtoMapper;
import ru.isands.appliance.repository.TvRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Service
@AllArgsConstructor
public class TvService {

    private TvRepository tvRepository;

    public List<TvDTO> findAll() {
        return tvRepository.findAll()
                .stream()
                .map(TvDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<TvDTO> findByColor(String color) {
        return tvRepository.findByColor(color)
                .stream()
                .map(TvDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
