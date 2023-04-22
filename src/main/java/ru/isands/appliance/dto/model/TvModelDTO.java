package ru.isands.appliance.dto.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Data
@Schema(description = "DTO для моделей телевизоров")
public class TvModelDTO extends ModelDTO {

    @Schema(description = "Категория")
    private String category;

    @Schema(description = "Технология")
    private String technology;
}
