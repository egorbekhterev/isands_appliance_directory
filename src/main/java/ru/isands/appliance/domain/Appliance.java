package ru.isands.appliance.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author: Egor Bekhterev
 * @date: 21.04.2023
 * @project: isands_appliance_directory
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Schema(description = "Абстрактный класс с общими атрибутами для доменных моделей")
@MappedSuperclass
public abstract class Appliance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Schema(description = "Идентификатор")
    private int id;

    @Schema(description = "Наименование")
    private String name;

    @Schema(description = "Страна производитель")
    private String country;

    @Schema(description = "Фирма производитель")
    private String manufacturer;

    @Schema(description = "Возможность заказа онлайн")
    private boolean online;

    @Schema(description = "Возможность оформления рассрочки")
    private boolean instalment;
}
