package ru.isands.appliance.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.appliance.domain.Appliance;
import ru.isands.appliance.dto.ApplianceDto;
import ru.isands.appliance.dto.post.TvDto;
import ru.isands.appliance.mapper.ApplianceToDtoMapper;
import ru.isands.appliance.mapper.post.TvFromDtoMapper;
import ru.isands.appliance.repository.TvRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
@Service
@AllArgsConstructor
public class TvService {

    private TvRepository tvRepository;

    public List<ApplianceDto> findAllTv() {
        return tvRepository.findAllTv()
                .stream()
                .map(ApplianceToDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public TvDto save(TvDto tvDto) {
        Appliance rsl = TvFromDtoMapper.fromDto(tvDto);
        rsl.setName("Телевизор");
        tvRepository.save(rsl);
        return tvDto;
    }
}
