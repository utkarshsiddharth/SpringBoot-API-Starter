package com.skdev.employee;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Entity
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_id_sequence",
            sequenceName = "employee_id_sequence"
    )
    @GeneratedValue(
            generator = "employee_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int id;
    private String name;
    private String department;
    private int employee_income;

    public Employee(int id, String name, String department, int employee_income) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.employee_income = employee_income;
    }

    public Employee(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getEmployee_income() {
        return employee_income;
    }

    public void setEmployee_income(int employee_income) {
        this.employee_income = employee_income;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getId() == employee.getId() && getEmployee_income() == employee.getEmployee_income() && Objects.equals(getName(), employee.getName()) && Objects.equals(getDepartment(), employee.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDepartment(), getEmployee_income());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", employee_income=" + employee_income +
                '}';
    }
}
