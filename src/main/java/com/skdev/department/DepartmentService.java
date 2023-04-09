package com.skdev.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements DepartmentServiceInter {

    @Autowired
    public DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department createDepartment(Department body) {
        Department department = new Department();
        department.setAddress(body.getAddress());
        department.setName(body.getName());
        department.setCode(body.getCode());
        return departmentRepository.save(department);
    }

    @Override
    public Optional<Department> getDepartmentById(int id) throws RuntimeException {
        Optional<Department> department =  departmentRepository.findById(id);
        if(department.isPresent()) {
            return department;
        }else {
            throw new RuntimeException("Department not found by give id!");
        }
    }

    public Optional<Department> updateDepartment(int id, Department body) {
        Optional<Department> dbDepartment = departmentRepository.findById(id);
        if(dbDepartment.isPresent()){
            Department department = dbDepartment.get();
            if(body.getAddress() != null && body.getAddress() != "") {
                department.setAddress(body.getAddress());
            }
            if(body.getName() != null && body.getName() != "") {
                department.setName(body.getName());
            }
            if(body.getCode() != null && body.getCode() != "") {
                department.setCode(body.getCode());
            }
            return Optional.of(departmentRepository.save(department));
        }else {
            throw new RuntimeException("Department with the provided id not found");
        }
    }
}
