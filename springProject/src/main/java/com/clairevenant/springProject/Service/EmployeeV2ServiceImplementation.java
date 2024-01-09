package com.clairevenant.springProject.Service;

import com.clairevenant.springProject.Entity.EmployeeEntity;
import com.clairevenant.springProject.Model.Employee;
import com.clairevenant.springProject.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImplementation implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> findAll() {

        List<EmployeeEntity>employeeEntityList = employeeRepository.findAll();
        List<Employee>employees
                = employeeEntityList
                .stream()
                .map(employeeEntity -> {
                    Employee employee = new Employee();
                    BeanUtils.copyProperties(employeeEntity,employee);
                    return employee;
                })
                .collect(Collectors.toList());
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {

        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String id) {
//      EmployeeEntity employeeEntity =
//                employeeRepository.findById(id).get();
//      Employee employee = new Employee();
  //    BeanUtils.copyProperties(employeeEntity,employee);
       employeeRepository.deleteById(id);
       return " Employee with this id :  " +
               id +  "have been deleted successful";
    }
}
