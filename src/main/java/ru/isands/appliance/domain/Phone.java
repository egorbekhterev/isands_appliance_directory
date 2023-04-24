package ru.isands.appliance.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.isands.appliance.domain.model.PhoneModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Data
@Entity
@Schema(description = "Доменная модель для сущности Phone")
@Table(name = "phone")
public class Phone extends Appliance {

    @OneToMany(orphanRemoval = true, mappedBy = "phone")
    @Schema(description = "Модели смартфонов в наличии")
    private List<PhoneModel> models = new ArrayList<>();
}
