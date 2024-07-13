package com.eduelevate.service;

import com.eduelevate.model.Employee;
import com.eduelevate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private  EmployeeRepository employeeRepository;


    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    public Employee updateEmployee(Long id, Employee employee) {
         Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
        existingEmployee.setName(employee.getName());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setDepartment(employee.getDepartment());
        return employeeRepository.save(existingEmployee);

    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);

    }
}