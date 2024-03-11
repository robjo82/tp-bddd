package com.tp.bddd.controller;

import com.tp.bddd.service.RandomService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/random")
@RequiredArgsConstructor
@Tag(name = "Random", description = "Create random data for testing purposes")
public class CreateRandomDataController {

    private final RandomService createRandomDataService;

    @PostMapping("/data")
    public ResponseEntity<Map<String, Object>> createRandomData(@RequestParam int amount) {
        return ResponseEntity.ok(createRandomDataService.generateRandomData(amount));
    }
}
