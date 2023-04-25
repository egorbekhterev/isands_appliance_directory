package ru.isands.appliance.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
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

    @Positive
    @Schema(description = "Размер (диагональ, inch/длина сетевого шнура, м/полезный объем, л/объем SSD, Gb)")
    private BigDecimal size;

    @Positive
    @Schema(description = "Цена")
    private BigDecimal price;

    @Schema(description = "Наличие товара")
    private boolean available;
}
