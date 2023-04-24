package ru.isands.appliance.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.isands.appliance.domain.Appliance;
import ru.isands.appliance.domain.Model;

import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
public interface ApplianceRepository extends CrudRepository<Appliance, Integer> {

    List<Appliance> findAll(Pageable pageable);

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a WHERE LOWER(m.color) = LOWER(:color)")
    List<Model> findByColor(String color);

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a ORDER BY m.price")
    List<Model> findAllSortByPriceAsc(Pageable pageable);

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a ORDER BY m.price DESC")
    List<Model> findAllSortByPriceDesc(Pageable pageable);

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a ORDER BY m.name")
    List<Model> findAllSortByNameAsc(Pageable pageable);

    @Query("SELECT m FROM Model m JOIN FETCH m.appliance a ORDER BY m.name DESC")
    List<Model> findAllSortByNameDesc(Pageable pageable);
}
