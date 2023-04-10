package com.skdev.department;

import com.skdev.error.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootApplication
class DepartmentServiceInterTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .name("CE")
                .code("CE-01")
                .address("Chandigarh Industrial Area, Phase II")
                .id(1)
                .build();
        System.out.println(departmentRepository.toString());
        Mockito.when(departmentRepository.findByName("CE"))
                .thenReturn(Optional.ofNullable(department));
    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldFound() throws NotFoundException {
        String name = "CE";
        Optional<Department> found = departmentService.getDepartmentByName(name);
        assertEquals(name, found.get().getName());
    }
}