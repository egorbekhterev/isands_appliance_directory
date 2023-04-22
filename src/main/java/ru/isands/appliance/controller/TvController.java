package ru.isands.appliance.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.isands.appliance.domain.TV;
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
public class TvController {

    private TvService tvService;

    @GetMapping
    public ResponseEntity<List<TV>> findAll() {
        return new ResponseEntity<>(tvService.findAll(), HttpStatus.OK);
    }
}
