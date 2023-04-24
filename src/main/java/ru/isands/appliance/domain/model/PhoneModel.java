package ru.isands.appliance.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.isands.appliance.domain.Phone;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Data
@Entity
@Table(name = "phone_model")
@Schema(description = "Доменная модель для моделей смартфонов")
public class PhoneModel extends Model {

    @Schema(description = "Память")
    private int memory;

    @Schema(description = "Количество камер")
    private int camera;

    @ManyToOne
    @JoinColumn(name = "phone_id", nullable = false)
    private Phone phone;
}
