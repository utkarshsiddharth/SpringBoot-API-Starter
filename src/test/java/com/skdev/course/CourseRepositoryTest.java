package com.skdev.course;

import com.skdev.teacher.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

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
    public void printAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses" + courses);
    }

}