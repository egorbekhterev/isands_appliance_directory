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
import ru.isands.appliance.dto.post.HooverDto;
import ru.isands.appliance.service.HooverService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 24.04.2023
 * @project: isands_appliance_directory
 */
@RestController
@AllArgsConstructor
@RequestMapping("/hoover")
@Tag(name = "Пылесосы", description = "Контроллер для работы с пылесосами")
public class HooverController {

    private static final String NOT_FOUND = "Пылесосы не найдены, проверьте вводимую информацию";

    private HooverService hooverService;

    @GetMapping
    @Operation(summary = "Получить список всех пылесосов")
    public ResponseEntity<List<ApplianceDto>> findAll() {
        return new ResponseEntity<>(hooverService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Добавить пылесос в реестр")
    public ResponseEntity<HooverDto> save(@Valid @RequestBody HooverDto hooverDto) {
        return new ResponseEntity<>(hooverService.save(hooverDto), HttpStatus.OK);
    }

    @GetMapping("/name")
    @Operation(summary = "Получить список пылесосов по наименованию")
    public ResponseEntity<List<ModelDto>> findAllByName(@RequestParam String name) {
        List<ModelDto> list = hooverService.findAllByNameIgnoreCase(name);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/serialNumber")
    @Operation(summary = "Получить список пылесосов по серийному номеру")
    public ResponseEntity<List<ModelDto>> findAllBySerialNumber(@RequestParam String serialNumber) {
        List<ModelDto> list = hooverService.findAllBySerialNumberIgnoreCase(serialNumber);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/color")
    @Operation(summary = "Получить список пылесосов по цвету")
    public ResponseEntity<List<ModelDto>> findAllByColor(@RequestParam String color) {
        List<ModelDto> list = hooverService.findAllByColorIgnoreCase(color);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/size")
    @Operation(summary = "Получить список пылесосов по размеру")
    public ResponseEntity<List<ModelDto>> findAllBySize(@RequestParam BigDecimal size) {
        List<ModelDto> list = hooverService.findAllBySizeIgnoreCase(size);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/price")
    @Operation(summary = "Получить список пылесосов по цене")
    public ResponseEntity<List<ModelDto>> findAllByPrice(@RequestParam BigDecimal price) {
        List<ModelDto> list = hooverService.findAllByPriceIgnoreCase(price);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/available")
    @Operation(summary = "Получить список пылесосов по наличию")
    public ResponseEntity<List<ModelDto>> findAllByAvailable() {
        List<ModelDto> list = hooverService.findAllByAvailable();

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/volume")
    @Operation(summary = "Получить список пылесосов по объему пылесборника")
    public ResponseEntity<List<ModelDto>> findAllByVolume(@RequestParam BigDecimal volume) {
        List<ModelDto> list = hooverService.findAllByVolume(volume);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/mode")
    @Operation(summary = "Получить список пылесосов по количеству режимов работы")
    public ResponseEntity<List<ModelDto>> findAllByMode(@RequestParam int mode) {
        List<ModelDto> list = hooverService.findAllByMode(mode);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
