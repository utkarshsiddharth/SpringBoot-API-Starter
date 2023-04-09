package com.skdev.department;

import com.skdev.error.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface DepartmentServiceInter {
    public List<Department> getAllDepartments();
    public Department createDepartment(Department department);

    public Optional<Department> getDepartmentById(int id) throws DepartmentNotFoundException;
    public Optional<Department> getDepartmentByName(String name) throws DepartmentNotFoundException;

    Optional<Department> updateDepartment(int id, Department body);
}
