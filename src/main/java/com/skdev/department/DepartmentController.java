package com.skdev.department;

import com.skdev.error.NotFoundException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController  {

    private final DepartmentServiceInter departmentService;

    public DepartmentController(DepartmentServiceInter departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @PostMapping
    public Department createDepartment(@Valid @RequestBody Department body){
        return departmentService.createDepartment(body);
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable("id") int id) throws NotFoundException {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<Department> getDepartmentByName(@PathVariable("name") String name) throws NotFoundException {
        return departmentService.getDepartmentByName(name);
    }

    @PutMapping("/{id}")
    public Optional<Department> updateDepartment(@PathVariable("id") int id, @RequestBody Department body){
        return departmentService.updateDepartment(id, body);
    }
}
