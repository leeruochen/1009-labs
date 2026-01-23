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
    private Circle circle;
    private Triangle triangle;
    private EntityManager em;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        em = new EntityManager();

        droplets = new TextureObject[10];
        for (int i = 0; i < droplets.length; i++) {
            int randomX = (int)(Math.random() * (Gdx.graphics.getWidth() - 64));
            int randomY = (int)(Math.random() * (Gdx.graphics.getHeight() - 64));
            droplets[i] = new TextureObject("droplet.png", randomX, randomY, false, 0.5f);
            em.addEntities(droplets[i]);
        }

        bucket = new TextureObject("bucket.png", 100, 0, true, 5.0f);
        em.addEntities(bucket);

        circle = new Circle(200, 200, 5, "red", 50);
        em.addEntities(circle);

        triangle = new Triangle(150, 150, 5, "green", 100);
        em.addEntities(triangle);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        em.movement();

        batch.begin();
        em.draw(batch);
        batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        em.draw(shapeRenderer);
        shapeRenderer.end();
        
    }

    @Override
    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
    }
}