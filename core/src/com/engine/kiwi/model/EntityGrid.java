package com.engine.kiwi.model;

import java.util.UUID;

public class EntityGrid {

    private final String[][] grid;
    private final int pixelsPerHeight;
    private final int pixelsPerWidth;
    private final int width;
    private final int height;

    public EntityGrid(int width, int height, int pixelsPerWidth, int pixelsPerHeight) {
        this.grid = new String[width][height];
        this.pixelsPerWidth = pixelsPerWidth;
        this.pixelsPerHeight = pixelsPerHeight;
        this.width = width;
        this.height = height;
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
    }

    public String[][] getGrid() {
        return this.grid;
    }

    public String getCell(int positionX, int positionY) {
        return this.grid[positionX][positionY];
    }
}
