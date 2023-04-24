package ru.isands.appliance.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.isands.appliance.dto.ApplianceDto;
import ru.isands.appliance.dto.ModelDto;
import ru.isands.appliance.service.ApplianceService;

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

    private ApplianceService applianceService;

    @GetMapping
    @Operation(summary = "Получить список всей техники")
    public ResponseEntity<List<ApplianceDto>> findAll() {
        return new ResponseEntity<>(applianceService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/color/{color}")
    @Operation(summary = "Получить список всей техники по цвету")
    public ResponseEntity<List<ModelDto>> findByColor(@RequestParam String color) {
        List<ModelDto> all = applianceService.findByColor(color);

        if (all.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(all, HttpStatus.OK);
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
