package com.routine.summer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.routine.summer.controllers.EmployeeController;
import com.routine.summer.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(EmployeeController.class)
@TestPropertySource(locations = "classpath:application.properties")
class EmployeeServiceTest {

    @MockBean EmployeeService employeeService;

    @Autowired private MockMvc mockMvc;

    @Test
    void employeeServiceGetOne() throws Exception {
        mockMvc
                .perform(get("/employees/100").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void employeeServiceGetAll() throws Exception {
        mockMvc
                .perform(get("/employees/all").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
