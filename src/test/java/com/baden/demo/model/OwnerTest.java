package com.baden.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void testToString() {
        Owner owner = new Owner(1,"Gareth","Badenhorst");
        assertEquals(owner.toString(), "Owner{id=1, firstName='Gareth', lastName='Badenhorst'}");
    }
}