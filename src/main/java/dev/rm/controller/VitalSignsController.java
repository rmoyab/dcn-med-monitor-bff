package dev.rm.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.rm.model.VitalSign;
import dev.rm.service.VitalSignService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class VitalSignsController {

    private final VitalSignService vitalSignService;

    @PostMapping("/vital-signs")
    public ResponseEntity<VitalSign> createVitalSign(@RequestBody VitalSign vitalSign) {
        VitalSign newVitalSign = vitalSignService.createVitalSign(vitalSign);
        return new ResponseEntity<>(newVitalSign, HttpStatus.CREATED);
    }

    @GetMapping("/vital-signs/patient/{patientId}")
    public ResponseEntity<List<VitalSign>> getVitalSignsByPatientId(@PathVariable Long patientId) {
        List<VitalSign> vitalSigns = vitalSignService.getVitalSignsByPatientId(patientId);
        return new ResponseEntity<>(vitalSigns, HttpStatus.OK);
    }

    @GetMapping("/vital-signs/{vitalSignId}")
    public ResponseEntity<VitalSign> getVitalSignById(@PathVariable Long vitalSignId) {
        VitalSign vitalSign = vitalSignService.getVitalSignById(vitalSignId);
        return new ResponseEntity<>(vitalSign, HttpStatus.OK);
    }

}