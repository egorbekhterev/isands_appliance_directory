package ru.isands.appliance.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Data
@Schema(description = "Абстрактный класс с общими атрибутами для DTO техники")
public abstract class ApplianceDTO {

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
