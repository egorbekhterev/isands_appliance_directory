package ru.isands.appliance.dto.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Schema(description = "DTO модель с общими атрибутами для моделей различных видов техники")
public class AllModelDTO extends ModelDTO {

    @Schema(description = "Категория")
    private String category;

    @Schema(description = "Технология")
    private String technology;

    @Schema(description = "Память")
    private int memory;

    @Schema(description = "Количество камер")
    private int camera;
}
