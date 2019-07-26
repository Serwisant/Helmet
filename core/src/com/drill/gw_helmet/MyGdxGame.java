package com.drill.gw_helmet;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.nio.FloatBuffer;

public class MyGdxGame extends ApplicationAdapter {
	private OrthographicCamera camera;
	private Viewport viewport;
	private Stage stage;
	private SpriteBatch batch;
	private TextureAtlasWrapper atlas;
	private DisplayPainter displayPainter;
	private Controller controller;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		viewport = new FitViewport(1600, 1000, camera);
		stage = new Stage(viewport);
		batch = new SpriteBatch();
		atlas = new TextureAtlasWrapper();

		controller = new Controller();

		displayPainter = new DisplayPainter();
		displayPainter.setSpriteBatch(batch);
		displayPainter.setTextureAtlas(atlas);
		displayPainter.setController(controller);

		camera.position.set(800, 550, 0);
		camera.update();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(168.f/255.f, 198.f/255.f, 78.f/255.f, 1);
        //Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);

		if(Gdx.input.justTouched()) {
			if (Gdx.input.getX() < Gdx.graphics.getWidth() / 2)
				controller.moveGuyLeft();

			if (Gdx.input.getX() > Gdx.graphics.getWidth() / 2)
				controller.moveGuyRight();
		}

		float dt = Gdx.graphics.getDeltaTime();

		camera.update();
		controller.update(dt);
		displayPainter.draw(dt);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		atlas.dispose();
	}
}
