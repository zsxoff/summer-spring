package com.routine.summer.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.routine.summer.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService service) {
        this.employeeService = service;
    }

    @RequestMapping(
            value = "/employee/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    public String get(@PathVariable int id) throws JsonProcessingException {
        return employeeService.getEmployee(id);
    }
}
