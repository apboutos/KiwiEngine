package com.engine.kiwi.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.engine.kiwi.config.Constants.CELL_HEIGHT;
import static com.engine.kiwi.config.Constants.CELL_WIDTH;

public class EntityGrid {

    private final String[][] grid;
    private final int width;
    private final int height;
    private final Map<String,Entity> entities;

    public EntityGrid(int width, int height) {
        this.grid = new String[width][height];
        this.width = width;
        this.height = height;
        this.entities = new HashMap<>();
    }

    public void addEntity(Entity entity) {
        if (entity.width() > this.width || entity.height() > this.height) {
            throw new IllegalStateException("Entity: " + entity.id() + " cannot fit in the grid");
        }
        if (entity.positionX() >= this.width) {
            throw new IllegalStateException("positionX of Entity: " + entity.id() + " is outside the grid");
        }
        if (entity.positionY() >= this.height) {
            throw new IllegalStateException("positionY of Entity: " + entity.id() + " is outside the grid");
        }
        for (int i=entity.positionX(); i<entity.positionX() + entity.width(); i++) {
            for (int j=entity.positionY(); j<entity.positionY() + entity.height(); j++) {
                grid[i][j] = entity.id();
            }
        }
        entities.put(entity.id(),entity);
    }

    public String getCell(int positionX, int positionY) {
        return this.grid[positionX][positionY];
    }

    public void draw(SpriteBatch spriteBatch) {
       for (int i=0; i<this.width; i++) {
           for (int j=this.width -1; j>=0; j--) {
               final Entity entity = entities.get(grid[i][j]);
               if (entity != null) {
                   spriteBatch.draw(entity.texture(),entity.positionX() * CELL_WIDTH, entity.positionY() * CELL_HEIGHT);
               }
           }
       }
    }
}
