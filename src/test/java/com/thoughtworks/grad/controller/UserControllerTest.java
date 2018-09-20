package com.thoughtworks.grad.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.grad.domain.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class UserControllerTest {
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        mockMvc = standaloneSetup(new UserController()).build();
    }


    @Test
    void should_save_user_contact() throws Exception {
        Contact contact = new Contact(1, 25, "femal","Alin", "123-1234");
        mockMvc.perform(post("/user/5/contact")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(contact)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))  ////返回contact
                .andExpect(jsonPath("$.age").value(25))
                .andExpect(jsonPath("$.gender").value("femal"))
                .andExpect(jsonPath("$.name").value("Alin"))
                .andExpect(jsonPath("$.phoneNumber").value("123-1234"));
    }

    @Test
    void should_get_contacts_of_user() throws Exception {
        mockMvc.perform(get("/user/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("['1'].name").value("Jack ContactOne"))  ////返回contacts对象
                .andExpect(jsonPath("['2'].name").value("Jack ContactTwo"));
    }

    @Test
    void should_update_user_contact() throws Exception {
        Contact contact = new Contact(1, 25, "femal","Alin", "123-1234");
        mockMvc.perform(put("/user/5/contact")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(contact)))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.id").value(1))  ////返回contact
                .andExpect(jsonPath("$.age").value(25))
                .andExpect(jsonPath("$.gender").value("femal"))
                .andExpect(jsonPath("$.name").value("Alin"))
                .andExpect(jsonPath("$.phoneNumber").value("123-1234"));
    }
}

