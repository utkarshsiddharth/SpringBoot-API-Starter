package com.skdev.department;

import com.skdev.error.NotFoundException;

import java.util.List;
import java.util.Optional;


public interface DepartmentServiceInter {
    public List<Department> getAllDepartments();
    public Department createDepartment(Department department);

    public Optional<Department> getDepartmentById(int id) throws NotFoundException;
    public Optional<Department> getDepartmentByName(String name) throws NotFoundException;

    Optional<Department> updateDepartment(int id, Department body);
}
