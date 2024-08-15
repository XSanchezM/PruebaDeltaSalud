package com.sprint3.admission_test.infrastructure.adapter.in.web;

import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.adapter.out.persistence.MedicationDTO;
import com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository.CategoryJpaRepository;
import com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository.MedicationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MedicationService {

    @Autowired
    private MedicationJpaRepository medicationRepository;

    @Autowired
    private CategoryJpaRepository categoryRepository;

    public Medication createMedication(MedicationDTO medicationDTO) {
        Medication medication = new Medication();
        medication.setName(medicationDTO.getName());
        medication.setDescription(medicationDTO.getDescription());
        medication.setPrice(medicationDTO.getPrice());
        medication.setExpirationDate(medicationDTO.getExpirationDate());

        Optional<Category> category = categoryRepository.findById(medicationDTO.getCategory().getId());
        medication.setCategory(category.orElse(null));

        return medicationRepository.save(medication);
    }

    public List<Medication> getMedicationsByCategoryAndExpirationDate(Category categoryName, LocalDate expirationDate) {
        return medicationRepository.findByCategoryAndExpirationDateBefore(categoryName, expirationDate);
    }

}

