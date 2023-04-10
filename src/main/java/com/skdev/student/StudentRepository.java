package com.skdev.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String firstName);

    List<Student> findByGuardianName(String guardianName);

    // jpql query
    @Query("select s from Student s where s.email = ?1")
    Student getStudentByEmailAddress(String email);


}
