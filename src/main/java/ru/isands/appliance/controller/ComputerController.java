package ru.isands.appliance.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.isands.appliance.dto.ApplianceDto;
import ru.isands.appliance.dto.ModelDto;
import ru.isands.appliance.dto.post.ComputerDto;
import ru.isands.appliance.service.ComputerService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
@RestController
@AllArgsConstructor
@RequestMapping("/computer")
@Tag(name = "ПК", description = "Контроллер для работы с ПК")
public class ComputerController {

    private static final String NOT_FOUND = "ПК не найдены, проверьте вводимую информацию";

    private ComputerService computerService;

    @GetMapping
    @Operation(summary = "Получить список всех ПК")
    public ResponseEntity<List<ApplianceDto>> findAll() {
        return new ResponseEntity<>(computerService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Добавить ПК в реестр")
    public ResponseEntity<ComputerDto> save(@Valid @RequestBody ComputerDto computerDto) {
        return new ResponseEntity<>(computerService.save(computerDto), HttpStatus.OK);
    }

    @GetMapping("/name")
    @Operation(summary = "Получить список ПК по наименованию")
    public ResponseEntity<List<ModelDto>> findAllByName(@RequestParam String name) {
        List<ModelDto> list = computerService.findAllByNameIgnoreCase(name);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/serialNumber")
    @Operation(summary = "Получить список ПК по серийному номеру")
    public ResponseEntity<List<ModelDto>> findAllBySerialNumber(@RequestParam String serialNumber) {
        List<ModelDto> list = computerService.findAllBySerialNumberIgnoreCase(serialNumber);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/color")
    @Operation(summary = "Получить список ПК по цвету")
    public ResponseEntity<List<ModelDto>> findAllByColor(@RequestParam String color) {
        List<ModelDto> list = computerService.findAllByColorIgnoreCase(color);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/size")
    @Operation(summary = "Получить список ПК по размеру")
    public ResponseEntity<List<ModelDto>> findAllBySize(@Positive @RequestParam BigDecimal size) {
        List<ModelDto> list = computerService.findAllBySizeIgnoreCase(size);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/price")
    @Operation(summary = "Получить список ПК по цене")
    public ResponseEntity<List<ModelDto>> findAllByPrice(@Positive @RequestParam BigDecimal price) {
        List<ModelDto> list = computerService.findAllByPriceIgnoreCase(price);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/available")
    @Operation(summary = "Получить список ПК по наличию")
    public ResponseEntity<List<ModelDto>> findAllByAvailable() {
        List<ModelDto> list = computerService.findAllByAvailable();

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/category")
    @Operation(summary = "Получить список ПК по категории")
    public ResponseEntity<List<ModelDto>> findAllByCategory(@RequestParam String category) {
        List<ModelDto> list = computerService.findAllByCategoryIgnoreCase(category);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/technology")
    @Operation(summary = "Получить список ПК по технологии")
    public ResponseEntity<List<ModelDto>> findAllByProcessor(@RequestParam String processor) {
        List<ModelDto> list = computerService.findAllByProcessorIgnoreCase(processor);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
