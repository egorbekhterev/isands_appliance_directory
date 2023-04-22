package ru.isands.appliance.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author: Egor Bekhterev
 * @date: 21.04.2023
 * @project: isands_appliance_directory
 */
@Data
@Entity
@Table(name = "tv_model")
@Schema(description = "Доменная модель для моделей телевизоров")
public class TvModel extends Model {

    @Schema(description = "Категория")
    private String category;

    @Schema(description = "Технология")
    private String technology;
}
