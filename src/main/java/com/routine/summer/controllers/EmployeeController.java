package com.routine.summer.controllers;

import com.routine.summer.entities.Employee;
import com.routine.summer.services.EmployeeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService service) {
        this.employeeService = service;
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee select(@PathVariable int id) {
        return employeeService.select(id);
    }

    @RequestMapping(value = "/employees/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> selectAll() {
        return employeeService.findAll();
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }
}
