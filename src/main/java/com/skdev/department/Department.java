package com.skdev.department;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private String name;
    private String address;
    private String code;
}
