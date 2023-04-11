package com.skdev.course;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_id_sequence",
            sequenceName = "course_material_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "course_material_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    @NotBlank(message="Please provide the course material URl")
    private String url;

    @OneToOne(
            mappedBy = "courseMaterial"
    )
    private Course course;
}
