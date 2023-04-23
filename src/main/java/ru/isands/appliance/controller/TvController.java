package ru.isands.appliance.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isands.appliance.dto.TvDTO;
import ru.isands.appliance.service.TvService;

import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@RestController
@AllArgsConstructor
@RequestMapping("/tv")
@Tag(name = "Телевизоры", description = "Контроллер для работы с телевизорами")
public class TvController {

    private TvService tvService;

    @GetMapping
    @Operation(summary = "Получить список всех телевизоров")
    public ResponseEntity<List<TvDTO>> findAll() {
        return new ResponseEntity<>(tvService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/color/{color}")
    @Operation(summary = "Получить список всех телевизоров по цвету")
    public ResponseEntity<List<TvDTO>> findByColor(@RequestParam String color) {
        List<TvDTO> tvs = tvService.findByColor(color);

        if (tvs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tvs, HttpStatus.OK);
    }
}
