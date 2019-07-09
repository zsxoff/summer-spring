package com.routine.summer.dao;

import com.routine.summer.entities.Employee;
import java.util.List;
import org.springframework.dao.DataAccessException;

public interface EmployeeDao {

    Employee select(int id) throws DataAccessException;

    List<Employee> selectAll() throws DataAccessException;

    Employee update(Employee employee) throws DataAccessException;

    Employee create(Employee employee) throws DataAccessException;

    Employee delete(int id) throws DataAccessException;
}
