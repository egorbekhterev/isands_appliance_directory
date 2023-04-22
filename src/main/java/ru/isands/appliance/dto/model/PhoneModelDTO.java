package ru.isands.appliance.dto.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Data
@Schema(description = "DTO для моделей смартфонов")
public class PhoneModelDTO extends ModelDTO {

    @Schema(description = "Память")
    private int memory;

    @Schema(description = "Количество камер")
    private int camera;
}
