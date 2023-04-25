package ru.isands.appliance.dto.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.isands.appliance.dto.ModelAbstractDto;

import javax.validation.constraints.NotBlank;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
@Data
@Schema(description = "DTO для моделей ПК")
public class ComputerModelDto extends ModelAbstractDto {

    @Schema(description = "Категория")
    @NotBlank
    private String category;

    @Schema(description = "Модель процессора")
    @NotBlank
    private String processor;
}
