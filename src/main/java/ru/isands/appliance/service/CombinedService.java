package ru.isands.appliance.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.isands.appliance.domain.Appliance;
import ru.isands.appliance.repository.CombinedRepository;

import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Service
@AllArgsConstructor
public class CombinedService {

    private CombinedRepository combinedRepository;

    public List<Appliance> findAll() {
        return combinedRepository.findAllWithModels();
    }
}
