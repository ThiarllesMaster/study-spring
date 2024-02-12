package com.example.java.eight.streams.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentModel {

    private String nameStudent;
    private Integer age;
    private List<Discipline> disciplines;
}
