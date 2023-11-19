package com.engine.kiwi.model;

import com.badlogic.gdx.graphics.Texture;

public record Entity(
        String id,
        int width,
        int height,
        int positionX,
        int positionY,
        Texture texture,
        EntityType entityType) {
}
