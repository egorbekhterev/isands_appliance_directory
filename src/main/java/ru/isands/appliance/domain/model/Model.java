package ru.isands.appliance.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Schema(description = "Абстрактный класс с общими атрибутами для моделей различных видов техники")
@MappedSuperclass
public abstract class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Schema(description = "Идентификатор")
    private int id;

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
