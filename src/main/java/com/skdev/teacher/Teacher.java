package com.skdev.teacher;

import com.skdev.course.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_id_sequence",
            sequenceName = "teacher_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "teacher_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long teacherId;
    private String firstName;
    private String lastName;

    //    @OneToMany(
    //            cascade = CascadeType.ALL
    //    )
    //    @JoinColumn(
    //            name = "teacher_id",
    //            referencedColumnName = "teacherId"
    //    )
    //    private List<Course> courses;
}
