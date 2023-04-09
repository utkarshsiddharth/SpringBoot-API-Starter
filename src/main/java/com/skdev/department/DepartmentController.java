package com.skdev.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController  {

    @Autowired
    private DepartmentServiceInter departmentService;

    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department body){
        return departmentService.createDepartment(body);
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable("id") int id){
        return departmentService.getDepartmentById(id);
    }

    @PutMapping("/{id}")
    public Optional<Department> updateDepartment(@PathVariable("id") int id, @RequestBody Department body){
        return departmentService.updateDepartment(id, body);
    }
}
