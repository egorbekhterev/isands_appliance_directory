package ru.isands.appliance.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isands.appliance.dto.PhoneDTO;
import ru.isands.appliance.service.PhoneService;

import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 22.04.2023
 * @project: isands_appliance_directory
 */
@RestController
@AllArgsConstructor
@RequestMapping("/phone")
@Tag(name = "Смартфоны", description = "Контроллер для работы со смартфонами")
public class PhoneController {

    private PhoneService phoneService;

    @GetMapping
    @Operation(summary = "Получить список всех смартфонов")
    public ResponseEntity<List<PhoneDTO>> findAll() {
        return new ResponseEntity<>(phoneService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/sortPriceAsc")
    @Operation(summary = "Получить список всех смартфонов цена по возрастанию")
    public ResponseEntity<List<PhoneDTO>> findAllSortPriceAsc() {
        return new ResponseEntity<>(phoneService.findAllSortPriceAsc(), HttpStatus.OK);
    }

    @GetMapping("/color/{color}")
    @Operation(summary = "Получить список всех смартфонов по цвету")
    public ResponseEntity<List<PhoneDTO>> findByColor(@RequestParam String color) {
        List<PhoneDTO> phones = phoneService.findByColor(color);

        if (phones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(phones, HttpStatus.OK);
    }
}
