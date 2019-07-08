package com.routine.summer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseControllerTest {

//    @Autowired
//    BaseController baseController;
//
//    @Autowired
//    EmployeeDao employeeDao;

    @DisplayName("Simple test")
    @Test
    public void test() {
        Assertions.assertEquals(2, 2);
    }
}
