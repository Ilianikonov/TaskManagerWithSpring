package com.example.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@lombok.Value
public class User {
    private int id;
    private String name;
    private String surname;
}
