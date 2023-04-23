package ru.isands.appliance.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import ru.isands.appliance.domain.Phone;

import javax.persistence.QueryHint;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
public interface PhoneRepository extends CrudRepository<Phone, Integer> {

    List<Phone> findAll();

    @Query("SELECT p FROM Phone p JOIN FETCH p.models m ORDER BY m.price ASC")
    List<Phone> findAllSortAsc();

    @Query("SELECT DISTINCT p FROM Phone p JOIN FETCH p.models m WHERE LOWER(m.color) = LOWER(:color)")
    @QueryHints(value = @QueryHint(name = "org.hibernate.annotations.QueryHints.PASS_DISTINCT_THROUGH", value = "false"))
    List<Phone> findByColor(String color);
}
