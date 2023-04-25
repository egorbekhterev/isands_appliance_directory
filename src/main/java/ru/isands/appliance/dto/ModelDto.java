package ru.isands.appliance.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;


/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Schema(description = "Класс с общими атрибутами для DTO моделей различных видов техники")
public class ModelDto extends ModelAbstractDto {

    @Nullable
    @Schema(description = "Категория")
    private String category;

    @Nullable
    @Schema(description = "Технология")
    private String technology;

    @Nullable
    @Schema(description = "Память(GB)")
    private Integer memory;

    @Nullable
    @Schema(description = "Количество камер")
    private Integer camera;

    @Nullable
    @Schema(description = "Объем пылесборника")
    private BigDecimal volume;

    @Nullable
    @Schema(description = "Количество режимов")
    private Integer mode;

    @Nullable
    @Schema(description = "Количество дверей")
    private Integer door;

    @Nullable
    @Schema(description = "Тип компрессора")
    private String compressor;

    @Nullable
    @Schema(description = "Модель процессора")
    private String processor;

    @Schema(description = "DTO тип техники, соответствующий данной модели")
    private ApplianceDto appliance;
}
