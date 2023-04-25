package ru.isands.appliance.repository;

import ru.isands.appliance.domain.Model;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 25.04.2023
 * @project: isands_appliance_directory
 */
public interface ApplianceModelRepository<T extends Model> {

    List<T> findAllByNameIgnoreCase(String name);

    List<T> findAllBySerialNumberIgnoreCase(String serialNumber);

    List<T> findAllByColorIgnoreCase(String color);

    List<T> findAllBySizeIgnoreCase(BigDecimal size);

    List<T> findAllByPriceIgnoreCase(BigDecimal price);

    List<T> findAllByAvailable();
}
