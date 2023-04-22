package ru.isands.appliance.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.isands.appliance.domain.Phone;
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
    public ResponseEntity<List<Phone>> findAll() {
        return new ResponseEntity<>(phoneService.findAll(), HttpStatus.OK);
    }
}
