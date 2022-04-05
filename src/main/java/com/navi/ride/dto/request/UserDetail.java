package com.navi.ride.dto.request;

public class UserDetail {
    private String name;
    private char gender;
    private Short age;

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public Short getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public UserDetail() {
    }
}
