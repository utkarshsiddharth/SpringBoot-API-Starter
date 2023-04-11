package com.skdev.teacher;

import com.skdev.course.Course;
import com.skdev.course.CourseMaterial;
import com.skdev.course.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Brad")
                .lastName("Traversy")
                .build();
        Teacher db_teacher = teacherRepository.save(teacher);
        System.out.println(db_teacher);
    }
}