package dev.rm.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.rm.model.Alert;
import dev.rm.service.AlertService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AlertController {

    private final AlertService alertService;

    @GetMapping("/alerts")
    public ResponseEntity<List<Alert>> getAlerts() {
        List<Alert> alerts = alertService.getAlerts();
        return new ResponseEntity<>(alerts, HttpStatus.OK);
    }

}
