package com.engine.kiwi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.assertj.core.api.Assertions.assertThat;


class EntityGridTest {

    @InjectMocks
    private EntityGrid classUnderTest;

    @BeforeEach
    void initialize() {
        classUnderTest = new EntityGrid(15,15,64,64);
    }

    @Test
    void test() {

        classUnderTest.addEntity(new Entity("entity1",1,2,0,0));

        assertThat(classUnderTest.getCell(0,0)).isEqualTo("entity1");
        assertThat(classUnderTest.getCell(0,1)).isEqualTo("entity1");
    }

}