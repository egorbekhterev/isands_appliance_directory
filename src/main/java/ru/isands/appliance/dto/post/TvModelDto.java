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
public class TvModelDto extends ModelAbstractDto {

    @Schema(description = "Категория")
    @NotBlank
    private String category;

    @Schema(description = "Технология")
    @NotBlank
    private String technology;
}
