package es.xgani.firstSpringApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.xgani.firstSpringApp.controller.api.UserRestController;
import es.xgani.firstSpringApp.controller.request.UserRequest;
import es.xgani.firstSpringApp.exception.UserNotFoundException;
import es.xgani.firstSpringApp.service.UserService;
import es.xgani.firstSpringApp.util.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        mockMvc.perform(get("/users/{id}", 1))
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
    void whenReplaceOnCollection_thenMethodIsNotAllowed() throws Exception {
        mockMvc.perform(put("/users"))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    void whenReplaceAnUserThatExists_thenIsOk() throws Exception {
        UserRequest userRequest = new UserRequest()
                .setName("Xavi")
                .setBirthdate(DateUtils.parse("03/04/1988"));

        mockMvc.perform(put("/users/{id}", 1)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userRequest)))
                .andExpect(status().isOk());
    }

    @Test
    void whenReplaceAnUserThatNotExists_thenIsNotFound() throws Exception {
        doThrow(UserNotFoundException.class).when(userService).replace(isA(Integer.class), isNotNull());
        UserRequest userRequest = new UserRequest()
                .setName("Xavi")
                .setBirthdate(DateUtils.parse("03/04/1988"));

        mockMvc.perform(put("/users/{id}", 1)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(userRequest)))
                .andExpect(status().isNotFound());
    }

    @Test
    void whenDeleteOnCollection_thenMethodIsNotAllowed() throws Exception {
        mockMvc.perform(delete("/users"))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    void whenDeleteAnUserThatExists_thenIsOk() throws Exception {
        mockMvc.perform(delete("/users/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    void whenDeleteAnUserThatNotExists_thenIsNotFound() throws Exception {
        doThrow(EmptyResultDataAccessException.class).when(userService).delete(isA(Integer.class));
        mockMvc.perform(delete("/users/{id}", 1))
                .andExpect(status().isNotFound());
    }


    @Test
    void whenAskSomethingThatNotExists_thenIsNotFound() throws Exception {
        mockMvc.perform(get("/show"))
                .andExpect(status().isNotFound());
    }
}