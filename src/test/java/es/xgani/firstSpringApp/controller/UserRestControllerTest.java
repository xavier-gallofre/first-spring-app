package es.xgani.firstSpringApp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserRestController.class)
class UserRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenAskSomethingThatExists_thenIsOk() throws Exception {
        mockMvc.perform(get("/users")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void whenAskSomethingThatNotExists_thenIsNotFound() throws Exception {
        mockMvc.perform(get("/show")
                .contentType("application/json"))
                .andExpect(status().isNotFound());
    }
}