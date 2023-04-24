package ru.isands.appliance.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.isands.appliance.domain.model.TvModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 21.04.2023
 * @project: isands_appliance_directory
 */
@Data
@Entity
@Schema(description = "Доменная модель для сущности TV")
@Table(name = "tv")
public class TV extends Appliance {

    @OneToMany(orphanRemoval = true, mappedBy = "tv")
    @Schema(description = "Модели телевизоров в наличии")
    private List<TvModel> models = new ArrayList<>();
}
