package dev.rm.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.rm.model.Patient;
import dev.rm.service.PatientService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/patients/{patientId}")
    public ResponseEntity<Patient> getUserById(@PathVariable Long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

}
