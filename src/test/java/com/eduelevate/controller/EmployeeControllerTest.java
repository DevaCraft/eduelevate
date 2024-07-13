package com.eduelevate.controller;

import com.eduelevate.model.Employee;
import com.eduelevate.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("John Doe");
        employee.setDepartment("Engineering");
        employee.setSalary(100000.00);

        given(employeeService.addEmployee(employee)).willReturn(employee);

        mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(employee)));
    }
@Test
public void testGetEmployeeById() throws Exception {
    Employee employee = new Employee();
    employee.setId(1L);
    employee.setName("John Doe");
    employee.setDepartment("Engineering");
    employee.setSalary(100000.00);

    given(employeeService.getEmployeeById(1L)).willReturn(employee);

    mockMvc.perform(get("/api/employees/{id}", 1L)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(employee)));
}
@Test
public void testUpdateEmployee() throws Exception {
    Long employeeId = 1L;
    Employee existingEmployee = new Employee();
    existingEmployee.setId(employeeId);
    existingEmployee.setName("John Doe");
    existingEmployee.setDepartment("Engineering");
    existingEmployee.setSalary(100000.00);

    Employee updatedEmployee = new Employee();
    updatedEmployee.setId(employeeId);
    updatedEmployee.setName("Jane Doe");
    updatedEmployee.setDepartment("HR");
    updatedEmployee.setSalary(110000.00);

    given(employeeService.updateEmployee(eq(employeeId), any(Employee.class))).willReturn(updatedEmployee);

    mockMvc.perform(put("/api/employees/{id}", employeeId)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(updatedEmployee)))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(updatedEmployee)));
}

@Test
public void testDeleteEmployee() throws Exception {
    Long employeeId = 1L;

    doNothing().when(employeeService).deleteEmployee(employeeId);

    mockMvc.perform(delete("/api/employees/{id}", employeeId))
            .andExpect(status().isOk());

    verify(employeeService, times(1)).deleteEmployee(employeeId);
}

}