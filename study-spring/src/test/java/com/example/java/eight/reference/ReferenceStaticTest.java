package com.example.java.eight.reference;

import io.micrometer.observation.Observation;
import org.junit.jupiter.api.Test;

public class ReferenceStaticTest {

    @Test
    void testReference() {
       ReferenceStaticInterface rsI = ReferenceStatic::print;
       rsI.print();

       ReferenceStaticObject referenceStaticObject = new ReferenceStaticObject();
       ReferenceStaticInterface rsO = referenceStaticObject::referenceObject;

    }

    @Test
    void testReferenceConstructor() {
        ReferenceObjectInterface referenceObjectInterface = Student::new;
    }
}
