package ru.isands.appliance.dto.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.isands.appliance.dto.ModelAbstractDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
@Data
@Schema(description = "DTO для моделей смартфонов")
public class PhoneModelDto extends ModelAbstractDto {

    @Schema(description = "Память")
    @NotNull
    @Positive
    private Integer memory;

    @Schema(description = "Количество камер")
    @NotNull
    @Positive
    private Integer camera;
}
