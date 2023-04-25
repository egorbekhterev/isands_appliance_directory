package ru.isands.appliance.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
@Data
@Schema(description = "Абстрактный класс с общими атрибутами для DTO моделей различных видов техники")
public abstract class ModelAbstractDto {

    @NotBlank
    @Schema(description = "Наименование")
    private String name;

    @Column(name = "serial_number")
    @NotBlank
    @Schema(description = "Серийный номер")
    private String serialNumber;

    @NotBlank
    @Schema(description = "Цвет")
    private String color;

    @Schema(description = "Размер (диагональ/длина сетевого шнура/)")
    private BigDecimal size;

    @Schema(description = "Цена")
    private BigDecimal price;

    @Schema(description = "Наличие товара")
    private boolean available;
}
