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
import ru.isands.appliance.dto.post.TvDto;
import ru.isands.appliance.service.TvService;

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
@RequestMapping("/tv")
@Tag(name = "Телевизоры", description = "Контроллер для работы с телевизорами")
public class TvController {

    private static final String NOT_FOUND = "Телевизоры не найдены, проверьте вводимую информацию";

    private TvService tvService;

    @GetMapping
    @Operation(summary = "Получить список всех телевизоров")
    public ResponseEntity<List<ApplianceDto>> findAll() {
        return new ResponseEntity<>(tvService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Добавить телевизор в реестр")
    public ResponseEntity<TvDto> save(@Valid @RequestBody TvDto tvDto) {
        return new ResponseEntity<>(tvService.save(tvDto), HttpStatus.OK);
    }

    @GetMapping("/name")
    @Operation(summary = "Получить список телевизоров по наименованию")
    public ResponseEntity<List<ModelDto>> findAllByName(@RequestParam String name) {
        List<ModelDto> list = tvService.findAllByNameIgnoreCase(name);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/serialNumber")
    @Operation(summary = "Получить список телевизоров по серийному номеру")
    public ResponseEntity<List<ModelDto>> findAllBySerialNumber(@RequestParam String serialNumber) {
        List<ModelDto> list = tvService.findAllBySerialNumberIgnoreCase(serialNumber);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/color")
    @Operation(summary = "Получить список телевизоров по цвету")
    public ResponseEntity<List<ModelDto>> findAllByColor(@RequestParam String color) {
        List<ModelDto> list = tvService.findAllByColorIgnoreCase(color);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/size")
    @Operation(summary = "Получить список телевизоров по размеру")
    public ResponseEntity<List<ModelDto>> findAllBySize(@Positive @RequestParam BigDecimal size) {
        List<ModelDto> list = tvService.findAllBySizeIgnoreCase(size);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/price")
    @Operation(summary = "Получить список телевизоров по цене")
    public ResponseEntity<List<ModelDto>> findAllByPrice(@Positive @RequestParam BigDecimal price) {
        List<ModelDto> list = tvService.findAllByPriceIgnoreCase(price);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/available")
    @Operation(summary = "Получить список телевизоров по наличию")
    public ResponseEntity<List<ModelDto>> findAllByAvailable() {
        List<ModelDto> list = tvService.findAllByAvailable();

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/category")
    @Operation(summary = "Получить список телевизоров по категории")
    public ResponseEntity<List<ModelDto>> findAllByCategory(@RequestParam String category) {
        List<ModelDto> list = tvService.findAllByCategoryIgnoreCase(category);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/technology")
    @Operation(summary = "Получить список телевизоров по технологии")
    public ResponseEntity<List<ModelDto>> findAllByTechnology(@RequestParam String technology) {
        List<ModelDto> list = tvService.findAllByTechnologyIgnoreCase(technology);

        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
