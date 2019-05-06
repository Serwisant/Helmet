package com.drill.gw_helmet;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGdxGame extends ApplicationAdapter {
	private OrthographicCamera camera;
	private Viewport viewport;
	private Stage stage;
	private SpriteBatch batch;
	private TextureAtlas atlas;
	private DisplayPainter displayPainter;
	private Controller controller;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.position.set(0,0,0);
		camera.update();
		viewport = new FitViewport(1744,1080, camera);
		stage = new Stage(viewport);
		batch = new SpriteBatch();
		atlas = new TextureAtlas();

		controller = new Controller();

		atlas.addTexture("hammer1", "Hammer/Hammer1.png");
		atlas.addTexture("hammer2", "Hammer/Hammer2.png");
		atlas.addTexture("hammer3", "Hammer/Hammer3.png");
		atlas.addTexture("hammer4", "Hammer/Hammer4.png");
		atlas.addTexture("hammer5", "Hammer/Hammer5.png");

		atlas.addTexture("bucket1", "Bucket/Bucket1.png");
		atlas.addTexture("bucket2", "Bucket/Bucket2.png");
		atlas.addTexture("bucket3", "Bucket/Bucket3.png");
		atlas.addTexture("bucket4", "Bucket/Bucket4.png");
		atlas.addTexture("bucket5", "Bucket/Bucket5.png");

		atlas.addTexture("key1", "Key/Key1.png");
		atlas.addTexture("key2", "Key/Key2.png");
		atlas.addTexture("key3", "Key/Key3.png");
		atlas.addTexture("key4", "Key/Key4.png");
		atlas.addTexture("key5", "Key/Key5.png");

		atlas.addTexture("screw1", "Screw/Screw1.png");
		atlas.addTexture("screw2", "Screw/Screw2.png");
		atlas.addTexture("screw3", "Screw/Screw3.png");
		atlas.addTexture("screw4", "Screw/Screw4.png");
		atlas.addTexture("screw5", "Screw/Screw5.png");

		atlas.addTexture("wrench1", "Wrench/Wrench1.png");
		atlas.addTexture("wrench2", "Wrench/Wrench2.png");
		atlas.addTexture("wrench3", "Wrench/Wrench3.png");
		atlas.addTexture("wrench4", "Wrench/Wrench4.png");
		atlas.addTexture("wrench5", "Wrench/Wrench5.png");

		atlas.addTexture("helmetGuy1", "HelmetGuy/HelmetGuy1.png");
		atlas.addTexture("helmetGuy2", "HelmetGuy/HelmetGuy2.png");
		atlas.addTexture("helmetGuy3", "HelmetGuy/HelmetGuy3.png");
		atlas.addTexture("helmetGuy4", "HelmetGuy/HelmetGuy4.png");
		atlas.addTexture("helmetGuy5", "HelmetGuy/HelmetGuy5.png");
		atlas.addTexture("helmetGuy6", "HelmetGuy/HelmetGuy6.png");
		atlas.addTexture("helmetGuy7", "HelmetGuy/HelmetGuy7.png");
		atlas.addTexture("fallenGuy", "HelmetGuy/FallSpr.png");

		atlas.addTexture("leftDoor", "Door/LeftDoorSpr.png");
		atlas.addTexture("rightDoorFrame", "Door/RightDoorStaticSpr.png");
		atlas.addTexture("rightDoorOpen", "Door/RightDoorOpenSpr.png");
		atlas.addTexture("rightDoorClosed", "Door/RightDoorClosedSpr.png");

		atlas.addTexture("missText", "GUI/MissTextSpr.png");
		atlas.addTexture("miss", "GUI/MissSpr.png");

		atlas.addTexture("balcony", "Scenery/Balcony.png");
		atlas.addTexture("trees", "Scenery/Trees.png");
		atlas.addTexture("roof", "Scenery/ShedRoof.png");
		atlas.addTexture("ground", "Scenery/Ground.png");

		displayPainter = new DisplayPainter();
		displayPainter.setSpriteBatch(batch);
		displayPainter.setTextureAtlas(atlas);
		displayPainter.setController(controller);
	}

	@Override
	public void render () {
		//Gdx.gl.glClearColor(168.f/255.f, 198.f/255.f, 78.f/255.f, 1);
        Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		/*
		draw("hammer1", 412, 267);
		draw("hammer2", 410, 355);
		draw("hammer3", 410, 426);
		draw("hammer4", 410, 503);
		draw("hammer5", 413, 570);

        draw("bucket1", 576, 248);
        draw("bucket2", 570, 351);
        draw("bucket3", 573, 443);
        draw("bucket4", 572, 527);
        draw("bucket5", 568, 613);

		draw("key1", 765, 272);
		draw("key2", 771, 365);
		draw("key3", 765, 439);
		draw("key4", 763, 506);
		draw("key5", 771, 588);

		draw("screw1", 944, 287);
		draw("screw2", 943, 376);
		draw("screw3", 945, 445);
		draw("screw4", 960, 499);
		draw("screw5", 978, 573);

		draw("wrench1", 1165, 264);
		draw("wrench2", 1189, 342);
		draw("wrench3", 1165, 455);
		draw("wrench5", 1167, 547);
		draw("wrench5", 1168, 622);

		draw("helmetGuy1", 214, 688);
		draw("helmetGuy2", 351, 705);
		draw("helmetGuy3", 555, 703);
		draw("helmetGuy4", 763, 698);
		draw("helmetGuy5", 944, 709);
		draw("helmetGuy6", 1139, 707);
		draw("helmetGuy7", 1402, 717);
		draw("fallenGuy", 707, 882);

		draw("leftDoor", 85, 647);
		draw("rightDoorFrame", 1508, 647);
		draw("rightDoorClosed", 1355, 647);
		draw("rightDoorOpen", 1539, 617);

		draw("missText", 988, 187);
		draw("miss", 937, 77);
		draw("miss", 1034, 77);
		draw("miss", 1131, 77);
		*/

		if(Gdx.input.justTouched()) {
			if (Gdx.input.getX() < viewport.getScreenWidth() / 2)
				controller.moveGuyLeft();

			if (Gdx.input.getX() > viewport.getScreenWidth() / 2)
				controller.moveGuyRight();
		}

		float dt = Gdx.graphics.getDeltaTime();

		controller.update(dt);
		displayPainter.draw(dt);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		atlas.dispose();
	}
}
