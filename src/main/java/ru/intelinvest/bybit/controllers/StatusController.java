package ru.intelinvest.bybit.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/status")
public class StatusController {
    @GetMapping()
    public ResponseEntity<String> status() {
        log.info("Get status!");
        return ResponseEntity.ok("BY_BIT");
    }
}