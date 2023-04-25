package ru.isands.appliance.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.isands.appliance.dto.ApplianceDto;
import ru.isands.appliance.dto.ModelDto;
import ru.isands.appliance.service.ApplianceService;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@RestController
@AllArgsConstructor
@Tag(name = "Вся техника", description = "Контроллер для работы с техникой")
public class ApplianceController {

    private static final String NOT_FOUND = "Техника не найдена, проверьте вводимую информацию";

    private ApplianceService applianceService;

    @GetMapping
    @Operation(summary = "Получить список всей техники")
    public ResponseEntity<List<ApplianceDto>> findAll() {
        return new ResponseEntity<>(applianceService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/name")
    @Operation(summary = "Получить список всей техники по наименованию")
    public ResponseEntity<List<ModelDto>> findByName(@RequestParam String name) {
        List<ModelDto> list = applianceService.findAllByNameIgnoreCase(name);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/color")
    @Operation(summary = "Получить список всей техники по цвету")
    public ResponseEntity<List<ModelDto>> findByColor(@RequestParam String color) {
        List<ModelDto> list = applianceService.findByColorIgnoreCase(color);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/price")
    @Operation(summary = "Получить список всей техники по цене от/до")
    public ResponseEntity<List<ModelDto>> findByPrice(
            @RequestParam(required = false, defaultValue = "0") BigDecimal min,
            @RequestParam(required = false, defaultValue = "1000000") BigDecimal max) {
        List<ModelDto> list = applianceService.findAllByPriceBetween(min, max);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("priceAsc")
    @Operation(summary = "Получить список всей техники по возрастанию цены")
    public ResponseEntity<List<ModelDto>> findAllSortByPriceAsc() {
        return new ResponseEntity<>(applianceService.findAllSortByPriceAsc(), HttpStatus.OK);
    }

    @GetMapping("priceDesc")
    @Operation(summary = "Получить список всей техники по убыванию цены")
    public ResponseEntity<List<ModelDto>> findAllSortByPriceDesc() {
        return new ResponseEntity<>(applianceService.findAllSortByPriceDesc(), HttpStatus.OK);
    }

    @GetMapping("nameAsc")
    @Operation(summary = "Получить список всей техники, используя алфавитную сортировку по возрастанию")
    public ResponseEntity<List<ModelDto>> findAllSortByNameAsc() {
        return new ResponseEntity<>(applianceService.findAllSortByNameAsc(), HttpStatus.OK);
    }

    @GetMapping("nameDesc")
    @Operation(summary = "Получить список всей техники, используя алфавитную сортировку по убыванию")
    public ResponseEntity<List<ModelDto>> findAllSortByNameDesc() {
        return new ResponseEntity<>(applianceService.findAllSortByNameDesc(), HttpStatus.OK);
    }
}
