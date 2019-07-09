package com.routine.summer.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.routine.summer.entities.Employee;
import com.routine.summer.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService service) {
        this.employeeService = service;
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable int id) throws JsonProcessingException {
        return employeeService.get(id);
    }

    @RequestMapping(value = "/employees/all", method = RequestMethod.GET, produces = "application/json")
    public String getAll() throws JsonProcessingException {
        return employeeService.getAll();
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST, produces = "application/json")
    public String create(@RequestBody Employee employee) throws JsonProcessingException {
        return employeeService.create(employee);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.PUT, produces = "application/json")
    public String update(@RequestBody Employee employee) throws JsonProcessingException {
        return employeeService.update(employee);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String delete(@PathVariable int id) throws JsonProcessingException {
        return employeeService.delete(id);
    }
}
