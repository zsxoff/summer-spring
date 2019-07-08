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
    private final ObjectMapper mapper = new ObjectMapper();

    private String exceptionSerializeObj(Exception e) throws JsonProcessingException {
        return mapper.writeValueAsString(
                ErrorImpl.builder().errorMsg(e.getClass().getSimpleName()).build());
    }

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public String getEmployee(int id) throws JsonProcessingException, DataAccessException {
        try {
            return mapper.writeValueAsString(employeeDao.get(id));
        } catch (Exception e) {
            return exceptionSerializeObj(e);
        }
    }

    public String getAllEmployees() throws JsonProcessingException, DataAccessException {
        try {
            return mapper.writeValueAsString(employeeDao.getAll());
        } catch (Exception e) {
            return exceptionSerializeObj(e);
        }
    }
}
