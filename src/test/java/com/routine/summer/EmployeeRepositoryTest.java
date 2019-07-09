package com.routine.summer;

import com.routine.summer.dao.EmployeeRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
class EmployeeDaoTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    @Transactional
    void employeeDaoGetOne() {
        Assert.assertNotNull(employeeRepository.getOne(100));
    }

    @Test
    @Transactional
    void employeeDaoGetAll() {
        Assert.assertNotNull(employeeRepository.findAll());
    }
}
