package com.thoughtworks.grad.domain;

public class Contact {
    private int id;
    private int age;
    private String gender;
    private String name;
    private String phoneNumber;

    public Contact() {
    }

    public Contact(int id, int age, String gender, String name, String phoneNumber) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
