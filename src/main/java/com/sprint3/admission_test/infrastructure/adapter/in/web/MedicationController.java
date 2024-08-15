package com.sprint3.admission_test.infrastructure.adapter.in.web;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.adapter.out.persistence.MedicationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired
    private IMedicationUseCase medicationUseCase;

    @Autowired
    private MedicationService medicationService;

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.getMedicationById(id));
    }

    @PostMapping
    public ResponseEntity<Medication> createMedication(@RequestBody MedicationDTO medicationDTO) {
        Medication medication = medicationService.createMedication(medicationDTO);
        return new ResponseEntity<>(medication, HttpStatus.CREATED);
    }

    @GetMapping("/category/{category}")
    public List<Medication> getMedicationsByCategoryAndExpirationDate(
            @RequestParam Category categoryName,
            @RequestParam LocalDate expirationDate, @PathVariable String category) {
        return medicationService.getMedicationsByCategoryAndExpirationDate(categoryName, expirationDate);
    }

}
