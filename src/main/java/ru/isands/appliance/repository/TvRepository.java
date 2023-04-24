package ru.isands.appliance.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import ru.isands.appliance.domain.TV;
import ru.isands.appliance.domain.model.TvModel;

import javax.persistence.QueryHint;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
public interface TvRepository extends CrudRepository<TV, Integer> {

    List<TV> findAll();

    @Query("SELECT m FROM TvModel m JOIN FETCH m.tv t ORDER BY m.price ASC")
    List<TvModel> findAllSortByPriceAsc();

    @Query("SELECT DISTINCT t FROM TV t JOIN FETCH t.models m WHERE LOWER(m.color) = LOWER(:color)")
    @QueryHints(value = @QueryHint(name = "org.hibernate.annotations.QueryHints.PASS_DISTINCT_THROUGH", value = "false"))
    List<TV> findByColor(String color);
}
