package com.sprint3.admission_test.domain.service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class MedicationService {
    private final MedicationRepository MedicationRepo;

    public void createMedication(Medication medication){
        MedicationRepo.save(medication);
    }

    public List<Medication> listAllMedication(){
        return MedicationRepo.findAll();
    }

    public List<Medication> getMedicationById(long id){

        try {
            List<Medication> Medication = MedicationRepo.findById(id);
            return Medication;

        } catch (Exception err) {
            throw new ResourceNotFoundException("Medication not found with id: " + id);
        }
    }


}