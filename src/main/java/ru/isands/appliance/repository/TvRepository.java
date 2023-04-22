package ru.isands.appliance.repository;

import org.springframework.data.repository.CrudRepository;
import ru.isands.appliance.domain.TV;

import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
public interface TvRepository extends CrudRepository<TV, Integer> {

    List<TV> findAll();
}
