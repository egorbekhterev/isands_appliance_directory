package ru.isands.appliance.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.isands.appliance.domain.Appliance;
import ru.isands.appliance.dto.ApplianceDto;
import ru.isands.appliance.dto.ModelDto;
import ru.isands.appliance.dto.post.TvDto;
import ru.isands.appliance.mapper.ApplianceToDtoMapper;
import ru.isands.appliance.mapper.ModelToDtoMapper;
import ru.isands.appliance.mapper.post.TvFromDtoMapper;
import ru.isands.appliance.repository.TvRepository;

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
public class TvService implements ApplianceModelService<ModelDto> {

    private TvRepository tvRepository;

    public List<ApplianceDto> findAll() {
        return tvRepository.findAll()
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

    @Override
    public List<ModelDto> findAllBySerialNumberIgnoreCase(String serialNumber) {
        return tvRepository.findAllBySerialNumberIgnoreCase(serialNumber)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllByNameIgnoreCase(String name) {
        return tvRepository.findAllByNameIgnoreCase(name)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllByColorIgnoreCase(String color) {
        return tvRepository.findAllByColorIgnoreCase(color)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllBySizeIgnoreCase(BigDecimal size) {
        return tvRepository.findAllBySizeIgnoreCase(size)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllByPriceIgnoreCase(BigDecimal price) {
        return tvRepository.findAllByPriceIgnoreCase(price)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelDto> findAllByAvailable() {
        return tvRepository.findAllByAvailable()
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllByCategoryIgnoreCase(String category) {
        return tvRepository.findAllByCategoryIgnoreCase(category)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }

    public List<ModelDto> findAllByTechnologyIgnoreCase(String technology) {
        return tvRepository.findAllByTechnologyIgnoreCase(technology)
                .stream()
                .map(ModelToDtoMapper::toModelDto)
                .collect(Collectors.toList());
    }
}
