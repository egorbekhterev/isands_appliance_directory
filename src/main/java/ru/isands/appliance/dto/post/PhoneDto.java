package ru.isands.appliance.dto.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.isands.appliance.dto.ApplianceAbstractDto;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
@Data
public class PhoneDto extends ApplianceAbstractDto {

    @Valid
    @Schema(description = "Список DTO моделей для смартфонов")
    private List<PhoneModelDto> models;
}
