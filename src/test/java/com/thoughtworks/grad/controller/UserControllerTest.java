package com.thoughtworks.grad.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.grad.domain.Contact;
import com.thoughtworks.grad.domain.User;
import com.thoughtworks.grad.repository.ContactStorage;
import com.thoughtworks.grad.repository.UserStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class UserControllerTest {
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        mockMvc = standaloneSetup(new UserController()).build();
       // UserStorage.clear();
    }
//
//    void init(){
//        Map<Integer, Contact> contacts = new HashMap<>();
//        Contact contactOne = new Contact(1, 20, "male", "Jack ContactOne", "111-1111");
//        contacts.put(1, contactOne);
//        UserStorage.addUser(new User(5, "Jack User", contacts));
//
//    }

    @Test
    void should_create_contact_for_user() throws Exception {
        //init();
        Contact contact = new Contact(3, 5, 25, "femal","Alin", "123-1234");
        int originalContactNumber = ContactStorage.getCONTACTS().size();

        mockMvc.perform(post("/api/users/5/contacts")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(contact)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.userId").value(5))
                .andExpect(jsonPath("$.age").value(25))
                .andExpect(jsonPath("$.gender").value("femal"))
                .andExpect(jsonPath("$.name").value("Alin"))
                .andExpect(jsonPath("$.phoneNumber").value("123-1234"));

        int scaledContactNumber = ContactStorage.getCONTACTS().size();
        assertEquals(originalContactNumber + 1,scaledContactNumber);
    }

    @Test
    void should_get_contacts_of_user() throws Exception {
        //init();
//        mockMvc.perform(get("/api/users/5/contacts"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.1.name").value("Jack ContactOne"))  /////$.1.name  $.当前对象 1 key  ==得到对应value
//                .andExpect(jsonPath("['1'].name").value("Jack ContactOne")) ///直接按对象写
//                .andExpect(jsonPath("['1'].id").value(1))
//                .andExpect(jsonPath("['1'].gender").value("male"))
//                .andExpect(jsonPath("['1'].phoneNumber").value("111-1111"));  //map

        mockMvc.perform(get("/api/users/5/contacts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].userId").value(5))
                .andExpect(jsonPath("$[0].age").value(20))
                .andExpect(jsonPath("$[0].gender").value("male"))
                .andExpect(jsonPath("$[0].name").value("personOne"))
                .andExpect(jsonPath("$[0].phoneNumber").value("111-1111"));
    }

    @Test
    void should_update_user_contact() throws Exception {
        //init();
        Contact contact = new Contact(1, 5,25, "femal","Alin", "123-1234");
        mockMvc.perform(put("/api/users/5/contacts/1")
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
        //init();
        //Contact contact = new Contact(1, 25, "femal","Alin", "123-1234");
        //UserStorage.saveUserContact(5, contact);
        mockMvc.perform(delete("/api/users/5/contacts/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void should_get_contact_by_user_name_and_contact_name() throws Exception {
       //init();

        mockMvc.perform(get("/api/users/Jack/contacts/personOne"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.userId").value(5))
                .andExpect(jsonPath("$.age").value(20))
                .andExpect(jsonPath("$.gender").value("male"))
                .andExpect(jsonPath("$.name").value("personOne"))
                .andExpect(jsonPath("$.phoneNumber").value("111-1111"));
    }
}

