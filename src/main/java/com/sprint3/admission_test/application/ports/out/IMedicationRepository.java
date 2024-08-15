package com.sprint3.admission_test.application.ports.out;

import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMedicationRepository {

    Optional<Medication> findById(Long id);

}
