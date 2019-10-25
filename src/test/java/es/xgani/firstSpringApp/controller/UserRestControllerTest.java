package es.xgani.firstSpringApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.xgani.firstSpringApp.controller.api.UserRestController;
import es.xgani.firstSpringApp.controller.request.UserRequest;
import es.xgani.firstSpringApp.service.UserService;
import es.xgani.firstSpringApp.util.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserRestController.class)
class UserRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    @Test
    void whenGetAllUsers_thenIsOk() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk());
    }

    @Test
    void whenGetASpecificUser_thenIsOk() throws Exception {
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk());
    }


    @Test
    void whenCreateAnUser_thenIsCreated() throws Exception {
        UserRequest userRequest = new UserRequest()
                .setName("Xavi")
                .setBirthdate(DateUtils.parse("03/04/1988"));

        mockMvc.perform(post("/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userRequest)))
                .andExpect(status().isCreated());
    }

    @Test
    void whenAskSomethingThatNotExists_thenIsNotFound() throws Exception {
        mockMvc.perform(get("/show"))
                .andExpect(status().isNotFound());
    }
}