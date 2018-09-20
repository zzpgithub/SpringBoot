package com.thoughtworks.grad.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.grad.domain.Contact;
import com.thoughtworks.grad.domain.User;
import com.thoughtworks.grad.repository.UserStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class UserControllerTest {
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        mockMvc = standaloneSetup(new UserController()).build();
        UserStorage.clear();
    }

    void init(){
        Map<Integer, Contact> contacts = new HashMap<>();
        Contact contactOne = new Contact(1, 20, "male", "Jack ContactOne", "111-1111");
        contacts.put(1, contactOne);
        UserStorage.addUser(new User(5, "Jack User", contacts));

    }

    @Test
    void should_save_user_contact() throws Exception {
        init();
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
        init();
        mockMvc.perform(get("/user/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("['1'].name").value("Jack ContactOne"))
                .andExpect(jsonPath("['1'].id").value(1))
                .andExpect(jsonPath("['1'].gender").value("male"))
                .andExpect(jsonPath("['1'].phoneNumber").value("111-1111"));  //map
    }

    @Test
    void should_update_user_contact() throws Exception {
        init();
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

    @Test
    void should_delete_contact() throws Exception {
        init();
        Contact contact = new Contact(1, 25, "femal","Alin", "123-1234");
        UserStorage.saveUserContact(5, contact);
        mockMvc.perform(delete("/user/5/contact/1")).andExpect(status().isNoContent());
    }

    @Test
    void should_get_contact_by_user_name() throws Exception {
       init();
        mockMvc.perform(get("/user/contact").param("userName", "Jack User")
        .param("contactName", "Jack ContactOne"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.age").value(20))
                .andExpect(jsonPath("$.gender").value("male"))
                .andExpect(jsonPath("$.name").value("Jack ContactOne"))
                .andExpect(jsonPath("$.phoneNumber").value("111-1111"));
    }
}

