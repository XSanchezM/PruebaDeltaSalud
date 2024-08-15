package com.sprint3.admission_test.infrastructure.adapter.out.persistence;

import com.sprint3.admission_test.domain.model.Category;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class MedicationDTO {

    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate expirationDate;
    private Category category;

}
