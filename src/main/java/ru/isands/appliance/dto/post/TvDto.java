package ru.isands.appliance.dto.post;

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
public class TvDto extends ApplianceAbstractDto {

    @Valid
    private List<TvModelDto> models;
}
