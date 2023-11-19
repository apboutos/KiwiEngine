package com.engine.kiwi.model;

import com.badlogic.gdx.graphics.Texture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class EntityGridTest {

    private EntityGrid classUnderTest;

    @BeforeEach
    void initialize() {
        classUnderTest = new EntityGrid(15,15);
    }

    @Test
    void shouldReturnEntitiesInCorrectCells() {
    }

}