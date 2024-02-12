package com.example.java.eight.functional;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestFunctional {

    @Test
    void testConsumer() {
        Consumer<String> consumer = System.out::println;
        consumer.accept("Rafa");

    }

    @Test
    void testPredicate() {
        Predicate<String> predicate = parameter -> parameter.equals("Rafinha");
        System.out.println(predicate.test("Rafinha"));
    }

    @Test
    void testFunction() {
        Function<Integer, String> function = parameter -> parameter.toString();
        System.out.println(function.apply(10));
    }

    @Test
    void testSupplier() {
        Supplier<String> supplier = () -> "xxxxxx";
        System.out.println(supplier.get());
    }
}
