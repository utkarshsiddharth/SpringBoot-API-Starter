package com.skdev.student;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        uniqueConstraints = @UniqueConstraint(
                name="email_unique",
                columnNames = "email_address"
        )
)

public class Student {

    @Id
    @SequenceGenerator(
            name = "student_id_sequence",
            sequenceName = "department_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "student_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    @NotBlank(message = "Please provide the firstName")
    private String firstName;
    private String lastName;

    @Column(name="email_address", nullable = false)
    private String email;

    @Embedded
    private Guardian guardian;

}
