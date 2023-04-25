package ru.isands.appliance.dto.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.isands.appliance.dto.ModelAbstractDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
@Data
@Schema(description = "DTO для моделей пылесосов")
public class HooverModelDto extends ModelAbstractDto {

    @Schema(description = "Объем пылесборника")
    @NotNull
    @Positive
    private BigDecimal volume;

    @Schema(description = "Количество режимов")
    @NotNull
    @Positive
    private Integer mode;
}
