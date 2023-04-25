package ru.isands.appliance.service;

import ru.isands.appliance.dto.ModelDto;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 25.04.2023
 * @project: isands_appliance_directory
 */
public interface ApplianceModelService<T extends ModelDto> {

    List<ModelDto> findAllBySerialNumberIgnoreCase(String serialNumber);

    List<ModelDto> findAllByNameIgnoreCase(String name);

    List<ModelDto> findAllByColorIgnoreCase(String color);

    List<ModelDto> findAllBySizeIgnoreCase(BigDecimal size);

    List<ModelDto> findAllByPriceIgnoreCase(BigDecimal price);

    List<ModelDto> findAllByAvailable();
}
