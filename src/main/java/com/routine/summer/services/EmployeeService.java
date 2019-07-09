package com.routine.summer.services;

import static com.routine.summer.serialization.Serialization.serializeException;
import static com.routine.summer.serialization.Serialization.serializeRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.routine.summer.dao.EmployeeDao;
import com.routine.summer.entities.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public String get(int id) throws JsonProcessingException, DataAccessException {
        try {
            return serializeRequest(employeeDao.get(id));
        } catch (Exception e) {
            return serializeException(e);
        }
    }

    public String getAll() throws JsonProcessingException, DataAccessException {
        try {
            return serializeRequest(employeeDao.getAll());
        } catch (Exception e) {
            return serializeException(e);
        }
    }

    public String update(Employee employee) throws JsonProcessingException, DataAccessException {
        try {
            return serializeRequest(employeeDao.update(employee));
        } catch (Exception e) {
            return serializeException(e);
        }
    }
}
