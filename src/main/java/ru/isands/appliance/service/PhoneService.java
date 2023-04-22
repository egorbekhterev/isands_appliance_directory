package ru.isands.appliance.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.isands.appliance.domain.Phone;
import ru.isands.appliance.repository.PhoneRepository;

import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Service
@AllArgsConstructor
public class PhoneService {

    private PhoneRepository phoneRepository;

    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }
}
