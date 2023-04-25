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
import ru.isands.appliance.dto.post.FridgeDto;
import ru.isands.appliance.service.FridgeService;

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
@RequestMapping("/fridge")
@Tag(name = "Холодильники", description = "Контроллер для работы с холодильниками")
public class FridgeController {

    private static final String NOT_FOUND = "Холодильники не найдены, проверьте вводимую информацию";

    private FridgeService fridgeService;

    @GetMapping
    @Operation(summary = "Получить список всех холодильников")
    public ResponseEntity<List<ApplianceDto>> findAll() {
        return new ResponseEntity<>(fridgeService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Добавить холодильник в реестр")
    public ResponseEntity<FridgeDto> save(@Valid @RequestBody FridgeDto fridgeDto) {
        return new ResponseEntity<>(fridgeService.save(fridgeDto), HttpStatus.OK);
    }

    @GetMapping("/name")
    @Operation(summary = "Получить список холодильников по наименованию")
    public ResponseEntity<List<ModelDto>> findAllByName(@RequestParam String name) {
        List<ModelDto> list = fridgeService.findAllByNameIgnoreCase(name);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/serialNumber")
    @Operation(summary = "Получить список холодильников по серийному номеру")
    public ResponseEntity<List<ModelDto>> findAllBySerialNumber(@RequestParam String serialNumber) {
        List<ModelDto> list = fridgeService.findAllBySerialNumberIgnoreCase(serialNumber);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/color")
    @Operation(summary = "Получить список холодильников по цвету")
    public ResponseEntity<List<ModelDto>> findAllByColor(@RequestParam String color) {
        List<ModelDto> list = fridgeService.findAllByColorIgnoreCase(color);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/size")
    @Operation(summary = "Получить список холодильников по размеру")
    public ResponseEntity<List<ModelDto>> findAllBySize(@Positive @RequestParam BigDecimal size) {
        List<ModelDto> list = fridgeService.findAllBySizeIgnoreCase(size);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/price")
    @Operation(summary = "Получить список холодильников по цене")
    public ResponseEntity<List<ModelDto>> findAllByPrice(@Positive @RequestParam BigDecimal price) {
        List<ModelDto> list = fridgeService.findAllByPriceIgnoreCase(price);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/available")
    @Operation(summary = "Получить список холодильников по наличию")
    public ResponseEntity<List<ModelDto>> findAllByAvailable() {
        List<ModelDto> list = fridgeService.findAllByAvailable();

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/category")
    @Operation(summary = "Получить список холодильников по количеству дверей")
    public ResponseEntity<List<ModelDto>> findAllByDoor(@Positive @RequestParam int door) {
        List<ModelDto> list = fridgeService.findAllByDoor(door);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/technology")
    @Operation(summary = "Получить список холодильников по типу компрессора")
    public ResponseEntity<List<ModelDto>> findAllByCompressor(@RequestParam String compressor) {
        List<ModelDto> list = fridgeService.findAllByCompressorIgnoreCase(compressor);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
