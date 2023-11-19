package com.engine.kiwi.boot;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.engine.kiwi.model.Entity;
import com.engine.kiwi.model.EntityGrid;

import static com.engine.kiwi.model.EntityType.IMPASSABLE_OBJECT;
import static com.engine.kiwi.model.EntityType.PLAYER;
import static com.engine.kiwi.textures.TextureRepository.getBoulder;
import static com.engine.kiwi.textures.TextureRepository.getPlayer;

public class KiwiEngine extends ApplicationAdapter {
	private SpriteBatch batch;
	private EntityGrid entityGrid;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		entityGrid = new EntityGrid(15,15);
		entityGrid.addEntity(new Entity("boulder1",1,2,0,1, getBoulder(), IMPASSABLE_OBJECT));
		entityGrid.addEntity(new Entity("boulder2",1,2,1,1,getBoulder(),IMPASSABLE_OBJECT));
		entityGrid.addEntity(new Entity("player",1,1,0,0,getPlayer(),PLAYER));
		entityGrid.addEntity(new Entity("boulder3",1,2,2,1,getBoulder(),IMPASSABLE_OBJECT));
		entityGrid.addEntity(new Entity("boulder4",1,2,3,1,getBoulder(),IMPASSABLE_OBJECT));
		entityGrid.addEntity(new Entity("boulder5",1,2,3,1,getBoulder(),IMPASSABLE_OBJECT));
		entityGrid.addEntity(new Entity("boulder6",1,2,7,1,getBoulder(),IMPASSABLE_OBJECT));
		entityGrid.addEntity(new Entity("boulder7",1,2,9,1,getBoulder(),IMPASSABLE_OBJECT));
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		entityGrid.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
