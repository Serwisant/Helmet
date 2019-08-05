package com.drill.gw_helmet;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Quaternion;
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

	private float deltaTime;
	
	@Override
	public void create () {
		prepareDrawingArea();
		createController();
		prepareDisplayPainter();
		setCamera();
		resetDeltaTime();
	}

	private void prepareDrawingArea() {
		camera = new OrthographicCamera();
		viewport = new FitViewport(1600, 1000, camera);
		stage = new Stage(viewport);
		batch = new SpriteBatch();
		atlas = new TextureAtlasWrapper();
	}

	private void createController() {
		controller = new Controller();
	}

	private void prepareDisplayPainter() {
		displayPainter = new DisplayPainter();
		displayPainter.setSpriteBatch(batch);
		displayPainter.setTextureAtlas(atlas);
		displayPainter.setController(controller);
	}

	private void setCamera() {
		camera.position.set(800, 550, 0);
		camera.update();
	}

	private void resetDeltaTime() {
		deltaTime = 0.f;
	}

	@Override
	public void render () {
		clearScreen();
		updateCamera();
		handleInput();

		updateDeltaTime();

		updateController();
		drawDisplay();
	}

	private void clearScreen() {
		Gdx.gl.glClearColor(168.f/255.f, 198.f/255.f, 78.f/255.f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	private void updateCamera() {
		batch.setProjectionMatrix(camera.combined);
		camera.update();
	}

	private void handleInput() {
		if(Gdx.input.justTouched()) {
			if (Gdx.input.getX() < Gdx.graphics.getWidth() / 2)
				controller.moveGuyLeft();

			if (Gdx.input.getX() > Gdx.graphics.getWidth() / 2)
				controller.moveGuyRight();
		}
	}

	private void updateDeltaTime() {
		deltaTime = Gdx.graphics.getDeltaTime();
	}

	private void updateController() {
		controller.update(deltaTime);
	}

	private void drawDisplay() {
		displayPainter.draw(deltaTime);
	}

	@Override
	public void dispose () {
		batch.dispose();
		atlas.dispose();
	}
}
