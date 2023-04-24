package ru.isands.appliance.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isands.appliance.dto.ApplianceDto;
import ru.isands.appliance.dto.post.TvDto;
import ru.isands.appliance.service.TvService;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
@RestController
@AllArgsConstructor
@RequestMapping("/tv")
@Tag(name = "Телевизоры", description = "Контроллер для работы с техникой")
public class TvController {

    private TvService tvService;

    @GetMapping
    @Operation(summary = "Получить список всех телевизоров")
    public ResponseEntity<List<ApplianceDto>> findAll() {
        return new ResponseEntity<>(tvService.findAllTv(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Добавить телевизор в реестр")
    public ResponseEntity<TvDto> save(@Valid @RequestBody TvDto tvDto) {
        return new ResponseEntity<>(tvService.save(tvDto), HttpStatus.OK);
    }
}
