package com.skdev.department;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @SequenceGenerator(
            name = "department_id_sequence",
            sequenceName = "department_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "department_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int id;
    @NotBlank(message = "Please provide the department name")
    private String name;
    private String address;
    private String code;
}
