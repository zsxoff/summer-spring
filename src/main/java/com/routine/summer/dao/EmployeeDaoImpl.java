package com.routine.summer.dao;

import com.routine.summer.entities.Employee;
import java.sql.ResultSet;
import java.util.List;
import oracle.sql.DATE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Employee> mapper =
            (ResultSet rs, int rowNum) ->
                    Employee.builder()
                            .employeeId(rs.getInt("EMPLOYEE_ID"))
                            .firstName(rs.getString("FIRST_NAME"))
                            .lastName(rs.getString("LAST_NAME"))
                            .email(rs.getString("EMAIL"))
                            .phoneNumber(rs.getString("PHONE_NUMBER"))
                            .hireDate(new DATE(rs.getDate("HIRE_DATE")))
                            .jobId(rs.getString("JOB_ID"))
                            .salary(rs.getInt("SALARY"))
                            .commissionPct(rs.getInt("COMMISSION_PCT"))
                            .managerId(rs.getInt("MANAGER_ID"))
                            .departmentId(rs.getInt("DEPARTMENT_ID"))
                            .build();

    @Autowired
    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Employee get(int id) throws DataAccessException {
        final String sql = "SELECT * FROM employees WHERE employee_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, mapper);
    }

    @Override
    public List<Employee> getAll() throws DataAccessException {
        final String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, mapper);
    }
}
