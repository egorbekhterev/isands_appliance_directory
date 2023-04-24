package ru.isands.appliance.dto.post;

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

    @NotBlank
    private String category;

    @NotBlank
    private String technology;
}
