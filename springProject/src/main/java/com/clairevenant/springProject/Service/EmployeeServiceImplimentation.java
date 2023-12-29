package com.clairevenant.springProject.Service;


import com.clairevenant.springProject.Exceptions.EmployeeNotFoundException;
import com.clairevenant.springProject.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImplimentation implements EmployeeService{
List<Employee> employees = new ArrayList<>();
    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> findAll() {

        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employees.stream().filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst()
                .orElseThrow(()->new EmployeeNotFoundException("No employee found for the given id : " +id));


    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee employee = employees.stream()
                .filter(Employee->Employee
                        .getEmployeeId().equalsIgnoreCase(id))
                .findFirst()
                .get();
        employees.remove(employee);
        return "employee with the id :" +id+ "  deleted successful";
    }


}

