package com.skdev.course;

import com.skdev.teacher.Teacher;
import com.skdev.teacher.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;


@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveCourse(){
        Course course = Course.builder()
                .title("DSA")
                .credit(100)
                .build();
        Course db_course = courseRepository.save(course);
        System.out.println(db_course);
    }

    @Test
    public void saveCourseWithCourseMaterial(){
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.algo.com")
                .build();
        CourseMaterial db_course_material = courseMaterialRepository.save(courseMaterial);
        Course course = Course.builder()
                .title("ALGO")
                .credit(99)
                .courseMaterial(db_course_material)
                .build();
        Course db_course = courseRepository.save(course);
        System.out.println(db_course);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Brad")
                .lastName("Traversy")
                .build();
        Teacher db_teacher = teacherRepository.save(teacher);
        Course course = Course.builder()
                .title("JAVA")
                .credit(100)
                .teacher(db_teacher)
                .build();
        Course db_course = courseRepository.save(course);
        System.out.println("Course With Teacher" + db_course);
    }

}