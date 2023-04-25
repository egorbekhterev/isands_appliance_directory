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
public interface ApplianceRepository extends CrudRepository<Appliance, Integer> {

    List<Appliance> findAll();

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a WHERE LOWER(m.color) = LOWER(:color)")
    List<Model> findByColorIgnoreCase(String color);

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a ORDER BY m.price")
    List<Model> findAllSortByPriceAsc();

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a ORDER BY m.price DESC")
    List<Model> findAllSortByPriceDesc();

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a ORDER BY m.name")
    List<Model> findAllSortByNameAsc();

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a ORDER BY m.name DESC")
    List<Model> findAllSortByNameDesc();

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a WHERE LOWER(m.name) = LOWER(:name)")
    List<Model> findAllByNameIgnoreCase(String name);

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a WHERE m.price BETWEEN :min AND :max ORDER BY m.price")
    List<Model> findAllByPriceBetween(BigDecimal min, BigDecimal max);
}
