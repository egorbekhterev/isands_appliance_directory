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
import ru.isands.appliance.dto.post.PhoneDto;
import ru.isands.appliance.service.PhoneService;

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
@RequestMapping("/phone")
@Tag(name = "Смартфоны", description = "Контроллер для работы со смартфонами")
public class PhoneController {

    private static final String NOT_FOUND = "Смартфоны не найдены, проверьте вводимую информацию";

    private PhoneService phoneService;

    @GetMapping
    @Operation(summary = "Получить список всех смартфонов")
    public ResponseEntity<List<ApplianceDto>> findAll() {
        return new ResponseEntity<>(phoneService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Добавить смартфон в реестр")
    public ResponseEntity<PhoneDto> save(@Valid @RequestBody PhoneDto phoneDto) {
        return new ResponseEntity<>(phoneService.save(phoneDto), HttpStatus.OK);
    }

    @GetMapping("/name")
    @Operation(summary = "Получить список смартфонов по наименованию")
    public ResponseEntity<List<ModelDto>> findAllByName(@RequestParam String name) {
        List<ModelDto> list = phoneService.findAllByNameIgnoreCase(name);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/serialNumber")
    @Operation(summary = "Получить список смартфонов по серийному номеру")
    public ResponseEntity<List<ModelDto>> findAllBySerialNumber(@RequestParam String serialNumber) {
        List<ModelDto> list = phoneService.findAllBySerialNumberIgnoreCase(serialNumber);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/color")
    @Operation(summary = "Получить список смартфонов по цвету")
    public ResponseEntity<List<ModelDto>> findAllByColor(@RequestParam String color) {
        List<ModelDto> list = phoneService.findAllByColorIgnoreCase(color);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/size")
    @Operation(summary = "Получить список смартфонов по размеру")
    public ResponseEntity<List<ModelDto>> findAllBySize(@Positive @RequestParam BigDecimal size) {
        List<ModelDto> list = phoneService.findAllBySizeIgnoreCase(size);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/price")
    @Operation(summary = "Получить список смартфонов по цене")
    public ResponseEntity<List<ModelDto>> findAllByPrice(@Positive @RequestParam BigDecimal price) {
        List<ModelDto> list = phoneService.findAllByPriceIgnoreCase(price);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/available")
    @Operation(summary = "Получить список смартфонов по наличию")
    public ResponseEntity<List<ModelDto>> findAllByAvailable() {
        List<ModelDto> list = phoneService.findAllByAvailable();

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/memory")
    @Operation(summary = "Получить список смартфонов по памяти")
    public ResponseEntity<List<ModelDto>> findAllByMemory(@Positive @RequestParam int memory) {
        List<ModelDto> list = phoneService.findAllByMemory(memory);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/camera")
    @Operation(summary = "Получить список смартфонов по количеству камер")
    public ResponseEntity<List<ModelDto>> findAllByCamera(@Positive @RequestParam int camera) {
        List<ModelDto> list = phoneService.findAllByCamera(camera);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
