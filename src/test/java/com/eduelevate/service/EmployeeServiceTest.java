package com.eduelevate.service;

import com.eduelevate.model.Employee;
import com.eduelevate.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() throws IOException {/*
        employee = new Employee();
        employee.setId(1L);
        employee.setName("John Doe");
        employee.setDepartment("Engineering");
        employee.setSalary(100000.00);*/
        String jsonFilePath = "src/test/resources/employee.json";
        String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        ObjectMapper objectMapper = new ObjectMapper();
        employee = objectMapper.readValue(jsonContent, Employee.class);
        System.out.println(employee);

    }

    @Test
    void addEmployee() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        Employee savedEmployee = employeeService.addEmployee(employee);
        assertNotNull(savedEmployee);
        assertEquals(employee.getName(), savedEmployee.getName());
    }

    @Test
    void getEmployeeById() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        Employee foundEmployee = employeeService.getEmployeeById(1L);
        assertNotNull(foundEmployee);
        assertEquals(employee.getId(), foundEmployee.getId());
    }

    @Test
    void updateEmployee() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        employee.setName("Jane Doe");
        Employee updatedEmployee = employeeService.updateEmployee(1L, employee);
        assertNotNull(updatedEmployee);
        assertEquals("Jane Doe", updatedEmployee.getName());
    }

    @Test
    void deleteEmployee() {
        doNothing().when(employeeRepository).deleteById(1L);
        employeeService.deleteEmployee(1L);
        verify(employeeRepository, times(1)).deleteById(1L);
    }
}