package ru.isands.appliance.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
@Data
@Schema(description = "Абстрактный класс с общими атрибутами для DTO техники")
public abstract class ApplianceAbstractDto {

    @Schema(description = "Страна производитель")
    @NotBlank
    private String country;

    @Schema(description = "Фирма производитель")
    @NotBlank
    private String manufacturer;

    @Schema(description = "Возможность заказа онлайн")
    private boolean online;

    @Schema(description = "Возможность оформления рассрочки")
    private boolean instalment;
}
