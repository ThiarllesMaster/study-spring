package com.example.java.eight.streams;

import com.example.java.eight.streams.model.Discipline;
import com.example.java.eight.streams.model.StudentModel;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestStreams {

    List<StudentModel> students = List.of(
            StudentModel.builder().nameStudent("Rafinha").age(9)
                    .disciplines(List.of(Discipline.builder()
                            .nameDiscipline("Geografia").build()))
                    .build()
    );

    @Test
    void testMap() {
        Function<StudentModel, Integer> functionStudent = StudentModel::getAge;
        List<Integer> ages = students.stream()
                .map(functionStudent)
                .toList();
        System.out.println(ages);
    }

    @Test
    void testFilter() {
        Predicate<StudentModel> predicateStudent = parameter -> parameter.getAge() < 6;
        List<StudentModel> studentsList = students.stream()
                .filter(predicateStudent)
                .toList();
    }

    @Test
    void testFlatMap() {
        students.stream()
                .flatMap(st -> st.getDisciplines().stream())
                .filter(d -> d.getNameDiscipline().equals(""))
                .collect(Collectors.toList());
    }

    @Test
    void testSorted() {
        students.stream()
                .sorted(Comparator.comparing(StudentModel::getAge))
                .collect(Collectors.toList());

       double average = students.stream()
                .mapToInt(StudentModel::getAge)
                .average().orElse(0d);

       System.out.println(average);
    }
}
