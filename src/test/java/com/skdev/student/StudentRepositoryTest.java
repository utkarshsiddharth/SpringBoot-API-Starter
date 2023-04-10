package com.skdev.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void saveStudent() {
        Guardian guardian = Guardian.builder()
                .name("Brad")
                .email("brad@gmail.com")
                .mobile("9992122645")
                .build();
        Student student = Student.builder()
                .email("john@gmail.com")
                .firstName("John")
                .lastName("Doe")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
        Guardian guardian1 = Guardian.builder()
                .name("Kevin")
                .email("kevin@gmail.com")
                .mobile("9992122645")
                .build();
        Student student1 = Student.builder()
                .email("jane@gmail.com")
                .firstName("Jane")
                .lastName("Doe")
                .guardian(guardian1)
                .build();
        studentRepository.save(student1);
    }

    @Test
    public void printAllStudents(){
        List<Student> students = studentRepository.findAll();
        System.out.println("Students" + students);
    }

    @Test
    public void getStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("John");
        System.out.println("Student With First Name" + students);
    }

    @Test
    public void findStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("Jan");
        System.out.println("Student Containing Jan in First Name" + students);
    }

    @Test
    public void findStudentByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Brad");
        System.out.println("Student With Guardian Name" + students);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("john@gmail.com");
        System.out.println("Student with email address" + student);
    }
}