package com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository;

import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MedicationJpaRepository extends JpaRepository<Medication, Long> {

    List<Medication> findByCategoryAndExpirationDateBefore(Category category, LocalDate expirationDate);
}
