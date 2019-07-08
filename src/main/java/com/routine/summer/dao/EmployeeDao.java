package com.routine.summer.dao;

import com.routine.summer.entities.Employee;
import java.util.List;
import org.springframework.dao.DataAccessException;

public interface EmployeeDao {

    Employee get(int id) throws DataAccessException;

    List<Employee> getAll() throws DataAccessException;

    //        void create(T t);
    //
    //    void update(T t);
    //
    //    void delete(T t);
    //
    //    void delete(int id);
    //
}
