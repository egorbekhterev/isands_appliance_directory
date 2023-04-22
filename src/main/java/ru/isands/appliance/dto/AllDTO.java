package ru.isands.appliance.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.isands.appliance.dto.model.AllModelDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Data
public class AllDTO extends ApplianceDTO {

    @Schema(description = "Модели в наличии")
    private List<AllModelDTO> models = new ArrayList<>();
}
