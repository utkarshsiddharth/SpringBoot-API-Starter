package com.skdev.department;

import java.util.List;
import java.util.Optional;

public interface DepartmentServiceInter {
    public List<Department> getAllDepartments();
    public Department createDepartment(Department department);

    public Optional<Department> getDepartmentById(int id);

    Optional<Department> updateDepartment(int id, Department body);
}
