package com.javaPlayground.multipleDataSource.model.department;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    long id;
    String finance;
    String it;
    String hr;
    String accounting;
    String marketing;
    String researchAndDevelopment;
}
