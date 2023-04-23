package ru.isands.appliance.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.isands.appliance.dto.AllDTO;
import ru.isands.appliance.service.CombinedService;

import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@RestController
@AllArgsConstructor
@Tag(name = "Вся техника", description = "Контроллер для работы с техникой")
public class CombinedController {

    private CombinedService combinedService;

    @GetMapping
    @Operation(summary = "Получить список всей техники")
    public ResponseEntity<List<AllDTO>> findAll() {
        return new ResponseEntity<>(combinedService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/color/{color}")
    @Operation(summary = "Получить список всей техники по цвету")
    public ResponseEntity<List<AllDTO>> findByColor(@RequestParam String color) {
        List<AllDTO> all = combinedService.findByColor(color);

        if (all.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
