package com.thoughtworks.grad.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class UserControllerTest {
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        mockMvc = standaloneSetup(new UserController()).build();
    }

    @Test
    void should_get_contacts_of_user() throws Exception {
        mockMvc.perform(get("/user/5"))
                .andExpect(status().isOk());
    }
}

