package ru.isands.appliance.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.isands.appliance.domain.Appliance;
import ru.isands.appliance.domain.Model;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
public interface ComputerRepository extends CrudRepository<Appliance, Integer>, ApplianceModelRepository<Model> {

    @Query("SELECT a FROM Appliance a WHERE a.name = 'ПК'")
    List<Appliance> findAll();

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a WHERE a.name = 'ПК' AND LOWER(m.name) = LOWER(:name)")
    @Override
    List<Model> findAllByNameIgnoreCase(String name);

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a WHERE a.name = 'ПК' "
            + "AND LOWER(m.serialNumber) = LOWER(:serialNumber)")
    @Override
    List<Model> findAllBySerialNumberIgnoreCase(String serialNumber);

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a WHERE a.name = 'ПК' "
            + "AND LOWER(m.color) = LOWER(:color)")
    @Override
    List<Model> findAllByColorIgnoreCase(String color);

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a WHERE a.name = 'ПК' AND m.size = :size")
    @Override
    List<Model> findAllBySizeIgnoreCase(BigDecimal size);

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a WHERE a.name = 'ПК' AND m.price = :price")
    @Override
    List<Model> findAllByPriceIgnoreCase(BigDecimal price);

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a WHERE a.name = 'ПК' AND m.available = true")
    @Override
    List<Model> findAllByAvailable();

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a WHERE a.name = 'ПК' "
            + "AND LOWER(m.category) = LOWER(:category)")
    List<Model> findAllByCategoryIgnoreCase(String category);

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a WHERE a.name = 'ПК' "
            + "AND LOWER(m.processor) = LOWER(:processor)")
    List<Model> findAllByProcessorIgnoreCase(String processor);
}
