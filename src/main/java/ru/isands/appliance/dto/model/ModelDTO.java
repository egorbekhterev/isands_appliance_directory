package ru.isands.appliance.dto.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Data
@Schema(description = "Абстрактный класс с общими атрибутами для DTO моделей различных видов техники")
public abstract class ModelDTO {

    @Schema(description = "Наименование")
    private String name;

    @Column(name = "serial_number")
    @Schema(description = "Серийный номер")
    private String serialNumber;

    @Schema(description = "Цвет")
    private String color;

    @Schema(description = "Размер (диагональ/")
    private BigDecimal size;

    @Schema(description = "Цена")
    private BigDecimal price;

    @Schema(description = "Наличие товара")
    private boolean available;
}
