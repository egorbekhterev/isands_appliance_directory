package ru.isands.appliance.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.isands.appliance.domain.Appliance;

import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
public interface TvRepository extends CrudRepository<Appliance, Integer> {

    @Query("SELECT a FROM Appliance a WHERE a.name = 'Телевизор'")
    List<Appliance> findAllTv();
}
