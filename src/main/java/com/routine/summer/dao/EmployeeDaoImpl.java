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
    private final RowMapper<Employee> mapper;

    @Autowired
    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        this.mapper =
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
    }

    @Override
    public Employee select(int id) throws DataAccessException {
        final String sql = "SELECT * FROM employees WHERE employee_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, mapper);
    }

    @Override
    public List<Employee> selectAll() throws DataAccessException {
        final String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public Employee update(Employee employee) throws DataAccessException {
        final String sql =
                "UPDATE employees SET "
                        + "FIRST_NAME = NVL(?, FIRST_NAME), "
                        + "LAST_NAME = NVL(?, LAST_NAME), "
                        + "EMAIL = NVL(?, EMAIL), "
                        + "PHONE_NUMBER = NVL(?, PHONE_NUMBER), "
                        + "HIRE_DATE = NVL(?, HIRE_DATE), "
                        + "JOB_ID = NVL(?, JOB_ID), "
                        + "SALARY = NVL(?, SALARY), "
                        + "COMMISSION_PCT = NVL(?, COMMISSION_PCT), "
                        + "MANAGER_ID = NVL(?, MANAGER_ID), "
                        + "DEPARTMENT_ID = NVL(?, DEPARTMENT_ID) "
                        + "WHERE employee_id = ?";

        jdbcTemplate.update(
                sql,
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getHireDate(),
                employee.getJobId(),
                employee.getSalary(),
                employee.getCommissionPct(),
                employee.getManagerId(),
                employee.getDepartmentId(),
                employee.getEmployeeId());

        return select(employee.getEmployeeId());
    }

    @Override
    public Employee create(Employee employee) throws DataAccessException {
        final String sql =
                "INSERT INTO employees ("
                        + "EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, "
                        + "SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                employee.getEmployeeId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getHireDate(),
                employee.getJobId(),
                employee.getSalary(),
                employee.getCommissionPct(),
                employee.getManagerId(),
                employee.getDepartmentId());

        return employee;
    }

    @Override
    public Employee delete(int id) throws DataAccessException {
        final Employee deletableEmployee = select(id);

        final String sql = "DELETE FROM employees WHERE employee_id = ?";
        jdbcTemplate.update(sql, id);

        return deletableEmployee;
    }
}
