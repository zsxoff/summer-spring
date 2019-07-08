package com.routine.summer;

import com.routine.summer.controllers.BaseController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
class TestBaseController {

    @Autowired BaseController baseController;

    @DisplayName("Simple 1 == 1")
    @Test
    void testOneIsOne() {
        Assertions.assertEquals(1, 1);
    }
}
