package com.skdev.course;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;


    @Test
    public void saveCourseMaterialWithCourseLinked(){
        //@todo - bi-directional fetch to be done

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
        System.out.println("Course" + db_course);
        System.out.println("Now Course Material Should Contain Course" + courseMaterialRepository.findById(db_course_material.getId()));
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("Course Material" + courseMaterials);
    }
}