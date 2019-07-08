package com.routine.summer.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.routine.summer.dao.EmployeeDao;
import com.routine.summer.errors.ErrorImpl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public String getEmployee(int id) throws JsonProcessingException, DataAccessException {

        try {
            return (new ObjectMapper()).writeValueAsString(employeeDao.get(id));

        } catch (JsonProcessingException e) {
            return (new ObjectMapper())
                    .writeValueAsString(ErrorImpl.builder().errorMsg("JsonProcessingException").build());

        } catch (DataAccessException e) {
            return (new ObjectMapper())
                    .writeValueAsString(ErrorImpl.builder().errorMsg("DataAccessException").build());
        }
    }
}
