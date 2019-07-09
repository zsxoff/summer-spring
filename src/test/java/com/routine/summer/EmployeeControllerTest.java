package com.routine.summer;

import com.routine.summer.controllers.EmployeeController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
class EmployeeControllerTest {

    @Autowired
    EmployeeController employeeController;

}
