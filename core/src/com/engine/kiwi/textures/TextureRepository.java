package com.engine.kiwi.textures;

import com.badlogic.gdx.graphics.Texture;

public class TextureRepository {

    private static Texture boulder;
    private static Texture player;

    private TextureRepository() {}

    public static Texture getBoulder() {
        if (boulder == null) {
            boulder = new Texture("boulder.jpg");
        }
        return boulder;
    }

    public static Texture getPlayer() {
        if (player == null) {
            player = new Texture("player.jpg");
        }
        return player;
    }

}
