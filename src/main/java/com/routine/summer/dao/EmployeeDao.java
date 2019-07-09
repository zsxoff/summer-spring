package com.routine.summer.dao;

import com.routine.summer.entities.Employee;
import java.util.List;
import org.springframework.dao.DataAccessException;

public interface EmployeeDao {

    Employee get(int id) throws DataAccessException;

    List<Employee> getAll() throws DataAccessException;

    Employee update(Employee employee);

    void create(Employee employee);

    void delete(int id);
}
