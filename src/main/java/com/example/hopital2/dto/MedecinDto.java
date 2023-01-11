package com.example.hopital2.dto;

import jakarta.persistence.criteria.CriteriaBuilder;

public class MedecinDto {

    private String display_name;
    private Integer age;

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
