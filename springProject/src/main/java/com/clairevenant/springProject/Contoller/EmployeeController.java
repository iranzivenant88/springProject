package com.clairevenant.springProject.Contoller;

import com.clairevenant.springProject.Model.Employee;
import com.clairevenant.springProject.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {
    @Autowired
    @Qualifier("employeeServiceImplementation")
    private EmployeeService employeeService;

    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }
    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();

    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id ){
        return employeeService. getEmployeeById(id);

    }
    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable String id){

        return employeeService.deleteEmployeeById(id);

    }
}
