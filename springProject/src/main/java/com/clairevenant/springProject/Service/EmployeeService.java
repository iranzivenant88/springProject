package com.clairevenant.springProject.Service;

import com.clairevenant.springProject.Model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee save(Employee employee);
    public List<Employee> findAll();

    Employee getEmployeeById(String id);

    String deleteEmployeeById(String id);
}
