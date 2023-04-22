package ru.isands.appliance.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.isands.appliance.domain.Appliance;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@NoRepositoryBean
public interface CombinedRepository extends CrudRepository<Appliance, Integer> {

    @Query("SELECT a FROM Appliance a LEFT JOIN FETCH a.models m WHERE TYPE(a) IN (TV, Phone)")
    List<Appliance> findAllWithModels();
}
