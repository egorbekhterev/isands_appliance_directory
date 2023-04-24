package ru.isands.appliance.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ApplianceDto extends ApplianceAbstractDto {

    @Schema(description = "Наименование")
    private String name;

    @Schema(description = "Список DTO моделей для типов техники")
    private List<ModelDto> models;
}
