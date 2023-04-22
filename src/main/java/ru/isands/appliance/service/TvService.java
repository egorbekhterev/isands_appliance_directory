package ru.isands.appliance.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.isands.appliance.domain.TV;
import ru.isands.appliance.repository.TvRepository;

import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Service
@AllArgsConstructor
public class TvService {

    private TvRepository tvRepository;

    public List<TV> findAll() {
        return tvRepository.findAll();
    }
}
