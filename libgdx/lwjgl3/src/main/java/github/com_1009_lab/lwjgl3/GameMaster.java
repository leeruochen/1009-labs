package github.com_1009_lab.lwjgl3;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
// import com.badlogic.gdx.Input.Keys;
// import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameMaster extends ApplicationAdapter {
    private TextureObject[] droplets;
    private TextureObject bucket;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private float speed = 1.0f;
    private Circle circle;
    private Triangle triangle;

    @Override
    public void create() {
        droplets = new TextureObject[10];

        for (int i = 0; i < droplets.length; i++) {
            int randomX = (int)(Math.random() * (Gdx.graphics.getWidth() - 64));
            int randomY = (int)(Math.random() * (Gdx.graphics.getHeight() - 64));

            droplets[i] = new TextureObject("droplet.png", randomX, randomY);
        }

        bucket = new TextureObject("bucket.png", 100, 0);
        batch = new SpriteBatch();

        shapeRenderer = new ShapeRenderer();

        circle = new Circle(200, 200, 5, "red", 50);
        triangle = new Triangle(150, 150, 5, "green", 100);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        bucket.movement();
        circle.movement();
        triangle.movement();

        batch.begin();
            bucket.draw(batch);

            for (int i = 0; i < droplets.length; i++) {
                TextureObject drop = droplets[i];
                
                drop.setY(drop.getY() - (int)speed);

                if (drop.getY() < 0) {
                    drop.setY(600 + (int)(Math.random() * 500));

                    if (speed < 1.0f)
                    {
                        speed += 0.1f;
                    }
                }

                drop.draw(batch);
            }
        batch.end();
        
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        circle.draw(shapeRenderer);
        triangle.draw(shapeRenderer);
        shapeRenderer.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
    }
}